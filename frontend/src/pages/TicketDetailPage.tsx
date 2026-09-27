import { FormEvent, useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { ApiError, ticketsClient } from '../api/ticketsClient';
import type { Ticket, TicketPriority, TicketStatus } from '../types/ticket';

const allowedTargets: Record<TicketStatus, TicketStatus[]> = {
  OPEN: ['IN_PROGRESS', 'CANCELLED'],
  IN_PROGRESS: ['RESOLVED', 'CANCELLED'],
  RESOLVED: ['CLOSED'],
  CLOSED: [],
  CANCELLED: []
};

export function TicketDetailPage() {
  const { id } = useParams();
  const [ticket, setTicket] = useState<Ticket>();
  const [error, setError] = useState('');
  const [clearAssignee, setClearAssignee] = useState(false);
  useEffect(() => {
    if (id) ticketsClient.getById(Number(id)).then(setTicket).catch(cause => setError(cause instanceof Error ? cause.message : 'Unable to load ticket'));
  }, [id]);
  const transition = (status: TicketStatus) => {
    if (!ticket) return;
    setError('');
    ticketsClient.transition(ticket.id, status).then(setTicket).catch(cause => {
      if (cause instanceof ApiError) {
        const { code, detail, currentStatus, requestedStatus } = cause.problem;
        setError([code, detail, currentStatus && `current status: ${currentStatus}`, requestedStatus && `requested status: ${requestedStatus}`].filter(Boolean).join(' — '));
      } else {
        setError('Unable to change status');
      }
    });
  };
  const update = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (!ticket) return;
    const form = new FormData(event.currentTarget);
    setError('');
    ticketsClient.update(ticket.id, {
      title: String(form.get('title')), description: String(form.get('description')),
      priority: String(form.get('priority')) as TicketPriority,
      assignee: clearAssignee ? null : String(form.get('assignee'))
    }).then(updated => { setTicket(updated); setClearAssignee(false); })
      .catch(cause => setError(cause instanceof Error ? cause.message : 'Unable to update ticket'));
  };
  const addComment = (event: FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (!ticket) return;
    const form = new FormData(event.currentTarget);
    setError('');
    ticketsClient.addComment(ticket.id, { content: String(form.get('content')) }).then(comment => {
      setTicket({ ...ticket, comments: [...ticket.comments, comment] });
      event.currentTarget.reset();
    }).catch(cause => setError(cause instanceof Error ? cause.message : 'Unable to add comment'));
  };
  if (error && !ticket) return <main><p role="alert">{error}</p></main>;
  if (!ticket) return <main><p>Loading…</p></main>;
  return <main><Link to="/">Tickets</Link><h1>#{ticket.id} {ticket.title}</h1><dl><dt>Status</dt><dd>{ticket.status}</dd><dt>Priority</dt><dd>{ticket.priority}</dd><dt>Assignee</dt><dd>{ticket.assignee || 'Unassigned'}</dd><dt>Description</dt><dd>{ticket.description}</dd></dl><h2>Edit ticket</h2><form onSubmit={update}><label>Title <input name="title" defaultValue={ticket.title} required /></label><label>Description <textarea name="description" defaultValue={ticket.description} required /></label><label>Priority <select name="priority" defaultValue={ticket.priority}><option>LOW</option><option>MEDIUM</option><option>HIGH</option></select></label><label>Assignee <input name="assignee" defaultValue={ticket.assignee ?? ''} disabled={clearAssignee} /></label><label><input type="checkbox" checked={clearAssignee} onChange={event => setClearAssignee(event.target.checked)} /> Clear assignee</label><button type="submit">Save changes</button></form><h2>Change status</h2>{allowedTargets[ticket.status].map(status => <button key={status} type="button" onClick={() => transition(status)}>{status}</button>)}{error && <p role="alert">{error}</p>}<h2>Comments</h2><ul>{ticket.comments.map(comment => <li key={comment.id}>{comment.content}</li>)}</ul><form onSubmit={addComment}><label>Comment <textarea name="content" required /></label><button type="submit">Add comment</button></form></main>;
}

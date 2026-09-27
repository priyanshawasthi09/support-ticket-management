import { useEffect, useState } from 'react';
import { Link, useParams } from 'react-router-dom';
import { ApiError, ticketsClient } from '../api/ticketsClient';
import type { Ticket, TicketStatus } from '../types/ticket';

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
  if (error && !ticket) return <main><p role="alert">{error}</p></main>;
  if (!ticket) return <main><p>Loading…</p></main>;
  return <main><Link to="/">Tickets</Link><h1>#{ticket.id} {ticket.title}</h1><dl><dt>Status</dt><dd>{ticket.status}</dd><dt>Priority</dt><dd>{ticket.priority}</dd><dt>Assignee</dt><dd>{ticket.assignee || 'Unassigned'}</dd><dt>Description</dt><dd>{ticket.description}</dd></dl><h2>Change status</h2>{allowedTargets[ticket.status].map(status => <button key={status} type="button" onClick={() => transition(status)}>{status}</button>)}{error && <p role="alert">{error}</p>}<h2>Comments</h2><ul>{ticket.comments.map(comment => <li key={comment.id}>{comment.content}</li>)}</ul></main>;
}

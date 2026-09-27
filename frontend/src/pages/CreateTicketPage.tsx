import { FormEvent, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { ticketsClient } from '../api/ticketsClient';
import type { TicketPriority } from '../types/ticket';
export function CreateTicketPage() {
  const navigate = useNavigate(); const [error, setError] = useState('');
  async function submit(event: FormEvent<HTMLFormElement>) { event.preventDefault(); const form = new FormData(event.currentTarget); try { const ticket = await ticketsClient.create({ title: String(form.get('title')), description: String(form.get('description')), priority: String(form.get('priority')) as TicketPriority, assignee: String(form.get('assignee') || '') || undefined }); navigate(`/tickets/${ticket.id}`); } catch (cause) { setError(cause instanceof Error ? cause.message : 'Unable to create ticket'); } }
  return <main><h1>Create ticket</h1><form onSubmit={submit}><label>Title <input name="title" required /></label><label>Description <textarea name="description" required /></label><label>Priority <select name="priority" required defaultValue=""><option value="" disabled>Select priority</option><option>LOW</option><option>MEDIUM</option><option>HIGH</option></select></label><label>Assignee <input name="assignee" /></label><button type="submit">Create</button>{error && <p role="alert">{error}</p>}</form></main>;
}

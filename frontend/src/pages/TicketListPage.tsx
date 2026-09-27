import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { ticketsClient } from '../api/ticketsClient';
import type { TicketStatus, TicketSummary } from '../types/ticket';
export function TicketListPage() {
  const [tickets, setTickets] = useState<TicketSummary[]>([]);
  const [keyword, setKeyword] = useState('');
  const [statusFilter, setStatusFilter] = useState<TicketStatus | ''>('');
  useEffect(() => {
    ticketsClient.list({ q: keyword, status: statusFilter || undefined })
      .then(setTickets).catch(() => setTickets([]));
  }, [keyword, statusFilter]);
  return <main>
    <h1>Tickets</h1>
    <Link to="/tickets/new">Create ticket</Link>
    <form>
      <label>Search <input value={keyword} onChange={event => setKeyword(event.target.value)} /></label>
      <label>Status <select value={statusFilter} onChange={event => setStatusFilter(event.target.value as TicketStatus | '')}>
        <option value="">All statuses</option>
        {(['OPEN', 'IN_PROGRESS', 'RESOLVED', 'CLOSED', 'CANCELLED'] as TicketStatus[]).map(status =>
          <option key={status} value={status}>{status}</option>)}
      </select></label>
    </form>
    <ul>{tickets.map(ticket => <li key={ticket.id}><Link to={`/tickets/${ticket.id}`}>#{ticket.id} {ticket.title} — {ticket.status}</Link></li>)}</ul>
  </main>;
}

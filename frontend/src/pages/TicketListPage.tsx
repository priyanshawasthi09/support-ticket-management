import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { ticketsClient } from '../api/ticketsClient';
import type { TicketSummary } from '../types/ticket';
export function TicketListPage() {
  const [tickets, setTickets] = useState<TicketSummary[]>([]);
  useEffect(() => { ticketsClient.list().then(setTickets).catch(() => setTickets([])); }, []);
  return <main><h1>Tickets</h1><Link to="/tickets/new">Create ticket</Link><ul>{tickets.map(ticket => <li key={ticket.id}><Link to={`/tickets/${ticket.id}`}>#{ticket.id} {ticket.title} — {ticket.status}</Link></li>)}</ul></main>;
}

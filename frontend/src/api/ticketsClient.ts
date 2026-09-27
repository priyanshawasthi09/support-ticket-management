import type { ApiProblem, Comment, CreateComment, CreateTicket, Ticket, TicketStatus, TicketSummary, UpdateTicket } from '../types/ticket';
const apiBase = '/api/v1/tickets';
export class ApiError extends Error { constructor(public readonly problem: ApiProblem) { super(problem.detail); } }
async function readJson<T>(response: Response): Promise<T> {
  if (!response.ok) { throw new ApiError(await response.json() as ApiProblem); }
  return response.json() as Promise<T>;
}
export const ticketsClient = {
  create: (ticket: CreateTicket) => fetch(apiBase, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(ticket) }).then(readJson<Ticket>),
  list: () => fetch(apiBase).then(readJson<TicketSummary[]>),
  getById: (id: number) => fetch(`${apiBase}/${id}`).then(readJson<Ticket>),
  update: (id: number, ticket: UpdateTicket) => fetch(`${apiBase}/${id}`, {
    method: 'PATCH', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(ticket)
  }).then(readJson<Ticket>),
  addComment: (id: number, comment: CreateComment) => fetch(`${apiBase}/${id}/comments`, {
    method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(comment)
  }).then(readJson<Comment>),
  transition: (id: number, status: TicketStatus) => fetch(`${apiBase}/${id}/transitions`, {
    method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ status })
  }).then(readJson<Ticket>)
};

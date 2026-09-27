export type TicketPriority = 'LOW' | 'MEDIUM' | 'HIGH';
export type TicketStatus = 'OPEN' | 'IN_PROGRESS' | 'RESOLVED' | 'CLOSED' | 'CANCELLED';
export interface TicketSummary { id: number; title: string; status: TicketStatus; }
export interface Ticket { id: number; title: string; description: string; priority: TicketPriority; assignee: string | null; status: TicketStatus; comments: Comment[]; }
export interface Comment { id: number; content: string; }
export interface CreateTicket { title: string; description: string; priority: TicketPriority; assignee?: string; }
export interface ApiProblem {
  code: string;
  detail: string;
  currentStatus?: TicketStatus;
  requestedStatus?: TicketStatus;
  errors?: { field: string; message: string }[];
}

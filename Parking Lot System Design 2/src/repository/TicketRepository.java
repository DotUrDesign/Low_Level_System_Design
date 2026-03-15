package repository;

import model.Ticket;

import java.util.HashMap;

public class TicketRepository {
    HashMap<String, Ticket> TicketHashMap = new HashMap<>();

    public void saveTicket(Ticket ticket) {
        TicketHashMap.put(ticket.getTicketNo(), ticket);
        return;
    }
}

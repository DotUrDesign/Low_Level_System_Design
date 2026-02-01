package repository;

import models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    HashMap<String, Ticket> ticketMap = new HashMap<>();
    public void saveTicket(String ticketNo, Ticket ticket) {
        ticketMap.put(ticketNo, ticket);
    }
}

package DTOs;

import models.Gate;
import models.Ticket;

public class IssueBillRequestDTO {
    private Ticket ticket;
    private Long exitGateId;

    public Long getExitGateId() {
        return exitGateId;
    }

    public void setExitGateId(Long exitGateId) {
        this.exitGateId = exitGateId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

package controllers;

import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import enums.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) {
        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();

        try {
            Ticket ticket = ticketService.issueTicket(
                    issueTicketRequestDTO.getOwner(),
                    issueTicketRequestDTO.getVehicleNo(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getParkingLotId(),
                    issueTicketRequestDTO.getGateId(),
                    issueTicketRequestDTO.getSpotAssignmentStrategyType()
            );
            issueTicketResponseDTO.setTicket(ticket);
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e) {
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILED);
        }

        return issueTicketResponseDTO;
    }
}

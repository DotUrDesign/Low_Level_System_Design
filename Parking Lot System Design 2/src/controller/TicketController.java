package controller;

import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import model.Ticket;
import model.enums.ResponseStatus;
import service.TicketService;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) throws ParkingLotNotFoundException, GateNotFoundException {
        // extracting the info and sending it to the service layer
        Ticket ticket = ticketService.issueTicket(
                issueTicketRequestDTO.getGateId(),
                issueTicketRequestDTO.getOwner(),
                issueTicketRequestDTO.getVehicleNo(),
                issueTicketRequestDTO.getVehicleType(),
                issueTicketRequestDTO.getParkingLotId(),
                issueTicketRequestDTO.getSpotAssignmentStrategyType()
        );


        IssueTicketResponseDTO issueTicketResponseDTO = new IssueTicketResponseDTO();
        issueTicketResponseDTO.setTicket(ticket);
        issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return issueTicketResponseDTO;
    }
}

/*
    TicketRequest -
    => owner  ---> not required(can get using the vehicle no)
    => vehicleNo
    => vehicleType  ---> not required(can get using the vehicle no)
    => GateId
    => ParkingLotId
    => SpotAssignmentAlgo- user will choose whether he/she wants the nearest spot or the safest spot...


    TicketResponse -
    => Ticket
    => ResponseStatus


At the end of the day, for the creation of a ticket - either we need a number or an Id for the gate
or the vehicle => basically we need an unique identifier.
 */

import DTOs.IssueBillRequestDTO;
import DTOs.IssueBillResponseDTO;
import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import controller.BillController;
import controller.TicketController;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import model.Bill;
import model.Ticket;
import model.enums.SpotAssignmentStrategyType;
import model.enums.VehicleType;
import repository.*;
import service.BillService;
import service.TicketService;

public class Client {
    public static void main(String[] args) throws ParkingLotNotFoundException, GateNotFoundException {
        // Creating an IssueTicketRequestDTO
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setOwner("Pratyush");
        issueTicketRequestDTO.setVehicleNo("OD 8888");
        issueTicketRequestDTO.setVehicleType(VehicleType.TWO_WHEELER);
        issueTicketRequestDTO.setGateId(20L);
        issueTicketRequestDTO.setParkingLotId(1L);
        issueTicketRequestDTO.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);

        // getting back the response
        // TICKET -
        VehicleRepository vehicleRepository = new VehicleRepository();
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(
                vehicleRepository,
                gateRepository,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(ticketService);
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        // BILL -
        BillRepository billRepository = new BillRepository();

        BillService billService = new BillService(billRepository);

        IssueBillRequestDTO issueBillRequestDTO = new IssueBillRequestDTO();
        Ticket ticket = issueTicketResponseDTO.getTicket();
        issueBillRequestDTO.setTicket(ticket);

        BillController billController = new BillController(billService);
        IssueBillResponseDTO issueBillResponseDTO = billController.issueBill(issueBillRequestDTO);

        // THE END
    }
}

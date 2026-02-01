import DTOs.IssueBillRequestDTO;
import DTOs.IssueBillResponseDTO;
import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import controllers.BillController;
import controllers.TicketController;
import enums.SpotAssignmentStrategyType;
import enums.VehicleType;
import models.Bill;
import models.Vehicle;
import repository.*;
import services.BillService;
import services.TicketService;

public class Client {
    public static void main(String[] args) {
        // ISSUING THE TICKET
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

        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        issueTicketRequestDTO.setOwner("Pratyush");
        issueTicketRequestDTO.setVehicleNo("OD 8888");
        issueTicketRequestDTO.setVehicleType(VehicleType.SUV);
        issueTicketRequestDTO.setGateId(20L);
        issueTicketRequestDTO.setParkingLotId(1L);
        issueTicketRequestDTO.setSpotAssignmentStrategyType(SpotAssignmentStrategyType.NEAREST);

        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        // ISSUING THE BILL
        BillRepository billRepository = new BillRepository();

        BillService billService = new BillService(
                gateRepository,
                billRepository
        );

        BillController billController = new BillController(billService);

        IssueBillRequestDTO issueBillRequestDTO = new IssueBillRequestDTO();
        issueBillRequestDTO.setTicket(issueTicketResponseDTO.getTicket());
        issueBillRequestDTO.setExitGateId(3L);

        IssueBillResponseDTO issueBillResponseDTO = billController.issueBill(issueBillRequestDTO);

    }
}

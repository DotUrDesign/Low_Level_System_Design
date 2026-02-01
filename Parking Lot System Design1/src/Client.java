import DTOs.IssueTicketRequestDTO;
import DTOs.IssueTicketResponseDTO;
import controllers.TicketController;
import enums.SpotAssignmentStrategyType;
import enums.VehicleType;
import models.Vehicle;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import services.TicketService;

public class Client {
    public static void main(String[] args) {
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

    }
}

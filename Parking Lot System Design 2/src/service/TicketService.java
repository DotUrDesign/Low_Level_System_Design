package service;

import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import factory.SpotAssignmentStrategyFactory;
import model.*;
import model.enums.SpotAssignmentStrategyType;
import model.enums.TicketStatus;
import model.enums.VehicleType;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {
    private VehicleRepository vehicleRepository;
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketService(
            VehicleRepository vehicleRepository,
            GateRepository gateRepository,
            ParkingLotRepository parkingLotRepository,
            TicketRepository ticketRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(
            Long gateId,
            String owner,
            String vehicleNo,
            VehicleType vehicleType,
            Long parkingLotId,
            SpotAssignmentStrategyType spotAssignmentStrategyType
    ) throws GateNotFoundException, ParkingLotNotFoundException {
        // issuing the ticket
        Ticket ticket = new Ticket();

        // vehicle
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVehicleNo(vehicleNo);
        if(optionalVehicle.isEmpty()) {
            Vehicle vehicle = new Vehicle();
            vehicle.setOwner(owner);
            vehicle.setNo(vehicleNo);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
            ticket.setVehicle(vehicle);
        } else {
            ticket.setVehicle(optionalVehicle.get());
        }

        // gate
        Optional<Gate> optionalGate = gateRepository.getGateByGateId(gateId);
        if(optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate not found.");
        }
        Gate gate = optionalGate.get();
        ticket.setGate(gate);

        // operator
        Operator operator = gate.getCurrentOperator();
        ticket.setOperator(operator);

        // parking spot
        // parking spot will be fetched based on the spot assignment
        // strategy...
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);
        ticket.setParkingSpot(parkingSpot);

        // entry time
        ticket.setEntryTime(System.currentTimeMillis());

        // ticketStatus
        ticket.setTicketStatus(TicketStatus.VALID);

        // ticketNo
        String ticketNo = "TICKET_" + gateId + "_" + vehicleNo + "_" + owner + "_" + System.currentTimeMillis();
        ticket.setTicketNo(ticketNo);

        // not required -> fetching the parking lot details from the
        // parking lot repository
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        if(optionalParkingLot.isEmpty()) {
            throw new ParkingLotNotFoundException("Parking lot not found.");
        }
        ParkingLot parkingLot = optionalParkingLot.get();

        // save the ticket into the db
        ticketRepository.saveTicket(ticket);

        return ticket;
    }
}

package services;

import enums.SpotAssignmentStrategyType;
import enums.VehicleType;
import exceptions.GateNotFoundException;
import exceptions.ParkingLotNotFoundException;
import factory.SpotAssignmentFactory;
import models.*;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import repository.VehicleRepository;
import strategies.SpotAssignmentAlgorithm.SpotAssignmentAlgo;

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
             String owner,
             String vehicleNo,
             VehicleType vehicleType,
             Long parkingLotId,
             Long gateId,
             SpotAssignmentStrategyType spotAssignmentStrategyType
     ) throws GateNotFoundException, ParkingLotNotFoundException {
          Ticket ticket = new Ticket();

          // vehicle
          Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByVehicleNo(vehicleNo);
          if(optionalVehicle.isEmpty()) {
               Vehicle vehicle = new Vehicle();
               vehicle.setNo(vehicleNo);
               vehicle.setOwner(owner);
               vehicle.setVehicleType(vehicleType);
               vehicleRepository.saveVehicle(vehicle);
               ticket.setVehicle(vehicle);
          } else {
               ticket.setVehicle(optionalVehicle.get());
          }

          // entry time
          ticket.setEntryTime(System.currentTimeMillis());

          // gate
          Optional<Gate> optionalGate = gateRepository.getGateByGateId(gateId);
          if(optionalGate.isEmpty()) {
               throw new GateNotFoundException("Gate No is invalid.");
          }
          Gate gate = optionalGate.get();
          ticket.setGate(gate);

          // operator
          ticket.setOperator(gate.getCurrentOperator());

          // parking spot
          Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotByParkingLotId(parkingLotId);
          if(optionalParkingLot.isEmpty()) {
               throw new ParkingLotNotFoundException("Parking Lot not found.");
          }
          ParkingLot parkingLot = optionalParkingLot.get();

          SpotAssignmentAlgo spotAssignmentAlgo = SpotAssignmentFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

          ParkingSpot parkingSpot = spotAssignmentAlgo.assignSpot(vehicleType, gate);

          ticket.setParkingSpot(parkingSpot);

          // Ticket no
          String ticketNo = "TICKET_" + gateId + "_" + vehicleNo + "_" + owner + "_" + System.currentTimeMillis();
          ticket.setTicketNo(ticketNo);

          // save the ticket in the db
          ticketRepository.saveTicket(ticketNo, ticket);

          return ticket;
     }
}















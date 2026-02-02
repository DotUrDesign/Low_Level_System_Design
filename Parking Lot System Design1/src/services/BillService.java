package services;

import enums.BillStatus;
import enums.VehicleType;
import exceptions.GateNotFoundException;
import factory.FeeCalculationStrategyFactory;
import models.Bill;
import models.Gate;
import models.Ticket;
import models.Vehicle;
import repository.BillRepository;
import repository.GateRepository;
import strategies.FeeCalculationAlgorithm.FeeCalculationAlgo;

import java.util.Optional;

public class BillService {
    private GateRepository gateRepository;
    private BillRepository billRepository;
    public BillService(
            GateRepository gateRepository,
            BillRepository billRepository
    ) {
        this.gateRepository = gateRepository;
        this.billRepository = billRepository;
    }
    public Bill issueBill(Ticket ticket, Long exitGateId) throws GateNotFoundException {

        // GENERATE THE BILL
        Bill bill = new Bill();

        // exit time
        bill.setExitTime(System.currentTimeMillis());

        // payments - dekhenge bd mein
        bill.setPayments(null);

        // gate
        Optional<Gate> optionalExitGate = gateRepository.getGateByGateId(exitGateId);
        if(optionalExitGate.isEmpty()) {
            throw new GateNotFoundException("Exit gate not found");
        }
        Gate exitGate = optionalExitGate.get();

        bill.setGate(exitGate);

        // operator
        bill.setOperator(exitGate.getCurrentOperator());

        // ticket
        bill.setTicket(ticket);

        // amount
        /*
            vehicletype
            entry time
            algo
         */

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        Long entryTime = ticket.getEntryTime();

        FeeCalculationAlgo feeCalculationAlgo = FeeCalculationStrategyFactory.getFeeCalculationAlgo(vehicleType);

        int amount = feeCalculationAlgo.calculateAmount(entryTime, bill.getExitTime());

        bill.setAmount(amount);

        // billNo
        String billNo = "BILL_" + ticket.getTicketNo() + "_" + exitGateId + "_" + ticket.getVehicle().getNo() + "_" + System.currentTimeMillis();
        bill.setBillNo(billNo);

        // billstatus
        bill.setBillStatus(BillStatus.PAID);

        return bill;
    }
}

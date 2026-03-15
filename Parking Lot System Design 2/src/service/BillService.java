package service;

import factory.FeeCalculationStrategyFactory;
import model.*;
import model.enums.BillStatus;
import repository.BillRepository;
import strategies.FeeCalculationStrategy.FeeCalculationStrategy;

import java.util.List;

public class BillService {
    private BillRepository billRepository;
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }
    public Bill issueBill(Ticket ticket, List<Payment> payments) {
        Bill bill = new Bill();

        // Gate
        Gate gate = ticket.getGate();
        bill.setGate(gate);

        // operator
        Operator operator = gate.getCurrentOperator();
        bill.setOperator(operator);

        // ticket
        bill.setTicket(ticket);

        // exit time
        bill.setExitTime(System.currentTimeMillis());

        // amount
        FeeCalculationStrategy feeCalculationStrategy = FeeCalculationStrategyFactory.getFeeCalculationStrategy(ticket.getParkingSpot());
        int amount = feeCalculationStrategy.calculateAmount();
        bill.setAmount(amount);

        // list of payments
        // 2 scenarios possible =>
        // payment successful => store the list of payments and update the billstatus as paid
        // payment unsuccessful => backout all the stored things from the bill, or you can just
        // delete the bill, as you haven't stored it inside the repository and set the billing
        // status as "FAILED"
        // in our case, we will assume that the payment status as successful.

        // bill no
        String billNo = "BILL_" + ticket.getTicketNo() + "_" + ticket.getParkingSpot();
        bill.setBillNo(billNo);

        // bill status
        bill.setBillStatus(BillStatus.PAID);

        // save the bill into the db
        billRepository.saveBill(bill);

        return bill;
    }
}

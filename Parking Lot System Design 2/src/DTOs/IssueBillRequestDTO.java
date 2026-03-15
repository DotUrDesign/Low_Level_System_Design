package DTOs;

import model.Payment;
import model.Ticket;

import java.util.List;

public class IssueBillRequestDTO {
    /*
        What all things we should be passing to generate the bill
        1) billNo - Not req
        2) List<payment> - yes
        3) gateId - ? --> Yes
           gate present - gate info
           gate not present - exception thrown
        4) operator - not req
                    - can be fetched from the gate info itself.
        5) billstatus - nope
        6) amount - feeCalculationStrategy
                  - spotAssignmentStrategyType
                  - MY PERCEPTION => dont think you can calculate the amount from the parking spot
                                     info, as a particular parking spot can be filled by the people
                                     who have choosen either SAFEST as their spot assignment strategy
                                     type or NEAREST as their spot assignment strategy type.
                                     So, passing the SPOTASSIGNMENTSTRATEGYTYPE is more of a good
                                     design to calculate the amount as it shows what the user wants -
                                     and accordingly the user has to pay for it.

                    MY OPINION -
                    The same parking spot can be of different prices.
                    Depending upon what the user wants -> a safest spot or a nearest spot or a random
                    spot...
                    Its more of a like - booking a seat in train, one person books the seat in normal
                    prices a month ago, and another books the seat at a higher cost in TATKAL.

                    Discuss this opinion with your friends.

                    --------------------

                    On the flip side, it might be bad design as one user has to pay a different price
                    from the other user, just because the intention of both the users are different.

                    DISCUSS!!

                    Simplest algo to calculate the price -
                    Vehicle Type & (exitTime - entryTime)
                    Every type of vehicle will have a specific amount assigned to it. Now the net
                    price will actually depend on how much time the user has spent keeping his/her
                    vehicle in the parking lot.

                    The first approach seems to be "OVER-ENGINEERING". But discuss it once.



            7)exit time - nope
            8) ticket - yes (already generated at the entry time)
            9) vehicleType - not req => we can extract it => ticket --> vehicle --> vehicleType

     */

    private List<Payment> payments;
    private Ticket ticket;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

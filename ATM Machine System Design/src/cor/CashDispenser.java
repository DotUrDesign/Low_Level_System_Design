package cor;

import model.ATM;

/*
    This cashDispenser interface will be holding 3 things -
    => can dispense - whether or not the cash can be dispensed or not
    => dispense - once we come to know that the cash can be dispensed, then the atm machine will
    dispense it.
    => setNextDispenser - this is the one which will be helping us to build the linked list type of thing.
    2000 --> 500 --> 100

 */
public interface CashDispenser {
    void setNextDispenser(CashDispenser next);
    boolean canDispense(ATM atm, int amount);
    void dispense(ATM atm, int amount);
}

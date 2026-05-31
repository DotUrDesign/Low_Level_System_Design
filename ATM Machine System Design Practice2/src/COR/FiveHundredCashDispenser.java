package COR;

import model.Atm;

public class FiveHundredCashDispenser implements CashDispenser{
    CashDispenser next;
    @Override
    public void setNextDispenser(CashDispenser cashDispenser) {
        this.next = cashDispenser;
    }

    @Override
    public boolean canDispense(long amount, Atm atm) {
        long notesAvailable = atm.getFiveHundreds();
        long notes = amount / notesAvailable;
        long remaining = amount - (notes * 500);
        return (remaining == 0) || (next != null && next.canDispense(remaining, atm));
    }

    @Override
    public void dispenseCash(long amount, Atm atm) {

    }
}

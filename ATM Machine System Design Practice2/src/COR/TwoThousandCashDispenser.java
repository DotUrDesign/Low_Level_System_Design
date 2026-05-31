package COR;

import model.Atm;

public class TwoThousandCashDispenser implements CashDispenser{
    CashDispenser next;

    @Override
    public void setNextDispenser(CashDispenser cashDispenser) {
        this.next = cashDispenser;
    }

    @Override
    public boolean canDispense(long amount, Atm atm) {
        long notesAvailable = atm.getTwoThousands();
        long notes = amount/notesAvailable;
        long remaining = amount - (notes * 2000);
        return (remaining == 0) || (next != null && next.canDispense(remaining, atm));
    }

    @Override
    public void dispenseCash(long amount, Atm atm) {

    }
}

package cor;

import model.Atm;

public class FiveHundredCashDispenser implements CashDispenser {
    CashDispenser next;
    @Override
    public void setCashDispenser(CashDispenser cashDispenser) {
        this.next = next;
    }

    @Override
    public boolean canDispense(int amount, Atm atm) {
        int available = atm.getTwoThousands();
        int needed = amount / 500;
        int notes = Math.min(available, needed);
        int remaining = amount - (notes * 500);
        return (remaining == 0) || (next != null && next.canDispense(remaining, atm));
    }

    @Override
    public void dispenseCash(int amount, Atm atm) {
        int available = atm.getTwoThousands();
        int needed = amount / 500;
        int notes = Math.min(available, needed);
        int remaining = amount - (notes * 500);
        atm.setTwoThousands(atm.getTwoThousands()-notes);
        System.out.println("Dispensed " + notes + " x 500 notes");
        if(remaining != 0 && next != null) {
            next.dispenseCash(amount, atm);
        }
    }
}

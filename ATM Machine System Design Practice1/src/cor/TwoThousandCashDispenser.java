package cor;

import model.Atm;

public class TwoThousandCashDispenser implements CashDispenser{
    CashDispenser next;
    @Override
    public void setCashDispenser(CashDispenser next) {
        this.next = next;
    }

    @Override
    public boolean canDispense(int amount, Atm atm) {
        int available = atm.getTwoThousands();
        int needed = amount / 2000;
        int notes = Math.min(available, needed);
        int remaining = amount - (notes * 2000);
        return (remaining == 0) || (next != null && next.canDispense(remaining, atm));
    }

    @Override
    public void dispenseCash(int amount, Atm atm) {
        int available = atm.getTwoThousands();
        int needed = amount / 2000;
        int notes = Math.min(available, needed);
        int remaining = amount - (notes * 2000);
        atm.setTwoThousands(atm.getTwoThousands()-notes);
        System.out.println("Dispensed " + notes + " x 2000 notes");
        if(remaining != 0 && next != null) {
            next.dispenseCash(amount, atm);
        }
    }
}

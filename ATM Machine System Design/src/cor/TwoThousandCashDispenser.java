package cor;

import model.ATM;

public class TwoThousandCashDispenser implements CashDispenser{
    private CashDispenser next;
    @Override
    public void setNextDispenser(CashDispenser next) {
        this.next = next;
    }

    @Override
    public boolean canDispense(ATM atm, int amount) {
        int available = atm.getThousands();
        int needed = amount/2000;
        int remainder = amount - Math.min(available,needed)*2000;
        return (remainder == 0) || (next != null && next.canDispense(atm, remainder));
    }

    @Override
    public void dispense(ATM atm, int amount) {
        int available = atm.getThousands();
        int notes = Math.min(available, amount/2000);
        int remainder = amount - notes*2000;
        if(notes > 0) {
            atm.setThousands(available-notes);
            System.out.println("Dispensed " + notes + " x 2000 notes");
        }
        if(remainder != 0 && next != null) {
            next.dispense(atm, remainder);
        }
    }
}

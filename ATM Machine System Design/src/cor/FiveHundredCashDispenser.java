package cor;

import model.ATM;

public class FiveHundredCashDispenser implements CashDispenser{
    private CashDispenser next;
    @Override
    public void setNextDispenser(CashDispenser next) {
        this.next = next;
    }

    @Override
    public boolean canDispense(ATM atm, int amount) {
        int available = atm.getFivehundreds();
        int needed = amount/500;
        int remainder = amount - Math.min(available, needed) * 500;
        return (remainder == 0) || (next != null && next.canDispense(atm, remainder));
    }

    @Override
    public void dispense(ATM atm, int amount) {
        int available = atm.getFivehundreds();
        int notes = Math.min(amount/500, available);
        int remainder = amount - notes * 500;
        if(notes > 0) {
            atm.setFivehundreds(available-notes);
            System.out.println("Dispensed " + notes + " x 500 notes");
        }
        if(remainder > 0 && next != null) {
            next.dispense(atm, remainder);
        }
    }
}

package COR;

import model.Atm;

public interface CashDispenser {
    public void setNextDispenser(CashDispenser cashDispenser);
    public boolean canDispense(long amount, Atm atm);
    public void dispenseCash(long amount, Atm atm);
}

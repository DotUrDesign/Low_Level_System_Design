package cor;

import model.Atm;

public interface CashDispenser {
    void setCashDispenser(CashDispenser cashDispenser);
    boolean canDispense(int amount, Atm atm);
    void dispenseCash(int amount, Atm atm);
}

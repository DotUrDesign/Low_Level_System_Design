package state;

import exceptions.AccountBalanceException;
import exceptions.AtmBalanceException;
import model.Card;
import service.AtmMachine;

public abstract class AtmState {
    AtmMachine atmMachine;
    public AtmState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    public abstract void insertCard(Card card);
    public abstract void enterPin(String pin);
    public abstract void enterOptions(String options);
    public abstract void dispenseCash(long amount) throws AccountBalanceException, AtmBalanceException;
    public abstract void ejectCard();
}

package state;

import model.Card;
import service.AtmMachine;

public abstract class AtmState {
    public AtmMachine atmMachine;
    public AtmState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    public abstract void insertCard(Card card);
    public abstract void enterPin(String pin);
    public abstract void enterOptions(String options);
    public abstract void dispenseCash(int amount);
    public abstract void ejectCard();
}

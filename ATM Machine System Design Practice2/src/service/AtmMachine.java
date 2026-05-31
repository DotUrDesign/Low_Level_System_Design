package service;

import exceptions.AccountBalanceException;
import exceptions.AtmBalanceException;
import factory.AtmStateFactory;
import model.Atm;
import model.Card;
import state.AtmState;

public class AtmMachine {
    AtmState state;
    Atm atm;
    Card card;
    public AtmMachine(Atm atm, Card card, String stateName) {
        this.atm = atm;
        this.card = card;
        this.state = AtmStateFactory.getState(this, stateName);
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }
    public void enterPin(String pin) {
        state.enterPin(pin);
    }
    public void enterOptions(String options) {
        state.enterOptions(options);
    }
    public void dispenseCash(long amount) throws AtmBalanceException, AccountBalanceException {
        state.dispenseCash(amount);
    }
    public void ejectCard() {
        state.ejectCard();
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
    }

    public Atm getAtm() {
        return atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

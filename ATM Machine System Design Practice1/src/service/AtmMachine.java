package service;

import factory.AtmStateFactory;
import model.Atm;
import model.Card;
import state.AtmState;

public class AtmMachine {
    Atm atm;
    Card card;
    AtmState state;
    public AtmMachine(Card card, Atm atm, String stateName) {
        this.card = card;
        this.atm = atm;
        this.state = AtmStateFactory.getAtmState(stateName, this);
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }

    public void enterPin(String number) {
        state.enterPin(number);
    }

    public void enterOptions(String withdraw) {
        state.enterOptions(withdraw);
    }

    public void dispenseCash(int i) {
    }

    public void ejectCard() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
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
}

package service;

import factory.AtmStateFactory;
import model.ATM;
import model.Card;
import repository.AtmRepository;
import state.AtmState;


public class AtmMachine {
    private ATM atm;
    private AtmState state;
    private Card card;
    private AtmRepository atmRepository;
    public AtmMachine(String stateName, AtmRepository atmRepository) {
        this.atmRepository = atmRepository;
        this.state = AtmStateFactory.getAtmState(stateName, this);
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }
    public void enterPin(String pin) {
        state.enterPin(pin);
    }
    public void enterOption(String option) {
        state.enterOption(option);
    }
    public void dispenseCash(int amount) {
        state.dispenseCash(amount);
    }
    public void ejectCard() {
        state.ejectCard();
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}












package state;

import model.Card;
import service.AtmMachine;

public class IdleState implements AtmState {
    private AtmMachine atmMachine;
    public IdleState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    @Override
    public void insertCard(Card card) {
        atmMachine.setCard(card);
        System.out.println("Card inserted");
        atmMachine.setState(new CardInsertedState(atmMachine));
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("No card inserted");
    }

    @Override
    public void enterOption(String option) {
        System.out.println("No card inserted");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("No card inserted");
    }

    @Override
    public void ejectCard() {
        System.out.println("No card inserted");
    }
}

package state;

import model.Card;
import service.AtmMachine;

public class CardInsertedState implements AtmState {
    private AtmMachine atmMachine;
    public CardInsertedState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted");
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCard().getPin().equals(pin)) {
            atmMachine.setState(new AuthenticatedState(atmMachine));
            System.out.println("User is authenticated.");
        } else {
            System.out.println("Incorrect pin");
        }
    }

    @Override
    public void enterOption(String option) {
        System.out.println("Please enter your pin");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Please enter your pin");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        System.out.println("Card ejected");
        atmMachine.setState(new IdleState(atmMachine));
    }
}

package state;

import model.Card;
import service.AtmMachine;

public class CardInsertedState extends AtmState {
    public CardInsertedState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCard().getPin().equals(pin)) {
            atmMachine.setState(new AuthenticatedState(atmMachine));
            System.out.println("User authenticated");
        } else {
            System.out.println("Invalid pin");
        }
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("Authentication in-progress");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Authentication in-progress");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
        System.out.println("Card ejected");
    }

}

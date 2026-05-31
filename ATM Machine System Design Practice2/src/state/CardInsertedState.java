package state;

import model.Card;
import service.AtmMachine;

public class CardInsertedState extends AtmState{
    public CardInsertedState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCard().getPin().equals(pin)) {
            System.out.println("Pin entered is correct");
            atmMachine.setState(new AuthenticatedState(atmMachine));
        } else {
            System.out.println("Pin entered is incorrect");
        }
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("Please enter the pin");
    }

    @Override
    public void dispenseCash(long amount) {
        System.out.println("Please enter the pin");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
    }

}

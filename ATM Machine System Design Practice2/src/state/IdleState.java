package state;

import model.Card;
import service.AtmMachine;

public class IdleState extends AtmState{
    public IdleState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card) {
        atmMachine.setCard(card);
        System.out.println("Card inserted successfully");
        atmMachine.setState(new CardInsertedState(atmMachine));
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Please insert the card");
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("Please insert the card");
    }

    @Override
    public void dispenseCash(long amount) {
        System.out.println("Please insert the card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Please insert the card");
    }

}

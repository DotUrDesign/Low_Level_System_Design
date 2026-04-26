package state;

import model.Card;
import service.AtmMachine;

public class AuthenticatedState extends AtmState {
    public AuthenticatedState(AtmMachine atmMachine) {
        super(atmMachine);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Pin validated. User authenticated");
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("User wants to withdraw cash");
        atmMachine.setState(new CashDispensedState(atmMachine));
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Please enter the option");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
        System.out.println("Card ejected");
    }

}

package state;

import model.Card;
import service.AtmMachine;

public class AuthenticatedState extends AtmState{
    public AuthenticatedState(AtmMachine atmMachine) {
        super(atmMachine);
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Pin entered is correct");
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("Option selected : " + options);
        atmMachine.setState(new CashDispenseState(atmMachine));
    }

    @Override
    public void dispenseCash(long amount) {
        System.out.println("Please select the option");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
    }
}

package state;

import model.Card;
import service.AtmMachine;

public class AuthenticatedState implements AtmState {
    private AtmMachine atmMachine;
    public AuthenticatedState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }
    @Override
    public void insertCard(Card card) {
        System.out.println("Card is inserted already");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Pin is correct. User is authenticated.");
    }

    @Override
    public void enterOption(String option) {
        System.out.println("Option selected : " + option);
        atmMachine.setState(new DispenseCashState(atmMachine));
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Please select the option");
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        System.out.println("Card ejected");
        atmMachine.setState(new IdleState(atmMachine));
    }
}

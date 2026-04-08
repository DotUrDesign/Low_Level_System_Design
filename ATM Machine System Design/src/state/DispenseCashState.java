package state;

import cor.CashDispenser;
import cor.CashDispenserBuilderChain;
import model.Card;
import service.AtmMachine;

public class DispenseCashState implements AtmState {
    private AtmMachine atmMachine;
    private CashDispenser chain;

    public DispenseCashState(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
        chain = CashDispenserBuilderChain.buildCashDispenser();
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Transaction in progress");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Already authenticated");
    }

    @Override
    public void enterOption(String option) {
        System.out.println("Option already selected");
    }

    @Override
    public void dispenseCash(int amount) {
        double atmBalance = atmMachine.getAtm().getCashAvailable();
        double accBalance = atmMachine.getCard().getAccount().getAccBalance();

        if(amount > atmBalance) {
            System.out.println("ATM has insufficient balance to withdraw");
            ejectCard();
            return;

        }

        if(amount > accBalance) {
            System.out.println("Insufficient account balance");
            ejectCard();
            return;
        }

        if(chain.canDispense(atmMachine.getAtm(),amount)) {
            chain.dispense(atmMachine.getAtm(), amount);

            // if dispensing cash is possible, then dispense it.
            // after dispensing - change the account balance and atm balance
            atmMachine.getAtm().setCashAvailable(atmBalance-amount);
            atmMachine.getCard().getAccount().setAccBalance(accBalance-amount);

            // eject the card
            ejectCard();
            System.out.println("Cash dispensed : " + amount);
        } else {
            System.out.println("Did not have enough denominations to get the desired amuont.");
            ejectCard();
        }
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        System.out.println("Card ejected");
        atmMachine.setState(new IdleState(atmMachine));
    }
}

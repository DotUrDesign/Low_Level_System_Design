package state;

import cor.CashDispenser;
import cor.CashDispenserChainBuilder;
import model.Card;
import service.AtmMachine;

public class CashDispensedState extends AtmState {
    CashDispenser chain;
    public CashDispensedState(AtmMachine atmMachine) {
        super(atmMachine);
        chain = CashDispenserChainBuilder.getCashDispenserChain();
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Transaction in progress");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Pin is correct");
    }

    @Override
    public void enterOptions(String options) {
        System.out.println("Option selected");
    }

    @Override
    public void dispenseCash(int amount) {
        int accBalance = atmMachine.getCard().getAccount().getAccBalance();
        int atmBalance = atmMachine.getAtm().getCashAvailable();

        if(atmBalance < amount) {
            System.out.println("ATM does not have sufficient amount of money");
            ejectCard();
            return;
        }

        if(accBalance < amount) {
            System.out.println("Your account does not have sufficient amount of money");
            ejectCard();
            return;
        }

        if(chain.canDispense(amount, atmMachine.getAtm())) {
            chain.dispenseCash(amount, atmMachine.getAtm());

            atmMachine.getAtm().setCashAvailable(atmBalance - amount);
            atmMachine.getCard().getAccount().setAccBalance(accBalance - amount);

            ejectCard();
            System.out.println("Cash dispensed");
        } else {
            System.out.println("Didn't have enough denominations to get the desired amount");
            ejectCard();
        }
    }

    @Override
    public void ejectCard() {
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
        System.out.println("Card ejected");
    }

}

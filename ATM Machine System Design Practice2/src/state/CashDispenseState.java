package state;

import COR.CashDispenser;
import COR.CashDispenserChainBuilder;
import exceptions.AccountBalanceException;
import exceptions.AtmBalanceException;
import model.Card;
import service.AtmMachine;

public class CashDispenseState extends AtmState{
    CashDispenser chain;
    public CashDispenseState(AtmMachine atmMachine) {
        super(atmMachine);
        this.chain = CashDispenserChainBuilder.getChain();
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
        System.out.println("Option already selected");
    }

    @Override
    public void dispenseCash(long amount) throws AccountBalanceException, AtmBalanceException {
        long accBal = atmMachine.getCard().getAccount().getAccBalance();
        long atmBal = atmMachine.getAtm().getCashAvailable();

        if(accBal < amount) {
            throw new AccountBalanceException("Account Balance is less");
        }

        if(atmBal < amount) {
            throw new AtmBalanceException("Atm Balance is less");
        }

        if(chain.canDispense(amount, atmMachine.getAtm())) {
            chain.dispenseCash(amount, atmMachine.getAtm());
            System.out.println("Cash dispensed");
            atmMachine.getCard().getAccount().setAccBalance(accBal-amount);
            atmMachine.getAtm().setCashAvailable(atmBal-amount);
            ejectCard();
            System.out.println("Cash dispensed");
        } else {
            System.out.println("Didn't have enough denominations to get the desired amount");
            ejectCard();
        }
    }

    @Override
    public void ejectCard() {
        System.out.println("Card ejected");
        atmMachine.setCard(null);
        atmMachine.setState(new IdleState(atmMachine));
    }

}

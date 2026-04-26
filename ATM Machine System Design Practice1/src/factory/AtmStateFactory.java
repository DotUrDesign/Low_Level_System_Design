package factory;

import service.AtmMachine;
import state.*;

public class AtmStateFactory {
    public static AtmState getAtmState(String stateName, AtmMachine atmMachine) {
        if(stateName.equals("IDLE_STATE")) {
            return new IdleState(atmMachine);
        } else if(stateName.equals("CARD_INSERTED_STATE")) {
            return new CardInsertedState(atmMachine);
        } else if(stateName.equals("AUTHENTICATED_STATE")) {
            return new AuthenticatedState(atmMachine);
        } else if(stateName.equals("CASH_DISPENSED_STATE")) {
            return new CashDispensedState(atmMachine);
        } else {
            return null;
        }
    }
}

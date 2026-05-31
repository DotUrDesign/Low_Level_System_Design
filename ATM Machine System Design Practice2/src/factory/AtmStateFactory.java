package factory;

import service.AtmMachine;
import state.*;

public class AtmStateFactory {
    public static AtmState getState(AtmMachine atmMachine, String stateName) {
        if(stateName.equals("IDLE_STATE")) {
            return new IdleState(atmMachine);
        } else if(stateName.equals("CARD_INSERTED_STATE")) {
            return new CardInsertedState(atmMachine);
        } else if(stateName.equals("AUTHENTICATED_STATE")) {
            return new AuthenticatedState(atmMachine);
        } else if(stateName.equals("CASH_DISPENSED_STATE")) {
            return new CashDispenseState(atmMachine);
        }
        return null;
    }
}

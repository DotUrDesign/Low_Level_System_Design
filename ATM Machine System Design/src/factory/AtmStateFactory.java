package factory;

import service.AtmMachine;
import state.*;

public class AtmStateFactory {
    public static AtmState getAtmState(String stateName, AtmMachine atmMachine) {
        return switch(stateName) {
            case "IDLE_STATE" -> new IdleState(atmMachine);
            case "CARD_INSERTED" -> new CardInsertedState(atmMachine);
            case "AUTHENTICATED_STATE" -> new AuthenticatedState(atmMachine);
            case "DISPENSE_CASH_STATE" -> new DispenseCashState(atmMachine);
            default -> null;
        };
    }
}

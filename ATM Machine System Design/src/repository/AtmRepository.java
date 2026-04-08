package repository;

import model.ATM;

import java.util.HashMap;
import java.util.Map;

public class AtmRepository {
    private Map<String, ATM> atms = new HashMap<>();

    public void save(ATM atm) {
        atms.put(atm.getAtmId(), atm);
    }
}

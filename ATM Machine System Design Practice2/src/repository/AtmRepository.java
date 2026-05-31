package repository;

import model.Atm;

import java.util.HashMap;
import java.util.Map;

public class AtmRepository {
    Map<Long, Atm> atmHashMap = new HashMap<>();

    public void saveAtm(Atm atm) {
        atmHashMap.put(atm.getAtmId(), atm);
    }
}

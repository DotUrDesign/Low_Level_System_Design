package repository;

import model.Atm;

import java.util.HashMap;
import java.util.Map;

public class AtmRepository {
    Map<String, Atm> atmHashMap = new HashMap<>();

    public void save(Atm atm) {
        atmHashMap.put(atm.getAtmId(), atm);
    }
}

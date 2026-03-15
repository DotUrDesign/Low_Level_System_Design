package repository;

import model.Gate;

import java.util.HashMap;
import java.util.Optional;
/*
    Here, everywhere we are using in-memory database.
 */
public class GateRepository {
    HashMap<Long, Gate> GateHashMap = new HashMap<>();
    public Optional<Gate> getGateByGateId(Long gateId) {
        if(GateHashMap.containsKey(gateId)) {
            return Optional.of(GateHashMap.get(gateId));
        } else {
            return Optional.empty();
        }
    }
}

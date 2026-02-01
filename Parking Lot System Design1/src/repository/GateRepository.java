package repository;

import models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    HashMap<Long, Gate> gateMap = new HashMap<>();
    public Optional<Gate> getGateByGateId(Long gateId) {
        if(gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        } else {
            return Optional.empty();
        }
    }
}

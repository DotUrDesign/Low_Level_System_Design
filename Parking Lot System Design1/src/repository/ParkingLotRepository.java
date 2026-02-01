package repository;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository {
    HashMap<Long, ParkingLot> parkingLotHashMap = new HashMap<>();
    public Optional<ParkingLot> getParkingLotByParkingLotId(Long parkingLotId) {
        if(parkingLotHashMap.containsKey(parkingLotId)) {
            return Optional.of(parkingLotHashMap.get(parkingLotId));
        } else {
            return Optional.empty();
        }
    }
}

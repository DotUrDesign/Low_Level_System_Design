package repository;

import model.ParkingLot;

import java.util.HashMap;
import java.util.Optional;

public class ParkingLotRepository {
    HashMap<Long, ParkingLot> ParkingLotHashMap = new HashMap<>();
    public Optional<ParkingLot> getParkingLot(Long parkingLotId) {
        if(ParkingLotHashMap.containsKey(parkingLotId)) {
            return Optional.of(ParkingLotHashMap.get(parkingLotId));
        } else {
            return Optional.empty();
        }
    }
}

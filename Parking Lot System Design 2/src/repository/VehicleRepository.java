package repository;

import model.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    HashMap<String, Vehicle> vehicleHashMap = new HashMap<>();

    public Optional<Vehicle> getVehicleByVehicleNo(String vehicleNo) {
        if(vehicleHashMap.containsKey(vehicleNo)) {
            return Optional.of(vehicleHashMap.get(vehicleNo));
        } else {
            return Optional.empty();
        }
    }

    public void save(Vehicle vehicle) {
        vehicleHashMap.put(vehicle.getNo(), vehicle);
        return;
    }
}

package repository;

import models.Vehicle;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    HashMap<String, Vehicle> vehicleMap = new HashMap<>();
    public Optional<Vehicle> getVehicleByVehicleNo(String vehicleNo) {
        if(vehicleMap.containsKey(vehicleNo)) {
            return Optional.of(vehicleMap.get(vehicleNo));
        } else {
            return Optional.empty();
        }
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getNo(), vehicle);
        return;
    }
}

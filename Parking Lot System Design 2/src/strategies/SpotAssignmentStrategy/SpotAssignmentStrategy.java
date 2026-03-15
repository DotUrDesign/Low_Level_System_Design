package strategies.SpotAssignmentStrategy;

import model.Gate;
import model.ParkingSpot;
import model.enums.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}

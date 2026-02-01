package strategies.SpotAssignmentAlgorithm;

import enums.VehicleType;
import models.Gate;
import models.ParkingSpot;

public interface SpotAssignmentAlgo {
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}

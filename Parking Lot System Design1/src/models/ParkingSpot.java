package models;

import enums.ParkingSpotStatus;
import enums.VehicleType;

public class ParkingSpot extends BaseModel {
    private int spotNo;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingFloor floor;  // might be redundant, but for the sake of fast retrieval - we can store it here.
    private VehicleType vehicleType;

    public int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

package factory;

import model.ParkingSpot;
import model.enums.VehicleType;
import strategies.FeeCalculationStrategy.FeeCalculationStrategy;
import strategies.FeeCalculationStrategy.SUVFeeCalculationStrategy;
import strategies.FeeCalculationStrategy.SedanFeeCalculationStrategy;
import strategies.FeeCalculationStrategy.TwoWheelerFeeCalculationStrategy;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationStrategy getFeeCalculationStrategy(ParkingSpot parkingSpot) {
        if(parkingSpot.getVehicleType().equals(VehicleType.TWO_WHEELER)) {
            return new TwoWheelerFeeCalculationStrategy();
        } else if(parkingSpot.getVehicleType().equals(VehicleType.SUV)) {
            return new SUVFeeCalculationStrategy();
        } else if(parkingSpot.getVehicleType().equals(VehicleType.SEDAN)) {
            return new SedanFeeCalculationStrategy();
        }
        return null;
    }
}

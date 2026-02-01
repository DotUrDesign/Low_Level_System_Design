package factory;

import enums.VehicleType;
import strategies.FeeCalculationAlgorithm.FeeCalculationAlgo;
import strategies.FeeCalculationAlgorithm.FourWheelerFeeCalculationStrategy;
import strategies.FeeCalculationAlgorithm.TwoWheelerFeeCalculationStrategy;

public class FeeCalculationStrategyFactory {
    public static FeeCalculationAlgo getFeeCalculationAlgo(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.TWO_WHEELER)) {
            return new TwoWheelerFeeCalculationStrategy();
        } else if(vehicleType.equals(VehicleType.SUV) || vehicleType.equals(VehicleType.SEDAN)) {
            return new FourWheelerFeeCalculationStrategy();
        } else {
            return null;
        }
    }
}

package strategies.FeeCalculationStrategy;

import model.ParkingSpot;

public class SUVFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateAmount() {
        return 200;
    }
}

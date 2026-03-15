package strategies.FeeCalculationStrategy;

import model.ParkingSpot;

public class TwoWheelerFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public int calculateAmount() {
        return 20;
    }
}

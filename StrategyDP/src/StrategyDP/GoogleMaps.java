package StrategyDP;

public class GoogleMaps {
    void chooseStrategy(TravelMode travelMode) {
        PathCalcStrategy strategy = PathCalcStrategyFactory.getStrategy(travelMode);
        strategy.calculate();
    }
}

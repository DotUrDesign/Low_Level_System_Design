package StrategyDP;

public class PathCalcStrategyFactory {
    static PathCalcStrategy getStrategy(TravelMode travelMode) {
        if(travelMode.equals(TravelMode.CAR)) {
            return new CarPathCalcStrategy();
        } else if(travelMode.equals(TravelMode.BUS)) {
            return new BusPathCalcStrategy();
        } else if(travelMode.equals(TravelMode.WALK)) {
            return new WalkPathCalcStrategy();
        }
        return null;
    }
}

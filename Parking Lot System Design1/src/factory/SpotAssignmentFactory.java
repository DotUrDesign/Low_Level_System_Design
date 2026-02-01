package factory;

import enums.SpotAssignmentStrategyType;
import strategies.SpotAssignmentAlgorithm.CheapestSpotAssignmentStrategy;
import strategies.SpotAssignmentAlgorithm.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentAlgorithm.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentAlgorithm.SpotAssignmentAlgo;

public class SpotAssignmentFactory {
    public static SpotAssignmentAlgo getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        } else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)) {
            return new CheapestSpotAssignmentStrategy();
        } else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.RANDOM)) {
            return new RandomSpotAssignmentStrategy();
        } else {
            return null;
        }
    }
}

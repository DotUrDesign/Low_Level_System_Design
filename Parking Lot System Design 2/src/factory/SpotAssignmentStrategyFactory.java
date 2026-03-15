package factory;

import model.enums.SpotAssignmentStrategyType;
import strategies.SpotAssignmentStrategy.CheapestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy.NearestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy.SafestSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.NEAREST)) {
            return new NearestSpotAssignmentStrategy();
        } else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)) {
            return new CheapestSpotAssignmentStrategy();
        } else if(spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.SAFEST)) {
            return new SafestSpotAssignmentStrategy();
        }
        return null;
    }
}

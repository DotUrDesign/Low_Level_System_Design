package strategies.FeeCalculationAlgorithm;

import exceptions.EntryOrExitTimeException;

public class FourWheelerFeeCalculationStrategy implements FeeCalculationAlgo{
    @Override
    public int calculateAmount(Long entryTime, Long exitTime) throws EntryOrExitTimeException {
        if(entryTime == null || exitTime == null || exitTime < entryTime) {
            throw new EntryOrExitTimeException("Entry time or exit time is invalid.");
        }

        Long duration = exitTime - entryTime;
        long hours = (long) Math.ceil(duration/(1000.0 * 60.0 * 60.0));
        int costPerHour = 20;
        int cost = (int) (hours * costPerHour);
        return cost;
    }
}

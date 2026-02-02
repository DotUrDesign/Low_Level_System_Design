package strategies.FeeCalculationAlgorithm;

import exceptions.EntryOrExitTimeException;

public class TwoWheelerFeeCalculationStrategy implements FeeCalculationAlgo{

    @Override
    public int calculateAmount(Long entryTime, Long exitTime) throws EntryOrExitTimeException {
        if(entryTime == null || exitTime == null || exitTime < entryTime) {
            throw new EntryOrExitTimeException("Invalid entry or exit time");
        }

        long durationMillis = exitTime - entryTime;

        long hours = (long) Math.ceil(durationMillis/(1000.0 * 60 * 60));

        int costPerHour = 5;

        return (int) (hours * costPerHour);
    }
}

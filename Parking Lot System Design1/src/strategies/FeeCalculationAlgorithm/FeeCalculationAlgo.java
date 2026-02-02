package strategies.FeeCalculationAlgorithm;

import exceptions.EntryOrExitTimeException;

public interface FeeCalculationAlgo {
    public int calculateAmount(Long entryTime, Long exitTime) throws EntryOrExitTimeException;
}

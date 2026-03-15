package strategies.FeeCalculationStrategy;

public class SedanFeeCalculationStrategy implements FeeCalculationStrategy{
    @Override
    public int calculateAmount() {
        return 300;
    }
}

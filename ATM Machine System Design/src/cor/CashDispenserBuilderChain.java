package cor;

public class CashDispenserBuilderChain {
    public static CashDispenser buildCashDispenser() {
        CashDispenser d1 = new TwoThousandCashDispenser();
        CashDispenser d2 = new FiveHundredCashDispenser();
        CashDispenser d3 = new OneHundredCashDispenser();

        d1.setNextDispenser(d2);
        d2.setNextDispenser(d3);
        return d1;
    }
}

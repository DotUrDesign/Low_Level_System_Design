package cor;

public class CashDispenserChainBuilder {
    public static CashDispenser getCashDispenserChain() {
        CashDispenser d1 = new TwoThousandCashDispenser();
        CashDispenser d2 = new FiveHundredCashDispenser();
        CashDispenser d3 = new OneHundredCashDispenser();

        d1.setCashDispenser(d2);
        d2.setCashDispenser(d3);
        return d1;
    }
}

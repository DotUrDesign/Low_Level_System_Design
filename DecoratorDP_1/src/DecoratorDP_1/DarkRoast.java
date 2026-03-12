package DecoratorDP_1;

public class DarkRoast implements Beverage {
    @Override
    public String getDesc() {
        return "DarkRoast";
    }

    @Override
    public int getAmount() {
        return 100;
    }
}

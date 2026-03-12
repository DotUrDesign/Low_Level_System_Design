package DecoratorDP_1;

public class HouseBlend implements Beverage {
    @Override
    public String getDesc() {
        return "HouseBlend";
    }

    @Override
    public int getAmount() {
        return 100;
    }
}

package DecoratorDP;

public class HouseBlend implements Beverage{
    @Override
    public String getDesc() {
        return "Houseblend";
    }

    @Override
    public int getCost() {
        return 150;
    }
}

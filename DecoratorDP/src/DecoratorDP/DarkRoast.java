package DecoratorDP;

public class DarkRoast implements Beverage{
    @Override
    public String getDesc() {
        return "DarkRoast";
    }

    @Override
    public int getCost() {
        return 200;
    }
}

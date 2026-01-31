package DecoratorDP;

public class Mocha extends AddOn{
    Mocha(Beverage b) {
        super(b);
    }

    @Override
    public String getDesc() {
        return b.getDesc() + " + Mocha";
    }

    @Override
    public int getCost() {
        return b.getCost() + 70;
    }
}

package DecoratorDP;

public class Milk extends AddOn{
    public Milk(Beverage b){
        super(b);
    }

    @Override
    public String getDesc() {
        return b.getDesc() + " + Milk";
    }

    @Override
    public int getCost() {
        return b.getCost() + 50;
    }
}

package DecoratorDP_1;

public class Milk extends AddOn {
    public Milk(Beverage b) {
        super(b);
    }
    @Override
    public String getDesc() {
        return this.b.getDesc() + " + Milk";
    }
    @Override
    public int getAmount() {
        return this.b.getAmount() + 25;
    }
}

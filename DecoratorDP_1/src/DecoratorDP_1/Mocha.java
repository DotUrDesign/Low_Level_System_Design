package DecoratorDP_1;

public class Mocha extends AddOn {
    public Mocha(Beverage b) {
        super(b);
    }
    @Override
    public String getDesc() {
        return this.b.getDesc() + " + Mocha";
    }
    @Override
    public int getAmount() {
        return this.b.getAmount() + 30;
    }
}

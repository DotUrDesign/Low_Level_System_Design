package DecoratorDP_1;

public class Client {
    public static void main(String[] args) {
        Beverage b = new DarkRoast();
        System.out.println(b.getDesc());
        System.out.println(b.getAmount());
        b = new Mocha(b);
        System.out.println(b.getDesc());
        System.out.println(b.getAmount());
        b = new Milk(b);
        b = new Milk(b);
        System.out.println(b.getDesc());
        System.out.println(b.getAmount());
    }
}

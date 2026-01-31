package BirdV4;

public class Peacock extends BirdV4 implements Flyable, Danceable {
    FlyingBehaviour f = new FlyLow();
    @Override
    public void fly() {
        f.makeFly();
    }
    @Override
    public void dance() {
        System.out.println("Peacock dance");
    }
    @Override
    public void makeSound() {
        System.out.println("Peacock sound");
    }
}

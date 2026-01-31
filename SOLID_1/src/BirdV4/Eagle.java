package BirdV4;

public class Eagle extends BirdV4 implements Flyable {
    FlyingBehaviour f = new FlyHigh();
    @Override
    public void fly() {
        f.makeFly();
    }
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }
}

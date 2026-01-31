package BirdV4;

public class Peacock extends BirdV4 implements Flyable,Danceable{
    FlyLow fl = new FlyLow();
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }

    @Override
    public void fly() {
        fl.fly();
    }

    @Override
    public void dance() {
        System.out.println("Peacock dance");
    }
}

package BirdV3;

public class Peacock extends BirdV3 implements Flyable, Danceable{
    @Override
    public void fly() {
        System.out.println("Fly high");
    }

    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }

    @Override
    public void dance() {
        System.out.println("Peacock dance");
    }
}

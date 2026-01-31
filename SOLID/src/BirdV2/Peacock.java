package BirdV2;

public class Peacock extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Fly low");
    }

    @Override
    public void makeSound() {
        System.out.println("Peacock sound");
    }

    public void dance() {
        System.out.println("Peacock dance");
    }
}

package BirdV3;

public class Peacock extends BirdV3 implements Flyable {
    @Override
    public void fly() {
        System.out.println("Fly low");
    }
    @Override
    public void makeSound() {
        System.out.println("Peacock sound");
    }
}

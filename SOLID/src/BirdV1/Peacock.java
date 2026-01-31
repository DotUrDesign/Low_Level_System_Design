package BirdV1;

public class Peacock extends BirdV1 {
    @Override
    public void fly() {
        System.out.println("fly low");
    }

    @Override
    public void makeSound() {
        System.out.println("peacock sound");
    }

    public void dance() {
        System.out.println("peacock dance");
    }
}

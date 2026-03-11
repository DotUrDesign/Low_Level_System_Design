package BirdV3;

public class Penguin extends BirdV3 implements Danceable {
    @Override
    public void dance() {
        System.out.println("Penguin dance");
    }
    @Override
    public void makeSound() {
        System.out.println("Penguin sound");
    }
}

package BirdV2;

public class Eagle extends FlyingBird{
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }

    @Override
    public void fly() {
        System.out.println("Fly high");
    }
}

package BirdV1;

public class Eagle extends BirdV1 {
    @Override
    public void fly() {
        System.out.println("fly high");
    }

    @Override
    public void makeSound() {
        System.out.println("eagle sound");
    }
}

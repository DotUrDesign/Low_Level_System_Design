package BirdV1;

public class Eagle extends BirdV1 {
    @Override
    public void fly() {
        System.out.println("Fly High");
    }
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }
}

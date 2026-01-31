package BirdV2;

public class Eagle extends FlyingBird{
    @Override
    public void fly() {
        System.out.println("Fly high");
    }
    @Override
    public void makeSound() {
        System.out.println("Eagle sound");
    }

    public void fun1() {
        System.out.println("Function method of Eagle");
    }
}

package BirdV2;

public class Client {
    public static void main(String[] args) {
        FlyingBird b1 = new Eagle();
        b1.fly();
        b1.makeSound();

        NonFlyingBird b2 = new Penguin();
        b2.makeSound();

        FlyingBird b3 = new Peacock();
        b3.fly();
        b3.makeSound();
        ((Peacock)b3).dance();
    }
}

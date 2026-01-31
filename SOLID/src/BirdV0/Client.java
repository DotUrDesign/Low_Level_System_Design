package BirdV0;

public class Client {
    public static void main(String[] args) {
        BirdV0 b1 = new BirdV0("Peacock");
        b1.fly();
        b1.makeSound();

        BirdV0 b2 = new BirdV0("Eagle");
        b2.fly();
        b2.makeSound();
    }
}

package BirdV1;

public class Client {
    public static void main(String[] args) {
        BirdV1 b1 = new Peacock();
        b1.fly();
        b1.makeSound();
        b1.eat();
        ((Peacock) b1).dance();

        Peacock p1 = new Peacock();
        p1.dance();

        BirdV1 b2 = new Eagle();
        b2.fly();
        b2.makeSound();
        b2.eat();
    }
}

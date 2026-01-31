package BirdV4;

public class Client {
    public static void main(String[] args) {
        BirdV4 b = new Peacock();
        b.eat();
        ((Peacock)b).fly();
        ((Peacock)b).dance();

        Flyable b1 = new Peacock();
        b1.fly();

        Peacock p = new Peacock();
        p.eat();
        p.dance();
        p.makeSound();

        Eagle e = new Eagle();
        e.eat();
        e.makeSound();
    }
}

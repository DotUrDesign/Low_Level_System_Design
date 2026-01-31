package BirdV4;

public class Client {
    public static void main(String[] args) {
        Eagle b1 = new Eagle();
        b1.eat();
        b1.fly();
        b1.makeSound();

        Peacock b2 = new Peacock();
        b2.eat();
        b2.fly();
        b2.makeSound();
        b2.dance();
    }
}

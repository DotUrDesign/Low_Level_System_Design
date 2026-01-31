package BirdV1;
/*
    In this case, we can see that when we calling the fly method for penguin, it's returning nothing.
    LSP - Liskov's Substitution Principle
        - If the child class is implementing the parent class, then the child class should implement all the methods of the parent class correctly(gracefully - meaning it should not have nothing inside the method, or it should not throw any exception).
*/
public class Client {
    public static void main(String[] args) {
        BirdV1 b1 = new Penguin();
        b1.fly();
        b1.makeSound();
    }
}

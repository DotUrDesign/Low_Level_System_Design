package BirdV1;
/*
    1. SRP followed
    2. OCP followed
    3. A child class should implement all its parent class's methods, otherwise it's not a child.
 */
public abstract class BirdV1 {
    String type;
    void eat() {
        System.out.println("Every bird eats");
    }

    public abstract void fly();
    public abstract void makeSound();
}

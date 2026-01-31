package BirdV2;

public abstract class BirdV2 {
    String type;
    public void eat() {
        System.out.println("Eat method");
    }

    public abstract void makeSound();
}

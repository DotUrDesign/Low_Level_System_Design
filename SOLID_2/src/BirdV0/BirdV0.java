package BirdV0;
/*
    => OCP principle is violated.
    Multiple if-else blocks are present inside the single class.

    => SRP principle is violated.
    There are more than one reason to change this class.

 */
public class BirdV0 {
    private String bird;
    public BirdV0(String bird) {
        this.bird = bird;
    }
    public void eat() {
        System.out.println("Eat method");
    }
    public void fly() {
        if(bird.equals("Eagle")) {
            System.out.println("Fly High");
        } else if(bird.equals("Peacock")) {
            System.out.println("Fly low");
        }
    }
    public void makeSound() {
        if(bird.equals("Eagle")) {
            System.out.println("Eagle sound");
        } else if(bird.equals("Peacock")) {
            System.out.println("Peacock sound");
        }
    }
}

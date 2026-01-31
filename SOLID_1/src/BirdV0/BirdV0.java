package BirdV0;
/*
    1. SRP - Single responsibility principle
           - There should be only one reason to change a code unit(class/package/method)

    2. OCP - Open Closed Principle
           - Open for extension, and closed for modification.

 */
public class BirdV0 {
    private String bird;
    public BirdV0(String bird) {
        this.bird = bird;
    }
    public void fly() {
        if(this.bird.equals("Eagle")) {
            System.out.println("Fly high");
        } else if(this.bird.equals("Peacock")) {
            System.out.println("Fly low");
        }
    }
    public void makeSound() {
        if(this.bird.equals("Eagle")) {
            System.out.println("Eagle sound");
        } else if(this.bird.equals("Peacock")) {
            System.out.println("Peacock sound");
        }
    }
}

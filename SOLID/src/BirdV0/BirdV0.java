package BirdV0;

/*
    1. multiple if-else blocks ==> OCP principle breaks
    2. This class has more than one reason to change ==> SRP principle breaks
 */

public class BirdV0 {
    String type;
    BirdV0(String type) {
        this.type = type;
    }

    void eat() {
        System.out.println("Every bird eats");
    }

    void fly() {
        if(type.equals("Peacock")) {
            System.out.println("Fly method of peacock");
        } else if(type.equals("Eagle")) {
            System.out.println("Fly method of eagle");
        }
    }

    void makeSound() {
        if(type.equals("Peacock")) {
            System.out.println("MakeSound method of peacock");
        } else if(type.equals("Eagle")) {
            System.out.println("MakeSound method of eagle");
        }
    }
}

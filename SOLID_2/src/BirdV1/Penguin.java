package BirdV1;
/*
    Liskov's Substitution Principle is violated.
    If the child class cant implement all the methods of the parent class
    properly, then it should not implement it.
    properly means the child class should not leave the implemented method
    blank or throw an exception inside the implemented method.
*/
public class Penguin extends BirdV1 {
    @Override
    public void fly() {

    }
    @Override
    public void makeSound() {
        System.out.println("Penguin sound");
    }
}

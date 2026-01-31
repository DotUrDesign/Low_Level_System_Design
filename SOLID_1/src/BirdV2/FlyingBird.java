package BirdV2;
/*
    If a child class wants to implement the parent class, and the child class doesn't want to implement the parent class methods - then the child class should be an abstract type, then that class doesn't need to implement the parent class's methods.
 */
public abstract class FlyingBird extends BirdV2{
    public abstract void fly();
}

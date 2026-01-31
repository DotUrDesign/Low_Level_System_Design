package BirdV2;
/*
    BirdV2(eat, makeSound(abs))  <----  FlyingBird(fly(abs))  <----  Eagle

    1st case -
    The object is of Eagle class and it's referencing to the BirdV2 class.
    It would only be able to call the methods of BirdV2 class, neither the methods of the FlyingBird, nor the personal methods of Eagle class itself.
    You want to call these methods - type cast the object - so that the object starts referencing the Eagle class itself.

    2nd case -
    Eagle b1 = new Eagle();
    The object is of type Eagle class, and it's referencing the object of Eagle class again. So, in this case,


    Problem -
    Class explosion can happen

 */
public class Client {
    public static void main(String[] args) {
        BirdV2 b = new Eagle();
        b.eat();
        b.makeSound();
        ((Eagle)b).fly();
        ((Eagle)b).fun1();

        FlyingBird b1 = new Eagle();
        b1.eat();
        b1.makeSound();
        b1.fly();
        ((Eagle)b1).fun1();

        Eagle e = new Eagle();
        e.eat();
        e.makeSound();
        e.fly();
        e.fun1();
    }
}

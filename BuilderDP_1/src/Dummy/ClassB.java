package Dummy;

public abstract class ClassB extends ClassA{
    public abstract void fun3();
    @Override
    public void fun1() {
        System.out.println("FUn1");
    }
    @Override
    public void fun2() {
        System.out.println("Fun2 from class B");
    }
}

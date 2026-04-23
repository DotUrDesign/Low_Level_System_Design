package Code_1;
/*
    There are 2 ways to promote multithreading -
    1. Implementing Runnable interface
    2. extending Thread class
 */
public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : Hello world");
    }
}

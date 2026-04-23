package Code_2;

public class HelloWorldPrinter extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " : Hello world");
    }
}

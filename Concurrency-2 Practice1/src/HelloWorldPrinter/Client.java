package HelloWorldPrinter;

public class Client {
    public static void main(String[] args) {
        Runnable h = new HelloWorldPrinter();
        Thread t1 = new Thread(h);
        t1.start();

        System.out.println("Main thread : " + Thread.currentThread().getName());

        Runnable h2 = new HelloWorldPrinter();
        Thread t2 = new Thread(h2);
        t2.start();
    }
}

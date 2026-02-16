package Code_1;

public class Client {
    public static void main(String[] args) {
        Runnable r1 = new HelloWorldPrinter();
        Thread t1 = new Thread(r1);
        t1.start();

        System.out.println(Thread.currentThread().getName() + " - Client");

        Runnable r2 = new HelloWorldPrinter();
        Thread t2 = new Thread(r2);
        t2.start();
    }
}

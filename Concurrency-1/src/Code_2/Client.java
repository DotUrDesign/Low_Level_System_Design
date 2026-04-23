package Code_2;

public class Client {
    public static void main(String[] args) {
        Thread t = new HelloWorldPrinter();
        t.start();

        System.out.println("Main thread : " + Thread.currentThread().getName());
    }
}

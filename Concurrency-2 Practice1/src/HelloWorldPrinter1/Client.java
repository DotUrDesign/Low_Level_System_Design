package HelloWorldPrinter1;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Runnable h1 = new HelloWorldPrinter();

        for(int i=0;i<10000;i++) {
            Thread.sleep(1000);
            Thread t = new Thread(h1);
            t.start();
        }

        System.out.println("Main thread : " + Thread.currentThread().getName());
    }
}

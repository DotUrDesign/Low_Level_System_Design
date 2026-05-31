package HelloWorldPrinter1;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Current Thread : " + Thread.currentThread().getName());
    }
}

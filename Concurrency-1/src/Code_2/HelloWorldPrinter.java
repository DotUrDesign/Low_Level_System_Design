package Code_2;

public class HelloWorldPrinter implements Runnable{
    @Override
    public void run() {
        //            Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " - Helloworld");

    }
}

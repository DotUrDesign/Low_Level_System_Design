package Code_2;

import Code_1.HelloWorldPrinter;
/*
    Remember t.start() will be promoting multithreading. Meaning everytime this line is called,
    a new thread is assigned some work and executed.

    But in case of t.run() -> this is a basic function call, so the main thread goes and executes
    the work, no threads are being created.
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new HelloWorldPrinter();
        for(int i=1;i<=10000;i++) {
            Thread.sleep(1000);
            Thread t = new Thread(r);
            t.start();
        }
    }
}

package Code_1;

public class Client {
    public static void main(String[] args) {
        Runnable rh = new HelloWorldPrinter();
        // The constructor of the thread class expects a runnable class as an argument.
        Thread t = new Thread(rh);
        t.start(); // this will be promoting multithreading -> meaning the class which is
        // implemented by the runnable will be running in a separate thread.
        System.out.println("Main thread : " + Thread.currentThread().getName());
        // t.run(); // this will be executed by the main thread => no multithreading
    }
}

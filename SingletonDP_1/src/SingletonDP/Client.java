package SingletonDP;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    private AtomicInteger a = new AtomicInteger(10);
    public static void main(String[] args) throws InterruptedException {
        DBConnection DBConn1 = DBConnection.getConnection();
        System.out.println(DBConn1);
        DBConnection DBConn2 = DBConnection.getConnection();
        System.out.println(DBConn2);

        // Checking whether the DBConnection1 is thread-safe or not.
        int threads = 100;
        CountDownLatch latch = new CountDownLatch(threads);

        Runnable task = () -> {
            DBConnection dbConn = DBConnection.getConnection();
            System.out.println(Thread.currentThread().getName() + " ---> " + dbConn);
            latch.countDown();
        };

        for(int i=0;i<threads;i++) {
            new Thread(task, "Thread-" + i).start();
        }

        latch.await();
        System.out.println("All threads finished.");
    }
}

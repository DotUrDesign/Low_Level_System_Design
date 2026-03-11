package SingletonDP;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    private AtomicInteger a = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        DBConnection dbConn1 = DBConnection.getDbConnection();
        System.out.println(dbConn1);
        DBConnection dbConn2 = DBConnection.getDbConnection();
        System.out.println(dbConn2);

        int threads = 100;
        CountDownLatch latch = new CountDownLatch(threads);

        Runnable task = () -> {
            DBConnection dbConnection = DBConnection.getDbConnection();
            System.out.println(Thread.currentThread().getName() + " ---> " + dbConnection);
            latch.countDown();
        };

        for(int i=0;i<threads;i++) {
            new Thread(task, "Thread-" + i).start();
        }

        latch.await();
        System.out.println("All threads finished");
    }
}

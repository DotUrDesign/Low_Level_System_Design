package SingletonDP;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
    Use "volatile" keyword while initialization of the DBConnection1.
    WHY ??
    See, there are 3 important keywords you have to understand, and when to use it.
    1. static
    2. AtomicInteger
    3. volatile

    static - Use it when you want exactly one shared copy of a variable per class/JVM
    AtomicInteger - Use it when multiple threads must update a numeric value atomically without using locks.
    volatile - Use it when one thread writes and the other thread must immediately see the latest value, especially for flags or safely publishing an object.

---------------------------------------------------------------------------------------------

    What are the things which by-passes the Singleton Design Pattern ?
    1. If the class implements Serializable Interface
    2. Usage of Reflection API

 */
public class DBConnection {
    private static volatile DBConnection DBConn = null;
    private static Lock lock = new ReentrantLock();
    public DBConnection() {
        System.out.println("DBConnection1 created");
    }
    public static DBConnection getConnection() {
        if(DBConn == null) {
            lock.lock();
            try {
                if (DBConn == null) {
                    DBConn = new DBConnection();
                }
            } finally {
                lock.unlock();
            }
        }
        return DBConn;
    }
}

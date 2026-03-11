package SingletonDP;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    static -
    static means it belongs to the class, not objects.
    Without static, every object will be having its own copy.
    With static, there will be only shared copy for the entire class.

    volatile -
    Its used for multithreading
    volatile ensures that if any thread updates the value of the DbConnection, then all other
    threads should be reading the updated value - they should not be reading any cached/stale data.

    Why not use Atomic instead of volatile -
    Simple, in our case, Atomicity is being handled by using locks.
    Atomic integer/long/any other references is used to ensure the operation(increment the value,
    update the value,...) is being handled in an atomic way without involving any locks.
    But in our case, we just want the threads to read each other's updated values, not stale value
    so, we used volatile in this case.


    To ensure any kind of multithreading problem not to happen, we are using
    DOUBLE CHECKED LOCKING APPROACH
 */
public class DBConnection {
    private static volatile DBConnection dbConnection = null;
    private static Lock lock = new ReentrantLock();

    public DBConnection() {

    }

    public static DBConnection getDbConnection() {
        if(dbConnection == null) {
            lock.lock();
            try {
                if(dbConnection == null) {
                    dbConnection = DBConnection.getDbConnection();
                }
            } finally {
                lock.unlock();
            }
        }
        return dbConnection;
    }
}

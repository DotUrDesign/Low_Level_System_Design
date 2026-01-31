package SingletonDP.SerializableBreakTest;
/*
    static - same for all the classes
    volatile - all the threads read the updated value of the dbconnection, not any stale/cached data maintained by the threads.

 */
import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBConnection1 implements Serializable {
    private static volatile DBConnection1 DBConn = null;
    private static Lock lock = new ReentrantLock();
    public DBConnection1() {

    }
    public static DBConnection1 getConnection() {
        if(DBConn == null) {
            lock.lock();
            try {
                if(DBConn == null) {
                    DBConn = new DBConnection1();
                }
            } finally {
                lock.unlock();
            }
        }
        return DBConn;
    }

}

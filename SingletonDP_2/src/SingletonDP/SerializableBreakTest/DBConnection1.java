package SingletonDP.SerializableBreakTest;

import java.io.Serializable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DBConnection1 implements Serializable {
    private static volatile DBConnection1 dbConnection = null;
    private static Lock lock = new ReentrantLock();

    public DBConnection1() {

    }

    public static DBConnection1 getDbConnection() {
        if(dbConnection == null) {
            lock.lock();
            try {
                if(dbConnection == null) {
                    dbConnection = DBConnection1.getDbConnection();
                }
            } finally {
                lock.unlock();
            }
        }
        return dbConnection;
    }
}

package Singleton_DP_SerializableTest;

import java.util.concurrent.locks.ReentrantLock;

public class DBConnection {
    private volatile static DBConnection dbConnection = null;
    private static ReentrantLock lock = new ReentrantLock();
    public DBConnection() {

    }
    public static DBConnection getConnection() {
        if(dbConnection == null) {
            lock.lock();
            try {
                if(dbConnection == null) {
                    dbConnection = new DBConnection();
                }
            } finally {
                lock.unlock();
            }
        }
        return dbConnection;
    }
}

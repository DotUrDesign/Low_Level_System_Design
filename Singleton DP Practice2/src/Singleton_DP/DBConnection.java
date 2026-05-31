package Singleton_DP;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class DBConnection implements Cloneable, Serializable {
    private volatile static DBConnection dbConnection = null;
    private static ReentrantLock lock = new ReentrantLock();
    public DBConnection() {

    }
    public static DBConnection getConnection() {
        if(dbConnection == null) {
            lock.lock();
            try {
                if (dbConnection == null) {
                    dbConnection = new DBConnection();
                }
            } finally {
                lock.unlock();
            }
        }
        return dbConnection;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public Object readResolve() {
        return dbConnection;
    }
}

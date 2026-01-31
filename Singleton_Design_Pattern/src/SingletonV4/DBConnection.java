package SingletonV4;

import java.util.concurrent.locks.Lock;

public class DBConnection {
    private static DBConnection dbConn = null;
    private static Lock lock;
    private DBConnection() {

    }

    public static DBConnection getInstance() {
        if(dbConn == null) {
            lock.lock();
            if(dbConn == null) {
                dbConn = new DBConnection();
                return dbConn;
            }
            lock.unlock();
        }
        return dbConn;
    }
}

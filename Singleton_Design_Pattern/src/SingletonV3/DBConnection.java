package SingletonV3;

public class DBConnection {
    private static DBConnection dbConn = null;
    private DBConnection() {

    }

    public static DBConnection getInstance() {
        if(dbConn == null) {
            dbConn = new DBConnection();
            return dbConn;
        }
        return dbConn;
    }
}

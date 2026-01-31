package SingletonV2;

public class DBConnection {
    private DBConnection() {
        System.out.println("DBConnection created");
    }
    public static DBConnection getInstance() {
        return new DBConnection();
    }
}

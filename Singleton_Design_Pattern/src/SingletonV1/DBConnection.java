package SingletonV1;

public class DBConnection {
    private DBConnection() {
        System.out.println("DB connection created");
    }
}

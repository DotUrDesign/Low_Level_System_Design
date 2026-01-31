package SingletonV0;
/*
    Multiple connections are getting created.
 */
public class SingletonV0 {
    public static void main(String[] args) {
        DBConnection dbConn1 = new DBConnection();
        DBConnection dbConn2 = new DBConnection();
    }
}

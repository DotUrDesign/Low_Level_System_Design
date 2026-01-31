package SingletonV2;
/*
    Again we can create multiple instances
 */
public class SingletonV2 {
    public static void main(String[] args) {
        DBConnection dbConn1 = DBConnection.getInstance();
        DBConnection dbConn2 = DBConnection.getInstance();
    }
}

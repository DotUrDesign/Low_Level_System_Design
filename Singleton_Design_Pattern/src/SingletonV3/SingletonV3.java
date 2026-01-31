package SingletonV3;
/*
    Is it thread safe?
 */

public class SingletonV3 {
    public static void main(String[] args) {
        DBConnection dbConn1 = DBConnection.getInstance();
        System.out.println(dbConn1);
        DBConnection dbConn2 = DBConnection.getInstance();
        System.out.println(dbConn2);
    }
}

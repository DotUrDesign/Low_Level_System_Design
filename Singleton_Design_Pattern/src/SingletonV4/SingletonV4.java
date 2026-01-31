package SingletonV4;
/*
    Creating a single instance and using it multiple times + Thread safe
 */
public class SingletonV4 {
    public static void main(String[] args) {
        DBConnection dbConn1 = DBConnection.getInstance();
        System.out.println(dbConn1);
        DBConnection dbConn2 = DBConnection.getInstance();
        System.out.println(dbConn2);
    }
}

package Singleton_DP;

public class Client {
    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getConnection();
        System.out.println(dbConnection);
    }
}

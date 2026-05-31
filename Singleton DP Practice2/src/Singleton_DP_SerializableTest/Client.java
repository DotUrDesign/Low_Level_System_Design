package Singleton_DP_SerializableTest;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBConnection dbConnection = DBConnection.getConnection();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("db.obj"));
        oos.writeObject(dbConnection);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("db.obj"));
        DBConnection dbConnection1 = (DBConnection) ois.readObject();
        ois.close();

        System.out.println("DBConnection ::: " + dbConnection);
        System.out.println("DBConnection1 ::: " + dbConnection1);
        System.out.println("Is DBConnection == DBConnection1 ? " + (dbConnection1 == dbConnection));
    }
}

package SingletonDP.SerializableBreakTest;

import java.io.*;

public class SerializableBreakTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBConnection1 dbConnection = DBConnection1.getDbConnection();

        // serialize it -
        // first converting the dbConnection object into bytes - serialized obj
        // then storing the serialized obj inside the db.obj file.
        // we are basically storing a photo of the obj.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("db.obj"));
        oos.writeObject(dbConnection);
        oos.close();

        // deserializing it
        // extracting the photo of the object from the db.obj file
        // then creating a concrete obj from that photo
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("db.obj"));
        DBConnection1 dbConnection1 = (DBConnection1) ois.readObject();
        ois.close();

        // printing the objects
        System.out.println("Connection 1 ==> " + dbConnection);
        System.out.println("Connection 2 ==> " + dbConnection1);
        System.out.println("Connection-1 == Connection-2 ? -> " + (dbConnection == dbConnection1));

        // so what I meant was - if I try to create multiple objects from the serialized one
        // (photo of the object) then all the objects created will be different from each other.
        // Which means that serializable interface by-passes singleton design pattern.
    }
}

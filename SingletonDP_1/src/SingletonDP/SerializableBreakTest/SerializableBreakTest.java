package SingletonDP.SerializableBreakTest;

import java.io.*;
/*

    What did we learn from this ?
    - First we created a connection object normally.
    - Then we serialized that connection object.
      So, basically what we did is, we created a photo of that connection object.

    - Now, deserializing the "serialized object" means we are creating a new object from that photo(created while serialization).
    - If we deserialize the photo(serialized object) mulitple times, then it creates multiple new objects.

    Object → serialize (photo taken)
    Photo → deserialize → NEW object
    Photo → deserialize again → ANOTHER new object

 */
public class SerializableBreakTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBConnection1 DBConn1 = DBConnection1.getConnection();

        // serialize the DBConn1
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("db.obj"));
        oos.writeObject(DBConn1);
        oos.close();

        // deserialize the Serialized Object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("db.obj"));
        DBConnection1 DBConn2 = (DBConnection1) ois.readObject();
        ois.close();

        System.out.println("Connection 1 ==> " + DBConn1);
        System.out.println("Connection 2 ==> " + DBConn2);
        System.out.println("Connection-1 == Connection-2 ? -> " + (DBConn1 == DBConn2));

        // Again deserialize the serialized connection
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("db.obj"));
        DBConnection1 DBConn3 = (DBConnection1) ois1.readObject();
        ois1.close();

        System.out.println("--------------------------------------------");

        System.out.println("Connection 1 ==> " + DBConn1);
        System.out.println("Connection 2 ==> " + DBConn2);
        System.out.println("Connection 3 ==> " + DBConn3);
        System.out.println("Connection-2 == Connection-3 ? -> " + (DBConn2 == DBConn3));
        System.out.println("Connection-1 == Connection-3 ? -> " + (DBConn1 == DBConn3));
    }
}

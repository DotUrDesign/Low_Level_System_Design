package BuilderV1;
/*
    Client should not have access to the StudentBuilder class. These are the internal backend
    stuffs which the client should not be able to access.

    The client should only have access to the essential things - like the Student class.

    DATA ABSTRACTION...
 */
public class Client {
    public static void main(String[] args) {
        Student sb = Student.getBuilder()
                .setName("Prats")
                .setAge(24)
                .setBatch("Academy")
                .build();

        System.out.println(sb.name);
    }
}

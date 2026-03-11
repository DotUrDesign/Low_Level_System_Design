package BuilderV3;

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

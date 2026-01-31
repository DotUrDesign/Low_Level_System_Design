package BuilderV2;


public class Client {
    public static void main(String[] args) {
        Student s = Student.getBuilder()
                .setName("Prats")
                .setGradYear(2024)
                .build();

        System.out.println(s.getName());
        System.out.println(s.getGradYear());
        System.out.println(s.getId());

    }
}

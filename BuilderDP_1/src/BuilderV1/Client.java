package BuilderV1;

/*
    Why Builder pattern is required ?
    - Solves the problem of constructor telescoping
    - Is important when you need to have basic validation checks for the values that are being passed by the client.
    - Is important when you need to have data-type restrictions over the values that are being passed by the client.
 */
public class Client {
    public static void main(String[] args) {
        Student s = Student.getBuilder()
                        .setName("Prats")
                        .setGradYear(2024)
                        .build();

        Student s2 = StudentBuilder.getBuilderFromStudentBuilder()
                                .setId(20)
                                .setName("Pratyush")
                                .setGradYear(2026)
                                .build();


        System.out.println(s.getName());
        System.out.println(s.getGradYear());
        System.out.println(s.getId());
        System.out.println("-------------------------------------");
        System.out.println(s2.getName());
        System.out.println(s2.getGradYear());
        System.out.println(s2.getId());

    }
}

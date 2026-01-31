package BuilderV0;
/*
    Why Builder pattern is required ?
    - Solves the problem of constructor telescoping
    - Is important when you need to have basic validation checks for the values that are being passed by the client.
    - Is important when you need to have data-type restrictions over the values that are being passed by the client.
 */
public class Client {
    public static void main(String[] args) {
        StudentBuilder sb = new StudentBuilder();
        sb.setName("Pratyush");
        sb.setGradYear(2024);

        Student s = new Student(sb);
        System.out.println(s.getName());
        System.out.println(s.getGradYear());
        System.out.println(s.getId());

    }
}

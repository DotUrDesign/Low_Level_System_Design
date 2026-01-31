package BuilderV1;

public class Client {
    public static void main(String[] args) {
        StudentBuilder sb = new StudentBuilder();
        sb.setName("Pratyush");
        sb.setAge(20);
        sb.setGradyear(2023);
        Student student = new Student(sb);
        System.out.println(student.name);
        System.out.println(student.age);
    }
}

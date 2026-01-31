package BuilderV2;

public class Client {
    public static void main(String[] args) {
        Student s = Student.builder()
                            .setName("Pratyush")
                            .setAge(20)
                            .setGradyear(2023)
                            .build();

        System.out.println(s.name);
        System.out.println(s.age);
    }
}

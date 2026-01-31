package BuilderV1;

public class Student {
    public String name;
    public int age;
    public String batch;
    public String course;
    public int gradyear;
    public Student(StudentBuilder sb) {
        // validation checks
        if(sb.name == null) {
            throw new IllegalArgumentException("Name should not be empty.");
        }
        if(sb.age < 10) {
            throw new IllegalArgumentException("Age cannot be less than 10.");
        }
        if(sb.gradyear > 2024) {
            throw new IllegalArgumentException("Gradyear must be smaller than 2024.");
        }

        this.name = sb.name;
        this.age = sb.age;
        this.batch = sb.batch;
        this.course = sb.course;
        this.gradyear = sb.gradyear;
    }
}

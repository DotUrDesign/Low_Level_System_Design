package BuilderV3;

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
    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        String name;
        int age;
        String batch;
        String course;
        int gradyear;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setGradyear(int gradyear) {
            this.gradyear = gradyear;
            return this;
        }

        public Student build() {
            return new  Student(this);
        }
    }
}

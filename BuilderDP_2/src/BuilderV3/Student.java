package BuilderV3;

public class Student {
    String name;
    int age;
    String batch;
    String course;
    int gradyear;
    public Student(StudentBuilder builder) {
        // basic validations
        if(builder.name == null) {
            throw new IllegalArgumentException("Name should not be empty.");
        }
        if(builder.age < 10) {
            throw new IllegalArgumentException("Age cannot be less than 10.");
        }
        if(builder.gradyear > 2024) {
            throw new IllegalArgumentException("Gradyear must be smaller than 2024.");
        }

        // setting the parameters
        this.name = builder.name;
        this.age = builder.age;
        this.batch = builder.batch;
        this.course = builder.course;
        this.gradyear = builder.gradyear;
    }

    public static StudentBuilder getBuilder() {
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
            return new Student(this);
        }
    }
}

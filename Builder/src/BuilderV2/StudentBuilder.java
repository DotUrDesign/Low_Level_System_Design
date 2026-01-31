package BuilderV2;

public class StudentBuilder {
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

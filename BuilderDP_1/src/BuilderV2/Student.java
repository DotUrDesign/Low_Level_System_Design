package BuilderV2;
/*
    Here, the class StudentBuilder is made static. WHY ??
    If the class StudentBuilder has been made non-static, then the to create an object of StudentBuilder, we first need an object of Student. And in our case, to create an object of Student, we have to first create an object of StudentBuilder ---> Circular dependency (chicken-egg problem/deadlock situation)

    If the class StudentBuilder is made non-static, then the class StudentBuilder has no exitence without the class Student.

 */

public class Student {
    private int id;
    private String name;
    private String batch;
    private int gradYear;
    public Student(StudentBuilder builder) {
        if(builder.getName() == null) {
            throw new IllegalArgumentException("Name should not be empty.");
        }
        if(builder.getGradYear() < 2024) {
            throw new IllegalArgumentException("Graduation Year should be equal or greater than 2024");
        }

        this.id = builder.getId();
        this.name = builder.getName();
        this.batch = builder.getBatch();
        this.gradYear = builder.getGradYear();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBatch() {
        return batch;
    }

    public int getGradYear() {
        return gradYear;
    }

    public static StudentBuilder getBuilder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private int id;
        private String name;
        private String batch;
        private int gradYear;

        public int getId() {
            return id;
        }

        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public String getBatch() {
            return batch;
        }

        public StudentBuilder setBatch(String batch) {
            this.batch = batch;
            return this;
        }

        public int getGradYear() {
            return gradYear;
        }

        public StudentBuilder setGradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

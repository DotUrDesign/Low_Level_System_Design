package BuilderV1;
/*
    There are 2 methods which are concern about for now -
    1. getBuilder() method of Student class
    2. build() method of StudentBuilder class

    In the first case, the getBuilder() method has been made static and in the second case, the build() method is made non-static.

    WHY ??
    Whenever static name comes to your mind - think about these line -
    1. Static has nothing to do with returning of an object.
    2. Ask this question to yourself => Does the method need values stored inside one particular object?

    Inside the getBuilder method, it didn't need any data of any specific object. No id, no name, nothing...Meaning in this case, we can use the static keyword.

    Inside the build() method, it needs the data of the specific/current object(this keyword) - meaning in this case, we can't use static keyword.
 */
public class StudentBuilder {
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

    public static StudentBuilder getBuilderFromStudentBuilder() {
        return new StudentBuilder();
    }
}

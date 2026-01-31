package PrototypeDP;

public class Student implements Prototype<Student>{
    int id;
    String name;
    String batch;

    Student() {

    }
    
    Student(Student s) {
        this.id = s.id;
        this.name = s.name;
        this.batch = s.batch;
    }

    @Override
    public Student copy() {
        return new Student(this);
    }
}

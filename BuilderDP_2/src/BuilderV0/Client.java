package BuilderV0;
/*
    2 things are important to know:
    1) why we need Builder design pattern
    2) whats the flow of builder design pattern

    why do we need builder design pattern ?
    - To avoid constructor telescoping => multiple constructors will be created covering all the
    cases via which the client can pass parameters
    like if we have 8 arguments
    no of constructors = 8c1 + 8c2 + 8c3....8c8

    - If we need basic validations => like we will be accepting only the dates which are from 1990
    to 2080.

    - Data type restrictions => for this reason only, we are not able to use objects because anyone
    can pass name to the id argument. Anything can be passed to any parameter.


    FLOW -
    1) First set the values to the StudentBuilder.
    2) Then pass the studentBuilder to the student class constructor.
    3) Then it will go through the basic validations of the Student class.
    4) Then set the parameters of the student class.
    5) Return the student object to the client.

    StudentBuilder(creation) --> Setting the parameters of the studentBuilder -->
    Student(StudentBuilder) --> Basic validations of the student --> Setting the parameters of the
    studentBuilder --> Return the student class.

 */
public class Client {
    public static void main(String[] args) {
        StudentBuilder sb = new StudentBuilder();
        sb.setAge(24);
        sb.setBatch("Illuminati Batch");
        sb.setGradyear(2020);
        sb.setName("Pratyush");
        Student st = new Student(sb);
        System.out.println(st.name);
        System.out.println(st.age);
        System.out.println(st.gradyear);
        System.out.println(st.course);
        System.out.println(st.batch);
    }
}
















package PrototypeDP;

public class Client {
    public static Student makeACopy(Student s) {
        Student outputObj = s.copy();
        return outputObj;
    }

    public static void main(String[] args) {
        // STUDENT OBJECT

        Student s1 = new Student();
        s1.name = "Prats";
        s1.id = 21;

        // Student s2 = s1.copy();  --> We generally dont prefer this as we dont want the user to know the class methods

        Student s2 = makeACopy(s1);
        System.out.println(s1.name);
        System.out.println(s2.name);

        System.out.println("Changing the data members values");
        s2.name = "Pratyush";
        System.out.println(s1.name);
        System.out.println(s2.name);


        // INTELLIGENT STUDENT
        IntelligentStudent ist = new IntelligentStudent();
        ist.name = "Prats";
        ist.id = 21;

        IntelligentStudent ist2 = makeACopy(ist);
        ist2.name = "Remon";
        ist2.id = 25;


    }
}

package PrototypeDP;

public class IntelligentStudent extends Student{
    int iq;
    IntelligentStudent() {

    }

    IntelligentStudent(IntelligentStudent ist) {
        super(ist);
        this.iq = ist.iq;
    }

    @Override
    public IntelligentStudent copy() {
        return new IntelligentStudent(this);
    }
}

package BuilderV0;

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
}

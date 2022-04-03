package bean;

public class Student {
    private long iD;
    private String name;

    public void setID(long iD) {
        this.iD = iD;
    }

    public long getID() {
        return iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student(long iD, String name) {
        this.iD = iD;
        this.name = name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                '}';
    }
}

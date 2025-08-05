import java.util.*;
public class Student
{
    private int Id;
    private int marks;
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}

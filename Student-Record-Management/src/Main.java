import java.util.*;
public class Main
{
    public static void view(List<Student> students1)
    {
        if(students1.isEmpty())
        {
            System.out.println("No Record Found");
            return;
        }
        System.out.println("*----------*----------*----------*");
        System.out.printf("%-10s %-15s %-5s\n", "ID", "Name", "Marks");
        for (Student s : students1) {
            System.out.printf("%-10d %-15s %-5d\n", s.getId(), s.getName(), s.getMarks());

        }
        System.out.println("*----------*----------*----------*");
    }
    public static List<Student> add(List<Student> students)
    {
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int marks = sc.nextInt();

        for(Student student:students)
        {
            if(student.getId()==id)
            {
                System.out.println("Student with this Id already exists");
                return students;
            }
            //System.out.println("No student found of this Id");
        }
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setMarks(marks);

        students.add(student);
        students.sort((a, b) -> Integer.compare(a.getId(), b.getId()));
        return students;
    }
    public static boolean viewId(List<Student> students1,int id)
    {
        for(Student student:students1)
        {
            if(student.getId()==id) {
                System.out.println(student.getId() + " " + student.getName() + " " + student.getMarks());
                return true;
            }
        }
        return false;
    }
    public static List<Student> update(List<Student> students1)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which Student do you want to update. Enter the Id");
        int id = sc.nextInt();
        if(!viewId(students1,id))
        {
            System.out.println("No student found of this Id");
            return students1;
        }
        System.out.println("What you want to change ?");
        System.out.println("Press 1 to change name");
        System.out.println("Press 2 to change marks");
        System.out.println("Press 3 to chang both");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Enter new name ");
                sc.nextLine();
                String name = sc.nextLine();
                for(Student student : students1)
                {
                    if(student.getId()==id)
                    {
                        student.setName(name);
                    }
                }
            break;
            case 2:
                System.out.println("Enter new marks");
                int marks =  sc.nextInt();
                for(Student student : students1)
                {
                    if(student.getId()==id)
                    {
                        student.setMarks(marks);
                    }
                }
                break;
            case 3:
                System.out.println("Enter new name");
                sc.nextLine();
                String name1 = sc.nextLine();
                System.out.println("Enter new marks");
                int mark = sc.nextInt();
                for(Student student : students1)
                {
                    if(student.getId()==id)
                    {
                        student.setName(name1);
                        student.setMarks(mark);
                    }
                }
                break;
        }
        students1.sort((a, b) -> Integer.compare(a.getId(), b.getId()));
        return students1;
    }
    public static List<Student> delete(List<Student> students)
    {
        Scanner sc = new Scanner(System.in);

        if(students.isEmpty())
        {
            System.out.println("Nothing to Delete");
            return null;
        }
        System.out.println("Enter id of the student you want to delete");
        int id = sc.nextInt();

        for(int i=0;i<students.size();i++)
        {
            if(students.get(i).getId()==id)
            {
                students.remove(i);
                students.sort((a, b) -> Integer.compare(a.getId(), b.getId()));
                return students;
            }
        }
        System.out.println("No student exists with such Id");
        students.sort((a, b) -> Integer.compare(a.getId(), b.getId()));
        return students;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Student Record Management System");

        List<Student> students = new ArrayList<>();
        while(true)
        {
            System.out.println("Enter 1 for Adding the Student in the Record");
            System.out.println("Enter 2 for Viewing the Students in the Record");
            System.out.println("Enter 3 for Updating the Student in the Record");
            System.out.println("Enter 4 for Deleting the Student from the Record");
            System.out.println("Enter 5 for Exit from the Student Record Management System");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    add(students);
                    System.out.println("Current Records");
                    view(students);
                    break;
                case 2:
                    view(students);
                    break;
                case 3:
                    students = update(students);
                    view(students);
                    break;
                case 4:
                    students = delete(students);
                    view(students);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try Again");
            }
        }
    }
}
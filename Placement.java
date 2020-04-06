import java.util.*;

class Student
{
    String name, regno, course;
    float cgpa;
    boolean placed;
    public static Scanner kb = new Scanner(System.in);
    public Student()
    {
        System.out.println("Enter name : ");
        this.name = kb.nextLine();
        System.out.println("Enter Registration number : ");
        this.regno = kb.nextLine();
        System.out.println("Enter Course : ");
        this.course = kb.nextLine();
        System.out.println("Enter CGPA : ");
        this.cgpa = Float.parseFloat(kb.nextLine());
        System.out.println("Is placed (y/n) : ");
        String ch = kb.nextLine();
        placed = ch.equals("y")? true : false;
    }
    public void showDetails()
    {
        System.out.println("Name : " + name);
        System.out.println("Registration  : " + regno);
        System.out.println("Course : " + course);
        System.out.println("CGPA : " + cgpa);
        System.out.println("Placed : " + ((placed)? "Yes" : "No"));
    }
}

class Placement
{
    static ArrayList<Student> students = new ArrayList<Student>();
    static int choice = 0;
    public static void main(String[] args)
    {
        do 
        {
            System.out.println("1. Add New Student");
            System.out.println("2. View Student List");
            System.out.println("3. Exit");
            choice = Integer.parseInt(Student.kb.nextLine());
            switch(choice)
            {
                case 1: Student st = new Student();
                        students.add(st);
                        break;
                case 2: System.out.println("Enter minimum cgpa");
                        float c = Float.parseFloat(Student.kb.nextLine());
                        System.out.println("Enter Course ");
                        String cr = Student.kb.nextLine();
                        displayList(c, cr);
            }
        } while (choice != 3);
        Student.kb.close();
    }
    static void displayList(float cgpa, String course)
    {
        for (Student student : students)
        {
            if(!student.placed && student.cgpa >=cgpa && student.course.equals(course))
                student.showDetails();  
            else{
                System.out.println("No sudent available for this job");
            }
        }
    }
}
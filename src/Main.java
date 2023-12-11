import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
static ArrayList<Course>courses=new ArrayList<>();
static ArrayList<Instructor>instructors=new ArrayList<>();
static ArrayList<Student>studentsArray=new ArrayList<>();
    static ArrayList<FinalExam>finalExams=new ArrayList<>();
    static ArrayList<MidtermExam>midtermExams=new ArrayList<>();
    static ArrayList<Assignment>assignments=new ArrayList<>();
    static ArrayList<Quiz>quizzes=new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        /*
        \\\\login by  id////
         */
      int studentNo = 0, instructorNo = 0;

        Student  [] students = new Student[100];
        Instructor [] instructors = new Instructor[100];

        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {

            Form.LogIn(students,instructors,studentNo,instructorNo);

        } else if (account == 2) {
            int who;
            do {
                System.out.println("Register as : ");
                System.out.println("1- Instructor");
                System.out.println("2- Student");
                who = input.nextInt();
                if(who==1||who==2)
                    break;
                System.out.println("Invalid Choice!Try Again.");
            }while (true);
            if(who==1)
                studentNo++;
            else
                instructorNo++;

            Form.Registration(who,students,instructors,studentNo,instructorNo);

        } else {

        }
      /*  Course course = new Course();
        course.courseTitle = "OOP";
        course.setCourseCode("5465");
        Course course1 = new Course();
        course1.courseTitle = "Logic";
        course1.setCourseCode("5786");
        courses.add(course);
        courses.add(course1);
        Student student1 = new Student();
        student1.RegisterForCourse(courses);
        studentsArray.add(student1);
        Student student2 = new Student();
        student1.RegisterForCourse(courses);
        studentsArray.add(student2);
        Student student3 = new Student();
        student1.RegisterForCourse(courses);
        studentsArray.add(student3);
        Instructor instructor = new Instructor("Sara","Darwish","Genady","CS");
        Admin a=new Admin();
        a.assignCoursesToInstructors("5465",0);
        instructor.forSignIn();
        student1.ViewGrades();
        student2.ViewGrades();
        student3.ViewGrades();*/

    }

}
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
static ArrayList<Course>courses=new ArrayList<>();
static ArrayList<Instructor>instructors=new ArrayList<>();
static ArrayList<Student>students=new ArrayList<>();
static ArrayList<FinalExam>finalExams=new ArrayList<>();
static ArrayList<MidtermExam>midtermExams=new ArrayList<>();
static ArrayList<Assignment>assignments=new ArrayList<>();
static ArrayList<Quiz>quizzes=new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Files.readStudents();

     int studentId = 0, instructorId = 0;
        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {

            Form.LogIn(students,instructors);

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
            Form.Registration(who,students,instructors,studentId,instructorId);
            if (who==1){
                instructors.get(instructorId).forSignIn();
                instructorId++;
            }else {
                for (Student student:students) {
                    System.out.println(student.getID());
                    System.out.println(student.getUsername());

                }
             //   Form.LogIn(students,instructors);
                Student.Student_AfterLogin(studentId,students,courses);
                        studentId++;
            }

        } else {
            System.out.println("Invalid Choice!Try Again.");
        }
        Files.writeStudents();
    }
}
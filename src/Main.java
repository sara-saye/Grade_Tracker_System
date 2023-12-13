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

     int studentId = 0, instructorId = 0;
        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {
            ArrayList who = Form.LogIn(students,instructors);
            int ID=(Integer) who.get(1);
            if(who.get(0).equals("Admin")){
                Admin.login();
            } else if (who.get(0).equals("Instructor")) {
                instructors.get(ID).forSignIn();
            }else {
                students.get(ID).Student_AfterLogin();
            }
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
                 students.get(studentId).Student_AfterLogin();
                        studentId++;
            }

        } else {
            System.out.println("Invalid Choice!Try Again.");
        }
    }
}
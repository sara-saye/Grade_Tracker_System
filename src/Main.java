import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public abstract class Main {
    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Instructor> instructors = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<FinalExam> finalExams = new ArrayList<>();
    static ArrayList<MidtermExam> midtermExams = new ArrayList<>();
    static ArrayList<Assignment> assignments = new ArrayList<>();
    static ArrayList<Quiz> quizzes = new ArrayList<>();
    static ArrayList<Admin>eventDetails=new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static boolean first = true;

    public static void main(String[] args) throws IOException {


        if (first) {
            Files.readInstructor();
            Files.readFinalExam();
            Files.readMidtermExam();
            Files.readCourse();
            Files.readAssignment();
            Files.readQuiz();
            Files.instructorAndCourseRelation();
            Files.assignmentAndCourseRelation();
            Files.quizAndCourseRelation();
            Files.readGrades();
            Files.readStudents();
            Files.readAttendance();
            Files.StudentCourseRelation();
            Files.readEventDetails();
            first = false;
        }
        int studentId = students.size(), instructorId = instructors.size();


        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {
            boolean logged=true;
            do {
                ArrayList who = Form.LogIn(Main.students, Main.instructors);
                int ID = (Integer) who.get(1);
                if (who.get(0).equals("Admin")) {
                    Admin.login();
                } else if (who.get(0).equals("Instructor")) {
                    Main.instructors.get(ID).forSignIn();
                } else if (who.get(0).equals("Student")) {
                    Main.students.get(ID).Student_AfterLogin();
                }else {
                    logged=false;
                }
            }while (!logged);

        } else if (account == 2) {
            int who;
            do {
                System.out.println("Register as : ");
                System.out.println("1- Instructor");
                System.out.println("2- Student");
                who = input.nextInt();
                if (who == 1 || who == 2)
                    break;
                System.out.println("Invalid Choice!Try Again.");
            } while (true);
            Form.Registration(who, Main.students, Main.instructors, studentId, instructorId);
            if (who == 1) {
                Main.instructors.get(instructorId).forSignIn();
                instructorId++;
            } else {
                Main.students.get(studentId).Student_AfterLogin();
                studentId++;
            }

        } else {
            System.out.println("Invalid Choice!Try Again.");
        }

        Files.writeInstructor();
        Files.writeFinalExam();
        Files.writeMidtermExam();
        Files.writeCourse();
        Files.writeAssignment();
        Files.writeQuiz();
        Files.writeStudents();
        Files.writeGrades();
        Files.writeAttendance();
        Files.writeEvent();

    }
    public static void forMatchingException(){}
}
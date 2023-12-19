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
            Files.finalExamAndCourseRelation();
            Files.midtermExamAndCourseRelation();
            Files.readGrades();
            Files.readStudents();
            Files.readAttendance();
            Files.StudentCourseRelation();
            Files.readEventDetails();
            first = false;
        }
        int studentId = students.size()+1000, instructorId = instructors.size()+1000;
        int account = 0;
        do {
        try {
            System.out.println("Already have an account?");
            System.out.println("1- Yes");
            System.out.println("2- No");
            account = input.nextInt();
            if (account == 1) {
                boolean logged;
                do {
                    ArrayList who = Form.LogIn(Main.students, Main.instructors);
                    int index = (Integer) who.get(1);
                    if (who.get(0).equals("Admin")) {
                        logged = true;
                        Admin.login();
                    } else if (who.get(0).equals("Instructor")) {
                        logged = true;
                        Main.instructors.get(index).forSignIn();
                    } else if (who.get(0).equals("Student")) {
                        logged = true;
                        Main.students.get(index).StudentAfterLogin();
                    } else {
                        logged = false;
                    }
                } while (!logged);

            } else if (account == 2) {
                int who;
                do {
                    try {
                        System.out.println("Register as : ");
                        System.out.println("1- Instructor");
                        System.out.println("2- Student");
                        who = input.nextInt();
                        if (who == 1 || who == 2)
                            break;
                        System.out.println("Invalid Choice!Try Again.");
                    } catch (InputMismatchException exception) {
                        System.out.println("Invalid! Please enter numeric values");
                        input.next();
                    }
                }while (true);
                int index = Form.Registration(who, Main.students, Main.instructors, studentId, instructorId);
                if (who == 1) {
                    Main.instructors.get(index).forSignIn();
                    instructorId++;
                } else if (who == 2) {
                    students.get(index).StudentAfterLogin();
                    studentId++;

                } else {
                    System.out.println("Invalid Choice!Try Again.");
                }
            } else {
                System.out.println("Invalid Choice!Try Again.");
            }
        } catch (InputMismatchException exception){
                    System.out.println("Invalid! Please enter numeric values");
                    account=0;
                    input.next();
                }
            } while (account != 2 && account != 1);
        

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
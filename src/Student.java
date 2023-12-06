import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
    public ArrayList<StudentGrades> Student_Grades = new ArrayList<>();
    private double expenses = 0;
    private boolean expenses_paid = false;
    public boolean[][]attendance = new boolean[10][];

    public ArrayList<Course> Student_courses = new ArrayList<>();

    private int NoOfCourses = Student_courses.size();

    private Notification notification = new Notification();

    public Student (){
        super();
    }

    public Student(String Fname, String Lname){
        super(Fname,Lname);

    }

    public Student(String Fname, String Lname,int id){
        super(Fname,Lname);
        this.setID(id);
    }


    public void ViewStudentPerformance() {


    }

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            for (int i=0;i<NoOfCourses;i++) {
                System.out.println("Course Title: " + Student_courses.get(i).courseTitle);
                Student_Grades.get(i).DisplayReport();
            }
        } else
            System.out.println("Please pay expenses first");
    }

    public void Payment() {
        if (NoOfCourses == 0 || expenses_paid)
            System.out.println("No payments to pay");
        else {
            for (Course course:Student_courses) {
                expenses += course.credits * 100;
            }
            do {
                System.out.println("Please pay " + expenses);
                System.out.println("Pay Now?");
                System.out.println("1- Yes\n2- No");
                int ans = input.nextInt();
                if (ans == 1) {
                    System.out.println("Payment Completed.");
                    expenses_paid = true;
                    break;
                } else if (ans == 2) {
                    //return back
                    break;
                } else {
                    System.out.println("Invalid Choice!Try Again.");
                }
            } while (true);
        }
    }

    public void AddCourse(ArrayList<Course> courses) {
        for(int i=0;i<courses.size();i++){
            System.out.println((i+1)+":"+courses.get(i).courseTitle);
        }
        System.out.println("Which Course You Want To Register For? ");
        int answer =input.nextInt();
        Student_courses.add(courses.get(answer-1));
    }

    public void ViewEvents() {
        for (Course course:Student_courses){

        }
    }

    public void Student_AfterLogin(int ID){
        System.out.println("1- Profile");
        System.out.println("2- Study Services");
        System.out.println("3- Payments record");
        if(students.get(ID).getNotification.)
        System.out.println("Press 4 to see notifications");
        int ans = input.nextInt();
        try {
         switch (ans){
             case 1:
                 System.out.println("Name:");
                 System.out.println(students.get(ID).getFname+" "+students.get(ID).getLname);
                 System.out.println("Email:");
                 System.out.println(students.get(ID).getEmail);
                 System.out.println("Phone Number:");
                 System.out.println();
                 System.out.println("User Name:");
                 System.out.println(students.get(ID).getUsername);
                 System.out.println("ID:");
                 System.out.println(ID);
                 System.out.println("Press 1 to edit information");
                 break;
             case 2:
                 System.out.println("1- Current Course");
                 System.out.println("2- Grades");
                 System.out.println("3- Course Registration");
                 System.out.println("4- ");


             case 3:

         }
        }catch (InputMismatchException exception){
            System.out.println("Error! Please enter numeric values");
        }
    }

    public void setNotification(Notification notification){
        this.notification=notification;
    }

    public Notification getNotification(){
        return this.notification;
    }


}
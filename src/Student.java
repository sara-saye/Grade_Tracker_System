import java.io.*;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
    public Course[] courses = new Course[48];
   public StudentGrades[] grades = new StudentGrades[48];
    private int NoOfCourses;
    private double expenses = 0;
    private boolean expenses_paid = false;
    public boolean[] attendance = new boolean[6];

    public void ViewStudentPerformance() {


    }

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            for (int courseNo = 0; courseNo < NoOfCourses; courseNo++) {
                System.out.println("Course Title: " + courses[courseNo].courseTitle);
                grades[courseNo].DisplayReport();
            }
        } else
            System.out.println("Please pay expenses first");
    }

    public void Payment() {
        if (NoOfCourses == 0 || expenses_paid)
            System.out.println("No payments to pay");
        else {
            for (int courseNo = 0; courseNo < NoOfCourses; courseNo++) {
                expenses += courses[courseNo].credits * 100;
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

    public void AddCourse() {

    }

    public void ViewEvents() {

    }

}
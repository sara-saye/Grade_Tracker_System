import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
    public ArrayList<StudentGrades> Student_Grades = new ArrayList<>();
    private double GPA;
    private double expenses = 0;
    private boolean expenses_paid = false;
<<<<<<< HEAD
    public boolean[][]attendance = new boolean[10][];
    public ArrayList<Course> Student_courses = new ArrayList<>();
    private int NoOfCourses = Student_courses.size();
   // Vector<pair<Integer,Integer>> attendance = new Vector<pair<Integer,Integer>>();
=======
    public boolean[][] attendance = new boolean[10][];

    public ArrayList<Course> Student_courses = new ArrayList<>();

    public int getNoOfCourses() {
        return NoOfCourses;
    }

    private int NoOfCourses = Student_courses.size();//test

>>>>>>> 4bfe1426e9c5509e3b32b7609765d3a658523ccd
    private Notification notification = new Notification();
    public ArrayList<Double> ZScore = new ArrayList<Double>();
    private boolean attendanceDrop;
    private boolean gpaDrop;


    public boolean isAttendanceDrop() {
        return attendanceDrop;
    }

    public void setAttendanceDrop(boolean attendanceDrop) {
        this.attendanceDrop = attendanceDrop;
    }

    public boolean isGpaDrop() {
        return gpaDrop;
    }

    public void setGpaDrop(boolean gpaDrop) {
        this.gpaDrop = gpaDrop;
    }

    public Student() {
        super();
    }

    public Student(String Fname, String Lname) {
        super(Fname, Lname);

    }

    public Student(String Fname, String Lname, int id) {
        super(Fname, Lname);
        this.setID(id);
    }

<<<<<<< HEAD

    public void ViewStudentPerformance() {}
=======
    public void DisplayCurrentCourses(){
        for (int i = 0; i < NoOfCourses; i++) {
            System.out.println((i+1)+"- "+Student_courses.get(i).courseTitle);
            System.out.println(Student_courses.get(i).department);
            System.out.println(Student_courses.get(i).description);
            System.out.println(Student_courses.get(i).credits);
            System.out.println(Student_courses.get(i).assignedInstructor);
            System.out.println("------------------------------------");
        }
    }
    public void ViewStudentPerformance() {
        for (int i = 0; i < NoOfCourses; i++) {
            System.out.println((i+1)+"- Course : " + Student_courses.get(i).courseTitle);
           // System.out.println(Student_courses.get(i).assignedInstructor.generateAttRepForIndStud(1,this.getID(),i,1));
            if(ZScore.get(i)>0){
                System.out.println("Your Performance in "+Student_courses.get(i).courseTitle+" is Great");
            } else if (ZScore.get(i)==0) {
                System.out.println("Your Performance in "+Student_courses.get(i).courseTitle+" is Good");
            }
            else {
                System.out.println("Your Performance in "+Student_courses.get(i).courseTitle+" is Weak");
            }
            System.out.println("------------------------------------");
        }
    }
>>>>>>> 4bfe1426e9c5509e3b32b7609765d3a658523ccd

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            for (int i = 0; i < NoOfCourses; i++) {
                System.out.println((i+1)+"- Course : " + Student_courses.get(i).courseTitle);
                double courseGrade=Student_Grades.get(i).CalcTotalGrade();
                double courseScale=Student_Grades.get(i).Calcscale();
                String courseLetterGrade=Student_Grades.get(i).CalcLetterGrade(courseGrade);
                System.out.println("Student Name: " + this.getFname()+" "+this.getLname());
                System.out.println("Student ID: " + this.getID());
                System.out.println("Midterm: " +Student_Grades.get(i).getMidTermGrade() );
                System.out.println("Assignment: " + Student_Grades.get(i).getAssignmentGrade());
                System.out.println("Quiz: " + Student_Grades.get(i).getQuizGrade());
                System.out.println("Attendance:" + Student_Grades.get(i).getAttendanceGrade());
                System.out.println("Final:" + Student_Grades.get(i).getFinalGrade());
                System.out.println("Total Grade: " +courseGrade);
                System.out.println("Points: " + courseScale);
                System.out.println("Letter Grade: " +courseLetterGrade);
            }
        } else
            System.out.println("Please pay expenses first");
    }

    public void Payment() {
        if (NoOfCourses == 0 || expenses_paid)
            System.out.println("No payments to pay");
        else {
            for (Course course : Student_courses) {
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

<<<<<<< HEAD
    public void AddCourse(ArrayList<Course> courses) {

        for(int i=0;i<courses.size();i++){
            System.out.println((i+1)+":"+courses.get(i).courseTitle);
=======
    public void RegisterForCourse(ArrayList<Course> courses) {
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ":" + courses.get(i).courseTitle);
>>>>>>> 4bfe1426e9c5509e3b32b7609765d3a658523ccd
        }
        System.out.println("Which Course You Want To Register For? ");
        int answer = input.nextInt();//validation
        Student_courses.add(courses.get(answer - 1));
        courses.get(answer - 1).enrollStudent(this);//test
    }

    public void ViewEvents() {
        notification.Display_Notification();
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public void DisplayInfo() {
        System.out.println("Name:");
        System.out.println(this.getFname() + " " + this.getLname());
        System.out.println("Email:");
        System.out.println(this.getEmail());
        System.out.println("Phone Number:");
        System.out.println(this.getPhoneNumber());
        System.out.println("User Name:");
        System.out.println(this.getUsername());
        System.out.println("ID:");
        System.out.println(this.getID());
    }

    public void Edit_Info() {
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\n3-Phone Number\n4-Username or Password");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter new first and last name");
                this.setFname(input.next());
                this.setLname(input.next());
                break;
            case 2:
                System.out.println("Enter new Email");
                String s = input.next();
                this.setEmail(s);
                break;
            case 3:
                System.out.println("Enter new Phone Number");
                String s1 = input.next();
                this.setPhoneNumber(s1);
                break;
            case 4:
                System.out.println("Enter your current username and password");
                String t1 = input.next(), t2 = input.next();
                if (this.getUsername().equals(t1) && this.getPassword().equals(t2)) {
                    System.out.println("Enter new username and password");
                    t1 = input.next();
                    t2 = input.next();
                    this.setUsername(t1);
                    this.setPassword(t2);
                    //validation
                }
                break;
            //validation
        }
    }

    public void CalcZScore(){
        for(int i=0;i<NoOfCourses;i++){
            ZScore.add((Student_Grades.get(i).CalcTotalGrade()-Student_courses.get(i).CalcMean())/Student_courses.get(i).CalcStandardDeviation());
        }
    }
    public double CalcGpa(){
        double sum=0; //  sums of (hour*scale)
        double totalHours =0;
        for(int i=0;i<NoOfCourses;i++){
          sum=sum + (Student_courses.get(i).credits*Student_Grades.get(i).Calcscale());
            totalHours+=Student_courses.get(i).credits;
        }
        GPA=(sum/totalHours);
        return GPA;
    }



//    public void Student_AfterLogin(int ID){
//        System.out.println("1- Profile");
//        System.out.println("2- Study Services");
//        System.out.println("3- Payments record");
//        if(students.get(ID))
//            System.out.println("Press 4 to see notifications");
//        int ans = input.nextInt();
//        try {
//            switch (ans){
//                case 1:
//                    System.out.println("Name:");
//                    System.out.println(students.get(ID).getFname+" "+students.get(ID).getLname);
//                    System.out.println("Email:");
//                    System.out.println(students.get(ID).getEmail);
//                    System.out.println("Phone Number:");
//                    System.out.println();
//                    System.out.println("User Name:");
//                    System.out.println(students.get(ID).getUsername);
//                    System.out.println("ID:");
//                    System.out.println(ID);
//                    System.out.println("Press 1 to edit information");
//                    break;
//                case 2:
//                    System.out.println("1- Current Course");
//                    System.out.println("2- Grades");
//                    System.out.println("3- Course Registration");
//                    System.out.println("4- Performance ");// stat analysis,attendance report,comments and feedback
//
//
//                case 3:
//
//            }
//        }catch (InputMismatchException exception){
//            System.out.println("Error! Please enter numeric values");
//        }
//    }

}
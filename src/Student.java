import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
    private double GPA=-1;
    private double expenses = 0;
    private boolean expenses_paid = false;
    public ArrayList<Course> Student_courses = new ArrayList<>();
    private int NoOfCourses ;  //test
    public ArrayList<StudentGrades> Student_Grades = new ArrayList<>();
    public boolean[][]attendance = new boolean[NoOfCourses][5];
    public Notification notification = new Notification();
    public ArrayList<Double> ZScore = new ArrayList<Double>();
    private boolean attendanceDrop;
    private boolean gpaDrop;


    public void setNoOfCourses(int noOfCourses) {
        NoOfCourses = noOfCourses;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
    public boolean isExpenses_paid() {
        return expenses_paid;
    }

    public void setExpenses_paid(boolean expenses_paid) {
        this.expenses_paid = expenses_paid;
    }
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getNoOfCourses() {
        return NoOfCourses;
    }

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

    public void DisplayCurrentCourses(){
        setStatus();
        if(!Student_courses.isEmpty()) {
            System.out.println("------------------------------------");
            for (int i = 0; i < Student_courses.size(); i++) {
                if(!Student_courses.get(i).isStatus()) {
                    System.out.println((i + 1) + "- " + Student_courses.get(i).courseTitle);
                    System.out.println(Student_courses.get(i).department);
                    System.out.println(Student_courses.get(i).description);
                    System.out.println(Student_courses.get(i).credits);
                    if(!Student_courses.get(i).assignedInstructor.isEmpty())
                    System.out.println(Student_courses.get(i).assignedInstructor.get(0)+"\n");
                }
            }
        }else {
            System.out.println("You haven't registered any course");
        }
    }

    public void ViewStudentPerformance() {
        CalcZScore();
        for (int i = 0; i < NoOfCourses; i++) {
            System.out.println((i+1)+"- Course : " + Student_courses.get(i).courseTitle);
            if(!Student_courses.get(i).assignedInstructor.isEmpty())
            Student_courses.get(i).assignedInstructor.get(0).generateAttRepForIndStud(getID());
            if(!ZScore.isEmpty()) {
                if (ZScore.get(i) > 0) {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Great");
                } else if (ZScore.get(i) == 0) {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Good");
                } else {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Weak");
                }
            }
            System.out.println("------------------------------------");
        }
    }

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            if(notification.isNew_grade()) {
                for (int i = 0; i < NoOfCourses; i++) {
                    System.out.println((i + 1) + "- Course : " + Student_courses.get(i).courseTitle);
                    double courseGrade = Student_Grades.get(i).CalcTotalGrade();
                    double courseScale = Student_Grades.get(i).Calcscale();
                    String courseLetterGrade = Student_Grades.get(i).CalcLetterGrade(courseGrade);
                    System.out.println("Student Name: " + this.getFname() + " " + this.getLname());
                    System.out.println("Student ID: " + this.getID());
                    System.out.println("Midterm: " + Student_Grades.get(i).getMidTermGrade());
                    System.out.println("Assignment: " + Student_Grades.get(i).getAssignmentGrade());
                    System.out.println("Quiz: " + Student_Grades.get(i).getQuizGrade());
                    System.out.println("Attendance:" + Student_Grades.get(i).getAttendanceGrade());
                    System.out.println("Final:" + Student_Grades.get(i).getFinalGrade());
                    System.out.println("Total Grade: " + courseGrade);
                    System.out.println("Points: " + courseScale);
                    System.out.println("Letter Grade: " + courseLetterGrade);
                }
            }
            else
                System.out.println("Unavailable Grades");
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
                    expenses=0;
                    break;
                } else if (ans == 2) {
                    expenses=0;
                    break;
                } else {
                    System.out.println("Invalid Choice!Try Again.");
                }
            } while (true);
        }
    }

    public void RegisterForCourse(ArrayList<Course> courses) {
        if(!courses.isEmpty()) {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ":" + courses.get(i).courseTitle);
            }
            System.out.println("Which Course You Want To Register For? ");
            int answer = input.nextInt();//validation
            Student_courses.add(courses.get(answer - 1));
            courses.get(answer - 1).enrollStudent(this);//test
            StudentGrades grade = new StudentGrades();
            Student_Grades.add(grade);
            NoOfCourses++;
            System.out.println("Registration Done");
        }
    }

    public void ViewEvents() {
        notification.Display_Notification(Student_courses);
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public void display(){
        System.out.println("------------------------------------");
        System.out.print("Name: ");
        System.out.println(this.getFname() + " " + this.getLname());
        System.out.print("Email: ");
        System.out.println(this.getEmail());
        System.out.print("Phone Number: ");
        System.out.println(this.getPhoneNumber());
        System.out.print("User Name: ");
        System.out.println(this.getUsername().replaceAll("@Student",""));
        System.out.print("ID: ");
        System.out.println(this.getID());
        System.out.println("------------------------------------");
    }
    public void Edit_Info() {
        int choice;
        boolean success=false;
        while (!success) {
            try {
                System.out.println("Select what you want change");
                System.out.println("1-Name\n2-Email\n3-Phone Number\n4-Username or Password");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter new first name");
                        this.setFname(input.next());
                        System.out.println("Enter new last name");
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
                        System.out.println("Enter your current username");
                        String t1 = input.next();
                        System.out.println("Enter your current password");
                        String t2 = input.next();
                        if (this.getUsername().replaceAll("@Student", "").equals(t1) && this.getPassword().equals(t2)) {
                            System.out.println("Enter new username: ");
                            t1 = input.next();
                            System.out.println("Enter new password: ");
                            t2 = input.next();
                            this.setUsername(t1 + "@Student");
                            this.setPassword(t2);
                        }
                        break;
                    default:
                        System.out.println("Invalid! Try Again.");
                }
              if(choice>=1&&choice<=4) {
                  success=true;
                  System.out.println("Edit Done Successfully.");
              }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values");
                input.next();
            }
        }


    }

    public void CalcZScore(){
        for(int i=0;i<NoOfCourses;i++){
            if(!Student_Grades.isEmpty())
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
        this.notification.addGpa(GPA);
        return GPA;
    }


    public void StudentAfterLogin() throws IOException {
        int ans, ans1, ans2;
        boolean success = false;
        while (!success) {
            try {
                System.out.println("------------------------------------");
                System.out.println("1- Profile");
                System.out.println("2- Study Services");
                System.out.println("3- Payments record");
                System.out.println("4- Notifications");
                System.out.println("5- Logout");
                System.out.println("6- Exit");
                System.out.println("------------------------------------");
                System.out.print("Enter Your Choice : ");
                ans = input.nextInt();
                System.out.println();
                switch (ans) {
                    case 1:
                        display();
                        do {
                            System.out.println("Press 1 to edit information");
                            System.out.println("Press 2 to return to list");
                            ans1 = input.nextInt();
                            switch (ans1) {
                                case 1:
                                    Edit_Info();
                                    StudentAfterLogin();
                                    break;
                                case 2:
                                    StudentAfterLogin();
                                    break;
                                default:
                                    System.out.println("Invalid! Try Again.");
                            }
                        } while (ans1 != 1 && ans1 != 2);
                        break;
                    case 2:
                        do {
                            System.out.println("1- Current Course");
                            System.out.println("2- Grades");
                            System.out.println("3- Course Registration");
                            System.out.println("4- Performance ");// stat analysis,attendance report,comments and feedback
                            ans2 = input.nextInt();
                            switch (ans2) {
                                case 1:
                                    DisplayCurrentCourses();
                                    break;
                                case 2:
                                    ViewGrades();
                                    break;
                                case 3:
                                    RegisterForCourse(Main.courses);
                                    break;
                                case 4:
                                    ViewStudentPerformance();
                                    break;
                                default:
                                    System.out.println("Invalid Choice!Try Again.");
                            }
                        } while (ans2 < 1 || ans2 > 4);
                        StudentAfterLogin();
                        break;
                    case 3:
                        Payment();
                        StudentAfterLogin();
                        break;
                    case 4:
                        if(notification==null) {
                            System.out.println("You don't have notification");
                        }
                        else {
                            ViewEvents();
                        }
                        StudentAfterLogin();
                        break;
                    case 5:
                        Main.main(null);
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid Choice!Try Again.");
                }
                if (ans >= 1 && ans <=6)
                    success = true;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values");
                input.next();
            }
        }
    }
    public String toString()
    {
        String s=getFname()+","+getLname()+","+getID()+","+getEmail()+","+getUsername()+","+getPassword()+
                ","+getPhoneNumber()+","+GPA+","+expenses+","+expenses_paid+","+gpaDrop+","+attendanceDrop+","+notification.isNew_grade()+
                ","+NoOfCourses;
        if(!Student_courses.isEmpty()) {
            s+=",";
            for (int i = 0; i < Student_courses.size(); i++) {
                Course course = Student_courses.get(i);
                s += course.getCourseCode();
                if (i!=Student_courses.size()-1){
                    s+='-';
                }
            }
        }
        return s;
    }
    public String GradesToString(){
        String a="";
        if(!Student_Grades.isEmpty()) {
            for (  int i=0;i<Student_Grades.size();i++) {
                a =getID()+","+ Student_Grades.get(i).getMidTermGrade()
                        + "," + Student_Grades.get(i).getFinalGrade()+ "," + Student_Grades.get(i).getAttendanceGrade();
                if(ZScore.size()<i)
                {
                    a+=","+ ZScore.get(i);
                }
                if(!Student_Grades.get(i).assignmentGrade.isEmpty()) {
                    a+=",";
                    for (int j=0;j<Student_Grades.get(i).assignmentGrade.size();j++) {
                        a +=Student_Grades.get(i).assignmentGrade.get(j) ;
                        if(j!=Student_Grades.get(i).assignmentGrade.size()-1)
                            a +="-";
                    }
                }
                if(!Student_Grades.get(i).quizGrade.isEmpty()) {
                    a+=",";
                    for (int j=0;j<Student_Grades.get(i).quizGrade.size();j++) {
                        a +=Student_Grades.get(i).quizGrade.get(j) ;
                        if(j!=Student_Grades.get(i).quizGrade.size()-1)
                            a +="-";
                    }
                }
            }
        }
        return a;
    }

    public String AttendanceToString(){
        String s="";
             s = String.valueOf(getID());
            for (int i = 0; i < NoOfCourses; i++) {
                for (int j = 0; j < 5; j++) {
                    if(attendance.length>0)
                    s += ("," + attendance[i][j]);
                }
            }
        return s;
    }

    public  void setStatus(){
        if(!Student_courses.isEmpty()) {
            for (int i = 0; i < Student_Grades.size(); i++) {
                if(!Student_courses.get(i).assignedInstructor.isEmpty()) {
                    if (Student_courses.get(i).assignedInstructor.get(0).getAllgradesAssigned() == 4 && Student_Grades.get(i).CalcTotalGrade() >= 60) {
                        Student_courses.get(i).setStatus(true);
                    }
                }
            }
        }
    }
}
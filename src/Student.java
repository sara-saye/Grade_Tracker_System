import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
    private double GPA = -1;
    private double expenses = 0;
    private boolean expenses_paid = false;

    public void setDepartment(String department) {
        this.department = department;
    }

    private String department;
    public ArrayList<Course> Student_courses = new ArrayList<>();
    private int NoOfCourses;
    public ArrayList<StudentGrades> Student_Grades = new ArrayList<>();
    public boolean[][] attendance = new boolean[6][5];
    public Notification notification = new Notification();
    public ArrayList<Double> ZScore = new ArrayList<Double>();

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


    public boolean isGpaDrop() {
        return gpaDrop;
    }

    public void setGpaDrop(boolean gpaDrop) {
        this.gpaDrop = gpaDrop;
    }

    public Student() {
        super();
        for(int i=0;i<NoOfCourses;i++){
            for(int j=0;j<5;j++){
                attendance[i][j] = false;
            }
        }
    }

    public Student(String Fname, String Lname) {
        super(Fname, Lname);

    }

    public Student(String Fname, String Lname, int id) {
        super(Fname, Lname);
        this.setID(id);
    }

    public Student(int ID, String Fname, String Lname, String email, String username,String password, String PhoneNumber){
        super(ID,Fname,Lname,email,username,password,PhoneNumber);

    }

    public void Register(){
        ArrayList<String> Departments = new ArrayList<>();
        for (int i = 0; i < Main.courses.size(); i++) {
            if(!Departments.contains(Main.courses.get(i).department))
                Departments.add(Main.courses.get(i).department);
        }
        do {
            try {
                int index=1;
                for(String department:Departments){
                    System.out.println((index)+"- "+department);
                    index++;
                }
                System.out.println("Choose your department: ");
                int answer = input.nextInt();
                department = Departments.get(answer-1);
                break;
            }catch (IndexOutOfBoundsException exception) {
                System.out.println("Invalid Choice!Try Again.");
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values.");
                input.next();
            }
        } while (true);

    }

    public void DisplayCurrentCourses() {
        setStatus();
        if (!Student_courses.isEmpty()) {
            System.out.println("------------------------------------");
            for (int i = 0; i < Student_courses.size(); i++) {
                if (!Student_courses.get(i).isStatus()) {
                    System.out.println((i + 1) + "- " + Student_courses.get(i).courseTitle);
                    System.out.println("Department: "+Student_courses.get(i).department);
                    System.out.println("Description: "+Student_courses.get(i).description);
                    System.out.println("Credit Hours: "+Student_courses.get(i).credits);
                    if (!Student_courses.get(i).assignedInstructor.isEmpty())
                        System.out.println("Instructor: "+Student_courses.get(i).assignedInstructor.get(0).getFname()+" "+ Student_courses.get(i).assignedInstructor.get(0).getLname());
                }
                System.out.println("\n*********************\n");
            }
        } else {
            System.out.println("You haven't registered any course yet");
        }
    }

    public void ViewStudentPerformance() {
        for (int i = 0; i < NoOfCourses; i++) {
            System.out.println((i + 1) + "- Course : " + Student_courses.get(i).courseTitle);
            if (!Student_courses.get(i).assignedInstructor.isEmpty()) {
                int attndance_sum=0;
                for (int j = 0; j < 5; j++) {
                    if (attendance[i][j]) {
                        attndance_sum++;
                    }
                }
                System.out.println("Number of attended sessions: " + attndance_sum);
                System.out.println("Attendance grade: " + Student_Grades.get(i).getAttendanceGrade());
                //            if (Student_courses.get(i).assignedInstructor.get(0).getAllgradesAssigned() == 4) {
                System.out.println(ZScore.get(i));
                if (ZScore.get(i) > 0) {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Great");
                } else if (ZScore.get(i) == 0) {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Good");
                } else {
                    System.out.println("Your Performance in " + Student_courses.get(i).courseTitle + " is Weak");
                }
//            }
                System.out.println("------------------------------------");
            }
        }

    }

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            if (notification.isNew_grade()) {
                for (int i = 0; i < Student_courses.size(); i++) {
                    System.out.println((i + 1) + "- Course : " + Student_courses.get(i).courseTitle);
                    System.out.println((Student_Grades.get(i)));
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
                    System.out.println("\n*********************\n");
                }
            } else
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
                    break;
                } else if (ans == 2) {
                    expenses = 0;
                    break;
                } else {
                    System.out.println("Invalid Choice!Try Again.");
                }
            } while (true);
        }
    }

    public void RegisterForCourse(ArrayList<Course> courses) {

        do {
            try {
                if (!courses.isEmpty()) {
                    int arr[] = new int [Main.courses.size()];
                    int index=0;
                    for (int i = 0; i < courses.size(); i++) {
                        if(courses.get(i).department.equals(department)) {
                            System.out.println((index+1) + ":" + courses.get(i).courseTitle);
                            arr[index]=i;
                            index++;
                        }
                    }
                    int answer = 0;
                    System.out.println("Which Course You Want To Register For? ");
                    answer = input.nextInt();
                    if(!Student_courses.contains(courses.get(arr[answer - 1]))) {
                        Student_courses.add(courses.get(arr[answer - 1]));
                        StudentGrades grade = new StudentGrades();
                        Student_Grades.add(grade);
                        System.out.println(Student_Grades.size());
                        ZScore.add(0.0);
                        courses.get(arr[answer - 1]).enrollStudent(this);
                        NoOfCourses++;
                        System.out.println("Registration Done.");
                        expenses = -expenses;
                        expenses_paid=false;
                    }
                    else {
                        System.out.println("You have already registered for this course.");
                    }
                } else {
                    System.out.println("No courses to register.");
                }
                break;
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("Invalid Choice!Try Again.");
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values.");
                input.next();
            }
        } while (true);

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

    public void display() {
        System.out.println("------------------------------------");
        System.out.print("Name: ");
        System.out.println(this.getFname() + " " + this.getLname());
        System.out.print("Email: ");
        System.out.println(this.getEmail());
        System.out.print("Phone Number: ");
        System.out.println(this.getPhoneNumber());
        System.out.print("User Name: ");
        System.out.println(this.getUsername().replaceAll("@Student", ""));
        System.out.print("ID: ");
        System.out.println(this.getID());
        System.out.println("------------------------------------");
    }
    public void DisplayForAdminClass() {
        System.out.println("Name: "+this.getFname() + " " + this.getLname());
        System.out.println("ID: "+this.getID());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Phone Number: "+this.getPhoneNumber());
        System.out.println("User Name: "+this.getUsername().replaceAll("@Student",""));
        if(this.Student_courses.isEmpty())
        {
            System.out.println("No Registered Courses");
        }
        else {
            System.out.println("Registered Courses: ");
            for(Course course:this.Student_courses)
            {
                System.out.println(course.courseTitle+" "+course.getCourseCode());
            }
        }

    }

    public void Edit_Info() {
        int choice;
        boolean success = false;
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
                        do {
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
                                break;
                            } else {
                                System.out.println("Username or Password Isn't Identical!Try Again.");
                            }
                        } while (true);
                        break;
                    default:
                        System.out.println("Invalid! Try Again.");
                }
                if (choice >= 1 && choice <= 4) {
                    success = true;
                    System.out.println("Edit Done Successfully.");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values");
                input.next();
            }
        }


    }

    public void CalcZScore() {
        for (int i = 0; i < NoOfCourses; i++) {
            if (!Student_Grades.isEmpty()) {
                if(Student_courses.get(i).CalcStandardDeviation()!=0.0) {
                    double z=(Student_Grades.get(i).CalcTotalGrade()-Student_courses.get(i).CalcMean()) / Student_courses.get(i).CalcStandardDeviation();
                    ZScore.add(z);
                }
                else
                    ZScore.add(0.0);
            }
        }
    }

    public double CalcGpa() {
        double sum = -1; //  sums of (hour*scale)
        double totalHours = 0;
        for (int i = 0; i < NoOfCourses; i++) {
           if( Student_courses.get(i).assignedInstructor.get(0).getAllgradesAssigned()==4) {
               sum = sum + (Student_courses.get(i).credits * Student_Grades.get(i).Calcscale());
               totalHours += Student_courses.get(i).credits;
           }
        }
        if(sum!=-1)
        GPA = (sum / totalHours);
        else
            GPA=-1;
        this.notification.addGpa(GPA);
        return GPA;
    }


    public void StudentAfterLogin() throws IOException {
        try {
            CalcGpa();
            CalcZScore();
        }catch (IndexOutOfBoundsException e){

        }
        int ans, ans1 = 0, ans2 = 0;
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
                            try {
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
                            } catch (InputMismatchException exception) {
                                System.out.println("Invalid! Please enter numeric values.");
                                input.next();
                            }
                        }while (ans1 != 1 && ans1 != 2);
                        break;
                    case 2:
                        do {
                            try {
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
                            } catch (InputMismatchException exception) {
                                System.out.println("Invalid! Please enter numeric values.");
                                input.next();
                            }
                        } while (ans2 < 1 || ans2 > 4);
                        StudentAfterLogin();
                        break;
                    case 3:
                        Payment();
                        StudentAfterLogin();
                        break;
                    case 4:
                        if (notification == null) {
                            System.out.println("You don't have new notification");
                        } else {
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
                if (ans >= 1 && ans <= 6)
                    success = true;
            } catch (InputMismatchException exception) {
                System.out.println("Invalid! Please enter numeric values");
                input.next();
            }
        }
    }

    public String toString() {
        String s = getFname() + "," + getLname() + "," + getID() + "," + getEmail() + "," + getUsername() + "," + getPassword() +
                "," + getPhoneNumber() + "," + GPA + "," + expenses + "," + expenses_paid + "," + gpaDrop +"," + notification.isNew_grade() +","+department+
                "," + NoOfCourses;
        if (!Student_courses.isEmpty()) {
            s += ",";
            for (int i = 0; i < Student_courses.size(); i++) {
                Course course = Student_courses.get(i);
                s += course.getCourseCode();
                if (i != Student_courses.size() - 1) {
                    s += '-';
                }
            }
        }
        return s;
    }

    public String GradesToString(StudentGrades grade,double zscore) {
        String a = "";
                a = getID() + "," + grade.getMidTermGrade()
                        + "," + grade.getFinalGrade() + "," + grade.getAttendanceGrade();
                    a += "," + zscore;
                if (!grade.assignmentGrade.isEmpty()) {
                    a += ",";
                    for (int j = 0; j < 2; j++) {
                        a += grade.assignmentGrade.get(j);
                        if (j != grade.assignmentGrade.size() - 1)
                            a += "-";
                    }
                }
                if (!grade.quizGrade.isEmpty()) {
                    a += ",";
                    for (int j = 0; j <2; j++) {
                        a += grade.quizGrade.get(j);
                        if (j != grade.quizGrade.size() - 1)
                            a += "-";
                    }
                }
        return a;
    }

    public String AttendanceToString() {
        String s = "";
        s = String.valueOf(getID());
        for (int i = 0; i < NoOfCourses; i++) {
            for (int j = 0; j < 5; j++) {
                if (attendance.length > 0)
                    s += ("," + attendance[i][j]);
            }
        }
        return s;
    }

    public void setStatus() {
        if (!Student_courses.isEmpty()) {
            for (int i = 0; i < Student_Grades.size(); i++) {
                if (!Student_courses.get(i).assignedInstructor.isEmpty()) {
                    if (Student_courses.get(i).assignedInstructor.get(0).getAllgradesAssigned() == 4 && Student_Grades.get(i).CalcTotalGrade() >= 60) {
                        Student_courses.get(i).setStatus(true);
                    }
                }
            }
        }
    }
}
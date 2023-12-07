import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;
    private int numOfSections = 0;
    public static int instructor_ID = 202212000;
    public ArrayList <Course> courses = new ArrayList<>();
    public Student students[] = new Student[10];
    public Instructor(){}
    public Instructor(String F, String L, String OFFL, String dep, int ns){
        super(F,L);
        this.office_location = OFFL;
        this.department = dep;
        this.numOfSections = ns;
        this.setID(instructor_ID);
        instructor_ID++;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
    }
    public String getOffice_location() {
        return office_location;
    }
    public void setOffice_location(String office_location) {
        this.office_location = office_location;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) { this.department = department; }
    public int getNumOfSections() {
        return numOfSections;
    }
    public void setNumOfSections(int numOfSections) {
        this.numOfSections = numOfSections;
    }
    public void editInfo(){
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\n3-Username or Password");
        System.out.println("4-Office location\n5-Department\n6-Number of Sections");
        int choice = input.nextInt();
        switch (choice){
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
                System.out.println("Enter your current username and password");
                String t1 = input.next(),t2 = input.next();
                if(this.getUsername().equals(t1) && this.getPassword().equals(t2)){
                    System.out.println("Enter new username and password");
                    t1=input.next();
                    t2=input.next();
                    this.setUsername(t1);
                    this.setPassword(t2);
                }
                break;
            case 4:
                System.out.println("Enter new office location");
                this.office_location = input.next();
                break;
            case 5:
                System.out.println("Enter new department");
                this.department = input.next();
                break;
            case 6:
                System.out.println("Enter number of sections");
                this.numOfSections = input.nextInt();
                break;
        }
    }
    public void trackAttendance(){
        System.out.println("Enter student ID");
        int sid = input.nextInt();
        System.out.println("Enter course Id");
        int cid =input.nextInt();
        System.out.println("Enter section number");
        int snum = input.nextInt();
        System.out.println("Did the student attend?(y/n)");
        char ch = input.next().charAt(0);
        if(ch == 'Y' || ch == 'y') {
            students[sid].attendance[cid][snum][0] = true;
        }
        else {
            students[sid].attendance[cid][snum][0] = false;
            System.out.println("Are there any exception?");
            ch = input.next().charAt(0);
            if(ch == 'Y' || ch == 'y') {
                students[sid].attendance[cid][snum][1] = true;
            }
        }
    }
    public void setAssessmentsToCourse(){
        System.out.println("Enter course ID");
        int cid = input.nextInt();
        System.out.println("Adding assessment to " + courses.get(cid).courseTitle);
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Practical");
        int choice =input.nextInt();
        switch (choice){
            case 1:
                //add Assignment
                Assignment assignment=new Assignment();
                System.out.println("Assignment number: ");
                assignment.setID(input.nextInt());
                System.out.print("Title: ");
                assignment.setTitle(input.next());
                System.out.print("Mark: ");
                assignment.setMax_score(input.nextInt());
                System.out.print("Deadline: ");
                assignment.set_Assignment_deadline(input.next());
                courses.get(cid).addAssignedAssignment(assignment);
                break;
            case 2:
                //add Quiz
                Quiz quiz =new Quiz();
                System.out.println("Quiz number: ");
                quiz.setID(input.nextInt());
                System.out.print("Title: ");
                quiz.setTitle(input.next());
                System.out.print("Date: ");
                quiz.setDate(input.next());
                System.out.print("Mark: ");
                quiz.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                quiz.setQuiz_Duration(input.nextInt());
                courses.get(cid).addAssignedQuiz(quiz);
                break;
            case 3:
                //add Midterm
                MidtermExam midtermExam = new MidtermExam();
                System.out.print("Title: ");
                midtermExam.setTitle(input.next());
                System.out.print("Date: ");
                midtermExam.setDate(input.next());
                System.out.print("Mark: ");
                midtermExam.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                midtermExam.setExam_Duration(input.nextInt());
                System.out.println("Location: ");
                midtermExam.setExam_Location(input.next());
                courses.get(cid).addAssignedMidterm(midtermExam);
                break;
            case 4:
                //add Final
                FinalExam finalExam = new FinalExam();
                System.out.print("Title: ");
                finalExam.setTitle(input.next());
                System.out.print("Date: ");
                finalExam.setDate(input.next());
                System.out.print("Mark: ");
                finalExam.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                finalExam.setExam_Time(input.nextInt());
                System.out.println("Location: ");
                finalExam.setLocation(input.next());
                courses.get(cid).addAssignedFinal(finalExam);
                break;
            case 5:
                //add Practical
                Practical practical = new Practical();
                System.out.print("Title: ");
                practical.setTitle(input.next());
                System.out.print("Date: ");
                practical.setDate(input.next());
                System.out.print("Mark: ");
                practical.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                practical.setPractical_Exam_Time(input.nextInt());
                System.out.println("Location: ");
                practical.setPractical_Exam_Location(input.next());
                //courses.get(cid).addAssignedpractical(practical);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
    public void inputGrades(){
        System.out.println("Enter student ID");
        int sid = input.nextInt();
        System.out.println("Enter course ID");
        int cid =input.nextInt();
        System.out.println("What do you want track");
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Practical\n5-Final");
        int choice = input.nextInt();
        switch (choice){
            case 1: //Assignment
                System.out.println("Enter grade");
                double a = input.nextDouble();
                students[sid].Student_Grades.get(cid).setAssignmentGrade(a);
                break;
            case 2: //Quiz
                System.out.println("Enter grade");
                double q = input.nextDouble();
                students[sid].Student_Grades.get(cid).setQuizGrade(q);
                break;
            case 3: //Midterm
                System.out.println("Enter grade");
                double m = input.nextDouble();
                students[sid].Student_Grades.get(cid).setMidTermGrade(m);
                break;
            case 4: //Practical
                System.out.println("Enter grade");
                double p = input.nextDouble();
              //  students[sid].Student_courses[cid].grades.se(p);
                break;
            case 5: //final
                System.out.println("Enter grade");
                double f = input.nextDouble();
                students[sid].Student_Grades.get(cid).setFinalGrade(f);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void generateAttRepForIndStud(int sum, int sid, int cid){
        System.out.println("Report for student "+students[sid].getFname()+" "+students[sid].getLname());
        System.out.println("Number of attended sessions: "+sum);
        System.out.println("Student have "+" exceptions ");
    }
    public void generateAttrepforallstud() {
        
    }
    public void setDEadlinesandReminders(){

    // LocalDate deadline = LocalDate.now();
     //System.out.println( "Assignmet deadline at : "+deadline.plusDays(10));
        LocalDate Assignment_startDate = LocalDate.of(2023, 12, 10); // Set the start date for the assignment
        LocalDate Assignment_Deadline = Assignment_startDate.plusDays(10); // Set the assignment deadline 10 from the start date
        Assignment assignment = new Assignment();
        System.out.println("Start Date: " + assignment.getAssignment_Deadline());
        System.out.println("Deadline: " + assignment.getAssignment_Deadline());

   }
    public void trackingStudentsAttendanceGrades(){
       for (Student student:students) {
           int attndance_sum = 0;
           for (int i = 0; i < 10; i++) {
               if (students.attendance[cid][i]) {
                   attndance_sum++;
               }
           }
           if (attndance_sum <= 5 && attndance_sum >= 3) {
               Notification notification = new Notification();
               notification.addAttendance(true);
               student.Student_Grades.get(cid).setAttendanceGrade(2);
           } else if (attndance_sum < 3) {
               student.Student_Grades.get(cid).setAttendanceGrade(0);
           } else {
               student.Student_Grades.get(cid).setAttendanceGrade(5);
           }
           //generateAttRepForIndStud(attndance_sum, sid, cid);
       }
    }
    public void viewEnrolledStudents (){
        for (Student student : students) {
            student.display();
        }
    }
}
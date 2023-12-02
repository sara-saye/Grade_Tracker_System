import java.util.Scanner;

public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;
    private int numOfSections = 0;
    public static int instructor_ID = 202212000;
    Course course = new Course();
    Student students[] = new Student[10];
    public Instructor(){}
    public Instructor(String F, String L, String OFFL, String dep, int ns){
        super(F,L);
        this.office_location = OFFL;
        this.department = dep;
        this.numOfSections = ns;
        this.ID = instructor_ID;
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
                this.Fname = input.next();
                this.Lname = input.next();
                break;
            case 2:
                System.out.println("Enter new Email");
                String s = input.next();
                this.setEmail(s);
                break;
            case 3:
                System.out.println("Enter your current username and password");
                String t1 = input.next(),t2=input.next();
                if(this.getUsername().equals(t1)&&this.getPassword().equals(t2)){
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
    public void trackAttenForoneSection(){
        System.out.println("Enter student ID");
        int sid = input.nextInt();
        System.out.println("Enter section number");
        int snum = input.nextInt();
        students[sid].attendance[snum] = true;
    }
    public void setAssessmentsToCourse(){
        System.out.println("Adding assessment to " + course.courseTitle);
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Practical\n5-Final");
        int choice =input.nextInt();
        switch (choice){
            case 1:
                //add Assignment
                Assignment assignment=new Assignment();
                System.out.print("Title: ");
                assignment.setTitle(input.next());
                System.out.print("Mark: ");
                assignment.setMark(input.nextInt());
                System.out.print("Deadline: ");
                assignment.set_Assignment_deadline(input.next());
                course.addAssignedAssignment(assignment);
                break;
            case 2:
                //add Quiz
                Quiz quiz =new Quiz();
                System.out.print("Title: ");
                quiz.setTitle(input.next());
                System.out.print("Date: ");
                quiz.setDate(input.next());
                System.out.print("Mark: ");
                quiz.setMark(input.nextInt());
                System.out.print("Duration: ");
                quiz.setQuiz_Duration(input.nextInt());
                course.addAssignedQuiz(quiz);
                break;
            case 3:
                //add Midterm
                MidtermExam midtermExam = new MidtermExam();
                System.out.print("Title: ");
                midtermExam.setTitle(input.next());
                System.out.print("Date: ");
                midtermExam.setDate(input.next());
                System.out.print("Mark: ");
                midtermExam.setMark(input.nextInt());
                System.out.print("Duration: ");
                midtermExam.setExam_Duration(input.nextInt());
                System.out.println("Location: ");
                midtermExam.setExam_Location(input.next());
                course.addAssignedMidterm(midtermExam);
                break;
            case 4:
                //add Practical
                Practical practical =new Practical();
                System.out.print("Title: ");
                practical.setTitle(input.next());
                System.out.print("Date: ");
                practical.setDate(input.next());
                System.out.print("Mark: ");
                practical.setMark(input.nextInt());
                System.out.print("Duration: ");
                practical.setPractical_Exam_Time(input.nextInt());
                System.out.println("Location: ");
                practical.setPractical_Exam_Location(input.next());
                break;
            case 5:
                //add Final
                FinalExam finalExam = new FinalExam();
                System.out.print("Title: ");
                finalExam.setTitle(input.next());
                System.out.print("Date: ");
                finalExam.setDate(input.next());
                System.out.print("Mark: ");
                finalExam.setMark(input.nextInt());
                System.out.print("Duration: ");
                finalExam.setExam_Time(input.nextInt());
                System.out.println("Location: ");
                finalExam.setLocation(input.next());
                course.addAssignedFinal(finalExam);
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
        //students[sid].courses[cid].grades
    }
    public void generateAttRepForIndStud(){
        
    }
}
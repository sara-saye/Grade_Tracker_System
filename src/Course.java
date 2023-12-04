
import java.util.ArrayList;
import java.io.*;
public class Course {
    private   String courseCode;
    public  String courseTitle;
    public  int credits;  //>>convert it to string while we deal with files
    public String department;
    public  String description;
    public Instructor assignedInstructor = new Instructor();
    public StudentGrades grades = new StudentGrades();
    public Assignment assignedAssignment = new Assignment();
    public Quiz assignedQuiz = new Quiz();
    public MidtermExam assignedMidterm = new MidtermExam();
    public FinalExam assignedfinal = new FinalExam();

    public ArrayList<Student>enrolledStudents=new ArrayList<Student>();
    public String []sessionDates=new String[2];
    public static int no_of_courses=0;//amr
    Course () {}
    Course (String courseCode,String courseTitle,int credits,String department,String description,Instructor assignedInstructor,
    Assignment assignedAssignment,Quiz assignedQuiz,MidtermExam assignedMidterm,FinalExam assignedfinal)
    {
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
        this.credits=credits;
        this.department=department;
        this.description=description;
        this.assignedInstructor=assignedInstructor;
        this.assignedAssignment=assignedAssignment;
        this.assignedQuiz=assignedQuiz;
        this.assignedfinal=assignedfinal;
        this.assignedMidterm=assignedMidterm;
        no_of_courses++;
    }
    public Course(String courseCode,String courseTitle)
    {
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
        no_of_courses++;
    }
    public void setCourseCode(String courseCode)
    {
        this.courseCode=courseCode;
    }
    public String getCourseCode(String courseCode)
    {
        return  courseCode;
    }
    public void enrollStudent(Student student) //>>student sends me the student and its index
    {
         enrolledStudents.add(student);
    }
    public  void dropStudent(int studentIdx) //>>student sends me that index
    {
        try {
            enrolledStudents.remove(studentIdx);
            }
        catch (IndexOutOfBoundsException IOBex)
        {
            System.out.println(IOBex.getMessage());
        }
    }
    public void addAssignedAssignment(Assignment assignedAssignment) //>>instructor sends me that assignment
    {
           this.assignedAssignment=assignedAssignment;
    }
    public void addAssignedQuiz(Quiz assignedQuiz) //>>instructor sends me that quiz
    {
        this.assignedQuiz=assignedQuiz;
    }
    public void addAssignedMidterm(MidtermExam assignedMidterm) //>>instructor sends me that Mid
    {
        this.assignedMidterm=assignedMidterm;
    }
    public void addAssignedFinal(FinalExam assignedfinal) //>>instructor sends me that finalExam
    {
       this.assignedfinal=assignedfinal;
    }
    public void setGrades(StudentGrades grade)    //>>Main will send it to me    //array or just a variable?
    {
        // grades.add(grade);
    }

}


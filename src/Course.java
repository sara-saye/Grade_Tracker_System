import java.util.ArrayList;
//anything
public class Course {
    protected  String courseCode;
    public  String courseTitle;
    public  int credits;  //>>convert it to string while we deal with files
    public String department;
    public  String description;
    public Course(String courseCode,String courseTitle)
    {
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
    }
    public Instructor assignedInstructor = new Instructor(); //>>change with real name
    public Assignment assignedAssignment = new Assignment(); //>>change with real name
    public Quiz assignedQuiz = new Quiz(); //>>change with real name
    public Final assignedfinal = new Final(); //>>change with real name
    public Midterm assignedMidterm = new Midterm(); //>>change with real name
    public ArrayList<Student>enrolledStudents=new ArrayList<Student>(); //>>change with real name
    public String []sessionDates=new String[2];

    Course ()
    {
    }
    public void enrollStudent(Student student,int studentIdx ) //>>student sends me the student and its index
    {

    }
    public  void dropStudent(int studentIdx) //>>student sends me that index
    {

    }
    public void addAssignedAssignment(Assignment assignment) //>>instructor sends me that assignment
    {

    }
    public void addAssignedQuiz(Quiz quiz) //>>instructor sends me that quiz
    {

    }
    public void addAssignedMidterm(Midterm midterm) //>>instructor sends me that Mid
    {

    }
    public void addAssignedFinal(Final finalExam) //>>instructor sends me that finalExam
    {

    }

}


import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.StringTokenizer;

public class Files   {
    static File courseFile =new File("course.txt");
    static File instructorFile =new File("instructor.txt");
    static File finalExamFile =new File("finalExam.txt");
    static File midtermExamFile =new File("midtermExam.txt");
    static File assignmentFile =new File("assignment.txt");
    static File quizFile =new File("quiz.txt");
    public static void readCourse () throws IOException {
        StringTokenizer token=null;

        BufferedReader courseBR=new BufferedReader(new FileReader(courseFile));
        String courseCode="";
        String courseTitle="";
        int credits=0;
        String department="";
        String description="";
        String line="" ;
        while((line = courseBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            courseCode =token.nextToken();
            courseTitle=token.nextToken();
            credits=Integer.parseInt(token.nextToken());
            department=token.nextToken();
            description=token.nextToken();
            String sessionLine=token.nextToken();
            String [] sessionDates=sessionLine.split("-");
            Course course=new Course(courseCode,courseTitle,credits,department,description,sessionDates);
            Main.courses.add(course);
        }
        courseBR.close();

    }

    public static void readInstructor () throws IOException {
        StringTokenizer token = null;
        BufferedReader instructorBR=new BufferedReader(new FileReader(instructorFile));
        int id=0;
        String firstName="";
        String lastName="";
        String email="";
        String password="";
        String PhoneNumber="";
        String office_location="";
        String department=" ";
        String line="" ;
        while((line = instructorBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            id = Integer.parseInt(token.nextToken());
            firstName=token.nextToken();
            lastName=token.nextToken();
            email=token.nextToken();
            password=token.nextToken();
            PhoneNumber=token.nextToken();
            office_location=token.nextToken();
            department=token.nextToken();
            Instructor instructor=new Instructor( id,firstName,lastName,email,password, PhoneNumber, office_location, department);
            Main.instructors.add(instructor);
        }
        instructorBR.close();

    }

    public static void readFinalExam() throws IOException {
        StringTokenizer token = null;
        BufferedReader finalExamBR=new BufferedReader(new FileReader(finalExamFile));
        int ID=0;
        String Title="" ;
        int Max_score=0;
        String Date;
        String Location;
        double Exam_Time;
        String line="";
        while((line =  finalExamBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            ID = Integer.parseInt(token.nextToken());
            Title=token.nextToken();
            Max_score=Integer.parseInt(token.nextToken());
            Date =token.nextToken();
            Location=token.nextToken();
            Exam_Time= Double.parseDouble(token.nextToken());
            FinalExam finalExam=new FinalExam(ID,Title,Max_score,Date,Location,Exam_Time);
            Main.finalExams.add(finalExam);
        }
        finalExamBR.close();

    }
    public static void readMidtermExam() throws IOException {
        StringTokenizer token = null;
        BufferedReader midtermExamBR=new BufferedReader(new FileReader(midtermExamFile));
        int ID=0;
        String Title="" ;
        int Max_score=0;
        String Date;
        String Exam_Location;
        int Exam_Duration;
        String line="";
        while((line =  midtermExamBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            ID = Integer.parseInt(token.nextToken());
            Title=token.nextToken();
            Max_score=Integer.parseInt(token.nextToken());
            Date =token.nextToken();
           Exam_Location= token.nextToken();
            Exam_Duration=Integer.parseInt(token.nextToken());
            MidtermExam midtermExam=new MidtermExam(ID,Title,Max_score,Date,Exam_Location,Exam_Duration);
            Main.midtermExams.add(midtermExam);
        }
        midtermExamBR.close();

    }
    public static void readAssignment() throws IOException {
        StringTokenizer token = null;
        BufferedReader assignmentBR=new BufferedReader(new FileReader(assignmentFile));
        int ID=0;
        String Title="" ;
        int Max_score=0;
        String Date="";
        String Assignment_startDate="";
        String Assignment_Deadline="";
        String line="";
        while((line =  assignmentBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            ID = Integer.parseInt(token.nextToken());
            Title=token.nextToken();
            Max_score=Integer.parseInt(token.nextToken());
            Date =token.nextToken();
            Assignment_startDate= token.nextToken();
            Assignment_Deadline=token.nextToken();
           Assignment assignment=new Assignment(ID,Title,Max_score,Date,Assignment_startDate,Assignment_Deadline);
            Main.assignments.add(assignment);
        }
        assignmentBR.close();

    }
    public static void readQuiz() throws IOException {
        StringTokenizer token = null;
        BufferedReader quizBR=new BufferedReader(new FileReader(quizFile));
        int ID=0;
        String Title="" ;
        int Max_score=0;
        String Date="";
        int Quiz_Duration ;
        String line="";
        while((line =  quizBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            ID = Integer.parseInt(token.nextToken());
            Title=token.nextToken();
            Max_score=Integer.parseInt(token.nextToken());
            Date =token.nextToken();
            Quiz_Duration=Integer.parseInt(token.nextToken());
            Quiz quiz=new Quiz(ID,Title,Max_score,Date,Quiz_Duration);
            Main.quizzes.add(quiz);
        }
        quizBR.close();

    }









    public  static void writeCourse() throws IOException {
        BufferedWriter courseBW=new BufferedWriter(new FileWriter(courseFile));
        for(Course course:Main.courses)
        {
            courseBW.write(course.toString());
            courseBW.newLine();
        }
        courseBW.flush();
        courseBW.close();
    }
    public  static void writeInstructor() throws IOException {
        BufferedWriter instructorBW=new BufferedWriter(new FileWriter(instructorFile));
        for(Instructor instructor :Main.instructors)
        {
            instructorBW.write(instructor.toString());
            instructorBW.newLine();
        }
        instructorBW.flush();
        instructorBW.close();
    }
    public  static void writeFinalExam() throws IOException {
        BufferedWriter finalExamBW=new BufferedWriter(new FileWriter(finalExamFile));
        for(FinalExam finalExam :Main.finalExams)
        {
            finalExamBW.write(finalExam.toString());
            finalExamBW.newLine();
        }
        finalExamBW.flush();
        finalExamBW.close();
    }
    public  static void writeMidtermExam() throws IOException {
        BufferedWriter midtermExamBW=new BufferedWriter(new FileWriter(midtermExamFile));
        for(MidtermExam midtermExam :Main.midtermExams)
        {
            midtermExamBW.write(midtermExam.toString());
            midtermExamBW.newLine();
        }
        midtermExamBW.flush();
        midtermExamBW.close();
    }
    public  static void writeAssignment() throws IOException {
        BufferedWriter assignmentBW=new BufferedWriter(new FileWriter(assignmentFile));
        for(Assignment assignment:Main.assignments)
        {
            assignmentBW.write(assignment.toString());
            assignmentBW.newLine();
        }
        assignmentBW.flush();
        assignmentBW.close();
    }
    public  static void writeQuiz() throws IOException {
        BufferedWriter quizBW=new BufferedWriter(new FileWriter(quizFile));
        for(Quiz quiz:Main.quizzes)
        {
            quizBW.write(quiz.toString());
            quizBW.newLine();
        }
        quizBW.flush();
        quizBW.close();
    }


}

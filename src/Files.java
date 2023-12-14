import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class Files   {
    static File courseFile =new File("course.txt");
    static File instructorFile =new File("instructor.txt");
    static File finalExamFile =new File("finalExam.txt");
    static File midtermExamFile =new File("midtermExam.txt");
    static File assignmentFile =new File("assignment.txt");
    static File quizFile =new File("quiz.txt");
    static File StudentFile =new File("Student.txt");
    static File GradesFile =new File("Grades.txt");
   // static File NotificationsFile =new File("Notification.txt");

    static File AttendanceFile =new File("Attendance.txt");


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
        String username=" ";
        String line="" ;
        while((line = instructorBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            id = Integer.parseInt(token.nextToken());
            firstName=token.nextToken();
            lastName=token.nextToken();
            email=token.nextToken();
            username=token.nextToken();
            password=token.nextToken();
            PhoneNumber=token.nextToken();
            office_location=token.nextToken();
            department=token.nextToken();
            Instructor instructor=new Instructor(id,firstName,lastName,email,username,password, PhoneNumber, office_location, department);
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
        double Max_score=0;
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
    public static void readCourse () throws IOException {
        StringTokenizer token=null;

        BufferedReader courseBR=new BufferedReader(new FileReader(courseFile));
        String courseCode="";
        String courseTitle="";
        int credits=0;
        String department="";
        String description="";
        int instructorId=-1;
        int assignedFinalExamId=-1;
        int assignedMidtermExamId=-1;
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
            if(token.hasMoreTokens() ) {                                  //>>Take care, FinalExamId always starts with 1
                instructorId = Integer.parseInt(token.nextToken());
            }

            if(token.hasMoreTokens()&&token.nextToken().startsWith("1"))      //Take care, FinalExamId always starts with 1
            {
                assignedFinalExamId = Integer.parseInt(token.nextToken());
            }
             if(token.hasMoreTokens()&&token.nextToken().startsWith("2")) {   //Take care, MidtermExamId always starts with 2
                 assignedMidtermExamId = Integer.parseInt(token.nextToken());
             }

            String [] sessionDates=sessionLine.split("-");


            Instructor instructor=null;
            for(int instructorIndex=0;instructorIndex<Main.instructors.size();instructorIndex++)
            {
                if(instructorId==Main.instructors.get(instructorIndex).getID())
                {
                    int id=Main.instructors.get(instructorIndex).getID();
                    String firstName=Main.instructors.get(instructorIndex).getFname();
                    String lastName=Main.instructors.get(instructorIndex).getLname();
                    String email=Main.instructors.get(instructorIndex).getEmail();
                    String username=Main.instructors.get(instructorIndex).getUsername();
                    String password=Main.instructors.get(instructorIndex).getPassword();
                    String PhoneNumber=Main.instructors.get(instructorIndex).getPhoneNumber();
                    String office_location=Main.instructors.get(instructorIndex).getOffice_location();
                    String instructorDepartment=Main.instructors.get(instructorIndex).getDepartment();
                    instructor=new Instructor( id,firstName,lastName,email,username,password, PhoneNumber,
                            office_location, instructorDepartment);
                }
            }
            FinalExam finalExam=new FinalExam();
            for(int finalExamIndex=0;finalExamIndex<Main.finalExams.size();finalExamIndex++)
            {
                   if(assignedFinalExamId==Main.finalExams.get(finalExamIndex).getID())
                   {
                       int ID=Main.finalExams.get(finalExamIndex).getID();
                       String Title=Main.finalExams.get(finalExamIndex).getTitle() ;
                       double Max_score=Main.finalExams.get(finalExamIndex).getMax_score();
                       LocalDate Date= Main.finalExams.get(finalExamIndex).getDate();
                       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                       String StringDate = Date.format(formatter);
                       String Location=Main.finalExams.get(finalExamIndex).getLocation();
                       double Exam_Time=Main.finalExams.get(finalExamIndex).getExam_Time();
                       finalExam =new FinalExam(ID,Title,Max_score,StringDate,Location,Exam_Time);
                   }
            }
            MidtermExam midtermExam=new MidtermExam();
            for(int midtermIndex=0;midtermIndex<Main.midtermExams.size();midtermIndex++)
            {
                if(assignedMidtermExamId==Main.midtermExams.get(midtermIndex).getID())
                {
                    int ID=Main.midtermExams.get(midtermIndex).getID();
                    String Title=Main.midtermExams.get(midtermIndex).getTitle() ;
                    double Max_score=Main.midtermExams.get(midtermIndex).getMax_score();
                    LocalDate Date= Main.midtermExams.get(midtermIndex).getDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                    String StringDate = Date.format(formatter);
                    String Exam_Location=Main.midtermExams.get(midtermIndex).getExam_Location();
                    double Exam_Duration=Main.midtermExams.get(midtermIndex).getExam_Duration();
                    midtermExam=new MidtermExam(ID,Title,Max_score,StringDate,Exam_Location,Exam_Duration);
                }
            }

            Course course=new Course(courseCode,courseTitle,credits,department,description,sessionDates,instructor,midtermExam,finalExam);
            Main.courses.add(course);
        }
        courseBR.close();

    }
    public static void readAssignment() throws IOException {
        StringTokenizer token = null;
        BufferedReader assignmentBR=new BufferedReader(new FileReader(assignmentFile));
        int ID=0;
        String Title="" ;
        double Max_score=0;
        String Date="";
        String Assignment_startDate="";
        String Assignment_Deadline="";
        String assignmentCourseCode="";
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
            assignmentCourseCode=token.nextToken();
            Assignment assignment=new Assignment(ID,Title,Max_score,Date,Assignment_startDate,Assignment_Deadline,assignmentCourseCode);
            Main.assignments.add(assignment);
        }
        assignmentBR.close();

    }

    public static void readQuiz() throws IOException {
        StringTokenizer token = null;
        BufferedReader quizBR=new BufferedReader(new FileReader(quizFile));
        int ID=0;
        String Title="" ;
        double Max_score=0;
        String Date="";
        double Quiz_Duration ;
        String quizCourseCode="";
        String line="";
        while((line =  quizBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            ID = Integer.parseInt(token.nextToken());
            Title=token.nextToken();
            Max_score=Integer.parseInt(token.nextToken());
            Date =token.nextToken();
            Quiz_Duration=Integer.parseInt(token.nextToken());
            quizCourseCode=token.nextToken();
            Quiz quiz=new Quiz(ID,Title,Max_score,Date,Quiz_Duration,quizCourseCode);
            Main.quizzes.add(quiz);
        }
        quizBR.close();

    }
    public static void instructorAndCourseRelation()
    {
        for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++)
        {
            for(int instructorIndex=0;instructorIndex<Main.instructors.size();instructorIndex++)
            {
                if((!Main.courses.get(courseIndex).assignedInstructor.isEmpty())&&(Main.courses.get(courseIndex).assignedInstructor.get(0).getID()==Main.instructors.get(instructorIndex).getID()))
                {
                    Main.instructors.get(instructorIndex).course.add(Main.courses.get(courseIndex));
                }
            }
        }
    }
    public static void assignmentAndCourseRelation()
    {
        for(int assignmentIndex=0;assignmentIndex<Main.assignments.size();assignmentIndex++)
        {
            for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++)
            {
                if(Main.assignments.get(assignmentIndex).courseCode.equals(Main.courses.get(courseIndex).getCourseCode()))
                {
                    Main.courses.get(courseIndex).assignedAssignment.add(Main.assignments.get(assignmentIndex));
                }
            }
        }
    }
    public static void quizAndCourseRelation()
    {
        for(int quizIndex=0;quizIndex<Main.quizzes.size();quizIndex++)
        {
            for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++)
            {
                if(Main.quizzes.get(quizIndex).courseCode.equals(Main.courses.get(courseIndex).getCourseCode()))
                {
                    Main.courses.get(courseIndex).assignedQuiz.add(Main.quizzes.get(quizIndex));
                }
            }
        }
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
    public  static void writeStudents() throws IOException {
        BufferedWriter StudentBW=new BufferedWriter(new FileWriter(StudentFile));
        for(Student student:Main.students)
        {
            StudentBW.write(student.toString());
            StudentBW.newLine();
        }
        StudentBW.flush();
        StudentBW.close();
    }
    public  static void writeGrades() throws IOException {
        BufferedWriter gradesBW=new BufferedWriter(new FileWriter(GradesFile));

        for(Student student:Main.students)
        {
            if(!student.Student_Grades.isEmpty()) {
                gradesBW.write(student.GradesToString());
                gradesBW.newLine();
            }
        }
        gradesBW.flush();
        gradesBW.close();
    }
//    public  static void writeNotification() throws IOException {
//        BufferedWriter NotificationBW=new BufferedWriter(new FileWriter(NotificationsFile));
//        for(Student student:Main.students)
//        {
//            NotificationBW.write(student.getID()+","+student.getNotification().NotificationToString());
//            NotificationBW.newLine();
//        }
//        NotificationBW.flush();
//        NotificationBW.close();
//    }
    public  static void writeAttendance() throws IOException {
        BufferedWriter AttendanceBW=new BufferedWriter(new FileWriter(AttendanceFile));
        for(Student student:Main.students)
        {
            AttendanceBW.write(student.AttendanceToString());
            AttendanceBW.newLine();
        }
        AttendanceBW.flush();
        AttendanceBW.close();
    }
    public static void readStudents() throws IOException {
        StringTokenizer token = null;
        BufferedReader StudentBR=new BufferedReader(new FileReader(StudentFile));
        String line="" ;
        while((line = StudentBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            Student student=new Student();
            student.setFname(token.nextToken());
            student.setLname(token.nextToken());
            student.setID(Integer.parseInt(token.nextToken()));
            student.setEmail(token.nextToken());
            student.setUsername(token.nextToken());
            student.setPassword(token.nextToken());
            student.setPhoneNumber(token.nextToken());
            student.setGPA(Double.parseDouble(token.nextToken()));
            student.setExpenses(Double.parseDouble(token.nextToken()));
            student.setExpenses_paid(Boolean.parseBoolean(token.nextToken()));
            student.setGpaDrop(Boolean.parseBoolean(token.nextToken()));
            student.setAttendanceDrop(Boolean.parseBoolean(token.nextToken()));
            student.getNotification().setNew_grade(Boolean.parseBoolean(token.nextToken()));
            student.setNoOfCourses(Integer.parseInt(token.nextToken()));
            if(student.getNoOfCourses()!=0) {
                String[] coursecode = token.nextToken().split("-");

                for (String code : coursecode) {
                    for (int i = 0; i < Main.courses.size(); i++) {
                        if (code.equals(Main.courses.get(i).getCourseCode())) {
                            student.Student_courses.add(Main.courses.get(i));
                        }
                    }
                }
            }
            Main.students.add(student);
        }
        StudentBR.close();
    }
    public static void readGrades() throws IOException {
        StringTokenizer token = null;
        BufferedReader GradesBR=new BufferedReader(new FileReader(GradesFile));
        String line="" ;
        int id;
        while((line = GradesBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            StudentGrades studentGrade=new StudentGrades();
            id=Integer.parseInt(token.nextToken());
            studentGrade.setMidTermGrade(Double.parseDouble(token.nextToken()));
            studentGrade.setFinalGrade(Double.parseDouble(token.nextToken()));
            studentGrade.setAttendanceGrade(Double.parseDouble(token.nextToken()));
            Main.students.get(id).ZScore.add(Double.parseDouble(token.nextToken()));
            String[] assignmentGrades = token.nextToken().split("-");
            String [] quizGrades = token.nextToken().split("-");
            for (String assignmentGrade : assignmentGrades) {
                studentGrade.assignmentGrade.add(Double.valueOf(assignmentGrade));
            }
            for (String quizGrade : quizGrades) {
                studentGrade.quizGrade.add(Double.valueOf(quizGrade));
            }

            Main.students.get(id).Student_Grades.add(studentGrade);
        }
        GradesBR.close();
    }

//    public static void readNotification() throws IOException {
//        StringTokenizer token = null;
//        BufferedReader NotificationBR=new BufferedReader(new FileReader(NotificationsFile));
//        String line="" ;
//        int id;
//        while((line = NotificationBR.readLine())!=null)
//        {
//            token =new StringTokenizer(line,",");
//            Notification n = new Notification();
//            id=Integer.parseInt(token.nextToken());
//            n.addStatueOfGrade(Boolean.parseBoolean(token.nextToken()));
//            n.addAttendance(Boolean.parseBoolean(token.nextToken()));
//            n.addGpa(Double.parseDouble(token.nextToken()));
//            n.addEvent((token.nextToken()));
//            String assignment=token.nextToken();
//            String quiz=token.nextToken();
//            String []assignmentarr= (assignment.split("-"));
//            String []quizarr= (quiz.split("-"));
//            for (String s : assignmentarr) {
//                for (int j = 0; j < Main.assignments.size(); j++) {
//                    if (Integer.parseInt(s) == (Main.assignments.get(j).getID())) {
//                        n.addAssignedAssignment(Main.assignments.get(j));
//                    }
//                }
//            }
//            for (String s : quizarr) {
//                for (int j = 0; j < Main.quizzes.size(); j++) {
//                    if (Integer.parseInt(s) == (Main.quizzes.get(j).getID())) {
//                        n.addAssignedQuiz(Main.quizzes.get(j));
//                    }
//                }
//            }
//
//            Main.students.get(id).setNotification(n);
//        }
//        NotificationBR.close();
//    }
    public static void readAttendance() throws IOException {
        StringTokenizer token = null;
        BufferedReader AttendanceBR=new BufferedReader(new FileReader(AttendanceFile));
        String line="" ;
        int id;
        while((line = AttendanceBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            Notification n = new Notification();
            id=Integer.parseInt(token.nextToken());
            for (int i=0;i<Main.students.get(id).getNoOfCourses();i++) {
                for (int j = 0; j < 10; j++) {
                    Main.students.get(id).attendance[i][j]=Boolean.parseBoolean(token.nextToken());
                }
            }
        }
        AttendanceBR.close();
    }

    public static void StudentCourseRelation(){
        for (Student student1:Main.students) {
            for (Course course:student1.Student_courses) {
                for (Course Maincourse:Main.courses){
                    if(course.getCourseCode().equals(Maincourse.getCourseCode())){
                        Maincourse.enrolledStudents.add(student1);
                    }
                }
            }
        }
    }
}

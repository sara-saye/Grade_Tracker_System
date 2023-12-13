import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Notification {
        private ArrayList<Assignment> assignment = new ArrayList<Assignment>();
        private  ArrayList<Quiz> quiz = new ArrayList<Quiz>();
    private boolean New_grade;
    private boolean attendance;
    private double gpa;
    private String Event;
    public int warningCounter = 0;


    public void addAssignedAssignment(Assignment assignedAssignment) //>>instructor sends me that assignment
    {
        for (int i=0;i <= this.assignment.size();i++) {
            assignment.add(assignedAssignment);
        }
    }

//    public void addAssignment(int ID){
//        for (int studentIndex=0;studentIndex<Main.students.size();studentIndex++){
//            if (ID==Main.students.get(studentIndex).getID()){
//                for (int studentCoursesIndex =0;studentCoursesIndex<Main.students.get(studentIndex).Student_courses.size();studentCoursesIndex++){
//                    for (int courseIndex =0; courseIndex<Main.courses.size();courseIndex++) {
//                        if (Main.courses.get(courseIndex).getCourseCode().equals(Main.students.get(studentIndex).Student_courses.get(studentCoursesIndex).getCourseCode())) {
//                            if (!Main.courses.get(courseIndex).assignedAssignment.isEmpty()) {
//                                for (int assignmentIndex = 0; assignmentIndex < Main.courses.get(courseIndex).assignedAssignment.size(); assignmentIndex++) {
//                                    this.assignment.add(Main.courses.get(courseIndex).assignedAssignment.get(assignmentIndex));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    public void addAssignedQuiz(Quiz assignedQuiz) //>>instructor sends me that quiz
    {
        for (int i=0;i<= this.quiz.size();i++) {
            quiz.add(assignedQuiz);
        }
    }

    public void addStatueOfGrade(boolean new_grade) //>>I get it from Grades class
    {
        this.New_grade = new_grade;
    }

    public void addAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public void addGpa(double gpa) {
        this.gpa = gpa;
    }

    public void addEvent(String event) {
        this.Event = event;
    }

    public void Display_Notification(ArrayList<Course> course, int studentID) {
        for (int courseIndex=0;courseIndex <Main.students.get(studentID).Student_courses.size();courseIndex++) {
            course.add(Main.students.get(studentID).Student_courses.get(courseIndex));
        }
        if (!course.isEmpty()) {
            for (int i = 0; i <= course.size(); i++) {
                System.out.println(course.get(i).assignedAssignment.get(i).getTitle());
                System.out.println("Start Date: " + course.get(i).assignedAssignment.get(i).getAssignment_startDate());
                System.out.println("Deadline: " + course.get(i).assignedAssignment.get(i).getAssignment_Deadline());
                Duration diff = Duration.between(course.get(i).assignedAssignment.get(i).getAssignment_startDate().atStartOfDay(), course.assignedAssignment.get(i).getAssignment_Deadline().atStartOfDay());
                long diffDays = diff.toDays();
                System.out.println("Assignment ends at " + diffDays + " days");
            }
        }
        for (int i = 0; i <= course.size(); i++) {
            System.out.println(course.get(i).assignedQuiz.get(i).getTitle() + " " + course.get(i).assignedQuiz.get(i).getDate());
        }

        if (this.New_grade) {
            System.out.println("Your grades have been updated!");
            this.New_grade = false;
        }

//        if (attendance) {
//            System.out.println("Warning content");
//            warningCounter++;
//            this.attendance = false;
//        }

        if (Main.students.get(studentID).getGPA() <= 1.5) {
            System.out.println("Warning content");
        }

        if (!Event.equals("NULL")) {
            System.out.println(Event);
        }

    }


    public void dropGPAStudent(int studentID) {

        if (Main.students.get(studentID).getGPA() < 1) {

            Main.students.get(studentID).setGpaDrop(true);
        }

    }

    public void dropAttendance(int studentID){
        if (warningCounter == 3){
            Main.students.get(studentID).setAttendanceDrop(true);
        }

    }
    public String NotificationToString(){
        String a=New_grade+","+attendance+","+gpa+","+Event;
        if(!assignment.isEmpty()) {
            a+=",";
            for (int j=0;j<assignment.size();j++) {
                a +=assignment.get(j).getID();
                if(j!= assignment.size()-1){
                    a+="-";
                }
            }
        }
        if(!quiz.isEmpty()) {
            a+=",";
            for (int j=0;j<quiz.size();j++) {
                a +=quiz.get(j).getID() ;
                if(j!= assignment.size()-1){
                    a+="-";
                }
            }
        }

        return a;
    }

}
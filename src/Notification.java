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

    public void addAssignedAssignment(Assignment assignedAssignment) //>>instructor sends me that assignment
    {
        for (int i=0;i <= this.assignment.size();i++) {
            assignment.add(assignedAssignment);
        }
    }
    public void addAssignedQuiz(Quiz assignedQuiz) //>>instructor sends me that quiz
    {
        for (int i=0;i<= this.quiz.size();i++) {
            quiz.add(assignedQuiz);
        }
    }
    public void addStatueOfGrade(boolean new_grade) //>>I get it from Grades class
    {
        this.New_grade=new_grade;
    }
    public void addAttendance(boolean attendance){
        this.attendance=attendance;
    }
    public void addGpa(double gpa){
        this.gpa=gpa;
    }
    public void addEvent(String event){
        this.Event=event;
    }



public void Display_Notification(){
        if(!assignment.isEmpty()) {
            for (int i = 0; i <= this.assignment.size(); i++) {
                System.out.println(assignment.get(i).getTitle());
                System.out.println("Start Date: " + assignment.get(i).getAssignment_startDate());
                System.out.println("Deadline: " + assignment.get(i).getAssignment_Deadline());
                Duration diff = Duration.between(assignment.get(i).getAssignment_startDate().atStartOfDay(), assignment.get(i).getAssignment_Deadline().atStartOfDay());
                long diffDays = diff.toDays();
                System.out.println("Assignment ends at " + diffDays + " days");
            }
        }
    if(!quiz.isEmpty()) {
        for (int i = 0; i <= this.quiz.size(); i++) {
            System.out.println(quiz.get(i).getTitle() + " " + quiz.get(i).getDate());
        }
    }
    if (this.New_grade){
        System.out.println("Your grades have been updated");
    }
    if (attendance){
        System.out.println("Warning content");
    }
    if (gpa <= 1.5&&gpa!=-1){
        System.out.println("Warning content");
    }
    if (Event != null){
        System.out.println(Event);
    }


}

}
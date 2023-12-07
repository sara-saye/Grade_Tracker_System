import java.util.ArrayList;
import java.util.List;

public class Notification {
private ArrayList<Assignment> assignment = new ArrayList<Assignment>();
private  ArrayList<Quiz> quiz = new ArrayList<Quiz>();
private boolean New_grade;
private boolean attendance;
private float gpa;
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
    public void addGpa(float gpa){
        this.gpa=gpa;
    }
    public void addEvent(String event){
        this.Event=event;
    }



public void Display_Notification(){

    for (int i=0;i <= this.assignment.size();i++) {
        System.out.println(assignment.get(i).getTitle() +" "+ assignment.get(i).getAssignment_Deadline());
    }
    for (int i=0;i<= this.quiz.size();i++) {
        System.out.println(quiz.get(i).getTitle()+" "+ quiz.get(i).getDate());
    }
    if (this.New_grade){
        System.out.println("Your grades have been updated");
    }
    if (attendance){
        System.out.println("Warning content");
    }
    if (gpa <= 1.5){
        System.out.println("Warning content");
    }
    if (!Event.equals("NULL")){
        System.out.println(Event);
    }


}

}
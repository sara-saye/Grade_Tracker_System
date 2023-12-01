public class Notification {
private Assignment[] assignment;
private  Quiz[] quiz;
private boolean New_grade;

    public void addAssignedAssignment(Assignment assignedAssignment) //>>instructor sends me that assignment
    {
        for (int i=0;i<10;i++) {
            this.assignment[i] = assignedAssignment;
        }
    }
    public void addAssignedQuiz(Quiz assignedQuiz) //>>instructor sends me that quiz
    {
        for (int i=0;i<10;i++) {
            this.quiz[i] = assignedQuiz;
        }
    }
    public void addStatueOfGrade(boolean new_grade) //>>i get it from Grades class
    {
        this.New_grade=new_grade;
    }


public void Display_Notification(){

    for (int i=0;i<10;i++) {
        System.out.println(this.assignment[i]);
    }
    for (int i=0;i<10;i++) {
        System.out.println(this.quiz[i]);
    }
    if (this.New_grade){
        System.out.println("Your grades have been updated");

    }




}

}
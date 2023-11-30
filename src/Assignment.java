
public class Assignment extends Test {
    private String Assignment_Deadline ;
    public Assignment(int id, String Title,int max_score ,double mark , String date,String assignment_Deadline){
        super(id,Title,max_score,mark,date);
        this.Assignment_Deadline=assignment_Deadline;
    }
    public void set_Assignment_deadline (String assignment_Deadline){
        Assignment_Deadline=assignment_Deadline;
    }
    public String getAssignment_Deadline() {
        return Assignment_Deadline;
    }
}


public class Quiz extends Test {
    public String courseCode;
    public Quiz(){}
    public Quiz(int id, String Title,double max_score, String date,double quiz_Duration){
        super(id,Title,max_score,date);
        setDuration(quiz_Duration);
    }
    public Quiz(int id, String Title,double max_score, String date,double quiz_Duration,String courseCode){
       this(id,Title,max_score,date,quiz_Duration);
       this.courseCode=courseCode;
    }
    public  String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+getDuration()+","+courseCode;
    }
}


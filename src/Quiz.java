
public class Quiz extends Test {
    private double Quiz_Duration ;
    public String courseCode;
    public Quiz(){}
    public Quiz(int id, String Title,int max_score, String date,int quiz_Duration){
        super(id,Title,max_score,date);
        this.Quiz_Duration=quiz_Duration;
    }
    public Quiz(int id, String Title,int max_score, String date,int quiz_Duration,String courseCode){
       this(id,Title,max_score,date,quiz_Duration);
       this.courseCode=courseCode;
    }
    public void setQuiz_Duration(double quiz_Duration) {
        Quiz_Duration = quiz_Duration;
    }
    public double getQuiz_Duration() {
        return Quiz_Duration;
    }

    public  String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+getQuiz_Duration();
    }
}


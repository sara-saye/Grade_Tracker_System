
public class Quiz extends Test {
    private int Quiz_Duration ;
    public Quiz(){}
    public Quiz(int id, String Title,int max_score, String date,int quiz_Duration){
        super(id,Title,max_score,date);
        this.Quiz_Duration=quiz_Duration;
    }
    public void setQuiz_Duration(int quiz_Duration) {
        Quiz_Duration = quiz_Duration;
    }
    public int getQuiz_Duration() {
        return Quiz_Duration;
    }
    public  String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+getQuiz_Duration();
    }
}


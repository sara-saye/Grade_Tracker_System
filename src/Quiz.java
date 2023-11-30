
public class Quiz extends Test {
    private int Quiz_Duration ;
    public Quiz(int id, String Title,int max_score ,double mark , String date,int quiz_Duration){
        super(id,Title,max_score,mark,date);
        this.Quiz_Duration=quiz_Duration;
    }
    public void setQuiz_Duration(int quiz_Duration) {
        Quiz_Duration = quiz_Duration;
    }
    public int getQuiz_Duration() {
        return Quiz_Duration;
    }
}


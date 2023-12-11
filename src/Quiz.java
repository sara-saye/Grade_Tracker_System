
public class Quiz extends Test {
    private int Quiz_Duration ;
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
    public void setQuiz_Duration(int quiz_Duration) {
        Quiz_Duration = quiz_Duration;
    }
    public int getQuiz_Duration() {
        return Quiz_Duration;
    }
<<<<<<< Updated upstream
    public  String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+getQuiz_Duration();
    }
=======
    public void setMax_score(int max_score) {
        while (true) {
            System.out.println("Enter a grade for this quiz that doesn't exceed 20 marks ");
            if( max_score<= 10 ) {
                setMax_score(max_score);
                break;
            }
            else if (max_score > 10 ) {
                System.out.println("Invalid quiz grade Please try again ! ");
            }

        }
    }

>>>>>>> Stashed changes
}


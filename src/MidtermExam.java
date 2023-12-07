
public class MidtermExam extends Test {
    private String Exam_Location;
    private int Exam_Duration;
    public MidtermExam (){}
    public void setExam_Location(String exam_Location) {
        Exam_Location = exam_Location;
    }
    public void setExam_Duration(int exam_Duration) {
        Exam_Duration = exam_Duration;
    }
    public int getExam_Duration() {
        return Exam_Duration;
    }
    public String getExam_Location() {
        return Exam_Location;
    }
    public void setMax_score(int max_score) {
        while (true) {
            System.out.println("Enter a grade for this midterm exam that doesn't exceed 15 marks ");
            if( max_score<= 15 ) {
                setMax_score(max_score);
                break;
            }
            else if (max_score > 15 ) {
                System.out.println("Invalid Grade Please try again ! ");
            }

        }
    }

}

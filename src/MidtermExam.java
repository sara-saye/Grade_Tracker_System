
public class MidtermExam extends Test {
    private String Exam_Location;
    private int Exam_Duration;
    public MidtermExam (){}
    public MidtermExam(int id, String Title,int max_score , String date,String location,int Exam_Duration){
        super(id,Title,max_score,date);
        Exam_Location=location;
        this.Exam_Duration=Exam_Duration;
    }
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
    public String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+Exam_Location+","+Exam_Duration;
    }
}

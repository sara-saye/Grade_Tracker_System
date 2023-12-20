
public class MidtermExam extends Test {
    private String Exam_Location;
    private double Exam_Duration;
    public MidtermExam (){}
    public MidtermExam(int id, String Title,double max_score , String date,String location,double Exam_Duration){
        super(id,Title,max_score,date);
        Exam_Location=location;
        setDuration(Exam_Duration);
    }
    public MidtermExam(int id, String Title,double max_score , String date,String location,double Exam_Duration,String courseCode){
      this(id,Title,max_score,date,location,Exam_Duration);
        this.courseCode=courseCode;
    }
    public void setExam_Location(String exam_Location) {
        Exam_Location = exam_Location;
    }
    public String getExam_Location() {
        return Exam_Location;
    }
    public String toString()
    {
        return  getID()+","+getTitle()+","+getMax_score()+","+getDate()+","+Exam_Location+","+getDuration()+","+courseCode;
    }
}

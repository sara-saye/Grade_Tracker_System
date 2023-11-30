

public class FinalExam extends Test {
    private String Location;
    private double Exam_Time;
    public FinalExam (){}
    public FinalExam(int id, String Title,int max_score ,double mark , String date,String location,double exam_Time){
        super(id,Title,max_score,mark,date);
        this.Location=location;
        this.Exam_Time=exam_Time;
    }
    public void setExam_Time(double exam_Time) {
        Exam_Time = exam_Time;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public double getExam_Time() {
        return Exam_Time;
    }
    public String getLocation() {
        return Location;
    }
}


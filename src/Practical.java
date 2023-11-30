public class Practical extends Test {
    private String Practical_Exam_Location;
    private int Practical_Exam_Time;
    public Practical(){}
    public Practical(int id, String Title,int max_score ,double mark , String date,String practical_Exam_Location,int practical_Exam_Time){
        super(id,Title,max_score,mark,date);
        this.Practical_Exam_Location=practical_Exam_Location;
        this.Practical_Exam_Time=practical_Exam_Time;

    }

    public void setPractical_Exam_Location(String practical_Exam_Location) {
        Practical_Exam_Location = practical_Exam_Location;
    }
    public void setPractical_Exam_Time(int practical_Exam_Time) {
        Practical_Exam_Time = practical_Exam_Time;
    }
    public int getPractical_Exam_Time() {
        return Practical_Exam_Time;
    }

    public String getPractical_Exam_Location() {
        return Practical_Exam_Location;
    }
}

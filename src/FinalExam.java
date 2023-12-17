

public class FinalExam extends Test {
    private String Location;
    public FinalExam (){}
    public FinalExam(int id, String Title,double max_score , String date,String location,double exam_Time){
        super(id,Title,max_score,date);
        this.Location=location;
        setDuration(exam_Time);
    }
    public void setLocation(String location) {
        Location = location;
    }
    public String getLocation() {
        return Location;
    }
    public  String toString()
    {
        return getID()+","+getTitle()+","+getMax_score()+","+Location+","+getDuration();
    }
}


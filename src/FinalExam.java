

public class FinalExam extends Test {
    private String Location;
    private double Exam_Time;
    public FinalExam (){}
    public FinalExam(int id, String Title,int max_score , String date,String location,double exam_Time){
        super(id,Title,max_score,date);
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
<<<<<<< Updated upstream
    public  String toString()
    {
        return getID()+","+getTitle()+","+getMax_score()+","+Location+","+Exam_Time;
    }
=======
    public void setMax_score(int max_score) {
        while (true) {
            System.out.println("Enter a grade for this exam that doesn't exceed 50 marks ");
            if( max_score<= 50 ) {
                setMax_score(max_score);
                break;
            }
            else if (max_score > 50 ) {
                System.out.println("Invalid Grade Please try again ! ");
            }

        }
    }

>>>>>>> Stashed changes
}


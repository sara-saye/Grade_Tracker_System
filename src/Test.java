import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Test {
    private int ID;
    private String Title ;
    private double Max_score;
    private LocalDate Date ;
    public Test(){
        ID=0;
        Title=null;
        Max_score=0;
        Date=null;
    }
    public Test (int ID, String Title,int Max_score , String Date ){
        this.ID=ID;
        this.Title=Title;
        this.Max_score=Max_score;
        this.Date= LocalDate.parse(Date);
    }
    public void setID(int id){
        ID=id;
    }
    public void setTitle(String title){
        Title=title;
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date = LocalDate.parse(date,formatter);
    }

    public void setMax_score(double max_score) {
        Max_score = max_score;
    }

    public int getID() {
        return ID;
    }
    public String getTitle(){
        return Title;
    }

    public double getMax_score() {
        return Max_score;
    }
    public LocalDate getDate() {
        return Date;
    }

}


import java.time.LocalDate;
public abstract class Test {
    private int ID;
    private String Title ;
    private int Max_score;
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
        Date = LocalDate.parse(date);
    }

    public void setMax_score(int max_score) {
        Max_score = max_score;
    }

    public int getID() {
        return ID;
    }
    public String getTitle(String title){
        return title;
    }

    public int getMax_score() {
        return Max_score;
    }
    public LocalDate getDate() {
        return Date;
    }
}


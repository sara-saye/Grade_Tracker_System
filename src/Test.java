
public abstract class Test {

    private int ID;
    private String Title ;
    private int Max_score ;
    private double Mark;
    private String Date ;
    public Test(){
        ID=0;
        Title=null;
        Max_score=0;
        Mark=0;
        Date=null;

    }
    public Test (int ID, String Title,int Max_score ,double Mark , String Date ){
        this.ID=ID;
        this.Title=Title;
        this.Max_score=Max_score;
        this.Mark=Mark;
        this.Date=Date;

    }

    public void setID(int id){
        ID=id;
    }
    public void setTitle(String title){

        Title=title;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setMark(double mark) {
        Mark = mark;
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

    public double getMark() {
        return Mark;
    }

    public String getDate() {
        return Date;
    }
}


import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Test {
    Scanner input=new Scanner(System.in);
    public String courseCode;
    private int ID;
    private String Title ;
    private double Max_score;
    private LocalDate Date ;
    private double Duration;
    public Test(){
        ID=0;
        Title=null;
        Max_score=0;
        Date=null;
        Duration=0;
    }
    public Test (int ID, String Title,double Max_score , String Date){
        this.ID=ID;
        this.Title=Title;
        this.Max_score=Max_score;
        this.Date= LocalDate.parse(Date);
    }
    public Test (int ID, String Title,double Max_score){
        this.ID=ID;
        this.Title=Title;
        this.Max_score=Max_score;
    }
    public void setID(int id){
        ID=id;
    }
    public void setTitle(String title){
        Title=title;
    }

    public void setDate() {
        String date;
        while(true){
            System.out.println("Enter date like this format DD-MM-YYYY");
            date = input.next();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                Date = LocalDate.parse(date, formatter);
                break;
            }catch (DateTimeException dt) {
                System.out.println("Invalid Date, you entered past date");
                input.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid Date, Please enter a valid date.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in dd-mm-yyyy format.");
                input.nextLine();
            }
        }
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
    public double getDuration() {
        return Duration;
    }
    public void setDuration(double duration) {
        Duration = duration;
    }
}
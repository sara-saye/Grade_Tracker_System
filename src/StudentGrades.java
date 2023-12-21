import java.util.ArrayList;
public class StudentGrades{
    public ArrayList<Double>assignmentGrade=new ArrayList<>();
    public ArrayList<Double>quizGrade=new ArrayList<>();
    private  double midTermGrade;
    private  double finalGrade;
    private double attendanceGrade;
    public StudentGrades(){
        this.assignmentGrade.add(-1.0); //20
        this.assignmentGrade.add(-1.0);
        this.quizGrade.add(-1.0);
        this.quizGrade.add(-1.0);//10
        this.midTermGrade=-1.0;    //15
        this.finalGrade=-1.0;           //50
        this.attendanceGrade=-1.0; //5
    }
    public StudentGrades(int i){
    }

    public void setAssignmentGrade(int index,double assgrade) {
        assignmentGrade.add(index,assgrade);
    }
    public void setQuizGrade(int index, double quizgrade) {
        quizGrade .add(index,quizgrade);
    }
    public void setMidTermGrade(double midTermGrade) {
        this.midTermGrade = midTermGrade;
    }
    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
    public void setAttendanceGrade(double attendanceGrade) {
        this.attendanceGrade = attendanceGrade;
    }
    public double getAssignmentGrade() {
        double totalassignment=0;
        for(double grade:assignmentGrade){
            totalassignment+=grade;
        }
        return totalassignment;
    }
    public double getQuizGrade() {
        double totalquiz=0;
        for(double grade:quizGrade){
            totalquiz+=grade;
        }
        return totalquiz;
    }
    public double getMidTermGrade() {
        return midTermGrade;
    }
    public double getFinalGrade() {
        return finalGrade;
    }
    public double getAttendanceGrade() {
        return attendanceGrade;
    }
    public double CalcTotalGrade(){
        double totalMark=(this.getAssignmentGrade() + this.getQuizGrade() + midTermGrade + finalGrade + attendanceGrade);
        return totalMark;
    }
    public double Calcscale(){
        double scale;
        double totalMark=this.CalcTotalGrade();
        if(totalMark<=100.0 && totalMark>=93.0){
            scale=4.0;
        } else if (totalMark<93.0 && totalMark>=89.0) {
            scale=3.7;
        } else if (totalMark<89.0 && totalMark>=84.0) {
            scale=3.3;
        } else if (totalMark<84.0 && totalMark>=80.0 ) {
            scale=3.0;
        } else if (totalMark<80.0 && totalMark>=76.0 ) {
            scale=2.7;
        } else if (totalMark<76.0 && totalMark>=73.0) {
            scale=2.3;
        } else if (totalMark<73.0 && totalMark>=70.0) {
            scale=2.0;
        } else if (totalMark<70.0 && totalMark>=67.0) {
            scale=1.7;
        } else if (totalMark<67.0 && totalMark>=64.0) {
            scale=1.3;
        } else if (totalMark<64.0 && totalMark>=60.0) {
            scale=1.0;
        }else{
            scale=0.0;
        }
        return scale;
    }
    public String CalcLetterGrade(double totalMark){
        String letterGrade;
        if(totalMark>=89 && totalMark<=100) {
            letterGrade = "A";
        }
        else if(totalMark>=76 && totalMark<=88){
            letterGrade = "B";
        }
        else if(totalMark>=67 && totalMark<=75) {
            letterGrade = "C";
        }
        else if(totalMark>=60 && totalMark<=67) {
            letterGrade = "D";
        }
        else{
            letterGrade = "F";
        }
        return letterGrade;
    }

}//class
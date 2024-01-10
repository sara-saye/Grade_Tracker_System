import java.util.ArrayList;
public class StudentGrades{
    public ArrayList<Double>assignmentGrade=new ArrayList<>();
    public ArrayList<Double>quizGrade=new ArrayList<>();
    private  double midTermGrade;
    private  double finalGrade;
    private double attendanceGrade;
    public StudentGrades(){
<<<<<<< HEAD
        this.assignmentGrade.add(0.0); //20
        this.assignmentGrade.add(0.0);
        this.quizGrade.add(0.0);
        this.quizGrade.add(0.0);   //10
        this.midTermGrade=0.0;       //15
        this.finalGrade=0.0;           //50
        this.attendanceGrade=0.0; //5
=======
        this.assignmentGrade.add(-1.0); //20
        this.assignmentGrade.add(-1.0);
        this.quizGrade.add(-1.0);
        this.quizGrade.add(-1.0);//10
        this.midTermGrade=-1.0;    //15
        this.finalGrade=-1.0;           //50
        this.attendanceGrade=-1.0; //5
>>>>>>> e16bd392442ac70516e38307a663f8654b5f81a5
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
            if(grade==-1.0)
              continue;
            totalassignment+=grade;
        }
        return totalassignment;
    }
    public double getQuizGrade() {
        double totalquiz=0;
        for(double grade:quizGrade){
            if(grade==-1)
                continue;
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
        double mid=midTermGrade,fin=finalGrade,att=attendanceGrade;
        if( mid==-1.0)
            mid=0.0;
        if( fin==-1.0)
            fin=0.0;
        if( att==-1.0)
            att=0.0;
        double totalMark=(this.getAssignmentGrade() + this.getQuizGrade() + mid + fin + att);
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
<<<<<<< HEAD
//    public void DisplayReport(String studentName , int id, ArrayList<Student>students){
//        for(int i=0;i<students.get(id).getNoOfCourses();i++) {
//            double courseGrade = CalcTotalGrade();
//            double courseScale = Calcscale();
//            String courseLetterGrade = CalcLetterGrade(courseGrade);
//            System.out.println((i+1)+"- Course : " + students.get(id).Student_courses.get(i).courseTitle);
//            System.out.println("Student Name: " + studentName);
//            System.out.println("Student ID: " + id);
//            System.out.println("Midterm: " + students.get(id).Student_Grades.get(i).getMidTermGrade());
//            System.out.println("Assignment: " + students.get(id).Student_Grades.get(i).getAssignmentGrade());
//            System.out.println("Quiz: " + students.get(id).Student_Grades.get(i).getQuizGrade());
//            System.out.println("Attendance:" + students.get(id).Student_Grades.get(i).getAttendanceGrade());
//            System.out.println("Final:" + students.get(id).Student_Grades.get(i).getFinalGrade());
//            System.out.println("Total Grade: " + courseGrade);
//            System.out.println("Points: " + courseScale);
//            System.out.println("Letter Grade: " + courseLetterGrade);
//        }
//    }
=======

>>>>>>> e16bd392442ac70516e38307a663f8654b5f81a5
}//class
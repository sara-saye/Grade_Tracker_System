import java.util.ArrayList;

public class StatusOfStudent {
    double mean=0;
    double []Z_Score=new double[100];

    ArrayList<Double> ZScore = new ArrayList<Double>();
    double []standard_deviation =new double[100];

    public double CalcMean(Course course){
        double sum=0;
        for (StudentGrades grade :course.grades ) {
             sum+=grade.CalcTotalGrade();
        }
        mean=sum/course.grades.size();//lesa
        return mean;
    }
    public double [] Calc_Z_Score(){

        return Z_Score;
    }

}

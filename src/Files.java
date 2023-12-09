import java.io.*;
import java.util.StringTokenizer;

public class Files   {
    static File courseFile =new File("course.txt");
    static File instructorFile =new File("instructor.txt");
    public static void readCourse () throws IOException {
        StringTokenizer token=null;

        BufferedReader courseBR=new BufferedReader(new FileReader(courseFile));
        String courseCode="";
        String courseTitle="";
        int credits=0;
        String department="";
        String description="";
        String line="" ;
        while((line = courseBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            courseCode =token.nextToken();
            courseTitle=token.nextToken();
            credits=Integer.parseInt(token.nextToken());
            department=token.nextToken();
            description=token.nextToken();
            String sessionLine=token.nextToken();
            String [] sessionDates=sessionLine.split("-");
            Course course=new Course(courseCode,courseTitle,credits,department,description,sessionDates);
            Main.courses.add(course);
        }
        courseBR.close();

    }

    public static void readInstructor () throws IOException {
        StringTokenizer token = null;
        BufferedReader instructorBR=new BufferedReader(new FileReader(instructorFile));
        int id=0;
        String firstName="";
        String lastName="";
        String password="";
        String PhoneNumber="";
        String office_location="";
        String department=" ";
        String line="" ;
        while((line = instructorBR.readLine())!=null)
        {
            token =new StringTokenizer(line,",");
            id = Integer.parseInt(token.nextToken());
           firstName=token.nextToken();
            lastName=token.nextToken();
            department=token.nextToken();

            String sessionLine=token.nextToken();
            String [] sessionDates=sessionLine.split("-");
            Course course=new Course(courseCode,courseTitle,credits,department,description,sessionDates);
            Main.courses.add(course);
        }

    }











    public  static void writeCourse() throws IOException {
        BufferedWriter courseBW=new BufferedWriter(new FileWriter(courseFile));
        for(Course c:Main.courses)
        {
            courseBW.write(c.toString());
            courseBW.newLine();
        }
        courseBW.flush();
        courseBW.close();
    }

}

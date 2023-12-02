import java.util.ArrayList;

public class Admin extends Person{
    ArrayList<Course>courses=new ArrayList<>();
   public Admin (){}
    public Admin (String Fname,String Lname,int ID){  //>>ID should be string
        super(Fname,Lname);
        this.ID=ID;
    }
    public void addCourse(Course course)
    {
        courses.add(course);    /*el ArrayList de we will split it in array 3adya then ndefha ll ArrayList
                                  elly btt_3amel m3a el files */
    }
    public String updateCourse(String courseCode,ArrayList<String>LinesOfCourseData,String newCourseCode,String courseTitle,
                             int credits,String department,String description,String instructorId,String newInstructorId)
        /*lmma y5tar eno 3ayez y update course han5leh yda5a courseCode as a string */
    {
        String check=null;
        for(int i=0;i< LinesOfCourseData.size();i++)
        {
            String[] courseFields = LinesOfCourseData.get(i).split(","); //>>law kolo in the same file, so el index will change as first word in the line will be the type of the user
            if(courseFields[0].equals(courseCode))
            {
                courseFields[0] =newCourseCode;
                courseFields[1]= courseTitle;
                courseFields[2]= String.valueOf(credits);
                courseFields[3]= department;
                courseFields[4]= description;
                if(!courseFields[5].equals(instructorId)) {
                    courseFields[5] = newInstructorId;
                    check=courseCode;
                }

            }
            String updatedLine=String.join(",",courseFields);
            LinesOfCourseData.set(i,updatedLine);
        }
        return check;             /*if null so, we won't call removeTheCourseFromTheInstructor()
                                    if = coursecode  so, we will call in main removeTheCourseFromTheInstructor()*/
    }
    public void removeTheCourseFromTheInstructor(String courseCode,ArrayList<String>linesOfInstructorData)
    {
        for(int i=0;i< linesOfInstructorData.size();i++)
        {
            String[]instructorFields=linesOfInstructorData.get(i).split(",");
            if(instructorFields[7].equals(courseCode))         //>>change [7] with the real index
            {
                instructorFields[7]="null";
            }
            String updatedLine=String.join(",",instructorFields);
            linesOfInstructorData.set(i,updatedLine);
        }
    }
    public void updateInInstructorFileWithUpdatedCourse(ArrayList<String>linesOfInstructorData,String courseCode
            ,String newCourseCode)
    //>>we must call it after updateCourseFunction
    {
        for(int i=0;i< linesOfInstructorData.size();i++)
        {
            String[]instructorFields=linesOfInstructorData.get(i).split(",");
            if(instructorFields[7].equals(courseCode))         //>>change [7] with the real index
            {
                instructorFields[7]=newCourseCode;
            }
            String updatedLine=String.join(",",instructorFields);
            linesOfInstructorData.set(i,updatedLine);
        }
    }
    public int findIndexofTheCourseWeWillDelete(String courseCode,ArrayList<String>LinesOfCourseData)
    /*variable in main = that function, then call deleteCourse() with that variable as a parameter,
    then call removeTheCourseFromTheInstructor*/
    {
        int index=0;
        for(int i=0;i< LinesOfCourseData.size();i++)
        {
            String[]instructorFields=LinesOfCourseData.get(i).split(",");
            if(instructorFields[0].equals(courseCode))         //>>check is[0] the right index or not
            {
                 index=i;
                 break;
            }
        }
        return index;
    }
    public void deleteCourse(int indexOfCourseWeWillDelete ,ArrayList<String>LinesOfCourseData)
    {
           LinesOfCourseData.remove(indexOfCourseWeWillDelete);

    }
    public void assignInstructorsToCourses()
    {

    }
    public void addEvent()
    {

    }
}

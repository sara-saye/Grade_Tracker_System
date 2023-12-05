import java.util.ArrayList;
public class Admin extends Person{
    String eventDetails;
    ArrayList<Course>courses=new ArrayList<>();
    ArrayList<Instructor>instructors=new ArrayList<>();
    public Admin (){}
    public Admin (String Fname,String Lname,int ID){  //>>ID should be string
        super(Fname,Lname);

        this.ID=ID;
       // this.setID(ID);
        this.setID(ID);
    }
    public void addCourse(Course course)
    {
        courses.add(course);    /*el ArrayList de we will split it in array 3adya then ndefha ll ArrayList
                                  elly btt_3amel m3a el files */
    }
    public void addInstructor(Instructor instructor)
    {
        instructors.add(instructor);    /*el ArrayList de we will split it in array 3adya then ndefha ll ArrayList
                                  elly btt_3amel m3a el files */
    }

    public String updateCourse(String courseCode,ArrayList<String>LinesOfCourseData,String newCourseCode,String courseTitle,
                             int credits,String department,String description,String instructorId,String newInstructorId)
        /*lmma y 5 tar eno 3ayez y update course han5leh yda5al courseCode as a string */
            //>>then call updateInInstructorFileWithUpdatedCourse()
    {
        String check=null;
        for(int i=0;i< LinesOfCourseData.size();i++)
        {
            String[] courseFields = LinesOfCourseData.get(i).split(","); //>>lw kolo in the same file, so el index will change as first word in the line will be the type of the user
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
    //>>we must call it after updateCourse()
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
    //In Main, call findIndexofTheCourseWeWillDelete() first.then, call this
    {
           LinesOfCourseData.remove(indexOfCourseWeWillDelete);

    }
    public int findIndexofTheInstructorWeWillDelete(String instructorId,ArrayList<String>LinesOfinstructorData)
            //when we want to delete instructor, we musst call this then call deleteInstructor()
    {
        int index=0;
        for(int i=0;i< LinesOfinstructorData.size();i++)
        {
            String[]instructorFields=LinesOfinstructorData.get(i).split(",");
            if(instructorFields[2].equals(instructorId))         //>>check is[2] the right index or not
            {
                index=i;
                break;
            }
        }
        return index;
    }
    public  void  deleteInstructor(int indexOfInstructorWeWillDelete ,ArrayList<String>LinesOfInstructorData)
    //In Main, call findIndexofTheInstructorWeWillDelete() first.then, call this.then,
    {
        LinesOfInstructorData.remove(indexOfInstructorWeWillDelete);
    }
    public void removeTheInstructorFromTheCourse(String instructorId,ArrayList<String>linesOfCourseData)
    {
        for(int i=0;i< linesOfCourseData.size();i++)
        {
            String[]courseFields=linesOfCourseData.get(i).split(",");
            if(courseFields[5].equals(instructorId))         //>>change [5] with the right index
            {
                courseFields[5]="null";                     //replace courseCode with null
            }
            String updatedLine=String.join(",",courseFields);
            linesOfCourseData.set(i,updatedLine);
        }
    }
    public void assignInstructorToCourse(String courseCode,String instructorId,ArrayList<String>linesOfCourseData,
                                         ArrayList<String>linesOfInstructorData)
    {
        boolean courseFlag=false;
        boolean instructorFlag=false;
        String courseName=null;
        String instructorName=null;
           for( int i=0 ; i<linesOfCourseData.size() ;i++ ) {
               String[] courseFields = linesOfCourseData.get(i).split(",");
               if (courseFields[0].equals(courseCode)) {
                   if (courseFields[5].equals("null")) {
                       courseFlag = true;
                       break;
                   } else {
                       courseName = courseFields[1];       //>>check whether the [0]is right or not
                       break;
                   }
               }

           }
               for( int i=0 ; i<linesOfInstructorData.size() ;i++ ) {
                   String[] instructorFields = linesOfInstructorData.get(i).split(",");
                   if (instructorFields[0].equals(courseCode)) {
                       if (instructorFields[7].equals("null")) {
                           instructorFlag = true;
                           break;
                       } else {
                           instructorName = instructorFields[0]; //>>check whether the [0]is right or not
                           break;
                       }
                   }

               }
                   if (instructorFlag == true && courseFlag == true)
                   {

                         for(int i=0;i<linesOfCourseData.size();i++)
                         {
                             String [] courseFields=linesOfCourseData.get(i).split(",");
                             if(courseFields[0].equals(courseCode))
                             {
                                 courseFields[5]=instructorId;
                                 String updatedLine=String.join(",",courseFields);
                                 linesOfCourseData.set(i,updatedLine);
                                 break;
                             }
                         }
                         for(int i=0;i<linesOfInstructorData.size();i++)
                         {
                             String []instructorFields=linesOfInstructorData.get(i).split(",");
                             if(instructorFields[2].equals(instructorId))  //>>check whether the [0]is right or not
                             {
                                 instructorFields[7]=courseCode;     //>>check whether the [0]is right or not
                                 String updatedLine=String.join(",",instructorFields);
                                 linesOfInstructorData.set(i,updatedLine);
                                 break;
                             }
                         }
                       System.out.println("Done Successfully");
                   }
                   else {
                       if (instructorFlag == false && courseFlag == true) {
                           System.out.println("Dr."+instructorName+" is already has a course");
                       }
                       else if(courseFlag == true && instructorFlag == false)
                       {
                           System.out.println(courseName+" is already has an instructor");
                       }
                       else if(courseFlag == true && instructorFlag == true)
                       {
                           System.out.print("Dr."+instructorName+" is already has a course and ");
                           System.out.println(courseName+" is already has an instructor");
                       }

                   }
    }
    public void addEvent()
    {

    }
}

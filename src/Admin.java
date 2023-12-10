
public class Admin extends Person {

    public static void addCourse(String courseCode, String courseTitle, int credits, String department, String description,
                                 String []sessionDates)  //>>pass these parameters from main
    {
        Course course = new Course(courseCode, courseTitle, credits, department, description,sessionDates);
        Main.courses.add(course);
    }
    public void updateCourse(String courseCode, String newCourseCode, String newCourseTitle, int newCredits,
                             String newDepartment, String newDescription,String []newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.set(courseIndex, course);
            }
        }
        updateUpdatedCourseInInstructor(courseCode, newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
    }

    public void updateUpdatedCourseInInstructor(String courseCode, String newCourseCode, String newCourseTitle, int newCredits,
                                                String newDepartment, String newDescription,String []newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).course.getCourseCode().equals(courseCode)) {
                Main.instructors.get(instrcutorIndex).course = course;
            }
        }
    }

    public void deleteCourse(String courseCode)   //>>once we call that, we must call deleteCourseFromInstructor()
    {
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.remove(courseIndex);
            }
        }
    }

    public void deleteCourseFromInstructor(String courseCode) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).course.getCourseCode().equals(courseCode)) {
                Main.instructors.get(instrcutorIndex).course = null;
            }
        }
    }

    //once admin choose to assign instructor to course, we just call  isInstructorFree()
    public void isInstructorFree(int instructorID, String courseCode) {
        boolean freeOrNot = false;
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                if (Main.instructors.get(instrcutorIndex).course.getCourseCode() == null) {
                    assignCoursesToInstructors(courseCode, instructorID);
                    assignInstructorsToCourses(courseCode, instructorID);
                    System.out.println("Done Successfully.");
                } else {
                    System.out.println("Dr." + Main.instructors.get(instrcutorIndex).getLname() + "already has a course.");
                }
            }
        }
    }

    public void assignCoursesToInstructors(String courseCode, int instructorID) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                    if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                        Main.instructors.get(instrcutorIndex).course = Main.courses.get(courseIndex);
                    }
                }
            }
        }
    }

    public void assignInstructorsToCourses(String courseCode, int instructorID) {
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                    if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                        Main.courses.get(courseIndex).assignedInstructor = Main.instructors.get(instrcutorIndex);
                    }
                }

            }
        }

    }
    public  void deleteInstructor(int instructorId)
    {
        deleteDeletedInstructorFromTheCourse(instructorId);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if(Main.instructors.get(instrcutorIndex).getID()==instructorId)
            {
                Main.instructors.remove(instrcutorIndex);
            }
        }

    }
    public void deleteDeletedInstructorFromTheCourse(int instructorId)
    {
        for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++ )
        {
            if(Main.courses.get(courseIndex).assignedInstructor.getID()==instructorId)
            {
                Main.courses.get(courseIndex).assignedInstructor=null;
            }
        }
    }
    public void dropStudent()
    {
        Course course=new Course();
        for(int studentIndex=0;studentIndex<Main.studentsArray.size();studentIndex++)
        {
           /* if(Main.studentsArray.get(studentIndex).gpaDrop == true ||            //>>student put gpaDrop and attendanceDrop as boolean attributes that notification toggle it to true
           Main.studentsArray.get(studentIndex).attendanceDrop == true)
            {
                for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++)
                {
                    for(int enrolledStudentsIndex=0;enrolledStudentsIndex<course.enrolledStudents.size();enrolledStudentsIndex++) {
                        if (Main.courses.get(courseIndex).enrolledStudents.get(enrolledStudentsIndex).getID()==Main.studentsArray.get(studentIndex).getID()){
                            Main.courses.get(courseIndex).enrolledStudents.remove(enrolledStudentsIndex);
                        }
                    }
                }
                Main.studentsArray.remove(studentIndex);
            }*/
        }
    }

}
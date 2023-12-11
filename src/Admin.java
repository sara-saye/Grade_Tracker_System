import java.util.Scanner;

public class Admin extends Person {
static Scanner input=new Scanner(System.in);
    public static void login()
    {
        System.out.println(" 1-Add Course");
        System.out.println(" 2-Update Course");
        System.out.println(" 3-Delete Course");
        System.out.println(" 4-assign instructor to course");
        System.out.println(" 5-Drop Instructor");
        System.out.println(" 6-Drop Student");
        int choice=0;
        choice=input.nextInt();
        switch (choice)
        {
            case 1:
                String courseCodeAdd;
                String courseTitleAdd;
                int creditsAdd;
                String departmentAdd;
                String descriptionAdd;
                String []sessionDatesAdd=new String[2];
                System.out.println("Course Code: ");
                courseCodeAdd=input.next();
                System.out.println("Course Title: ");
                courseTitleAdd=input.next();
                System.out.println("Credits: ");
                creditsAdd=input.nextInt();
                System.out.println("Department: ");
                departmentAdd=input.next();
                System.out.println("Description: ");
                descriptionAdd=input.next();
                for(int i=0;i<2;i++)
                {
                    System.out.println("Session "+ i+1 +" date: ");
                    sessionDatesAdd[i]=input.next();
                }
                addCourse(courseCodeAdd,courseTitleAdd,creditsAdd,departmentAdd,descriptionAdd,sessionDatesAdd);
                break;
            case 2:
                String courseCodeUpdate;
                String newCourseCodeUpdate;
                String newCourseTitleUpdate;
                int newCreditsUpdate;
                String newDepartmentUpdate;
                String newDescriptionUpdate;
                String []newSessionDatesUpdate=new String[2];
                System.out.println("Input code of the course you want to update: ");
                courseCodeUpdate=input.next();
                System.out.println("Course Code: ");
                newCourseCodeUpdate=input.next();
                System.out.println("Course Title: ");
                newCourseTitleUpdate=input.next();
                System.out.println("Credits: ");
                 newCreditsUpdate=input.nextInt();
                System.out.println("Department: ");
                newDepartmentUpdate=input.next();
                System.out.println("Description: ");
                newDescriptionUpdate=input.next();
                for(int i=0;i<2;i++)
                {
                    System.out.println("Session "+ i+1 +" date: ");
                    newSessionDatesUpdate[i]=input.next();
                }
                updateCourse(courseCodeUpdate,newCourseCodeUpdate,newCourseTitleUpdate,newCreditsUpdate,newDepartmentUpdate,
                        newDescriptionUpdate,newSessionDatesUpdate);
                break;
            case 3:
                System.out.println("Code of the course you want to delete: ");
                String courseCodeDelete;
                courseCodeDelete=input.next();
                deleteCourse(courseCodeDelete);
                break;
            case 4:
                int instructorIdAssign;
                String courseCodeAssign;
                System.out.println("Instructor ID: ");
                instructorIdAssign= input.nextInt();
                System.out.println("Course Code: ");
                courseCodeAssign=input.next();
                isInstructorFreeAndTheCourseEmpty(instructorIdAssign,courseCodeAssign);
                break;
            case 5:
                 int instructorIdDrop;
                 instructorIdDrop=input.nextInt();
                 dropInstructor(instructorIdDrop);
                 break;
            case 6:
                dropStudent();
                break;
            default:
                System.out.println("Invalid Input!");
                System.out.println("Do You want to try again? ");
                System.out.println("1-yes");
                System.out.println("2-No");
                int choice2=input.nextInt();
                if(choice2==1) {                                          // what else?????
                    login();
                }
        }

    }
    public static void addCourse(String courseCode, String courseTitle, int credits, String department, String description,
                                 String []sessionDates)  //>>pass these parameters from main
    {
        Course course = new Course(courseCode, courseTitle, credits, department, description,sessionDates);
        Main.courses.add(course);
    }

    public static void updateCourse(String courseCode, String newCourseCode, String newCourseTitle, int newCredits,
                             String newDepartment, String newDescription,String []newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.set(courseIndex, course);
            }
        }
        updateUpdatedCourseInInstructor(courseCode, newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
    }

    public static void updateUpdatedCourseInInstructor(String courseCode, String newCourseCode, String newCourseTitle, int newCredits,
                                                String newDepartment, String newDescription,String []newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription,newSessionDtes);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).course.getCourseCode().equals(courseCode)) {
                Main.instructors.get(instrcutorIndex).course = course;
            }
        }
    }

    public static void deleteCourse(String courseCode)
    {
        deleteCourseFromInstructor(courseCode);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.remove(courseIndex);
            }
        }
    }

    public static void deleteCourseFromInstructor(String courseCode) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).course.getCourseCode().equals(courseCode)) {
                Main.instructors.get(instrcutorIndex).course = null;
            }
        }
    }



    //once admin choose to assign instructor to course, we just call  isInstructorFree()
    public static void isInstructorFreeAndTheCourseEmpty(int instructorID, String courseCode) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                if (Main.instructors.get(instrcutorIndex).course.getCourseCode() == null) {
                    for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++){
                        if(Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                            if(Main.courses.get(courseIndex).assignedInstructor==null) {
                                assignCoursesToInstructors(courseCode, instructorID);
                                assignInstructorsToCourses(courseCode, instructorID);
                                System.out.println("Done Successfully.");
                            }
                            else {
                                System.out.println(Main.courses.get(courseIndex).courseTitle+" Course already has an instructor!");
                            }
                        }
                    }
                }
                else {
                    System.out.println("Dr." + Main.instructors.get(instrcutorIndex).getLname() + "already has a course!");
                }
            }
        }
    }

    public static void assignCoursesToInstructors(String courseCode, int instructorID) {
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

    public static void assignInstructorsToCourses(String courseCode, int instructorID) {
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
    public  static void dropInstructor(int instructorId)
    {
        deleteDeletedInstructorFromTheCourse(instructorId);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if(Main.instructors.get(instrcutorIndex).getID()==instructorId)
            {
                Main.instructors.remove(instrcutorIndex);
            }
        }

    }
    public static void deleteDeletedInstructorFromTheCourse(int instructorId)
    {
        for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++ )
        {
            if(Main.courses.get(courseIndex).assignedInstructor.getID()==instructorId)
            {
                Main.courses.get(courseIndex).assignedInstructor=null;
            }
        }
    }
    public static void dropStudent()
    {
        Course course=new Course();
        for(int studentIndex=0;studentIndex<Main.studentsArray.size();studentIndex++)
        {
            if(Main.studentsArray.get(studentIndex).isGpaDrop() ||            //>>student put gpaDrop and attendanceDrop as boolean attributes that notification toggle it to true
                    Main.studentsArray.get(studentIndex).isAttendanceDrop())
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
            }
            else {
                System.out.println(" No students to drop ");
            }
        }
    }

}
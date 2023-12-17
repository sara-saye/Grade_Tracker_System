import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person{
    static Scanner input = new Scanner(System.in);
    public static String eventDetails=null;
    String eventName;
    String eventDate;
    String eventLocation;
    public Admin(String eventName,String eventDate,String eventLocation)
    {
        this.eventName=eventName;
        this.eventDate=eventDate;
        this.eventLocation=eventLocation;
        eventDetails=eventName+"  "+eventDate+"  "+eventLocation;
    }
    public static void login() throws IOException {
        System.out.println(" 1-Add Course");
        System.out.println(" 2-Update Course");
        System.out.println(" 3-Delete Course");
        System.out.println(" 4-assign instructor to course");
        System.out.println(" 5-Drop Instructor");
        System.out.println(" 6-Drop Student");
        System.out.println(" 7-Add Event");
        System.out.println(" 8-Delete Event");
        System.out.println(" 9-Logout");
        System.out.println(" 10-Exit");
        int choice = 0;
        choice = input.nextInt();
        switch (choice) {
            case 1:
                String courseCodeAdd;
                String courseTitleAdd;
                int creditsAdd;
                String departmentAdd;
                String descriptionAdd;
                String[] sessionDatesAdd = new String[2];
                System.out.println("Course Code: ");
                courseCodeAdd = input.next();
                System.out.println("Course Title: ");
                courseTitleAdd = input.next();
                System.out.println("Credits: ");
                creditsAdd = input.nextInt();
                System.out.println("Department: ");
                departmentAdd = input.next();
                System.out.println("Description: ");
                descriptionAdd = input.next();
                System.out.println("Session 1 date: ");
                sessionDatesAdd[0] = input.next();
                System.out.println("Session 2 date: ");
                sessionDatesAdd[1] = input.next();
                addCourse(courseCodeAdd, courseTitleAdd, creditsAdd, departmentAdd, descriptionAdd, sessionDatesAdd);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice1=input.nextInt();
                if(moreOperationsChoice1==1)
                {
                            login();
                }
                break;
            case 2:
                String courseCodeUpdate;
                String newCourseCodeUpdate;
                String newCourseTitleUpdate;
                int newCreditsUpdate;
                String newDepartmentUpdate;
                String newDescriptionUpdate;
                String[] newSessionDatesUpdate = new String[2];
                System.out.println("Input code of the course you want to update: ");
                courseCodeUpdate = input.next();
                System.out.println("New Course Code: ");
                newCourseCodeUpdate = input.next();
                System.out.println("Course Title: ");
                newCourseTitleUpdate = input.next();
                System.out.println("Credits: ");
                newCreditsUpdate = input.nextInt();
                System.out.println("Department: ");
                newDepartmentUpdate = input.next();
                System.out.println("Description: ");
                newDescriptionUpdate = input.next();
                System.out.println("Session 1 date: ");
                newSessionDatesUpdate[0] = input.next();
                System.out.println("Session 2 date: ");
                newSessionDatesUpdate[1] = input.next();

                updateCourse(courseCodeUpdate, newCourseCodeUpdate, newCourseTitleUpdate, newCreditsUpdate,
                        newDepartmentUpdate, newDescriptionUpdate, newSessionDatesUpdate);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice2=input.nextInt();
                if(moreOperationsChoice2==1)
                {
                    login();
                }
                break;
            case 3:
                System.out.println("Code of the course you want to delete: ");
                String courseCodeDelete;
                courseCodeDelete = input.next();
                deleteCourse(courseCodeDelete);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice3=input.nextInt();
                if(moreOperationsChoice3==1)
                {
                    login();
                }
                break;
            case 4:
                int instructorIdAssign;
                String courseCodeAssign;
                System.out.println("Instructor ID: ");
                instructorIdAssign = input.nextInt();
                System.out.println("Course Code: ");
                courseCodeAssign = input.next();
                isInstructorFreeAndTheCourseEmpty(instructorIdAssign, courseCodeAssign);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice4=input.nextInt();
                if(moreOperationsChoice4==1)
                {
                    login();
                }
                break;
            case 5:
                int instructorIdDrop;
                System.out.println("ID of instructor yow want to drop: ");
                instructorIdDrop = input.nextInt();
                dropInstructor(instructorIdDrop);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice5=input.nextInt();
                if(moreOperationsChoice5==1)
                {
                    login();
                }
                break;
            case 6:
                dropStudent();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice6=input.nextInt();
                if(moreOperationsChoice6==1)
                {
                    login();
                }
                break;
            case 7:
                String eventName;
                String eventDate;
                String eventLocation;
                System.out.println("Event Name: ");
                eventName=input.next();
                System.out.println("Event Date: ");
                eventDate=input.next();
                System.out.println("Event Location: ");
                eventLocation=input.next();
                addEvent(eventName,eventDate,eventLocation);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice7=input.nextInt();
                if(moreOperationsChoice7==1)
                {
                    login();
                }
                break;
            case 8:
                deleteEvent();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice8=input.nextInt();
                if(moreOperationsChoice8==1)
                {
                    login();
                }
                break;
            case 9:
                Main.main(null);
            case 10:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    public static void addCourse(String courseCode, String courseTitle, int credits, String department,
                                 String description, String[] sessionDates)  //>>pass these parameters from main
    {
        Course course = new Course(courseCode, courseTitle, credits, department, description, sessionDates);
        Main.courses.add(course);
    }

    public static void updateCourse(String courseCode, String newCourseCode, String newCourseTitle,
                                    int newCredits, String newDepartment, String newDescription, String[] newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDtes);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.set(courseIndex, course);
            }
        }
        updateUpdatedCourseInInstructor(courseCode, newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDtes);
    }

    public static void updateUpdatedCourseInInstructor(String courseCode, String newCourseCode, String newCourseTitle,
                                                       int newCredits, String newDepartment, String newDescription,
                                                       String[] newSessionDates) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDates);
        try{
            for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                if ( (!Main.instructors.get(instrcutorIndex).course.isEmpty()) &&(Main.instructors.get(instrcutorIndex).course.get(0).getCourseCode().equals(courseCode))) {
                    Main.instructors.get(instrcutorIndex).course.set(0, course);
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("Take Care, NullPointerException!!");
        }
    }

    public static void deleteCourse(String courseCode) {
        deleteCourseFromInstructor(courseCode);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.remove(courseIndex);
            }
        }
    }

    public static void deleteCourseFromInstructor(String courseCode) {
        try {
            for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                if ( (!Main.instructors.get(instrcutorIndex).course.isEmpty()) &&(Main.instructors.get(instrcutorIndex).course.get(0).getCourseCode().equals(courseCode))) {
                    Main.instructors.get(instrcutorIndex).course.remove(0);
                }
            }
        }
        catch (NullPointerException ex)
        {
            System.out.println("Take Care, Null Pointer Exception!!");
        }
    }


    //once admin choose to assign instructor to course, we just call  isInstructorFree()
    public static void isInstructorFreeAndTheCourseEmpty(int instructorID, String courseCode) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                if (!(Main.instructors.get(instrcutorIndex).course.isEmpty())) {

                    System.out.println("Dr." + Main.instructors.get(instrcutorIndex).getFname() + " " +
                            Main.instructors.get(instrcutorIndex).getLname() +
                            " already has a course! ");
                }
                else {
                    for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                        if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                            if (!(Main.courses.get(courseIndex).assignedInstructor.isEmpty())) {
                                System.out.println(Main.courses.get(courseIndex).courseTitle +
                                        " Course already has an instructor!");

                            } else {
                                assignCoursesToInstructors(courseCode, instructorID);
                                assignInstructorsToCourses(courseCode, instructorID);
                                System.out.println("Done Successfully.");
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    public static void assignCoursesToInstructors(String courseCode, int instructorID) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                    if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                        Main.instructors.get(instrcutorIndex).course.add(Main.courses.get(courseIndex));
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
                        Main.courses.get(courseIndex).assignedInstructor.add(Main.instructors.get(instrcutorIndex));
                    }
                }

            }
        }

    }

    public static void dropInstructor(int instructorId) {
        deleteDeletedInstructorFromTheCourse(instructorId);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorId) {
                Main.instructors.remove(instrcutorIndex);
            }
        }

    }

    public static void deleteDeletedInstructorFromTheCourse(int instructorId) {
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            try{
                if ((!Main.courses.get(courseIndex).assignedInstructor.isEmpty())&&(Main.courses.get(courseIndex).assignedInstructor.get(0).getID() == instructorId)) {
                    Main.courses.get(courseIndex).assignedInstructor.remove(0);
                }
            }
            catch (IndexOutOfBoundsException IdxOOFB)
            {
                System.out.println("Take Care, IndexOutOfBoundsException");
            }
        }
    }

    public static void dropStudent() {
        int flag = 0;
        ArrayList<Integer> studentsId = new ArrayList<>();
        ArrayList<Integer> enrolledStudentsIdArray = new ArrayList<>();
        for (int studentIndex1 = 0; studentIndex1 < Main.students.size(); studentIndex1++) {
            if (((Main.students.get(studentIndex1).isGpaDrop())) || ((Main.students.get(studentIndex1).isAttendanceDrop()))) {

                for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                    for (int enrolledStudentsIndex = 0; enrolledStudentsIndex < Main.courses.get(courseIndex).enrolledStudents.size();
                         enrolledStudentsIndex++) {
                        if (Main.courses.get(courseIndex).enrolledStudents.get(enrolledStudentsIndex).getID() ==
                                Main.students.get(studentIndex1).getID()) {
                            enrolledStudentsIdArray.add(Main.students.get(studentIndex1).getID());
                        }
                    }


                    studentsId.add(Main.students.get(studentIndex1).getID());

                }
            }
        }
        for (int studentsIdIndex = 0; studentsIdIndex < studentsId.size(); studentsIdIndex++) {
            for (int studentIndex2 = 0; studentIndex2 < Main.students.size(); studentIndex2++) {
                if (studentsId.get(studentsIdIndex) == Main.students.get(studentIndex2).getID()) {
                    Main.students.remove(studentIndex2);
                    flag = 1;
                    break;
                }
            }
        }
        for (int enrolledStudentsIDIndex=0;enrolledStudentsIDIndex<enrolledStudentsIdArray.size();enrolledStudentsIDIndex++)
        {
            for(int courseIndex=0;courseIndex<Main.courses.size();courseIndex++)
            {
                for(int courseEnrolledStudentsIndex=0;courseEnrolledStudentsIndex<
                        Main.courses.get(courseIndex).enrolledStudents.size();courseEnrolledStudentsIndex++)
                {
                    if(enrolledStudentsIdArray.get(enrolledStudentsIDIndex)==Main.courses.get(courseIndex).
                            enrolledStudents.get(courseEnrolledStudentsIndex).getID())
                    {
                        Main.courses.get(courseIndex).enrolledStudents.remove(courseEnrolledStudentsIndex);
                        break;
                    }
                }
            }

        }
        if (flag == 0) {
            System.out.println("No Students to drop");
        }

    }
    public static void addEvent(String eventName,String eventDate,String eventLocation)  //from main when admin choose to add event
    {
        eventDetails=eventName+"  "+eventDate+"  "+eventLocation;
        Admin event=new Admin(eventName,eventDate,eventLocation);
        Main.eventDetails.add(event);
    }
    public static void deleteEvent()
    {
        Main.eventDetails.remove(0);
    }
    public String toString()
    {
        return eventName+","+eventDate+","+eventLocation;
    }

}




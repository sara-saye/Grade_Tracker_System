<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;

    public static int instructor_ID = 202212000;
    Course course = new Course();

//    Student students[] = new Student[10];
    public Instructor(String F, String L, String OFFL, String dep, int ns) {
        super(F, L);
        this.office_location = OFFL;
        this.department = dep;

        //  this.ID = instructor_ID;
    }
    public Instructor(int ID,String Fname,String Lname,String email,String password,String PhoneNumber
            ,String office_location,String department)
    {
        super(ID,Fname,Lname,email,password,PhoneNumber);
        this.office_location=office_location;
        this.department=department;
    }

<<<<<<< HEAD
    //public static int instructor_ID = 0;
   // public  Course course = new Course();
    public ArrayList <Student> students = (ArrayList<Student>) Main.students.stream()
=======
=======

 import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.stream.Collectors;
public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;
>>>>>>> Stashed changes
    public static int instructor_ID = 0;
    public  Course course = new Course();
    public ArrayList <Student> students = (ArrayList<Student>) Main.studentsArray.stream()
>>>>>>> b9502fbb8fd58385fcf464faeede8ac598722155
            .filter(Student -> Student.Student_courses.equals(course))
            .collect(Collectors.toList());
<<<<<<< Updated upstream
    public  Instructor( ){
        super();
        this.office_location = "Unknown";
        this.department = "Unknown";

=======
    public Instructor(){
        super();
        this.office_location = "Unknown";
        this.department = "Unknown";
        this.setID(instructor_ID);
        instructor_ID++;
    }
    public Instructor(String Fname, String Lname, String office_location, String department){
        super(Fname,Lname);
        this.office_location = office_location;
        this.department = department;
>>>>>>> Stashed changes
        this.setID(instructor_ID);
        instructor_ID++;
    }
    public Instructor(String Fname, String Lname, String office_location, String department){
        super(Fname,Lname);
        this.office_location = office_location;
        this.department = department;
        this.setID(instructor_ID);
        instructor_ID++;
    }
    public void forSignUp(){
        System.out.println("Your first name & last name: ");
        this.setFname(input.next());
        this.setLname(input.next());
        this.setID(instructor_ID);
        instructor_ID++;
        System.out.println("Your office Location: ");
        this.office_location = input.next();
        System.out.println("Your Department: ");
        this.department = input.next();
        System.out.println("Data entered successfully!");
    }
    public void forSignIn(){
        int choice = 0;
        do {
            System.out.println("1-Show your information\n2-Edit your information");
            System.out.println("3-View students\n4-Assign Assessment");
            System.out.println("5-Take attendance\n6-Input students Grades");
            System.out.println("7-Make report for attendance specific student");
            System.out.println("8-Make report for attendance all students");
            System.out.println("9-Generate Report for attendance by sections\n10-Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    this.display();
                    break;
                case 2:
                    this.editInfo();
                    this.display();
                    break;
                case 3:
                    this.viewEnrolledStudents();
                    break;
                case 4:
                    this.setAssessmentsToCourse();
                    break;
                case 5:
                    this.trackAttendance();
                    break;
                case 6:
                    this.inputGrades();
                    break;
                case 7:
                    System.out.println("Enter student ID");
                    int studentID = input.nextInt();
                    this.generateAttRepForIndStud(studentID);
                    break;
                case 8:
                    this.generateAttrepforallstud();
                    break;
                case 9:
                    this.reportForSectionsAttendance();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choice != 10);
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
<<<<<<< Updated upstream
        System.out.println("Responsible for course: " + this.course.courseTitle);
=======
        System.out.println("Email: " + this.getEmail());
>>>>>>> Stashed changes
    }
    public String getOffice_location() {
        return office_location;
    }
    public void setOffice_location(String office_location) {
        this.office_location = office_location;
    }
    public String getDepartment() {
        return department;
    }
<<<<<<< Updated upstream
    public void setDepartment(String department) {
        this.department = department; }
    public void editInfo(){
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\nPassword");
=======
    public void setDepartment(String department) { this.department = department; }

    public void editInfo(){
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\n3-Username or Password");
>>>>>>> Stashed changes
        System.out.println("4-Office location\n5-Department");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter new first and last name");
                this.setFname(input.next());
                this.setLname(input.next());
                break;
            case 2:
                System.out.println("Enter new Email");
                String s = input.next();
                this.setEmail(s);
                break;
            case 3:
                System.out.println("Enter your ID current password");
                int IID =input.nextInt();
                String IPassword = input.next();
                if(this.getID() == IID && this.getPassword().equals(IPassword)){
                    System.out.println("Enter new username and password");
                    IPassword = input.next();
                    this.setPassword(IPassword);
                }
                break;
            case 4:
                System.out.println("Enter new office location");
                this.office_location = input.next();
                break;
            case 5:
                System.out.println("Enter new department");
                this.department = input.next();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public void trackAttendance(){
        for (Student student:students) {
            int courseIndex = findindexs(student);
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            for(int i = 0; i < 10; i++) {
                System.out.println("section number #" + (i + 1));
                System.out.println("Did this student attend?(y/n)");
                char ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    student.attendance[courseIndex][i] = true;
                } else {
                    student.attendance[courseIndex][i] = false;
                    System.out.println("Are there any exception?");
                    ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        student.attendance[courseIndex][i] = true;
                    }
        System.out.println("Enter section number");
        int section_number = input.nextInt();
        for (Student student:students) {
            int i = 0;
            for (Course course : student.Student_courses) {
                if(course.equals(this.course)) {
                    break;
                }
                i++;
            }
            int cid = i;
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            System.out.println("Did this student attend?(y/n)");
            char ch = input.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                student.attendance[cid][section_number] = true;
            } else {
                student.attendance[cid][section_number] = false;
                System.out.println("Are there any exception?");
                ch = input.next().charAt(0);
                if (ch == 'Y' || ch == 'y') {
                    student.attendance[cid][section_number] = true;
                }
            }
            trackingStudentsAttendanceGrades(student);

        }
    }
    public void setAssessmentsToCourse(){
        System.out.println("Adding assessment to " + course.courseTitle);
        checkIfExist();
        System.out.println("What do you want to add");
        System.out.println("Enter course ID");
        int cid = input.nextInt();
        System.out.println("Adding assessment to " + course.courseTitle);
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Practical");
        int choice =input.nextInt();
        switch (choice){
            case 1:
                //add Assignment
                Assignment assignment=new Assignment();
                System.out.println("How many assignments?1 0r 2 " );
                System.out.println("If 1 assignment mark will be 20");
                System.out.println("If 2 the sum of two assignments will be 20");
                int numOfAssignment = input.nextInt();
                if(numOfAssignment == 1) {
                    System.out.println("Assignment number: ");
                    assignment.setID(input.nextInt());
                    System.out.print("Title: ");
                    assignment.setTitle(input.next());
                    assignment.setMax_score(20);
                    setDeadlineassignment(0);
                    course.addAssignedAssignment(assignment);
                }else if (numOfAssignment == 2) {
                    for(int i = 0; i < 2; i++){
                        System.out.println("Assignment number: ");
                        assignment.setID(input.nextInt() - 1);
                        System.out.print("Title: ");
                        assignment.setTitle(input.next());
                        if(i == 1){
                            int assignment1grade = course.assignedAssignment.get(0).getMax_score();
                            course.assignedAssignment.get(1).setMax_score(20 - assignment1grade);
                        }
                        else{
                            System.out.print("Mark: ");
                            assignment.setMax_score(input.nextInt());
                        }
                        setDeadlineassignment(i);
                        course.addAssignedAssignment(assignment);
                    }
                }
                else
                    System.out.println("Invalid input");
                System.out.println("Assignment number: ");
                assignment.setID(input.nextInt());
                System.out.print("Title: ");
                assignment.setTitle(input.next());
                System.out.print("Mark: ");
                assignment.setMax_score(input.nextInt());
                System.out.print("Deadline: ");
                assignment.set_Assignment_deadline(input.next());
                course.addAssignedAssignment(assignment);
                break;
            case 2:
                //add Quiz
                Quiz quiz =new Quiz();
                System.out.println( "How many quizzes ? 1 0r 2 " );
                System.out.println("If 1 quiz mark will be 10");
                System.out.println("If 2 the sum of quizzes will be 10");
                int numOfQuiz = input.nextInt();
                if(numOfQuiz == 1){
                System.out.println("Quiz number: ");
                quiz.setID(input.nextInt());
                System.out.print("Title: ");
                quiz.setTitle(input.next());
                System.out.print("Date: ");
                quiz.setDate(input.next());
                quiz.setMax_score(10);
                System.out.print("Duration: ");
                quiz.setQuiz_Duration(input.nextInt());
                course.addAssignedQuiz(quiz);
<<<<<<< Updated upstream
                } else if (numOfQuiz == 2) {
                    for(int i = 0; i < 2; i++){
                        System.out.println("Quiz number: ");
                        quiz.setID(input.nextInt() - 1);
                        System.out.print("Title: ");
                        quiz.setTitle(input.next());
                        System.out.print("Date: ");
                        quiz.setDate(input.next());
                        if(i == 1){
                            int assignment1grade = course.assignedQuiz.get(0).getMax_score();
                            course.assignedQuiz.get(1).setMax_score(10 - assignment1grade);
                        }
                        else{
                            System.out.print("Mark: ");
                            quiz.setMax_score(input.nextInt());
                        }
                        quiz.setMax_score(15);
                        System.out.print("Duration: ");
                        quiz.setQuiz_Duration(input.nextInt());
                    }
                }
=======
>>>>>>> Stashed changes
                break;
            case 3:
                //add Midterm
                MidtermExam midtermExam = new MidtermExam();
                System.out.println("Midterm mark will be 15");
                System.out.print("Title: ");
                midtermExam.setTitle(input.next());
                System.out.print("Date: ");
                midtermExam.setDate(input.next());
                midtermExam.setMax_score(15);
                System.out.print("Duration: ");
                midtermExam.setExam_Duration(input.nextInt());
                System.out.println("Location: ");
                midtermExam.setExam_Location(input.next());
                course.addAssignedMidterm(midtermExam);
                break;
            case 4:
                //add Final
                FinalExam finalExam = new FinalExam();
                System.out.println("Final exam mark will be 50");
                System.out.print("Title: ");
                finalExam.setTitle(input.next());
                System.out.print("Date: ");
                finalExam.setDate(input.next());
                finalExam.setMax_score(50);
                System.out.print("Duration: ");
                finalExam.setExam_Time(input.nextInt());
                System.out.println("Location: ");
                finalExam.setLocation(input.next());
                course.addAssignedFinal(finalExam);
                break;
            case 5:
                //add Practical
                Practical practical = new Practical();
                System.out.print("Title: ");
                practical.setTitle(input.next());
                System.out.print("Date: ");
                practical.setDate(input.next());
                System.out.print("Mark: ");
                practical.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                practical.setPractical_Exam_Time(input.nextInt());
                System.out.println("Location: ");
                practical.setPractical_Exam_Location(input.next());
                //courses.get(cid).addAssignedpractical(practical);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
    public void inputGrades(){
<<<<<<< Updated upstream
        for (Student student : students) {
            int courseIndex = findindexs(student);
            System.out.println("What do you want track");
            System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Practical\n5-Final");
            int choice = input.nextInt();
            switch (choice) {
                case 1: //Assignment
                    double assignmentGrade = 0.0;
                    if (course.assignedAssignment.size() == 1) {
                        while (true) {
                            System.out.println("Enter grade: ");
                            assignmentGrade = input.nextDouble();
                            if (assignmentGrade > 20) {
                                System.out.println("Invalid grade\nEnter grade less than or equal 20");
                            } else if (assignmentGrade <= 20) {
                                student.Student_Grades.get(courseIndex).setAssignmentGrade(0, assignmentGrade);
                                break;
                            }
                        }
                    } else if (course.assignedAssignment.size() == 2) {
                        while (true) {
                            System.out.println("Enter assignment number: ");
                            int assignmentNumber = input.nextInt() - 1;
                            int assignmentgrade = course.assignedAssignment.get(assignmentNumber).getMax_score();
                            System.out.println("Enter grade: ");
                            assignmentGrade = input.nextDouble();
                            if (assignmentGrade > assignmentgrade) {
                                System.out.println("Invalid grade\nEnter grade less than or equal " + assignmentgrade);
                            }
                            if (assignmentGrade <= assignmentgrade) {
                                student.Student_Grades.get(courseIndex).setAssignmentGrade(assignmentNumber, assignmentGrade);
                                break;
                            }
                        }
                    }
                    break;
                case 2: //Quiz
                    double quizGrade = 0.0;
                    if (course.assignedQuiz.size() == 1) {
                        while (true) {
                            System.out.println("Enter grade: ");
                            quizGrade = input.nextDouble();
                            if (quizGrade > 20) {
                                System.out.println("Invalid grade\nEnter grade less than or equal 10");
                            } else if (quizGrade <= 20) {
                                student.Student_Grades.get(courseIndex).setQuizGrade(0, quizGrade);
                                break;
                            }
                        }
                    } else if (course.assignedQuiz.size() == 2) {
                        while (true) {
                            System.out.println("Enter quiz number: ");
                            int quizNumber = input.nextInt() - 1;
                            int quizgrade = course.assignedQuiz.get(quizNumber).getMax_score();
                            System.out.println("Enter grade: ");
                            quizGrade = input.nextDouble();
                            if (quizGrade > quizgrade) {
                                System.out.println("Invalid grade\nEnter grade less than or equal " + quizgrade);
                            }
                            if (quizGrade <= quizgrade) {
                                student.Student_Grades.get(courseIndex).setQuizGrade(quizNumber, quizGrade);
                                break;
                            }
                        }
                    }
                    break;
                case 3: //Midterm
                    while (true) {
                        System.out.println("Enter grade");
                        double midtermGrade = input.nextDouble();
                        if (midtermGrade > 15) {
                            System.out.println("Invalid grade\nEnter grade less than or equal 15");
                        } else if (midtermGrade <= 15) {
                            student.Student_Grades.get(courseIndex).setMidTermGrade(midtermGrade);
                            break;
                        }
                    }
                    break;
                case 4: //Practical
                    System.out.println("Enter grade");
                    double p = input.nextDouble();
                    //  students[sid].Student_courses[courseIndex].grades.se(p);
                    break;
                case 5: //final exam
                    while (true) {
                        System.out.println("Enter grade");
                        double finalGrade = input.nextDouble();
                        if (finalGrade > 50) {
                            System.out.println("Invalid grade\nEnter grade less than or equal 50");
                        } else if (finalGrade <= 50) {
                            student.Student_Grades.get(courseIndex).setFinalGrade(finalGrade);
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public void generateAttRepForIndStud(int student_ID) {
        int courseIndex = findindexs(students.get(student_ID));
        int j = 0, attndance_sum = 0;
        //reset for instructor student array
=======
        System.out.println("Enter student ID");
        int student_ID = input.nextInt(), i = 0,j = 0;
        for (Student student : students) {
           if(student.getID() == student_ID){
               break;
           }
            j++;
        }
        student_ID = j;
        for (Course course : students.get(student_ID).Student_courses) {
            if(course.equals(this.course)) {
                break;
            }
            i++;
        }
        int cid = i;
        System.out.println("What do you want track");
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Practical\n5-Final");
        int choice = input.nextInt();
        switch (choice){
            case 1: //Assignment
                System.out.println("Enter assignment number");
                int x = input.nextInt()- 1;
                System.out.println("Enter grade");
                double a = input.nextDouble();
        students.get(student_ID).Student_Grades.get(cid).setAssignmentGrade(x,a);

                break;
            case 2: //Quiz
                System.out.println("Enter quiz number");
                int y = input.nextInt()- 1;
                System.out.println("Enter grade");
                double q = input.nextDouble();
                students.get(student_ID).Student_Grades.get(cid).setQuizGrade(y,q);

                break;
            case 3: //Midterm
                System.out.println("Enter grade");
                double m = input.nextDouble();
                students.get(student_ID).Student_Grades.get(cid).setMidTermGrade(m);

                break;
            case 4: //Practical
                System.out.println("Enter grade");
                double p = input.nextDouble();
              //  students[sid].Student_courses[cid].grades.se(p);
                break;
            case 5: //final
                System.out.println("Enter grade");
                double f = input.nextDouble();
                students.get(student_ID).Student_Grades.get(cid).setFinalGrade(f);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void generateAttRepForIndStud(int student_ID) {
        int[] indexs = new int[2];//first index for attendance times & second index for course id
        int j = 0, i = 0;
>>>>>>> Stashed changes
        for (Student student : students) {
            if (student.getID() == student_ID) {
                break;
            }
            j++;
        }
        student_ID = j;
<<<<<<< Updated upstream
        for (int i = 0; i < 10; i++) {
            if (students.get(student_ID).attendance[courseIndex][i]) {
                attndance_sum++;
            }
        }
        System.out.println("Report for student " + students.get(student_ID).getFname() + " " + students.get(student_ID).getLname());
        System.out.println("Student ID: " + students.get(student_ID).getID());
        System.out.println("Number of attended sessions: " + attndance_sum);
        System.out.println("Attendance grade: " + students.get(student_ID).Student_Grades.get(courseIndex).getAttendanceGrade());
=======
        for (Course course : students.get(student_ID).Student_courses) {
            if (course.equals(this.course)) {
                break;
            }
            i++;
        }
        indexs[1] = i;
        trackingStudentsAttendanceGrades(students.get(student_ID), indexs);
        System.out.println("Report for student " + students.get(student_ID).getFname() + " " + students.get(student_ID).getLname());
        System.out.println("Student ID: " + students.get(student_ID).getID());
        System.out.println("Number of attended sessions: " + indexs[0]);
        System.out.println("Attendance grade: " + students.get(student_ID).Student_Grades.get(indexs[1]).getAttendanceGrade());
>>>>>>> Stashed changes
    }
    public void generateAttrepforallstud() {
        for(Student student:students){
        generateAttRepForIndStud(student.getID());
<<<<<<< Updated upstream
=======
        }
    }
    public void setDEadlinesandReminders(){
    // LocalDate deadline = LocalDate.now();
     //System.out.println( "Assignmet deadline at : "+deadline.plusDays(10));
        LocalDate Assignment_startDate = LocalDate.of(2023, 12, 10); // Set the start date for the assignment
        LocalDate Assignment_Deadline = Assignment_startDate.plusDays(10); // Set the assignment deadline 10 from the start date
        Assignment assignment = new Assignment();
        System.out.println("Start Date: " + assignment.getAssignment_Deadline());
        System.out.println("Deadline: " + assignment.getAssignment_Deadline());
   }
    private void trackingStudentsAttendanceGrades(Student student,int []indexs) {
        int attndance_sum = 0;
        for (int i = 0; i < 10; i++) {
            if (student.attendance[indexs[1]][i]) {
                attndance_sum++;
            }
>>>>>>> Stashed changes
        }
        if (attndance_sum <= 5 && attndance_sum >= 3) {
            Notification notification = new Notification();
            notification.addAttendance(true);
            student.setNotification(notification);
            student.Student_Grades.get(indexs[1]).setAttendanceGrade(2);
        } else if (attndance_sum < 3) {
            student.Student_Grades.get(indexs[1]).setAttendanceGrade(0);
        } else {
            student.Student_Grades.get(indexs[1]).setAttendanceGrade(5);
        }

    }
<<<<<<< Updated upstream
    public void viewEnrolledStudents(){
        course.viewListOfEnrolledStudents();
    }
    public void reportForSectionsAttendance(){
        for (int i = 0; i < 10; i++) {
            int sumOfAttendance = 0;
            for(Student student : students){
            int courseIndex =findindexs(student);
            if (student.attendance[courseIndex][i]) {
                   sumOfAttendance++;
                }
            }
            System.out.print("Number of attended students in section number #" + (i + 1));
            System.out.println(" = " + sumOfAttendance);
        }
    }
    private void setDeadlineassignment(int number) {
        System.out.println("Enter Assignment start date like this format yyyy-MM-dd ");
        String date = input.next();
        System.out.println("Enter Assignment duration ");
        int x = input.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate Date = LocalDate.parse(date, formatter);
            course.assignedAssignment.get(number).setAssignment_startDate(Date); // Set the start date for the assignment
            course.assignedAssignment.get(number).set_Assignment_deadline(LocalDate.parse(course.assignedAssignment.get(number).getAssignment_startDate().plusDays(x).toString()));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
        } finally {
            input.close();
        }
    }
    private void trackingStudentsAttendanceGrades(Student student) {
        int attndance_sum = 0;
        int courseIndex = findindexs(student);
        for (int i = 0; i < 10; i++) {
            if (student.attendance[courseIndex][i]) {
                attndance_sum++;
            }
        }
        if (attndance_sum <= 5 && attndance_sum >= 3) {
            Notification notification = new Notification();
            notification.addAttendance(true);
            student.setNotification(notification);
            student.Student_Grades.get(courseIndex).setAttendanceGrade(2);
        } else if (attndance_sum < 3) {
            student.Student_Grades.get(courseIndex).setAttendanceGrade(0);
        } else {
            student.Student_Grades.get(courseIndex).setAttendanceGrade(5);
        }
    }
    private int findindexs(Student student){
       int i = 0;
       for (Course course : student.Student_courses) {
           if(course.equals(this.course)) {
               break;
           }
           i++;
       }
       return i;
   }
    private void checkIfExist(){
        if(course.assignedAssignment.isEmpty()) {
            System.out.println("This course doesn't have assignment");
        }else if (course.assignedQuiz.isEmpty()) {
            System.out.println("This course doesn't have quiz");
        } else if (course.assignedMidterm.getID() == -1) {
            System.out.println("This course doesn't have midterm yet");
        }
        else if(course.assignedfinal.getID() == -1){
           System.out.println("This course doesn't have final yet");
        }
   }

   public String toString()
   {
      return getID()+","+getFname()+","+getLname()+","+getEmail()+","+getPassword()+","+PhoneNumber+","+office_location+","+department;
   }
=======

   private void findindexs(int[] index){}
>>>>>>> Stashed changes
}

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Instructor extends Person {
    Scanner input = new Scanner(System.in);
    public static int instructor_ID = 0;
    private String office_location, department;
    public ArrayList<Course> course = new ArrayList<>();
    public ArrayList<Student> instructor_students = new ArrayList<>();
    public Instructor() {
        super();
        this.office_location = "Unknown";
        this.department = "Unknown";
        this.setID(instructor_ID);
    }
    public Instructor(int ID, String Fname, String Lname, String email,String username, String password, String PhoneNumber, String office_location, String department) {
        super(ID, Fname, Lname, email,username,password, PhoneNumber);
        this.office_location = office_location;
        this.department = department;
    }
    public Instructor(int ID, String Fname, String Lname, String email, String username,String password, String PhoneNumber) {
        super(ID, Fname, Lname, email,username, password, PhoneNumber);
        this.office_location = office_location;
        this.department = department;
    }
    public Instructor(String Fname, String Lname, String office_location, String department) {
        super(Fname, Lname);
        this.office_location = office_location;
        this.department = department;
        this.setID(instructor_ID);
        instructor_ID++;
    }
    public void forSignUp(){
        System.out.println("Your office Location: ");
        this.office_location = input.next();
        System.out.println("Your Department: ");
        this.department = input.next();
        System.out.println("Data entered successfully!");
        System.out.println("Your ID is: " + this.getID());
        instructor_ID++;
    }
    public void forSignIn() throws IOException {
        filterStudents();
        int choice = 0;
        while (choice != 11 && choice != 12) {
            System.out.println("-------------------------");
            System.out.println("1-Show your information\n2-Edit your information");

                System.out.println("3-View students\n4-Assign Assessment");
                System.out.println("5-Take attendance\n6-Input students grades");
                System.out.println("7-Make report for attendance specific student");
                System.out.println("8-Make report for attendance all students");
                System.out.println("9-Generate Report for attendance by sections");
                System.out.println("10-Edit students grades");

            System.out.println("11-Logout");
            System.out.println("12-Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    this.display();
                    break;
                case 2:
                    this.editInfo();
                    break;
                case 3:
                    if (!isNotResponsibleForCourse()) {
                        this.viewEnrolledStudents();
                    }
                    break;
                case 4:
                    if (!isNotResponsibleForCourse()){
                    this.setAssessmentsToCourse();}
                    break;
                case 5:
                    if (!isNotResponsibleForCourse()){
                    this.trackAttendance();}
                    break;
                case 6:
                    if (!isNotResponsibleForCourse()) {
                        this.inputGrades();
                    }
                    break;
                case 7:
                    if (!isNotResponsibleForCourse()){
                    System.out.println("Enter student ID");
                    int studentID = input.nextInt();
                    this.generateAttRepForIndStud(studentID);}
                    break;
                case 8:
                    if (!isNotResponsibleForCourse()){
                    this.generateAttrepforallstud();}
                    break;
                case 9:
                    if (!isNotResponsibleForCourse()){
                    this.reportForSectionsAttendance();}
                    break;
                case 10:
                    if (!isNotResponsibleForCourse()){
                    this.editGrades();}
                case 11:
                    Main.main(null);
                    break;
                case 12:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    @Override
    public void display() {
        System.out.println("Name: " + this.getFname() + " " + this.getLname());
        System.out.println("ID: " + this.getID());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Department: " + this.department);
        System.out.println("Office Location: "+this.office_location);
        try {
            System.out.println("Responsible for course: " + this.course.get(0).courseTitle);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Responsible for no course ");
        }
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
    public void setDepartment(String department) {
        this.department = department;
    }
    public void editInfo() {
        int choice = 0;
        while(choice != 6){
            System.out.println("Select what you want change");
            System.out.println("1-Name\n2-Email\n3-Password");
            System.out.println("4-Office location\n5-Department\n6-Back");
            choice = input.nextInt();
            switch (choice) {
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
                    System.out.println("Enter your current username");
                    String username = input.next();
                    System.out.println("Enter your current password");
                    String IPassword = input.next();
                    if (this.getUsername().replaceAll("@Instructor","").equals(username) && this.getPassword().equals(IPassword)) {
                        System.out.println("Enter new username");
                        String Nusername = input.next();
                        this.setUsername(Nusername+"@Instructor");
                        System.out.println("Enter new password");
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
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            this.display();
        }
    }
    public void trackAttendance() {
        for (Student student : instructor_students) {
            int courseIndex = findindexs(student);
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            for (int i = 0; i < 5; i++) {
                while(true) {
                    System.out.println("section number #" + (i + 1));
                    System.out.println("Did this student attend?(y/n)");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        student.attendance[courseIndex][i] = true;
                        break;
                    } else if (ch == 'n' || ch == 'N') {
                        System.out.println("Are there any exception?");
                        ch = input.next().charAt(0);
                        if (ch == 'Y' || ch == 'y') {
                            student.attendance[courseIndex][i] = true;
                            break;
                        }
                    } else {
                        System.out.println("Invalid input");
                    }
                }
            }
            trackingStudentsAttendanceGrades(student);
        }

    }
    public void setAssessmentsToCourse() {
        Test test;
        System.out.println("--------------------------------------");
        System.out.println("Adding assessment to " + course.get(0).courseTitle);
        int choice = 0;
        while (choice != 5) {
            choice =  checkIfExist();
            switch (choice) {
                case 1:
                    //add Assignment
                    if(course.get(0).assignedAssignment.isEmpty()) {
                        System.out.println("How many assignments?1 or 2 ");
                        System.out.println("If 1 assignment mark will be 20");
                        System.out.println("If 2 the sum of two assignments will be 20");
                        int numOfAssignment = 0;
                        while (true) {
                            numOfAssignment = input.nextInt();
                            if (numOfAssignment > 2)
                                System.out.println("Invalid input");
                            else
                                break;
                        }
                        for (int i = 0; i < numOfAssignment; i++) {
                            test = new Assignment();
                            setassignment((Assignment) test, numOfAssignment, i);
                        }
                    }else{
                        System.out.println("This course already have assignment");
                    }
                    break;
                case 2:
                    //add Quiz
                    if(course.get(0).assignedQuiz.isEmpty()) {
                        System.out.println("How many quizzes ? 1 0r 2 ");
                        System.out.println("If 1 quiz mark will be 10");
                        System.out.println("If 2 the sum of quizzes will be 10");
                        int numOfQuiz = 0;
                        while (true) {
                            numOfQuiz = input.nextInt();
                            if (numOfQuiz > 2)
                                System.out.println("Invalid input");
                            else
                                break;
                        }
                        for (int i = 0; i < numOfQuiz; i++) {
                            test = new Quiz();
                            double grade;
                            if (i == 1) {
                                double quiz1grade = course.get(0).assignedQuiz.get(0).getMax_score();
                                grade = 10 - quiz1grade;
                            } else if (numOfQuiz == 1) {
                                grade = 10;
                            } else {
                                System.out.print("Mark: ");
                                grade = input.nextDouble();
                            }
                            forAddAssessment(test, grade);
                            course.get(0).addAssignedQuiz((Quiz) test);
                        }
                    }else{
                        System.out.println("This course already have quiz");
                    }
                    break;
                case 3:
                    //add Midterm
                    if(course.get(0).assignedMidterm.getMax_score() == 0) {
                        test = new MidtermExam();
                        System.out.println("Midterm mark will be 15");
                        forAddAssessment(test, 15);
                        System.out.println("Location: ");
                        ((MidtermExam) test).setExam_Location(input.next());
                        course.get(0).addAssignedMidterm((MidtermExam) test);
                    }
                    else{
                        System.out.println("This course already have midterm exam");
                    }
                    break;
                case 4:
                    //add Final
                    if(course.get(0).assignedfinal.getMax_score() == 0) {
                        test = new FinalExam();
                        System.out.println("Final exam mark will be 50");
                        forAddAssessment(test, 50);
                        System.out.println("Location: ");
                        ((FinalExam) test).setLocation(input.next());
                        course.get(0).addAssignedFinal((FinalExam) test);
                    }else{
                        System.out.println("This course already have final exam");
                    }
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    public void inputGrades() {
        int choice = 0;
        while(choice != 5) {
            System.out.println("What do you want set");
            System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Exit");
            choice = input.nextInt();
            for (Student student : instructor_students) {
                int courseIndex = findindexs(student);
                switch (choice) {
                    case 1: //Assignment
                        assignmentCase(student, courseIndex);
                        break;
                    case 2: //Quiz
                        quizCase(student, courseIndex);
                        break;
                    case 3: //Midterm
                        midtermCase(student, courseIndex);
                        break;
                    case 4: //final exam
                        finalCase(student, courseIndex);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;

                }
            }
        }
    }
    public void generateAttRepForIndStud(int student_ID) {
        int j = 0, attndance_sum = 0;
        for (Student student : instructor_students) {
            if (student.getID() == student_ID) {
                break;
            }
            j++;
        }
        student_ID = j;
        int courseIndex = findindexs(instructor_students.get(student_ID));
        for (int i = 0; i < 5; i++) {
            if (instructor_students.get(student_ID).attendance[courseIndex][i]) {
                attndance_sum++;
            }
        }
        System.out.println("Report for student " + instructor_students.get(student_ID).getFname() + " " +instructor_students.get(student_ID).getLname());
        System.out.println("Student ID: " + instructor_students.get(student_ID).getID());
        System.out.println("Number of attended sessions: " + attndance_sum);
        System.out.println("Attendance grade: " + instructor_students.get(student_ID).Student_Grades.get(courseIndex).getAttendanceGrade());
        System.out.println("--------------------------------------");

    }
    public void generateAttrepforallstud() {
        for(Student student : instructor_students){
            generateAttRepForIndStud(student.getID());
        }
    }
    public void viewEnrolledStudents() {
        course.get(0).viewListOfEnrolledStudents();
    }
    public void reportForSectionsAttendance() {
        System.out.println("--------------------------------------");
        System.out.println("Report for attendance by section");
        for (int i = 0; i < 5; i++) {
            int sumOfAttendance = 0;
            for (Student student : instructor_students) {
                int courseIndex = findindexs(student);
                if (student.attendance[courseIndex][i]) {
                    sumOfAttendance++;
                }
            }
            System.out.print("Number of attended students in section number #" + (i + 1));
            System.out.println(" = " + sumOfAttendance);
        }
    }
    public String toString(){
        return getID()+","+getFname()+","+getLname()+","+getEmail()+","+getUsername()+","+getPassword()+","+PhoneNumber+","+office_location+","+department;
    }
    public void editGrades() throws IOException {
        int choice=0;
        System.out.println("Enter student ID:");
        int studentID = input.nextInt(), j = 0;
        for (Student student : instructor_students) {
            if (student.getID() == studentID) {
                break;
            }
            j++;
        }
        int courseIndex = findindexs(instructor_students.get(j));
        while(choice != 5){
            System.out.println("What grade do you want to edit");
            System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Exit");
            choice = input.nextInt();
            switch (choice) {
                case 1: //Assignment
                    editassignmentCase(instructor_students.get(j), courseIndex);
                    break;
                case 2: //Quiz
                    editquizCase(instructor_students.get(j), courseIndex);
                    break;
                case 3: //Midterm
                    editmidtermCase(instructor_students.get(j), courseIndex);
                    break;
                case 4: //final exam
                    editfinalCase(instructor_students.get(j), courseIndex);
                    break;
                case 5:
                    this.forSignIn();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    private void setassignment(Assignment assignment,int number,int i) {
        assignment.courseCode = course.get(0).getCourseCode();
        System.out.println("Assignment ID: ");
        assignment.setID(input.nextInt());
        System.out.print("Title: ");
        assignment.setTitle(input.next());
        if (i == 1) {
            double assignment1grade = course.get(0).assignedAssignment.get(0).getMax_score();
            assignment.setMax_score(20 - assignment1grade);
        } else if (number == 1) {
            assignment.setMax_score(20);
        } else {
            System.out.print("Mark: ");
            assignment.setMax_score(input.nextDouble());
        }
        setAssignmentDate(assignment);
        course.get(0).addAssignedAssignment(assignment);
    }
    private void trackingStudentsAttendanceGrades(Student student) {
        int attndance_sum = 0;
        int courseIndex = findindexs(student);
        for (int i = 0; i < 5; i++) {
            if (student.attendance[courseIndex][i]) {
                attndance_sum++;
            }
        }
        if (attndance_sum < 5 && attndance_sum >= 3) {
            student.Student_Grades.get(courseIndex).setAttendanceGrade(2);
        } else if (attndance_sum < 2) {
            student.Student_Grades.get(courseIndex).setAttendanceGrade(0);
            student.getNotification().addAttendance(true);
        } else {
            student.Student_Grades.get(courseIndex).setAttendanceGrade(5);
        }
    }
    private int findindexs(Student student) {
        int i = 0;
        for (Course course : student.Student_courses) {
            if (course.equals(this.course.get(0))) {
                break;
            }
            i++;
        }
        return i;
    }
    private int checkIfExist(){
        System.out.println("--------------------------------------");
        if(course.get(0).assignedAssignment.isEmpty()) {
            System.out.println("This course doesn't have assignment");
        }
        if (course.get(0).assignedQuiz.isEmpty()) {
            System.out.println("This course doesn't have quiz");
        }
        if (course.get(0).assignedMidterm.getMax_score() == 0) {
            System.out.println("This course doesn't have midterm exam yet");
        }
        if(course.get(0).assignedfinal.getMax_score() == 0){
            System.out.println("This course doesn't have final exam yet");
        }
        System.out.println("--------------------------------------");
        System.out.println("What do you want to add");
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Exit");
        int x=input.nextInt();
        return x;
    }
    private void filterStudents(){
        if(!isNotResponsibleForCourse()) {
            for (Student student : Main.students) {
                for (Course c : student.Student_courses) {
                    if (c.equals(course.get(0))) {
                        instructor_students.add(student);
                    }
                }
            }
        }
    }
    private boolean isNotResponsibleForCourse(){
        if(this.course.isEmpty()){
            System.out.println("You don't have course yet");
            return true;
        }
        return false;
    }
    private void forAddAssessment(Test test, double max_Score) {
        test.courseCode = course.get(0).getCourseCode();
        System.out.println("Enter Assessment ID");
        test.setID(input.nextInt());
        System.out.print("Title: ");
        test.setTitle(input.next());
        System.out.println("Enter date like this format yyyy-MM-dd ");
        test.setDate(input.next());
        test.setMax_score(max_Score);
        System.out.print("Duration in hours: ");
        test.setDuration(input.nextDouble());
    }
    private void setAssignmentDate(Assignment assignment){
        while (true) {
            try {
                System.out.println("Enter Assignment start date like this format dd-MM-yyyy ");
                String date = input.next();
                System.out.println("Enter Assignment duration in days");
                assignment.setDuration(input.nextDouble());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate Date = LocalDate.parse(date, formatter);
                assignment.setAssignment_startDate(Date); // Set the start date for the assignment
                assignment.set_Assignment_deadline(LocalDate.parse(assignment.getAssignment_startDate().plusDays((long) assignment.getDuration()).toString()));
                System.out.println("Assignment deadline will be at " + assignment.getAssignment_Deadline());
                break;
            } catch (DateTimeException dt) {
                System.out.println("Invalid Date, you entered past date");
            } catch (InputMismatchException ime) {
                System.out.println("Invalid Date, Please enter a valid date.");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
                input.nextLine();
            }
        }
    }
    //for input grades method
    private void assignmentCase(Student student,int courseIndex){
        if (course.get(0).assignedAssignment.isEmpty()) {
            System.out.println("This course doesn't have assignment yet");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            double assignmentGrade = 0.0;
            if (course.get(0).assignedAssignment.size() == 1) {
                while (true) {
                    System.out.println("Enter grade: ");
                    assignmentGrade = input.nextDouble();
                    if (assignmentGrade > 20) {
                        System.out.println("Invalid grade\nEnter grade less than or equal 20");
                    } else if (assignmentGrade <= 20) {
                        student.Student_Grades.get(courseIndex).setAssignmentGrade(0, assignmentGrade);
                        System.out.println("Grade entered successfully");
                        student.getNotification().addStatueOfGrade(true);
                        break;
                    }
                }
            } else if (course.get(0).assignedAssignment.size() == 2) {
                for(int i = 0; i < 2; i++) {
                    System.out.println("Assignment number #"+(i+1));
                    while (true) {
                        double assignmentgrade = course.get(0).assignedAssignment.get(i).getMax_score();
                        System.out.println("Enter grade: ");
                        assignmentGrade = input.nextDouble();
                        if (assignmentGrade > assignmentgrade) {
                            System.out.println("Invalid grade\nEnter grade less than or equal " + assignmentgrade);
                        }
                        if (assignmentGrade <= assignmentgrade) {
                            student.Student_Grades.get(courseIndex).setAssignmentGrade(i, assignmentGrade);
                            System.out.println("Grade entered successfully");
                            break;
                        }
                    }
                }
                student.getNotification().addStatueOfGrade(true);
            }
        }
    }
    private void quizCase(Student student,int courseIndex) {
        if (course.get(0).assignedQuiz.isEmpty()) {
            System.out.println("This course doesn't have quiz yet");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            double quizGrade = 0.0;
            if (course.get(0).assignedQuiz.size() == 1) {
                while (true) {
                    System.out.println("Enter grade: ");
                    quizGrade = input.nextDouble();
                    if (quizGrade > 20) {
                        System.out.println("Invalid grade\nEnter grade less than or equal 10");
                    } else if (quizGrade <= 20) {
                        student.Student_Grades.get(courseIndex).setQuizGrade(0, quizGrade);
                        System.out.println("Grade entered successfully");
                        break;
                    }
                }
                student.getNotification().addStatueOfGrade(true);
            } else if (course.get(0).assignedQuiz.size() == 2) {
                for (int i = 0; i < 2; i++) {
                    while (true) {
                        double quizgrade = course.get(0).assignedQuiz.get(i).getMax_score();
                        System.out.println("Enter grade: ");
                        quizGrade = input.nextDouble();
                        if (quizGrade > quizgrade) {
                            System.out.println("Invalid grade\nEnter grade less than or equal " + quizgrade);
                        }
                        if (quizGrade <= quizgrade) {
                            student.Student_Grades.get(courseIndex).setQuizGrade(i, quizGrade);
                            System.out.println("Grade entered successfully");
                            break;
                        }
                    }
                }
                student.getNotification().addStatueOfGrade(true);
            }
        }
    }
    private void midtermCase(Student student,int courseIndex){
        if (course.get(0).assignedMidterm.getMax_score() == 0) {
            System.out.println("This course doesn't have midterm yet");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            while (true) {
                System.out.println("Enter grade");
                double midtermGrade = input.nextDouble();
                if (midtermGrade > 15) {
                    System.out.println("Invalid grade\nEnter grade less than or equal 15");
                } else if (midtermGrade <= 15) {
                    student.Student_Grades.get(courseIndex).setMidTermGrade(midtermGrade);
                    System.out.println("Grade entered successfully");
                    break;
                }
            }
            student.getNotification().addStatueOfGrade(true);
        }
    }
    private void finalCase(Student student,int courseIndex){
        if (course.get(0).assignedfinal == null) {
            System.out.println("This course doesn't have midterm yet");
        } else {
            System.out.println("--------------------------------------");
            System.out.println("Student name: " + student.getFname() + " " + student.getLname());
            System.out.println("Student ID: " + student.getID());
            while (true) {
                System.out.println("Enter grade");
                double finalGrade = input.nextDouble();
                if (finalGrade > 50) {
                    System.out.println("Invalid grade\nEnter grade less than or equal 50");
                } else if (finalGrade <= 50) {
                    student.Student_Grades.get(courseIndex).setFinalGrade(finalGrade);
                    System.out.println("Grade entered successfully");
                    break;
                }
            }
            student.getNotification().addStatueOfGrade(true);
        }
    }
    //for Edit grades method
    private void editassignmentCase(Student student,int courseIndex){
        if (course.get(0).assignedAssignment.isEmpty()) {
            System.out.println("This course doesn't have assignment yet");
        } else {
            double assignmentGrade = 0.0;
            if (course.get(0).assignedAssignment.size() == 1) {
                while (true) {
                    System.out.println("Enter grade: ");
                    assignmentGrade = input.nextDouble();
                    if (assignmentGrade > 20) {
                        System.out.println("Invalid grade\nEnter grade less than or equal 20");
                    } else if (assignmentGrade <= 20) {
                        student.Student_Grades.get(courseIndex).assignmentGrade.set(0,assignmentGrade);
                        System.out.println("Grade entered successfully");
                        break;
                    }
                }
            } else if (course.get(0).assignedAssignment.size() == 2) {
                for(int i = 0; i < 2; i++) {
                    System.out.println("Assignment number #"+(i+1));
                    while (true) {
                        double assignmentgrade = course.get(0).assignedAssignment.get(i).getMax_score();
                        System.out.println("Enter grade: ");
                        assignmentGrade = input.nextDouble();
                        if (assignmentGrade > assignmentgrade) {
                            System.out.println("Invalid grade\nEnter grade less than or equal " + assignmentgrade);
                        }
                        if (assignmentGrade <= assignmentgrade) {
                            student.Student_Grades.get(courseIndex).assignmentGrade.set(i,assignmentGrade);
                            System.out.println("Grade entered successfully");
                            break;
                        }
                    }
                }
            }
        }
    }
    private void editquizCase(Student student,int courseIndex) {
        if (course.get(0).assignedQuiz.isEmpty()) {
            System.out.println("This course doesn't have quiz yet");
        } else {
            double quizGrade = 0.0;
            if (course.get(0).assignedQuiz.size() == 1) {
                while (true) {
                    System.out.println("Enter grade: ");
                    quizGrade = input.nextDouble();
                    if (quizGrade > 20) {
                        System.out.println("Invalid grade\nEnter grade less than or equal 10");
                    } else if (quizGrade <= 20) {
                        student.Student_Grades.get(courseIndex).quizGrade.set(0, quizGrade);
                        System.out.println("Grade entered successfully");
                        break;
                    }
                }
            } else if (course.get(0).assignedQuiz.size() == 2) {
                for (int i = 0; i < 2; i++) {
                    while (true) {
                        double quizgrade = course.get(0).assignedQuiz.get(i).getMax_score();
                        System.out.println("Enter grade: ");
                        quizGrade = input.nextDouble();
                        if (quizGrade > quizgrade) {
                            System.out.println("Invalid grade\nEnter grade less than or equal " + quizgrade);
                        }
                        if (quizGrade <= quizgrade) {
                            student.Student_Grades.get(courseIndex).quizGrade.set(i, quizGrade);
                            System.out.println("Grade entered successfully");
                            break;
                        }
                    }
                }
            }
        }
    }
    private void editmidtermCase(Student student,int courseIndex){
        if (course.get(0).assignedMidterm.getMax_score() == 0) {
            System.out.println("This course doesn't have midterm yet");
        } else {
            while (true) {
                System.out.println("Enter grade");
                double midtermGrade = input.nextDouble();
                if (midtermGrade > 15) {
                    System.out.println("Invalid grade\nEnter grade less than or equal 15");
                } else if (midtermGrade <= 15) {
                    student.Student_Grades.get(courseIndex).setMidTermGrade(midtermGrade);
                    System.out.println("Grade entered successfully");
                    break;
                }
            }
        }
    }
    private void editfinalCase(Student student,int courseIndex){
        if (course.get(0).assignedfinal == null) {
            System.out.println("This course doesn't have midterm yet");
        } else {
            while (true) {
                System.out.println("Enter grade");
                double finalGrade = input.nextDouble();
                if (finalGrade > 50) {
                    System.out.println("Invalid grade\nEnter grade less than or equal 50");
                } else if (finalGrade <= 50) {
                    student.Student_Grades.get(courseIndex).setFinalGrade(finalGrade);
                    System.out.println("Grade entered successfully");
                    break;
                }
            }
        }
    }
}
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Instructor extends Person {
    Scanner input = new Scanner(System.in);
    private String office_location, department;
    public static int instructor_ID = 0;
    public ArrayList<Course> course = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
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
    public void forSignUp() throws IOException {
        System.out.println("Your office Location: ");
        this.office_location = input.next();
        System.out.println("Your Department: ");
        this.department = input.next();
        System.out.println("Data entered successfully!");
        System.out.println("Your ID is: " + this.getID());
        instructor_ID++;
        System.out.println("you will use it for login next time");
        forSignIn();
    }
    public void forSignIn() throws IOException {
        filterStudents();
        int choice = 0;
        do {
            System.out.println("-------------------------");
            System.out.println("1-Show your information\n2-Edit your information");
            System.out.println("3-View students\n4-Assign Assessment");
            System.out.println("5-Take attendance\n6-Input students Grades");
            System.out.println("7-Make report for attendance specific student");
            System.out.println("8-Make report for attendance all students");
            System.out.println("9-Generate Report for attendance by sections\n10-Logout\n11-Exit");
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
                case 10:
                    Main.main(null);
                case 11:
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            if(choice==11)
                break;
        } while (true);
    }
    @Override
    public void display() {
        System.out.println("Name: " + this.getFname() + " " + this.getLname());
        System.out.println("ID: " + this.getID());
        System.out.println("Department: " + this.department);
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
        int choice;
        do {
            System.out.println("Select what you want change");
            System.out.println("1-Name\n2-Email\n3-Password");
            System.out.println("4-Office location\n5-Department\n6-Exit");
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
        }while(choice != 6);
    }
    public void trackAttendance(){
        if(!isNotResponsible()) {
            for (Student student : students) {
                int courseIndex = findindexs(student);
                System.out.println("Student name: " + student.getFname() + " " + student.getLname());
                System.out.println("Student ID: " + student.getID());
                for (int i = 0; i < 5; i++) {
                    System.out.println("section number #" + (i + 1));
                    System.out.println("Did this student attend?(y/n)");
                    char ch = input.next().charAt(0);
                    if (ch == 'Y' || ch == 'y') {
                        student.attendance[courseIndex][i] = true;
                    } else {
                        System.out.println("Are there any exception?");
                        ch = input.next().charAt(0);
                        if (ch == 'Y' || ch == 'y') {
                            student.attendance[courseIndex][i] = true;
                        }
                    }
                }
                trackingStudentsAttendanceGrades(student);
            }
        }
    }
    public void setAssessmentsToCourse(){
        if(!isNotResponsible()) {
            System.out.println("--------------------------------------");
            System.out.println("Adding assessment to " + course.get(0).courseTitle);
            int choice;
            do {
                checkIfExist();
                System.out.println("--------------------------------------");
                System.out.println("What do you want to add");
                System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Exit");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        //add Assignment
                        Assignment assignment = new Assignment();
                        System.out.println("How many assignments?1 0r 2 ");
                        System.out.println("If 1 assignment mark will be 20");
                        System.out.println("If 2 the sum of two assignments will be 20");
                        int numOfAssignment = input.nextInt();
                        if (numOfAssignment == 1) {
                            assignment.courseCode = course.get(0).getCourseCode();
                            System.out.println("Assignment number: ");
                            assignment.setID(input.nextInt());
                            System.out.print("Title: ");
                            assignment.setTitle(input.next());
                            assignment.setMax_score(20);
                            setDeadlineassignment(assignment);
                            course.get(0).addAssignedAssignment(assignment);
                        } else if (numOfAssignment == 2) {
                            for (int i = 0; i < 2; i++) {
                                Assignment assignments = new Assignment();
                                assignments.courseCode = course.get(0).getCourseCode();
                                System.out.println("Assignment number: ");
                                assignments.setID(input.nextInt());
                                System.out.print("Title: ");
                                assignments.setTitle(input.next());
                                if (i == 1) {
                                    double assignment1grade = course.get(0).assignedAssignment.get(0).getMax_score();
                                    assignments.setMax_score(20 - assignment1grade);
                                } else {
                                    System.out.print("Mark: ");
                                    assignments.setMax_score(input.nextDouble());
                                }
                                setDeadlineassignment(assignments);
                                course.get(0).addAssignedAssignment(assignments);
                            }
                        } else
                            System.out.println("Invalid input");
                        break;
                    case 2:
                        //add Quiz
                        Quiz quiz = new Quiz();
                        System.out.println("How many quizzes ? 1 0r 2 ");
                        System.out.println("If 1 quiz mark will be 10");
                        System.out.println("If 2 the sum of quizzes will be 10");
                        int numOfQuiz = input.nextInt();
                        if (numOfQuiz == 1) {
                            quiz.courseCode = course.get(0).getCourseCode();
                            System.out.println("Quiz number: ");
                            quiz.setID(input.nextInt());
                            System.out.print("Title: ");
                            quiz.setTitle(input.next());
                            System.out.println("Enter quiz date like this format yyyy-MM-dd ");
                            quiz.setDate(input.next());
                            quiz.setMax_score(10);
                            System.out.print("Duration in hours: ");
                            quiz.setQuiz_Duration(input.nextInt());
                            course.get(0).addAssignedQuiz(quiz);
                        } else if (numOfQuiz == 2) {
                            Quiz quizzes = new Quiz();
                            for (int i = 0; i < 2; i++) {
                                quizzes.courseCode = course.get(0).getCourseCode();
                                System.out.println("Quiz number: ");
                                quizzes.setID(input.nextInt());
                                System.out.print("Title: ");
                                quizzes.setTitle(input.next());
                                System.out.println("Enter quiz date like this format yyyy-MM-dd ");
                                quizzes.setDate(input.next());
                                if (i == 1) {
                                    double quiz1grade = course.get(0).assignedQuiz.get(0).getMax_score();
                                    quizzes.setMax_score(10 - quiz1grade);
                                } else {
                                    System.out.print("Mark: ");
                                    quiz.setMax_score(input.nextDouble());
                                }
                                System.out.print("Duration in hours: ");
                                quizzes.setQuiz_Duration(input.nextDouble());
                                course.get(0).addAssignedQuiz(quizzes);
                            }
                        }
                        break;
                    case 3:
                        //add Midterm
                        MidtermExam midtermExam = new MidtermExam();
                        System.out.println("Midterm mark will be 15");
                        System.out.print("Title: ");
                        midtermExam.setTitle(input.next());
                        System.out.println("Enter midterm exam date like this format yyyy-MM-dd ");
                        midtermExam.setDate(input.next());
                        midtermExam.setMax_score(15);
                        System.out.print("Duration in hours: ");
                        midtermExam.setExam_Duration(input.nextDouble());
                        System.out.println("Location: ");
                        midtermExam.setExam_Location(input.next());
                        course.get(0).addAssignedMidterm(midtermExam);
                        break;
                    case 4:
                        //add Final
                        FinalExam finalExam = new FinalExam();
                        System.out.println("Final exam mark will be 50");
                        System.out.print("Title: ");
                        finalExam.setTitle(input.next());
                        System.out.println("Enter final exam date like this format yyyy-MM-dd ");
                        finalExam.setDate(input.next());
                        finalExam.setMax_score(50);
                        System.out.print("Duration in hours: ");
                        finalExam.setExam_Time(input.nextDouble());
                        System.out.println("Location: ");
                        finalExam.setLocation(input.next());
                        course.get(0).addAssignedFinal(finalExam);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            } while (choice != 6);
        }
    }
    public void inputGrades(){
        if(!isNotResponsible()) {
            for (Student student : students) {
                Notification n = new Notification();
                int courseIndex = findindexs(student);
                System.out.println("--------------------------------------");
                System.out.println("Student name: " + student.getFname() + " " + student.getLname());
                System.out.println("Student ID: " + student.getID());
                int choice;
                StudentGrades g = new StudentGrades();
                student.Student_Grades.add(g);
                do {
                    System.out.println("--------------------------------------");
                    System.out.println("What do you want set");
                    System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Exit");
                    choice = input.nextInt();
                    switch (choice) {
                        case 1: //Assignment
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
                                            student.Student_Grades.get(courseIndex).setAssignmentGrade(0, assignmentGrade);
                                            n.addStatueOfGrade(true);
                                            break;
                                        }
                                    }
                                } else if (course.get(0).assignedAssignment.size() == 2) {
                                    while (true) {
                                        System.out.println("Enter assignment number: ");
                                        int assignmentNumber = input.nextInt() - 1;
                                        double assignmentgrade = course.get(0).assignedAssignment.get(assignmentNumber).getMax_score();
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
                                    n.addStatueOfGrade(true);
                                }
                            }
                            break;
                        case 2: //Quiz
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
                                            student.Student_Grades.get(courseIndex).setQuizGrade(0, quizGrade);
                                            break;
                                        }
                                    }
                                    n.addStatueOfGrade(true);
                                } else if (course.get(0).assignedQuiz.size() == 2) {
                                    while (true) {
                                        System.out.println("Enter quiz number: ");
                                        int quizNumber = input.nextInt() - 1;
                                        double quizgrade = course.get(0).assignedQuiz.get(quizNumber).getMax_score();
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
                                    n.addStatueOfGrade(true);
                                }
                            }
                            break;
                        case 3: //Midterm
                            if (course.get(0).assignedMidterm == null) {
                                System.out.println("This course doesn't have midterm yet");
                            } else {
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
                                n.addStatueOfGrade(true);
                            }
                            break;
                        case 4: //final exam
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
                                        break;
                                    }
                                }
                                n.addStatueOfGrade(true);
                            }
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    student.setNotification(n);
                } while (choice != 6);
            }
        }
    }
    public void generateAttRepForIndStud(int student_ID) {
        if (!isNotResponsible()) {
            int courseIndex = findindexs(students.get(student_ID));
            int j = 0, attndance_sum = 0;
            //reset for instructor student array
            for (Student student : students) {
                if (student.getID() == student_ID) {
                    break;
                }
                j++;
            }
            student_ID = j;
            for (int i = 0; i < 5; i++) {
                if (students.get(student_ID).attendance[courseIndex][i]) {
                    attndance_sum++;
                }
            }
            System.out.println("Report for student " + students.get(student_ID).getFname() + " " + students.get(student_ID).getLname());
            System.out.println("Student ID: " + students.get(student_ID).getID());
            System.out.println("Number of attended sessions: " + attndance_sum);
            System.out.println("Attendance grade: " + students.get(student_ID).Student_Grades.get(courseIndex).getAttendanceGrade());
            System.out.println("--------------------------------------");
        }
    }
    public void generateAttrepforallstud() {
        for(Student student:students){
            generateAttRepForIndStud(student.getID());
        }
    }
    public void viewEnrolledStudents(){
        if(!isNotResponsible()) {
            for (Student student : students) {
                course.get(0).viewListOfEnrolledStudents();
            }
        }
    }
    public void reportForSectionsAttendance() {
        if (!isNotResponsible()) {
            System.out.println("--------------------------------------");
            System.out.println("Report for attendance by section");
            for (int i = 0; i < 5; i++) {
                int sumOfAttendance = 0;
                for (Student student : students) {
                    int courseIndex = findindexs(student);
                    if (student.attendance[courseIndex][i]) {
                        sumOfAttendance++;
                    }
                }
                System.out.print("Number of attended students in section number #" + (i + 1));
                System.out.println(" = " + sumOfAttendance);
            }
        }
    }
    public String toString(){
        return getID()+","+getFname()+","+getLname()+","+getEmail()+","+getUsername()+","+getPassword()+","+PhoneNumber+","+office_location+","+department;
    }
    private void setDeadlineassignment(Assignment assignment) {
        while (true) {
            try {
                System.out.println("Enter Assignment start date like this format yyyy-MM-dd ");
                String date = input.next();
                System.out.println("Enter Assignment duration in days");
                int x = input.nextInt();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate Date = LocalDate.parse(date, formatter);
                assignment.setAssignment_startDate(Date); // Set the start date for the assignment
                assignment.set_Assignment_deadline(LocalDate.parse(assignment.getAssignment_startDate().plusDays(x).toString()));
                System.out.println("Assignment deadline will be at " + assignment.getAssignment_Deadline());
                break;
            } catch (DateTimeException dt) {
                System.out.println("Invalid Date, you entered past date");
            }catch (InputMismatchException ime){
                System.out.println("Invalid Date, Please enter a valid date.");
                input.nextLine();
            }
            catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
                input.nextLine();
            }
        }
    }
    private void trackingStudentsAttendanceGrades(Student student) {
        int attndance_sum = 0;
        int courseIndex = findindexs(student);
        for (int i = 0; i < 5; i++) {
            if (student.attendance[courseIndex][i]) {
                attndance_sum++;
            }
        }
        if (attndance_sum <= 5 && attndance_sum >= 3) {
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
        if(course.get(0).assignedAssignment.isEmpty()) {
            System.out.println("This course doesn't have assignment");
        }
        if (course.get(0).assignedQuiz.isEmpty()) {
            System.out.println("This course doesn't have quiz");
        }
        if (course.get(0).assignedMidterm == null) {
            System.out.println("This course doesn't have midterm yet");
        }
        if(course.get(0).assignedfinal == null){
            System.out.println("This course doesn't have final yet");
        }
    }
    private void filterStudents(){
        for(Student student : Main.students){
            for(Course c:student.Student_courses){
                if(c.equals(course.get(0))){
                    students.add(student);
                }
            }
        }
    }
    private boolean isNotResponsible(){
        if(this.course.isEmpty()){
            System.out.println("You don't have course yet");
            return true;
        }
            return false;
    }
}

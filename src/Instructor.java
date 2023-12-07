
 import java.time.LocalDate;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.stream.Collectors;
public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;
    public static int instructor_ID = 0;
    public  Course course = new Course();
    public ArrayList <Student> students = (ArrayList<Student>) Main.studentsArray.stream()
            .filter(Student -> Student.Student_courses.equals(course))
            .collect(Collectors.toList());
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
        this.setID(instructor_ID);
        instructor_ID++;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
        System.out.println("Email: " + this.getEmail());
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
    public void setDepartment(String department) { this.department = department; }

    public void editInfo(){
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\n3-Username or Password");
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
                System.out.println("Enter your current username and password");
                String t1 = input.next(),t2 = input.next();
                if(this.getUsername().equals(t1) && this.getPassword().equals(t2)){
                    System.out.println("Enter new username and password");
                    t1=input.next();
                    t2=input.next();
                    this.setUsername(t1);
                    this.setPassword(t2);
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
        }
    }
    public void setAssessmentsToCourse(){
        System.out.println("Enter course ID");
        int cid = input.nextInt();
        System.out.println("Adding assessment to " + course.courseTitle);
        System.out.println("1-Assignment\n2-Quiz\n3-Midterm\n4-Final\n5-Practical");
        int choice =input.nextInt();
        switch (choice){
            case 1:
                //add Assignment
                Assignment assignment=new Assignment();
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
                System.out.println("Quiz number: ");
                quiz.setID(input.nextInt());
                System.out.print("Title: ");
                quiz.setTitle(input.next());
                System.out.print("Date: ");
                quiz.setDate(input.next());
                System.out.print("Mark: ");
                quiz.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                quiz.setQuiz_Duration(input.nextInt());
                course.addAssignedQuiz(quiz);
                break;
            case 3:
                //add Midterm
                MidtermExam midtermExam = new MidtermExam();
                System.out.print("Title: ");
                midtermExam.setTitle(input.next());
                System.out.print("Date: ");
                midtermExam.setDate(input.next());
                System.out.print("Mark: ");
                midtermExam.setMax_score(input.nextInt());
                System.out.print("Duration: ");
                midtermExam.setExam_Duration(input.nextInt());
                System.out.println("Location: ");
                midtermExam.setExam_Location(input.next());
                course.addAssignedMidterm(midtermExam);
                break;
            case 4:
                //add Final
                FinalExam finalExam = new FinalExam();
                System.out.print("Title: ");
                finalExam.setTitle(input.next());
                System.out.print("Date: ");
                finalExam.setDate(input.next());
                System.out.print("Mark: ");
                finalExam.setMax_score(input.nextInt());
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
        for (Student student : students) {
            if (student.getID() == student_ID) {
                break;
            }
            j++;
        }
        student_ID = j;
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
    }
    public void generateAttrepforallstud() {
        for(Student student:students){
        generateAttRepForIndStud(student.getID());
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

   private void findindexs(int[] index){}
}

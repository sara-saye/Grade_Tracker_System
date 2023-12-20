import java.time.Duration;
import java.util.ArrayList;


public class Notification {
    private boolean New_grade;
    private boolean attendance;
    private double gpa;

    public boolean isNew_grade() {
        return New_grade;
    }

    public void setNew_grade(boolean new_grade) {
        New_grade = new_grade;
    }


    public void addStatueOfGrade(boolean new_grade) //>>I get it from Grades class
    {
        this.New_grade = new_grade;
    }

    public void addAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public void addGpa(double gpa) {
        this.gpa = gpa;
    }

    public void Display_Notification(ArrayList<Course> course) {
        if (!course.isEmpty()) {
            for (int i = 0; i < course.size(); i++) {
                System.out.println(course.get(i).courseTitle);
                System.out.print("Your Assignments:");
                if (!course.get(i).assignedAssignment.isEmpty()) {
                    for (int j = 0; j < course.get(i).assignedAssignment.size(); j++) {
                        System.out.println(course.get(i).assignedAssignment.get(j).getTitle());
                        System.out.println("Start Date: " + course.get(i).assignedAssignment.get(j).getAssignment_startDate());
                        System.out.println("Deadline: " + course.get(i).assignedAssignment.get(j).getAssignment_Deadline());
                        Duration diff = Duration.between(course.get(i).assignedAssignment.get(j).getAssignment_startDate().atStartOfDay(), course.get(i).assignedAssignment.get(j).getAssignment_Deadline().atStartOfDay());
                        long diffDays = diff.toDays();
                        System.out.println("Assignment ends at " + diffDays + " days");
                    }
                } else {
                    System.out.println("No Assignments");
                }
            }
        }
        System.out.println("-----------------------------------");
        if (!course.isEmpty()) {
            System.out.print("Your Quizzes:");
            for (int i = 0; i < course.size(); i++) {
                if (!course.get(i).assignedQuiz.isEmpty()) {
                    for (int j = 0; j < course.get(i).assignedQuiz.size(); j++) {
                        System.out.println(course.get(i).assignedQuiz.get(j).getTitle() + " " + course.get(i).assignedQuiz.get(j).getDate());
                    }
                } else {
                    System.out.println("No Quizzes");
                }
            }
        }
        System.out.println("-----------------------------------");
        if (!course.isEmpty()) {
            System.out.print("Your Midterms:");
            for (int i = 0; i < course.size(); i++) {
                if (course.get(i).assignedMidterm.getID() != 0)
                    System.out.println(course.get(i).assignedMidterm.getTitle() + " " + course.get(i).assignedMidterm.getDate());
                else
                    System.out.println("No Midterms");
            }
        }
        System.out.println("-----------------------------------");
        if (!course.isEmpty()) {
            System.out.print("Your Finals:");
            for (int i = 0; i < course.size(); i++) {
                if (course.get(i).assignedfinal.getID() != 0)
                    System.out.println(course.get(i).assignedfinal.getTitle() + " " + course.get(i).assignedfinal.getDate());
                else
                    System.out.println("No Finals");
            }
        }
        System.out.println("-----------------------------------");
        if (this.New_grade) {
            System.out.println("Your grades have been updated!");
            this.New_grade = false;
        }
        System.out.println("-----------------------------------");
        if (attendance) {
            System.out.println("You have an attendance warning, please be aware to attend the remaining sessions");
            this.attendance = false;
        }
        System.out.println("-----------------------------------");
        if (this.gpa <= 1.5 && this.gpa != -1) {
            System.out.println("Be aware that your gpa is lower than 1.5, Please note that if gpa reached lower than 1 then you will be droped!");
        }
        System.out.println("-----------------------------------");
        if (Admin.eventDetails != null) {
            System.out.println("Events:");
            System.out.println(Admin.eventDetails);
        }
    }


    public void dropGPAStudent(int studentID) {
        for (int studentIndex = 0; studentIndex < Main.students.size(); studentIndex++) {
            if (studentID == Main.students.get(studentIndex).getID()) {
                if (Main.students.get(studentIndex).getGPA() < 1) {
                    Main.students.get(studentID).setGpaDrop(true);
                }
            }
        }
    }
}
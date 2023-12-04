import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
       /* int studentNo = 0, instructorNo = 0;

        Student  [] students = new Student[100];
        Instructor [] instructors = new Instructor[100];

        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {

            Form.LogIn(students,instructors,studentNo,instructorNo);

        } else if (account == 2) {
            int who;
            do {
                System.out.println("Register as : ");
                System.out.println("1- Instructor");
                System.out.println("2- Student");
                who = input.nextInt();
                if(who==1||who==2)
                    break;
                System.out.println("Invalid Choice!Try Again.");
            }while (true);
            if(who==1)
                studentNo++;
            else
                instructorNo++;

            Form.Registration(who,students,instructors,studentNo,instructorNo);

        } else {

        }*/
        //test case for Instructor skip
        String n=input.next(),l=input.next(),off=input.next(),dep=input.next();
        int num=input.nextInt();
        Instructor instructor= new Instructor(n,l,off,dep,num);
        instructorMenu(instructor);
    }
    public static void instructorMenu(Instructor instructor){
        System.out.println("1-Show your information\n2-Edit your information");
        System.out.println("3-View students\n4-Assign Assessment");
        System.out.println("5-Mark attendance\n6-Input students Grades");
        System.out.println("7-Make report for attendance specific student");
        System.out.println("8-Make report for attendance all students");
        System.out.println("Enter your choice");
        int choice = input.nextInt();
        selectInstrMenu(choice,instructor);
    }
    public static void selectInstrMenu(int x,Instructor instructor){
        switch (x){
            case 1:
                instructor.display();
                break;
            case 2:
                instructor.editInfo();
                instructor.display();
                break;
            case 3:
                instructor.viewEnrolledStudents();
                break;
            case 4:
                instructor.setAssessmentsToCourse();
                break;
            case 5:
                instructor.trackAttenForoneSection();
                break;
            case 6:
                instructor.inputGrades();
                break;
            case 7:
              //  instructor.generateAttRepForIndStud();
                break;
            case 8:
                instructor.generateAttrepforallstud();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
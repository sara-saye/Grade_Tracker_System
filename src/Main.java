import java.util.Scanner;

public class Main {
   static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
       int studentNo = 0, instructorNo = 0;

        Student  [] students = new Student[100];

        Scanner input = new Scanner(System.in);

        System.out.println("Already have an account?");
        System.out.println("1- Yes");
        System.out.println("2- No\n");
        int account = input.nextInt();

        if (account == 1) {

                LogIn();

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

            Registration(who,students,studentNo,instructorNo);

        } else {

        }
        //test case for Instructor skip
        /*String n=input.next(),l=input.next(),off=input.next(),dep=input.next();
        int num=input.nextInt();
        Instructor ss= new Instructor(n,l,off,dep,num);
        instructorMenu(ss);*/
    }
    public static void instructorMenu(Instructor ss){
        System.out.println("1-Show your information\n2-Edit your information");
        System.out.println("3-View students\n4-Assign Assessment");
        System.out.println("5-Mark attendance\n6-Input students Grades");
        System.out.println("7-Create assessment\n8-Set specific deadline");
        System.out.println("9-Make report for attendance specific student");
        System.out.println("10-Make report for attendance all students");
        System.out.println("Enter your choice");
        int choice = input.nextInt();
        selectInstrMenu(choice,ss);
    }
    public static void selectInstrMenu(int x,Instructor ss){
        switch (x){
            case 1:
                ss.display();
                break;
            case 2:
                ss.editInfo();
                ss.display();
                break;
        }
    }
    public static void LogIn() {

        Scanner input = new Scanner(System.in);
        int who=0;

        System.out.println("Username : ");
        String UserName = input.next();

        System.out.println("Password : ");
        String Password = input.next();

        if(UserName.contains("@Admin")){
            who=1;
        } else if (UserName.contains("@Instructor")) {
            who=2;
        } else if (UserName.contains("@Student")) {
            who=3;
        }
        else{
            //invalid state
        }
        System.out.println(who);

    }

    public static void Registration(int who,Student [] students,int studentNo,int instructorNo) {

        Scanner input = new Scanner(System.in);

        System.out.println("Email : ");
        String Email = input.next();

        System.out.println("Username : ");
        String UserName = input.next();

        System.out.println("Password : ");
        String Password = input.next();

        if(who==1) {
            Instructor instructor = new Instructor();
            instructor.setEmail(Email);
            instructor.setUsername(UserName+"@Instructor");
            instructor.setPassword(Password);

        } else if(who==2){
            studentNo++;
            Student student = new Student();
            student.setEmail(Email);
            student.setUsername(UserName+"@Student");
            student.setPassword(Password);
            students[studentNo] = student;
        }
    }

    public static void LogOut() {

    }

}
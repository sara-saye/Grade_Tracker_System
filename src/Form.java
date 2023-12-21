
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class Form {
        static  Scanner input = new Scanner(System.in);
        public static ArrayList LogIn(ArrayList<Student>students, ArrayList<Instructor> instructors) {

            ArrayList login = new ArrayList();
            String who="noOne";
            int index = 0;

            System.out.println("Username : ");
            String UserName = input.next();
            String IUserName = UserName;
            String SUserName=IUserName;
            IUserName+="@Instructor";
            SUserName+="@Student";

            System.out.println("Password : ");
            String Password = input.next();

            if(UserName.equalsIgnoreCase("Admin2023")&&Password.equals("2023"))
                who="Admin";

            for (int i=0;i<instructors.size();i++) {
                if(instructors.get(i).getUsername().equals(IUserName)){
                    if(instructors.get(i).getPassword().equals(Password)){
                        who="Instructor";
                        index=i;
                    }
                }
            }
            for (int i =0;i<students.size();i++) {
                if(students.get(i).getUsername().equals(SUserName)){
                    if(students.get(i).getPassword().equals(Password)){
                        who="Student";
                        index=i;
                    }
                }
            }

            if(who .equals("noOne")){
                System.out.println("Wrong User Name Or Password!Try Again.");
            }else {
                System.out.println("\nLogged In Successfully");
            }
            login.add(who);
            login.add(index);
            return login;
        }

        public static int Registration(int who,ArrayList<Student>students, ArrayList<Instructor> instructors, int studentId, int instructorId) throws IOException {

            boolean found;
            String UserName;
            int index = 0;

            System.out.println("Email : ");
            String Email = input.next();

            do {
                System.out.println("Username : "); // check if username exist
                UserName = input.next();
                if (who == 1) {
                    found = CheckInstructorUsername(instructors, UserName);
                } else {
                    found = CheckStudentUsername(students, UserName);
                }
                if (found) {
                    System.out.println("User Name Already exists.Try another one");
                }
            }while (found);

            System.out.println("Password : ");
            String Password = input.next();

            System.out.println("Your first name: ");
            String Fname = input.next();

            System.out.println("Your Last name: ");
            String Lname = input.next();

            System.out.println("Phone Number : ");
            String PhoneNo = input.next();
           
            if(who==1) {
                Instructor instructor = new Instructor(instructorId,Fname,Lname,Email,UserName+"@Instructor",Password,PhoneNo);
                instructor.forSignUp();
                instructors.add(instructor);
               index= Main.instructors.size()-1;
            } else if(who==2){
                Student student = new Student(studentId,Fname,Lname,Email,UserName+"@Student",Password,PhoneNo);
                student.Register();
                students.add(student);
                index =Main.students.size()-1;
            }
            return index;
        }

        public static boolean CheckInstructorUsername(ArrayList<Instructor> instructors, String UserName){
            for (Instructor instructor:instructors) {
                if(instructor.getUsername().replaceAll("@Instructor","").equals(UserName)){
                    return true;
                }
            }
            return false;
        }

        public static boolean CheckStudentUsername(ArrayList<Student> students, String UserName){
            for (Student student:students) {
                if(student.getUsername().replaceAll("@Student","").equals(UserName)){
                    return true;
                }
            }
            return false;
        }

    }
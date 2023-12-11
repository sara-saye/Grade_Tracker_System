
    import java.util.ArrayList;
    import java.util.Scanner;

    public class Form {
        public static String LogIn(ArrayList<Student>students, ArrayList<Instructor> instructors) {

            Scanner input = new Scanner(System.in);
            String who=null;

            System.out.println("Username : ");
            String IUserName = input.next();
            String SUserName=IUserName;
            IUserName+="@Instructor";
            SUserName+="@Student";
            System.out.println(IUserName);
            System.out.println(SUserName);

            System.out.println("Password : ");
            String Password = input.next();

            for (Instructor instructor:instructors) {
                if(instructor.getUsername().equals(IUserName)){
                  if(instructor.getPassword().equals(Password)){
                      who="Instructor";
                  }
                }
            }
            for (Student student:students) {
                if(student.getUsername().equals(SUserName)){
                    if(student.getPassword().equals(Password)){
                        who="Student";
                    }
                }
            }
            if(who == null){
                System.out.println("Wrong User Name Or Password!Try Again.");
                LogIn(students,instructors);
            }else {
                System.out.println("Logged In Successfully");
            }
            return who;
        }

        public static void Registration(int who,ArrayList<Student>students, ArrayList<Instructor> instructors, int studentId, int instructorId) {

            Scanner input = new Scanner(System.in);
            boolean found;
            String UserName;

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
                if (found == true) {
                    System.out.println("User Name Already exists.Try another one");
                }
            }while (found==true);

            System.out.println("Password : ");
            String Password = input.next();

            System.out.println("Phone Number : ");
            String PhoneNo = input.next();

            if(who==1) {
                Instructor instructor = new Instructor();
//                instructor.forSignUp();
                instructor.setEmail(Email);
                instructor.setUsername(UserName+"@Instructor");
                instructor.setPassword(Password);
                instructor.setPhoneNumber(PhoneNo);
                //instructor.setID(instructorNo);
                instructors.add(instructor);
            } else if(who==2){
                Student student = new Student();
                student.setEmail(Email);
                student.setUsername(UserName+"@Student");
                student.setPassword(Password);
                student.setID(studentId);
                student.setPhoneNumber(PhoneNo);
                students.add(student);
            }
        }

        public static void LogOut() {

        }

        public static boolean CheckInstructorUsername(ArrayList<Instructor> instructors, String UserName){
            for (Instructor instructor:instructors) {
                if(instructor.getUsername().equals(UserName)){
                    return true;
                }
            }
            return false;
        }

        public static boolean CheckStudentUsername(ArrayList<Student> students, String UserName){
            for (Student student:students) {
                if(student.getUsername().equals(UserName)){
                    return true;
                }
            }
            return false;
        }

    }

    import java.util.ArrayList;
    import java.util.Scanner;

    public class Form {
        public static ArrayList LogIn(ArrayList<Student>students, ArrayList<Instructor> instructors) {

            ArrayList login = new ArrayList();
            Scanner input = new Scanner(System.in);
            String who=null;
            int ID = 0;

            System.out.println("Username : ");
            String UserName = input.next();
            String IUserName = UserName;
            String SUserName=IUserName;
            IUserName+="@Instructor";
            SUserName+="@Student";

            System.out.println("Password : ");
            String Password = input.next();

            if(UserName.equals("Admin2023")&&Password.equals("88888888"))
                who="Admin";

            for (Instructor instructor:instructors) {
                if(instructor.getUsername().equals(IUserName)){
                    if(instructor.getPassword().equals(Password)){
                        who="Instructor";
                        ID=instructor.getID();
                    }
                }
            }
            for (Student student:students) {
                if(student.getUsername().equals(SUserName)){
                    if(student.getPassword().equals(Password)){
                        who="Student";
                        ID=student.getID();
                    }
                }
            }

            if(who == null){
                System.out.println("Wrong User Name Or Password!Try Again.");
                LogIn(students,instructors);
            }else {
                System.out.println("Logged In Successfully");
            }
            login.add(who);
            login.add(ID);
            return login;
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

            System.out.println("Your first name: ");
            String Fname = input.next();

            System.out.println("Your Last name: ");
            String Lname = input.next();

            System.out.println("Phone Number : ");
            String PhoneNo = input.next();

            if(who==1) {
                Instructor instructor = new Instructor();
                instructor.forSignUp();
                instructor.setEmail(Email);
                instructor.setUsername(UserName+"@Instructor");
                instructor.setPassword(Password);
                instructor.setPhoneNumber(PhoneNo);
                instructor.setFname(Fname);
                instructor.setLname(Lname);
                instructor.setID(instructorId);
                instructors.add(instructor);
            } else if(who==2){
                Student student = new Student();
                student.setEmail(Email);
                student.setUsername(UserName+"@Student");
                student.setPassword(Password);
                student.setID(studentId);
                student.setPhoneNumber(PhoneNo);
                student.setFname(Fname);
                student.setLname(Lname);
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

    import java.util.Scanner;

    public class Form {
        public static void LogIn(Student []students,Instructor []instructors,int studentNo,int instructorNo) {

            Scanner input = new Scanner(System.in);
            int who=0;

            System.out.println("Username : ");
            String UserName = input.next();

            System.out.println("Password : ");
            String Password = input.next();

        }

        public static void Registration(int who,Student [] students,Instructor [] instructors,int studentNo,int instructorNo) {

            Scanner input = new Scanner(System.in);

            System.out.println("Email : ");
            String Email = input.next();

            System.out.println("Username : "); // check if username exist
            String UserName = input.next();

            System.out.println("Password : ");
            String Password = input.next();

            System.out.println("Phone Number : ");
            String PhoneNo = input.next();

            if(who==1) {
                Instructor instructor = new Instructor();
                instructor.setEmail(Email);
                instructor.setUsername(UserName+"@Instructor");
                instructor.setPassword(Password);
                instructor.setPhoneNumber(PhoneNo);
                //instructor.setID(instructorNo);
                instructor.forSignUp();
                instructors[instructorNo] = instructor;
                instructorNo++;
            } else if(who==2){
                Student student = new Student();
                student.setEmail(Email);
                student.setUsername(UserName+"@Student");
                student.setPassword(Password);
                student.setID(studentNo);
                students[studentNo] = student;
                studentNo++;
            }
        }

        public static void LogOut() {

        }

    }


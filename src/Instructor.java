import java.util.Scanner;

public class Instructor extends Person{
    Scanner input = new Scanner(System.in);
    private String office_location, department;
    private int numOfSections = 0;
    public static int instructor_ID = 202212000;
    Student students[] = new Student[100];
    public Instructor(){}
    public Instructor(String F, String L, String OFFL, String dep, int ns){
        super(F,L);
        this.office_location = OFFL;
        this.department = dep;
        this.numOfSections = ns;
        this.ID = instructor_ID;
        instructor_ID++;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Department: " + this.department);
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
    public int getNumOfSections() {
        return numOfSections;
    }
    public void setNumOfSections(int numOfSections) {
        this.numOfSections = numOfSections;
    }
    public void editInfo(){
        System.out.println("Select what you want change");
        System.out.println("1-Name\n2-Email\n3-Username or Password");
        System.out.println("4-Office location\n5-Department\n6-Number of Sections");
        int choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter new first and last name");
                this.Fname = input.next();
                this.Lname = input.next();
                break;
            case 2:
                System.out.println("Enter new Email");
                String s = input.next();
                this.setEmail(s);
                break;
            case 3:
                System.out.println("Enter your current username and password");
                String t1 = input.next(),t2=input.next();
                if(this.getUsername().equals(t1)&&this.getPassword().equals(t2)){
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
            case 6:
                System.out.println("Enter number of sections");
                this.numOfSections = input.nextInt();
                break;
        }
    }
}

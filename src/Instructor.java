public class Instructor extends Person{
    private String office_location, department;
    private int numOfSections = 0;
    public static int instructorID = 202212000;
    Student students[] = new Student[100];
    public Instructor(){}
    public Instructor(String F, String L, String OFFL, String dep, int ns){
        super(F,L);
        this.office_location = OFFL;
        this.department = dep;
        this.numOfSections = ns;
        this.ID = instructorID;
        instructorID++;
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
}

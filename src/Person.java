public abstract class Person {
    private String Fname, Lname;
    private int ID;
    private String email, Username, password;
    private String PhoneNumber;
    //add phone number
    public Person(){
        this.Fname = "unknown";
        this.Lname = "unknown";
        this.ID = 0;
    }
    public Person(String Fname, String Lname) {
        this.Fname = Fname;
        this.Lname = Lname;
    }
    public void display(){
        System.out.println("Name: " + this.Fname + " " + this.Lname);
        System.out.println("ID: " + this.ID);
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return Username;
    }
    public String getFname() {
        return Fname;
    }
    public void setFname(String fname) {
        Fname = fname;
    }
    public String getLname() {
        return Lname;
    }
    public void setLname(String lname) {
        Lname = lname;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() { return PhoneNumber; }
    public void setPhoneNumber(String phoneNumber) {PhoneNumber = phoneNumber;}
}

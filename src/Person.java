public abstract class Person {
    private String Fname, Lname;
    private int ID;
    private String email, Username, password;
    public String PhoneNumber;
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
    public Person(int ID,String Fname, String Lname,String email,String password,String PhoneNumber) {

        this(Fname,Lname);
        this.ID=ID;
        this.email=email;
        this.password=password;
        this.PhoneNumber=PhoneNumber;
    }

    public Person(int ID,String Fname, String Lname,String email,String username,String password,String PhoneNumber) {

        this(Fname,Lname);
        this.ID=ID;
        this.Username=username;
        this.email=email;
        this.password=password;
        this.PhoneNumber=PhoneNumber;
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
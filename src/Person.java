public abstract class Person {
    public String Fname, Lname;
    public int ID;
    private String email, Username, password;
    public Person(){
        this.Fname = "unknown";
        this.Lname = "unknown";
        this.ID = 0;
    }
    public Person(String Fname, String Lname, int ID) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.ID = ID;
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
    public String getPassword() {
        return password;
    }
}

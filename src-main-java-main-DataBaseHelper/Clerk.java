package main;
public class Clerk {

    private int Clerk_id;
    private String firstname;
    private String lastname;
    private int contactNumber;
    private String email;

    public Clerk() {}

    public Clerk(int Clerk_id, String firstname, String lastname, int contactNumber, String email) {
        this.Clerk_id = Clerk_id;
        this.firstname = firstname;
        this.contactNumber = contactNumber;
        this.lastname = lastname;
        this.email = email;
    }

    public int getClerk_id() { return Clerk_id; }

    public void setClerk_id(int Clerk_id ) { this.Clerk_id = Clerk_id; }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                ", Clerk_id=" + Clerk_id +
                ", firstname=" + firstname +
                ", lastname=" + lastname +
                ", contactNumber='" + contactNumber + '\'' +
                ", email=" + email +
                '}';
    }
}

package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Clerk {
    @DatabaseField(generatedId = true, columnName = "Clerk_id")
    private int Clerk_id;
    @DatabaseField(canBeNull = false, unique = false, columnName = "firstname")
    private String firstname;
    @DatabaseField(canBeNull = false, unique = false, columnName = "lastname")
    private String lastname;
    @DatabaseField(canBeNull = true, unique = false, columnName = "contactNumber")
    private int contactNumber;
    @DatabaseField(canBeNull = true, unique = false, columnName = "email")
    private String email;

    public Clerk(){
        //empty constructor, required by ORMLite
    }
    public Clerk(int Clerk_id, String firstname, String lastname, int contactNumber, String email) {
        this.Clerk_id = Clerk_id;
        this.firstname = firstname;
        this.contactNumber = contactNumber;
        this.lastname = lastname;
        this.email = email;
    }


    public int getClerk_id() {
        return Clerk_id;
    }

    public void setClerk_id(int clerk_id) {
        Clerk_id = clerk_id;
    }

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

    /*public int save(Repo repo)
    {
        if(repo.Users.getByUsername(username) == null)
        {
            return repo.Users.create(this);
        }
        else
        {
            return repo.Users.update(this);
        }
    }

    public int delete(Repo repo)
    {
        return repo.Users.delete(this);
    }*/

    @Override
    public String toString() {
        return "BillOfMaterials{" +
                "Clerk_id='" + Clerk_id + '\'' +
                ", firstname=" + firstname +
                ", contactNumber='" + contactNumber + '\'' +
                ", lastname=" + lastname +
                ", email=" + email +
                '}';
    }
}

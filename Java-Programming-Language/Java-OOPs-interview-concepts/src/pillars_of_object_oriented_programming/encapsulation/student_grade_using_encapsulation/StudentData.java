package pillars_of_object_oriented_programming.encapsulation.student_grade_using_encapsulation;

public class StudentData {
    // protected access modifier because I only want to use this to its subclass.
    protected String firstName;
    protected String lastName;
    protected String email;

    // Here we are not create a parametrized constructor because we use getter and setter for data access.
    // public access modifier because we need to use the getter and setter where ever the proepties of this class needed
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

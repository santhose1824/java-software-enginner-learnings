package relationship_and_behavior.association.one_to_one;

// One class(Student) uses other object(Passport) where the other class(Passport) doesn't care about who owns it.
class Passport{
    private int passportNumber;

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getPassportNumber() {
        return passportNumber;
    }
}


class Student{
    private String name;
    private Passport passport;

    public Student(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }


    public void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Passport Number: " + this.passport.getPassportNumber());
    }

}



public class OneToOne {
    public static void main(String[] args) {
        Passport passport = new Passport(135546674);
        Student student = new Student("Santhose", passport);
        student.displayDetails();
    }
}

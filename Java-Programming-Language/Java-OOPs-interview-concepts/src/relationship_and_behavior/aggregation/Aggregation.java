package relationship_and_behavior.aggregation;


// Here the class passport is not depend on the Student it gets object from somewhere else,
// also if the student object is deleted still the passport object is in memory.
// This type of weak relationship is called aggregation.

class Passport{
    private int passportNumber;

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getPassportNumber() {
        return passportNumber;
    }
}


class Student {
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

public class Aggregation {
    public static void main(String[] args) {
        Passport passport = new Passport(135546674);
        Student student = new Student("Santhose", passport);
        student.displayDetails();
    }        
}


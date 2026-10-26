package relationship_and_behavior.composition;

// Here the class passport is depending on the Student it gets object while creating Student class object else,
// If the student object is deleted  the passport object is also deleted.
// This type of strong relationship is called composition.
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

    public Student(String name,int passportNumber) {
        this.name = name;
        this.passport = new Passport(passportNumber);
    }


    public void displayDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Passport Number: " + passport.getPassportNumber());
    }

}



public class Composition {
    public static void main(String[] args) {
        Student student = new Student("Santhose", 135546674);
        student.displayDetails();
    }
}

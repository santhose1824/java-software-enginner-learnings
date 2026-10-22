package pillars_of_object_oriented_programming.encapsulation.access_modifiers;

public class Main {
    public static void main(String[] args) {
        AccessModifiers accessModifiers = new AccessModifiers(10,"Santhose");

        // Here we can't directly able to access the num from AccessModifiers because it is private.
        // private - only accessed by within the same file.
        // So we use getters and setters to access it
        // So as the concept of the encapsulation we're restricting the direct access of the data/properties of class.

        accessModifiers.setNum(35);
        System.out.println(accessModifiers.getNum());
    }
}

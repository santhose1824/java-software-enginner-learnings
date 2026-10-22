package pillars_of_object_oriented_programming.encapsulation.student_grade_using_encapsulation;

public class Main {
    public static void main(String[] args) {
        StudentMarks studentMarks = new StudentMarks();

        // Here we are achieving the encapsulation.
        // We are not directly access the properties or methods of the StudentMarks Class or StudentData Class
        // We just set the values with help of setter methods and inheritance for set the studentData
        // Then we set the marks for StudentMarks Class via setter method and calculate the grade inside the Class
        // And then just send the result in the toString() with the help of overriding concept.
        studentMarks.setFirstName("Santhose");
        studentMarks.setLastName("H.M");
        studentMarks.setEmail("santhose@h.m");
        studentMarks.setMarks(85.6);

        System.out.println(studentMarks.toString());
    }
}

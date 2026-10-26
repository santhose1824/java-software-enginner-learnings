package relationship_and_behavior.association.many_to_many;


import java.util.ArrayList;
import java.util.List;
// Many to Many - Student class has list of Courses instance where Courses class has list of Student instance.
class Std{
    private String name;
    private List<Courses> courses;

    public Std(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Courses courses){
        this.courses.add(courses);
    }

    public String getName() {
        return name;
    }
}


class Courses{
    private String name;
    private List<Std> students;


    public Courses(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }


    public void addStudent(Std student){
        this.students.add(student);
    }

    public  String getCourseName(){
        return this.name;
    }
    public List<Std> getStudents(){
        return this.students;
    }

    public void displayStudentsByCourses(){
        for(Std student : students){
            System.out.println("Name : "+student.getName()+" is enrolled in "+this.name);
        }
    }


}


public class ManyToMany {
    public static void main(String[] args) {
        Std santhose = new Std("Santhose");
        Std hayagreevan = new Std("Hayagreevan");
        Std someone = new Std("Someone");

        Courses math = new Courses("Math");
        Courses english = new Courses("English");
        Courses french = new Courses("French");


        math.addStudent(santhose);
        math.addStudent(hayagreevan);
        math.addStudent(someone);

        english.addStudent(someone);
        english.addStudent(hayagreevan);
        english.addStudent(santhose);

        french.addStudent(someone);
        french.addStudent(hayagreevan);

        System.out.println("Students enrolled in Maths");
        math.displayStudentsByCourses();
        System.out.println("Students enrolled in English");
        english.displayStudentsByCourses();
        System.out.println("Students enrolled in French");
        french.displayStudentsByCourses();
    }
}

package relationship_and_behavior.association.one_to_many;


import java.util.ArrayList;
import java.util.List;

// One to Many The College object can have the list of objects of the Students class.

class College{
    private String name;
    List<Students> students;

    public College(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Students student){
        this.students.add(student);
    }

    public void printAllStudents(){
        System.out.println("College Name: " + this.name);
        for(Students student : students){
            System.out.println("Name : "+student.getName()+" Id : "+student.getId());
        }
    }
}


class Students {
    private String name;
    private int id;

    public Students(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
public class OneToMany {
    public static void main(String[] args) {
        Students student1 = new Students("Santhose", 1);
        Students student2 = new Students("Hayagreevan", 2);

        College college1 = new College("Madras Institute of Technology");


        college1.addStudent(student1);
        college1.addStudent(student2);

        college1.printAllStudents();
    }
}

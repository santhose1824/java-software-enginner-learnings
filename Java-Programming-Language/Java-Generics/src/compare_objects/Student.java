package compare_objects;

//implements Comparable<Student>
public class Student {
    int roll_no;
    float marks;

    public Student(int roll_no, float marks) {
        this.roll_no = roll_no;
        this.marks = marks;
    }

//    @Override
//    public int compareTo(Student student) {
//        // if both are equals return 0.
//        // if  < 1 student is bigger else student is smaller
//
//        return  (int)(this.marks - student.marks);
//    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", marks=" + marks +
                '}';
    }
}

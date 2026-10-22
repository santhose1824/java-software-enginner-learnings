package compare_objects;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student santhose = new Student(12,89.76f);
        Student hayagreevan = new Student(5,99.56f);
        Student student = new Student(4,96.56f);
        Student student1 = new Student(87,49.56f);
        Student student2 = new Student(13,69.56f);
        Student student3 = new Student(7,79.56f);


        Student [] students = {santhose,hayagreevan,student,student1,student2,student3};

        System.out.println(Arrays.toString(students));

        // It will sort based on the compareTo () what we used to compare.
        // Now it will sort based on the roll_no
        // We can write this in as lambda expressions
        Arrays.sort(students,(o1,o2)->(int)(o1.marks-o2.marks));
//                new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return (int)(o1.roll_no - o2.roll_no);
//            }
//        });

        System.out.println(Arrays.toString(students));

        // Here if we do like this it will show error which one is needs to compare roll_no or marks.
        // Inorder to do that we need to create Comparable
//        if(santhose.compareTo( hayagreevan) < 0){
//            System.out.println("Hayagreevan has more marks");
//        }
    }
}

import java.util.Arrays;

public class ArrayOfObjects {

    public static void main(String[] args) {

        // Array of Strings (objects)
        // The array object is somewhere in the heap; each element is a REFERENCE to a String object
        String[] strArray = new String[5];       // all elements are null at first
        System.out.println(Arrays.toString(strArray));

        String[] names = {"Santhosh", "Kumar", "Ravi", "Anu", "Meena"};
        for (int i = 0; i <= names.length - 1; i++) {
            System.out.println(i + " -> " + names[i]);
        }
        System.out.println(Arrays.toString(names));

        // Any element not yet assigned is null -> calling a method on it throws NullPointerException
        try {
            System.out.println(strArray[0].length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException - element is null until we assign an object");
        }

        // Array of custom objects
        Student[] students = new Student[2];
        students[0] = new Student("Santhosh", 64);
        students[1] = new Student("Kumar", 65);
        for (Student s : students) {
            System.out.println(s);
        }

        // Array of arrays (each inner array stored elsewhere in the heap)
        int[][] arr = { {1, 2}, {3, 4}, {5, 6} };
        System.out.println(Arrays.deepToString(arr));
    }

    static class Student {
        String name;
        int roll;

        Student(String name, int roll) {
            this.name = name;
            this.roll = roll;
        }

        @Override
        public String toString() {                 // without this we'd see Student@1b6d3586
            return "Student{name='" + name + "', roll=" + roll + "}";
        }
    }
}

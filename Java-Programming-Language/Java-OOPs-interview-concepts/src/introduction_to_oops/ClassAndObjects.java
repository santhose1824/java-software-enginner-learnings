package introduction_to_oops;

import java.util.Arrays;

public class ClassAndObjects {
    public static void main(String[] args) {
        // Want to store 5 roll nos
        int [] roll_nos = new int[5];

        // Want to store 5 names
        String[] names = new String[5];


        /* Now want to store both roll_nos and names
           like this StudentData student = rollno, name
           For that we use class
        */

        StudentData [] studentsData = new StudentData[5];

        // When we print the studentsData reference variable with the real object value.
        // [null, null, null, null, null]
        // Here this is array so that's why it shows null.
        System.out.println(Arrays.toString(studentsData));


        // When you print the student reference variable here it shows.
        // introduction_to_oops.StudentData@53d8d10a
        StudentData student = new StudentData();
        System.out.println(student);

        System.out.println("=====================================================");
        System.out.println("Before assign value");
        // By default, the int value is 0 so it prints 0
        System.out.println(student.rollNumber);

        // By default, the string value is null so it prints null
        System.out.println(student.studentName);
        student.greeting();
        System.out.println("=====================================================");

        // To assign values
        student.rollNumber = 39;
        student.studentName = "Santhose";

        System.out.println("=====================================================");
        // Now if you print this will print "Santhose" and 39;
        System.out.println("After assign value");
        System.out.println(student.studentName);
        System.out.println(student.rollNumber);
        student.greeting();
        System.out.println("=====================================================");

        System.out.println("=====================================================");
        student.changeName("Hayagreevan");
        System.out.println("After changing name");
        System.out.println(student.rollNumber);
        System.out.println(student.studentName);
        System.out.println("=====================================================");

        System.out.println("=====================================================");
        System.out.println("Paramter Constructor");
        StudentData studenDataOne = new StudentData(40,"Santhose");

        System.out.println(studenDataOne.studentName);
        System.out.println(studenDataOne.rollNumber);
        studenDataOne.changeName("Hayagreevan----");
        studenDataOne.greeting();
        System.out.println("=====================================================");

        System.out.println("Consructor with object as parameter");
        StudentData stdData = new StudentData(34,"Someone");
        StudentData studenDataTwo = new StudentData(stdData);
        System.out.println(studenDataTwo.studentName);
        System.out.println(studenDataTwo.rollNumber);
        studenDataTwo.changeName("Hayagreevan ***");
        System.out.println("=====================================================");


        System.out.println("Consructor inside another constructor");
        StudentData stdDetails  = new StudentData();
        System.out.println(stdDetails.studentName);
        System.out.println(stdDetails.rollNumber);

        // This tells that the change via refernce variable two will reflect on the refernce variable one
        StudentData one = new StudentData( 39, "Someone");
        System.out.println(one.studentName);
        System.out.println(one.rollNumber);
        StudentData two = one;
        two.studentName = "Something";
        System.out.println(two.studentName);
        System.out.println(two.rollNumber);
    }

}

class  StudentData{
    // We can give the default value here as well
    int rollNumber;
    String studentName;

    // we need a way to assign a value while creating the object.
    // that's were the constructor comes.

    // This will change the student name of the with the given name
    void changeName(String name){
        studentName = name;
    }

    // the studentName in the method is default Alex and Santhose after assigin value to it
    void greeting(){
        System.out.println("Hello My name is "+studentName);
    }

    // the values in this constructor is set before we assign any value to our object.
    // this is called as non-paramater constructor.
//    StudentData(){
//        // Here I want to do the below things
//
//       /*
//        student.rollNumber = 39;
//        student.studentName = "Santhose";
//        */
//
//        // So insted of using the object name we use "this" keyword.
//        // When we call the properties via object, the object name is replaced the this.
//
//        this.rollNumber = 20;
//        this.studentName = "Alex";
//    }

    // the above constructor has same values for every object we created
    // To avoid this we use paramter constructor

    StudentData(int roll,String name){
        // If we use both parameter name and property name then use this.
        this.rollNumber = roll;
        this.studentName = name;

        /*
            rollNumber = roll;
            studentName = name;
        */
    }

    // Constructor using object as argument
    StudentData(StudentData studentData  ){
        // here the keyword this replaced with studentDataTwo and the parameter studentData is replaced with stdData arugment.
        this.studentName = studentData.studentName;
        this.rollNumber = studentData.rollNumber;
    }

    // Calling one constructor with another

    StudentData(){
        //'StudentData()' is already defined in 'introduction_to_oops.StudentData'
        // Internally here this() == new Student();
        this(39,"default");
    }
}
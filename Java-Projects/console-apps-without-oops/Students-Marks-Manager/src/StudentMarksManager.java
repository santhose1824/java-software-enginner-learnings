import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMarksManager {

    static ArrayList<String> studentsName  = new ArrayList<>();
    static ArrayList<Double> studentMarksOne = new ArrayList<>();
    static ArrayList<Double> studentMarksTwo = new ArrayList<>();
    static ArrayList<Double> studentMarksThree = new ArrayList<>();
    static ArrayList<Double> totalOfEachStudentsMarks = new ArrayList<>();
    static ArrayList<Character> gradeOfEachStudent = new ArrayList<>();
    static ArrayList<String> resultOfEachStudent = new ArrayList<>();

    public static void addStudent(Scanner input) {
        input.nextLine();
        System.out.println("Enter the Student Name : ");
        String studentName = input.nextLine();
        System.out.println("Enter the Student Marks One : ");
        double studentMarkOne = input.nextDouble();
        studentMarkOne = Math.floor(studentMarkOne * 100) / 100;
        System.out.println("Enter the Student Marks Two : ");
        double studentMarkTwo = input.nextDouble();
        studentMarkTwo = Math.floor(studentMarkTwo * 100) / 100;
        System.out.println("Enter the Student Marks Three : ");
        double studentMarkThree = input.nextDouble();
        studentMarkThree = Math.floor(studentMarkThree * 100) / 100;
        studentsName.add(studentName);
        studentMarksOne.add(studentMarkOne);
        studentMarksTwo.add(studentMarkTwo);
        studentMarksThree.add(studentMarkThree);

        double totalMarks = studentMarkOne + studentMarkTwo + studentMarkThree;
        totalOfEachStudentsMarks.add(totalMarks);
        String tableFormat =  "%-20s %-10s %-10s %-10s %-10s%n";
        System.out.printf(tableFormat,"Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks");
        System.out.printf(tableFormat,studentName,studentMarkOne,studentMarkTwo,studentMarkThree,totalMarks);
        System.out.println();
    }


    public static void viewAllStudents(){
        gradeOfEachStudent.clear();
        resultOfEachStudent.clear();
        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";
        int j = 0;
        for(double num:totalOfEachStudentsMarks){
            double averageMarks = num / 3.0;

            if (averageMarks >= 90) {
                gradeOfEachStudent.add('A');
                resultOfEachStudent.add("Distinction");
            } else if (averageMarks >= 80) {
                gradeOfEachStudent.add('B');
                resultOfEachStudent.add("First Class");
            } else if (averageMarks >= 70) {
                gradeOfEachStudent.add('C');
                resultOfEachStudent.add("Second Class");
            } else if (averageMarks >= 60) {
                gradeOfEachStudent.add('D');
                resultOfEachStudent.add("Third Class");
            } else {
                gradeOfEachStudent.add('F');
                resultOfEachStudent.add("Failed");
            }
            j++;
        }
        System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks", "Grade" ,"Result");
        for(int i = 0; i < studentsName.size(); i++){
            System.out.printf(tableFormat,(i+1),studentsName.get(i),studentMarksOne.get(i),studentMarksTwo.get(i),studentMarksThree.get(i),totalOfEachStudentsMarks.get(i),gradeOfEachStudent.get(i),resultOfEachStudent.get(i));
        }
    }

    public static void searchStudentByName(Scanner input){
        input.nextLine();
        System.out.println("Enter the Student Name :");
        String studentName = input.nextLine();
        boolean found = false;
        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";
        for(int i = 0; i < studentsName.size(); i++){
            if(studentsName.get(i).equals(studentName)){
                found = true;
                System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks", "Grade" ,"Result");
                System.out.printf(tableFormat,(i+1),studentsName.get(i),studentMarksOne.get(i),studentMarksTwo.get(i),studentMarksThree.get(i),totalOfEachStudentsMarks.get(i),gradeOfEachStudent.get(i),resultOfEachStudent.get(i));
            }
        }
        if(!found){
            System.out.println("Student Name Not Found");
        }
    }

    public static void updateStudentMarks(Scanner input){
        input.nextLine();
        System.out.println("Enter Student Name : ");
        String studentName = input.nextLine();
        boolean found = false;
        for (String s : studentsName) {
            if (s.equals(studentName)) {
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student Name Not Found");
            return;
        }
        System.out.println("Which mark you want to change ? Mark One / Mark Two / Mark Three :");
        int markTracker = input.nextInt();
        double diff;
        double previousMark = 0;
        switch (markTracker){
            case 1 ->{
                System.out.println("Enter the Mark One : ");
                double markOne = input.nextDouble();
                for(int i = 0; i < studentsName.size(); i++){
                    if(studentsName.get(i).equals(studentName)){
                        previousMark = studentMarksOne.get(i);
                        studentMarksOne.set(i,markOne);
                    }

                    if(markOne > previousMark){
                        diff = markOne - previousMark;
                        double update = totalOfEachStudentsMarks.get(i) + diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }

                    }else if(markOne < previousMark){
                        diff = previousMark - markOne;
                        double update = totalOfEachStudentsMarks.get(i) - diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }
                    }
                }
            }
            case 2 ->{
                System.out.println("Enter the Mark Two : ");
                double markTwo = input.nextDouble();
                for(int i = 0; i < studentsName.size(); i++){
                    if(studentsName.get(i).equals(studentName)){
                        previousMark = studentMarksTwo.get(i);
                        studentMarksTwo.set(i,markTwo);
                    }

                    if(markTwo > previousMark){
                        diff = markTwo - previousMark;
                        double update = totalOfEachStudentsMarks.get(i) + diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }
                    }else if(markTwo < previousMark){
                        diff = previousMark - markTwo;
                        double update = totalOfEachStudentsMarks.get(i) - diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }
                    }
                }
            }
            case 3 ->{
                System.out.println("Enter the Mark Three : ");
                double markThree = input.nextDouble();
                for(int i = 0; i < studentsName.size(); i++){
                    if(studentsName.get(i).equals(studentName)){
                        previousMark = studentMarksThree.get(i);
                        studentMarksThree.set(i,markThree);
                    }

                    if(markThree > previousMark){
                        diff = markThree - previousMark;
                        double update = totalOfEachStudentsMarks.get(i) + diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }
                    }else if(markThree < previousMark){
                        diff = previousMark - markThree;
                        double update = totalOfEachStudentsMarks.get(i) - diff;
                        totalOfEachStudentsMarks.set(i,update);
                        double averageMarks = totalOfEachStudentsMarks.get(i) / 3.0;
                        if (averageMarks >= 90) {
                            gradeOfEachStudent.add('A');
                            resultOfEachStudent.add("Distinction");
                        } else if (averageMarks >= 80) {
                            gradeOfEachStudent.add('B');
                            resultOfEachStudent.add("First Class");
                        } else if (averageMarks >= 70) {
                            gradeOfEachStudent.add('C');
                            resultOfEachStudent.add("Second Class");
                        } else if (averageMarks >= 60) {
                            gradeOfEachStudent.add('D');
                            resultOfEachStudent.add("Third Class");
                        } else {
                            gradeOfEachStudent.add('F');
                            resultOfEachStudent.add("Failed");
                        }
                    }
                }
            }
        }

        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";
        for(int i = 0; i < studentsName.size(); i++){
            if(studentsName.get(i).equals(studentName)){
                System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks", "Grade" ,"Result");
                System.out.printf(tableFormat,(i+1),studentsName.get(i),studentMarksOne.get(i),studentMarksTwo.get(i),studentMarksThree.get(i),totalOfEachStudentsMarks.get(i),gradeOfEachStudent.get(i),resultOfEachStudent.get(i));
            }
        }


    }

    public static void deleteStudent(Scanner input ){
        input.nextLine();
        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";
        System.out.println("Enter Student Name : ");
        boolean found = false;
        String name = input.nextLine();
        for (String s : studentsName) {
            if (s.equals(name)) {
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("Student Not Found");
            return;
        }
        for(int i = 0; i < studentsName.size(); i++){
            if(studentsName.get(i).equals(name)){
              String stdName =  studentsName.remove(i);
              double markOne = studentMarksOne.remove(i);
              double markTwo = studentMarksTwo.remove(i);
              double markThree =studentMarksThree.remove(i);
              double totalMarks = totalOfEachStudentsMarks.remove(i);
              double grade = gradeOfEachStudent.remove(i);
              String result = resultOfEachStudent.remove(i);
              System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks","Grade","Result");
              System.out.printf(tableFormat,(i+1),stdName,markOne,markTwo,markThree,totalMarks,grade,result);
            }
        }
    }

    public static void showTopperAndAverageMarks(){
        int topperOfClass = 0;
        double averageOfTheClass = 0;
        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";

        for(int i = 0; i < studentsName.size(); i++){
            if(totalOfEachStudentsMarks.get(i) >  topperOfClass){
                topperOfClass = i;
            }
        }

        System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks", "Grade","Result");
        System.out.printf(tableFormat,(topperOfClass+1),studentsName.get(topperOfClass),studentMarksOne.get(topperOfClass),studentMarksTwo.get(topperOfClass),studentMarksThree.get(topperOfClass),totalOfEachStudentsMarks.get(topperOfClass),gradeOfEachStudent.get(topperOfClass),resultOfEachStudent.get(topperOfClass));


        for(int i = 0; i < studentsName.size(); i++){
            averageOfTheClass += totalOfEachStudentsMarks.get(i);
        }

        averageOfTheClass = (averageOfTheClass/totalOfEachStudentsMarks.size())/3;

        int passedStudentsCount  = 0;
        int failedStudentsCount = 0;
        for(String str : resultOfEachStudent){
            if(str  == "Failed"){
                failedStudentsCount++;
            }
        }

        passedStudentsCount = resultOfEachStudent.size() - failedStudentsCount;

        System.out.printf("Average Marks of the Whole Class is  : %.1f", averageOfTheClass);
        System.out.println();
        System.out.println("Total no. of passed students are : "+passedStudentsCount+".Total no.of failed students are : "+failedStudentsCount);
    }


    public static void sortByMarks(){
        int n = totalOfEachStudentsMarks.size();
        for(int i = n-1; i >= 0; i--){
            boolean isSwap = false;
            for(int j = 0; j <= i-1; j++){
                if(totalOfEachStudentsMarks.get(j) > totalOfEachStudentsMarks.get(j+1)){
                    double temp = totalOfEachStudentsMarks.get(j);
                    totalOfEachStudentsMarks.set(j, totalOfEachStudentsMarks.get(j+1));
                    totalOfEachStudentsMarks.set(j+1,temp);

                    String studentTemp = studentsName.get(j);
                    studentsName.set(j, studentsName.get(j+1));
                    studentsName.set(j+1,studentTemp);

                    double markOneTemp = studentMarksOne.get(j);
                    studentMarksOne.set(j, studentMarksOne.get(j+1));
                    studentMarksOne.set(j+1,markOneTemp);

                    double  markTwoTemp = studentMarksTwo.get(j);
                    studentMarksTwo.set(j, studentMarksTwo.get(j+1));
                    studentMarksTwo.set(j+1,markTwoTemp);

                    double  markThreeTemp = studentMarksThree.get(j);
                    studentMarksThree.set(j, studentMarksThree.get(j+1));
                    studentMarksThree.set(j+1,markThreeTemp);

                    char gradeTemp = gradeOfEachStudent.get(j);
                    gradeOfEachStudent.set(j, gradeOfEachStudent.get(j+1));
                    gradeOfEachStudent.set(j+1,gradeTemp);

                    String resultTemp = resultOfEachStudent.get(j);
                    resultOfEachStudent.set(j,resultOfEachStudent.get(j+1));
                    resultOfEachStudent.set(j+1,resultTemp);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }

        Collections.reverse(totalOfEachStudentsMarks);
        Collections.reverse(gradeOfEachStudent);
        Collections.reverse(resultOfEachStudent);
        Collections.reverse(studentsName);
        Collections.reverse(studentMarksOne);
        Collections.reverse(studentMarksTwo);
        Collections.reverse(studentMarksThree);

        String tableFormat =  "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";

        for(int i = 0; i < studentsName.size(); i++){
            System.out.printf(tableFormat, "S.NO","Student Name", "Mark One", "Mark Two", "Mark Three", "Total Marks", "Grade" ,"Result");
            System.out.printf(tableFormat, (i+1),studentsName.get(i), studentMarksOne.get(i), studentMarksTwo.get(i), studentMarksThree.get(i), totalOfEachStudentsMarks.get(i),gradeOfEachStudent.get(i),resultOfEachStudent.get(i));
        }


    }

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("========== STUDENT MARKS MANAGER ===========");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search student by name");
        System.out.println("4. Update Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Show Topper and Average Marks");
        System.out.println("7. Sort By Marks");
        System.out.println("8. Exit");
        System.out.println("=============================================");
        do {
            System.out.println("Enter your choice : ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> addStudent(input);
                case 2 -> viewAllStudents();
                case 3 -> searchStudentByName(input);
                case 4 -> updateStudentMarks(input);
                case 5 -> deleteStudent(input);
                case 6 -> showTopperAndAverageMarks();
                case 7 -> sortByMarks();
                case 8 -> System.out.println("Exit");
                default -> System.out.println("Invalid Choice");
            }


        } while (choice != 8);

    }
}

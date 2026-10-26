import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * ============================ STUDENT MARKS MANAGER ============================
 * Console app: add / view / search / update / delete students, find the topper and
 * class average, and sort by marks.
 *
 * CHANGE LOG (bugs found in the first version, and how this version fixes them)
 * ---------------------------------------------------------------------------
 *  BUG 1  update changed OTHER students' totals       -> fixed in updateStudentMarks()
 *  BUG 2  update used .add() on the grade/result lists -> grade/result lists removed
 *  BUG 3  grade/result only existed after "View All"   -> grade/result now calculated on demand
 *  BUG 4  topper compared a total with an INDEX        -> fixed in showTopperAndAverageMarks()
 *  BUG 5  str == "Failed" (reference comparison)       -> fixed (uses getGrade(), no String compare)
 *  BUG 6  Character remove() stored in a double        -> fixed in deleteStudent()
 *  BUG 7  sort printed the table header for every row  -> fixed in sortByMarks()
 *  BUG 8  same grade if/else block copy-pasted 8 times -> one getGrade() method
 *  BUG 9  search was case-sensitive, no validation     -> equalsIgnoreCase + input validation
 * ===============================================================================
 */
public class StudentMarksManagerBugFixed {

    // ------------------------------------------------------------------
    // DATA - parallel lists: the SAME index in every list = the SAME student.
    //
    // PREVIOUS CODE (two extra lists):
    //     static ArrayList<Character> gradeOfEachStudent = new ArrayList<>();
    //     static ArrayList<String> resultOfEachStudent = new ArrayList<>();
    // CAUSE OF BUG (BUG 2 and BUG 3): grade and result are DERIVED from the total, but they
    //     were stored in separate lists that had to be kept in sync by hand. They were only
    //     filled inside viewAllStudents(), so before "View All" they were empty
    //     (IndexOutOfBoundsException in search/delete/topper/sort), and update used .add()
    //     which appended new entries instead of replacing the old ones (lists went out of sync).
    // FIX: removed both lists. Grade/result are calculated from the total whenever needed
    //     (getGrade / getResult), so there is nothing to keep in sync.
    // ------------------------------------------------------------------
    static ArrayList<String> studentsName = new ArrayList<>();
    static ArrayList<Double> studentMarksOne = new ArrayList<>();
    static ArrayList<Double> studentMarksTwo = new ArrayList<>();
    static ArrayList<Double> studentMarksThree = new ArrayList<>();
    static ArrayList<Double> totalOfEachStudentsMarks = new ArrayList<>();

    // One table format used everywhere (previously this String was re-declared in every method)
    static final String TABLE_FORMAT = "%-10s %-20s %-12s %-12s %-12s %-12s %-10s %-20s%n";

    // ------------------------------------------------------------------
    // HELPER METHODS
    // ------------------------------------------------------------------

    // PREVIOUS CODE: this if / else if block was copy-pasted in viewAllStudents() and
    //     6 times inside updateStudentMarks() (BUG 8).
    // CAUSE: no reusable method - copy/paste makes every future change (e.g. a new grade
    //     boundary) need 8 edits, and one missed copy = wrong grades.
    // FIX: write it once.
    static char getGrade(double total) {
        double averageMarks = total / 3.0;          // 3 subjects
        if (averageMarks >= 90) return 'A';
        else if (averageMarks >= 80) return 'B';
        else if (averageMarks >= 70) return 'C';
        else if (averageMarks >= 60) return 'D';
        else return 'F';
    }

    static String getResult(char grade) {
        return switch (grade) {
            case 'A' -> "Distinction";
            case 'B' -> "First Class";
            case 'C' -> "Second Class";
            case 'D' -> "Third Class";
            default -> "Failed";
        };
    }

    static void printHeader() {
        System.out.printf(TABLE_FORMAT, "S.NO", "Student Name", "Mark One", "Mark Two",
                "Mark Three", "Total Marks", "Grade", "Result");
    }

    static void printRow(int i) {
        char grade = getGrade(totalOfEachStudentsMarks.get(i));
        System.out.printf(TABLE_FORMAT, (i + 1), studentsName.get(i), studentMarksOne.get(i),
                studentMarksTwo.get(i), studentMarksThree.get(i),
                totalOfEachStudentsMarks.get(i), grade, getResult(grade));
    }

    // PREVIOUS CODE (BUG 9): studentsName.get(i).equals(studentName)
    // CAUSE: equals() is case-sensitive, so "anu" could not find "Anu".
    // FIX: equalsIgnoreCase + one shared search method (also removes the repeated search loops
    //      that existed in search / update / delete). Returns -1 when not found.
    static int findStudentIndex(String name) {
        for (int i = 0; i < studentsName.size(); i++) {
            if (studentsName.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    // BUG 9 (validation): the previous version accepted any number (e.g. 500 or -20) and
    // crashed with InputMismatchException when text was typed.
    static double readMark(Scanner input, String label) {
        while (true) {
            System.out.println("Enter the Student " + label + " (0 - 100) : ");
            if (!input.hasNextDouble()) {
                input.next();                                   // throw away the bad text
                System.out.println("Please enter a number.");
                continue;
            }
            double mark = input.nextDouble();
            if (mark < 0 || mark > 100) {
                System.out.println("Marks must be between 0 and 100.");
                continue;
            }
            return Math.floor(mark * 100) / 100;                // keep 2 decimals (same as before)
        }
    }

    // swap the student at positions a and b in EVERY list (keeps parallel lists in sync)
    static void swapStudents(int a, int b) {
        Collections.swap(studentsName, a, b);
        Collections.swap(studentMarksOne, a, b);
        Collections.swap(studentMarksTwo, a, b);
        Collections.swap(studentMarksThree, a, b);
        Collections.swap(totalOfEachStudentsMarks, a, b);
    }

    // ------------------------------------------------------------------
    // 1. ADD
    // ------------------------------------------------------------------
    public static void addStudent(Scanner input) {
        input.nextLine();                                       // consume leftover newline from nextInt()
        System.out.println("Enter the Student Name : ");
        String studentName = input.nextLine().trim();
        if (studentName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (findStudentIndex(studentName) != -1) {              // NEW: no duplicate names
            System.out.println("Student already exists.");
            return;
        }
        double studentMarkOne = readMark(input, "Marks One");
        double studentMarkTwo = readMark(input, "Marks Two");
        double studentMarkThree = readMark(input, "Marks Three");

        studentsName.add(studentName);
        studentMarksOne.add(studentMarkOne);
        studentMarksTwo.add(studentMarkTwo);
        studentMarksThree.add(studentMarkThree);
        totalOfEachStudentsMarks.add(studentMarkOne + studentMarkTwo + studentMarkThree);

        System.out.println("Student added:");
        printHeader();
        printRow(studentsName.size() - 1);
        System.out.println();
    }

    // ------------------------------------------------------------------
    // 2. VIEW ALL
    // PREVIOUS CODE: this method also calculated + stored every grade/result
    //     (gradeOfEachStudent.clear(); ... .add('A') ...; an unused int j++).
    // CAUSE: a "view" method was doing the work of "calculate", and other features depended
    //     on the user pressing option 2 first (BUG 3).
    // FIX: viewing only prints; grade comes from getGrade().
    // ------------------------------------------------------------------
    public static void viewAllStudents() {
        if (studentsName.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        printHeader();
        for (int i = 0; i < studentsName.size(); i++) {
            printRow(i);
        }
    }

    // ------------------------------------------------------------------
    // 3. SEARCH
    // ------------------------------------------------------------------
    public static void searchStudentByName(Scanner input) {
        input.nextLine();
        System.out.println("Enter the Student Name :");
        String studentName = input.nextLine().trim();
        int index = findStudentIndex(studentName);
        if (index == -1) {
            System.out.println("Student Name Not Found");
            return;
        }
        printHeader();
        printRow(index);
    }

    // ------------------------------------------------------------------
    // 4. UPDATE
    //
    // PREVIOUS CODE (BUG 1) - repeated inside each of case 1, 2, 3:
    //     for (int i = 0; i < studentsName.size(); i++) {
    //         if (studentsName.get(i).equals(studentName)) {
    //             previousMark = studentMarksOne.get(i);
    //             studentMarksOne.set(i, markOne);
    //         }
    //         if (markOne > previousMark) {                    // <-- OUTSIDE the name check
    //             diff = markOne - previousMark;
    //             totalOfEachStudentsMarks.set(i, totalOfEachStudentsMarks.get(i) + diff);
    //             gradeOfEachStudent.add('A');  ...              // <-- .add instead of .set (BUG 2)
    //         } else if (markOne < previousMark) { ... }
    //     }
    //
    // CAUSE: only the first two lines were inside the "is this the student?" if. The
    //     "markOne > previousMark" block ran for EVERY student in the loop, so every other
    //     student's total was also changed by diff (students before the match used
    //     previousMark = 0, so they got the whole new mark added). Test: only Ravi's mark
    //     changed, but Anu's total went 240 -> 330 and Meena's 210 -> 250.
    //     On top of that the code was copy-pasted 3 times (one per mark) with grade logic
    //     inside each, and the prompt said "Mark One / Mark Two / Mark Three" but read an int.
    //
    // FIX: find the student's index ONCE. Set the one mark. Recompute the total from the
    //     three marks (no "diff" maths needed, so no way to drift). Nothing else is touched.
    // ------------------------------------------------------------------
    public static void updateStudentMarks(Scanner input) {
        input.nextLine();
        System.out.println("Enter Student Name : ");
        String studentName = input.nextLine().trim();
        int index = findStudentIndex(studentName);
        if (index == -1) {
            System.out.println("Student Name Not Found");
            return;
        }

        System.out.println("Which mark do you want to change? Enter 1 (Mark One), 2 (Mark Two) or 3 (Mark Three) :");
        if (!input.hasNextInt()) {
            input.next();
            System.out.println("Invalid choice.");
            return;
        }
        int markTracker = input.nextInt();
        if (markTracker < 1 || markTracker > 3) {
            System.out.println("Invalid choice. Enter 1, 2 or 3.");
            return;
        }

        double newMark = readMark(input, "New Mark");
        switch (markTracker) {
            case 1 -> studentMarksOne.set(index, newMark);
            case 2 -> studentMarksTwo.set(index, newMark);
            case 3 -> studentMarksThree.set(index, newMark);
        }

        // recompute the total ONLY for this student
        double newTotal = studentMarksOne.get(index) + studentMarksTwo.get(index) + studentMarksThree.get(index);
        totalOfEachStudentsMarks.set(index, newTotal);

        System.out.println("Marks updated:");
        printHeader();
        printRow(index);
    }

    // ------------------------------------------------------------------
    // 5. DELETE
    // PREVIOUS CODE (BUG 3 + BUG 6):
    //     double grade = gradeOfEachStudent.remove(i);
    // CAUSE: (a) the grade list was empty unless "View All" had been used first, so this threw
    //     IndexOutOfBoundsException; (b) remove() returns a Character, and assigning it to a
    //     double converts 'A' to its number, so the table printed 65.0 instead of A.
    // FIX: no grade list; the removed student's row is printed BEFORE removing, using getGrade().
    // ------------------------------------------------------------------
    public static void deleteStudent(Scanner input) {
        input.nextLine();
        System.out.println("Enter Student Name : ");
        String name = input.nextLine().trim();
        int index = findStudentIndex(name);
        if (index == -1) {
            System.out.println("Student Not Found");
            return;
        }

        System.out.println("Deleted student:");
        printHeader();
        printRow(index);

        studentsName.remove(index);
        studentMarksOne.remove(index);
        studentMarksTwo.remove(index);
        studentMarksThree.remove(index);
        totalOfEachStudentsMarks.remove(index);
    }

    // ------------------------------------------------------------------
    // 6. TOPPER + AVERAGE
    // PREVIOUS CODE (BUG 4):
    //     int topperOfClass = 0;
    //     for (...) if (totalOfEachStudentsMarks.get(i) > topperOfClass) { topperOfClass = i; }
    // CAUSE: topperOfClass holds an INDEX (0, 1, 2 ...) but it was compared with a TOTAL
    //     (e.g. 240.0). "Is 240 > 2?" is almost always true, so the topper became simply the
    //     last student. Test: the real topper was first, the code printed the last student.
    //     It also crashed (get(0)) when the list was empty.
    // FIX: compare total with the CURRENT TOPPER'S TOTAL: totals.get(topperIndex).
    //
    // PREVIOUS CODE (BUG 5):
    //     if (str == "Failed") failedStudentsCount++;
    // CAUSE: == compares references, not text (see my Strings notes). It only worked because
    //     both were pooled literals - one new String("Failed") would break it.
    // FIX: no String comparison at all - count students whose getGrade(total) is 'F'.
    // ------------------------------------------------------------------
    public static void showTopperAndAverageMarks() {
        if (studentsName.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        int topperIndex = 0;
        for (int i = 1; i < studentsName.size(); i++) {
            if (totalOfEachStudentsMarks.get(i) > totalOfEachStudentsMarks.get(topperIndex)) {
                topperIndex = i;                       // (if two students tie, the first one stays topper)
            }
        }
        System.out.println("Topper of the class:");
        printHeader();
        printRow(topperIndex);

        double sumOfTotals = 0;
        int failedStudentsCount = 0;
        for (int i = 0; i < totalOfEachStudentsMarks.size(); i++) {
            sumOfTotals += totalOfEachStudentsMarks.get(i);
            if (getGrade(totalOfEachStudentsMarks.get(i)) == 'F') {
                failedStudentsCount++;
            }
        }
        double averageOfTheClass = (sumOfTotals / studentsName.size()) / 3;   // average mark per subject
        int passedStudentsCount = studentsName.size() - failedStudentsCount;

        System.out.printf("Average Marks of the Whole Class is  : %.1f%n", averageOfTheClass);
        System.out.println("Total no. of passed students are : " + passedStudentsCount
                + ". Total no. of failed students are : " + failedStudentsCount);
    }

    // ------------------------------------------------------------------
    // 7. SORT BY MARKS (highest first)
    // PREVIOUS CODE (BUG 7 + extra work):
    //     if (total.get(j) > total.get(j+1)) { ...7 manual swaps... }   // sorts ASCENDING
    //     ...
    //     Collections.reverse(...) on all 7 lists                       // then flips it
    //     for (...) { printf(header); printf(row); }                    // header INSIDE loop
    // CAUSE: it sorted the wrong way and then reversed 7 lists to correct it; the grade lists
    //     were swapped too (crash if empty); the header print was inside the for loop, so the
    //     header appeared above every row.
    // FIX: use "<" to sort DESCENDING directly, swap through ONE helper (swapStudents),
    //     and print the header once.
    // ------------------------------------------------------------------
    public static void sortByMarks() {
        if (studentsName.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }
        int n = studentsName.size();
        for (int i = n - 1; i >= 0; i--) {                      // bubble sort with early exit
            boolean isSwap = false;
            for (int j = 0; j <= i - 1; j++) {
                if (totalOfEachStudentsMarks.get(j) < totalOfEachStudentsMarks.get(j + 1)) {
                    swapStudents(j, j + 1);
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
        System.out.println("Students sorted by total marks (highest first):");
        printHeader();
        for (int i = 0; i < studentsName.size(); i++) {
            printRow(i);
        }
    }

    // ------------------------------------------------------------------
    // MAIN
    // ------------------------------------------------------------------
    static void printMenu() {
        System.out.println("\n========== STUDENT MARKS MANAGER ===========");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search student by name");
        System.out.println("4. Update Marks");
        System.out.println("5. Delete Student");
        System.out.println("6. Show Topper and Average Marks");
        System.out.println("7. Sort By Marks");
        System.out.println("8. Exit");
        System.out.println("=============================================");
    }

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            printMenu();
            System.out.println("Enter your choice : ");

            // PREVIOUS CODE: choice = input.nextInt();
            // CAUSE: typing a letter crashed the whole program with InputMismatchException.
            // FIX: check hasNextInt() first.
            if (!input.hasNextInt()) {
                input.next();
                System.out.println("Please enter a number between 1 and 8.");
                choice = 0;
                continue;                                       // jumps to the while(...) check
            }
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

        input.close();
    }
}
import java.util.Scanner;

public class IfStatements {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ---- 1. if ----
        System.out.print("Enter age: ");
        int age = input.nextInt();
        if (age >= 18)
            System.out.println("Eligible");           // braces optional for one statement (but recommended)

        // ---- 2. if - else ----
        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not Eligible to vote");
        }

        // ---- 3. if - else if - else ----
        System.out.print("Enter marks: ");
        int marks = input.nextInt();
        if (marks > 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else {
            System.out.println("Fail");
        }

        // ---- 4. nested if ----
        if (marks >= 60) {
            if (marks >= 90) System.out.println("Distinction");
            else             System.out.println("Pass");
        }

        // ---- 5. ternary operator (short if-else) ----
        String result = (marks >= 60) ? "Pass" : "Fail";
        System.out.println("Ternary result: " + result);

        input.close();
    }
}

import java.util.Scanner;   // Scanner lives in the java.util package

public class ScannerInput {

    public static void main(String[] args) {
        // Step 1: create the Scanner object
        //   Scanner  -> class
        //   input    -> object reference variable
        //   new      -> creates the object
        //   Scanner(System.in) -> constructor; System.in is the keyboard input stream
        Scanner input = new Scanner(System.in);

        // Step 2: call methods of the Scanner class on the object
        System.out.print("Enter roll number (int): ");
        int rollno = input.nextInt();

        System.out.print("Enter marks (float): ");
        float marks = input.nextFloat();

        System.out.print("Enter large decimal (double): ");
        double largeDecimal = input.nextDouble();

        System.out.print("Enter true/false (boolean): ");
        boolean isTrue = input.nextBoolean();

        System.out.print("Enter a single word (String): ");
        String word = input.next();             // reads ONE word

        input.nextLine();                       // consume the leftover newline!

        System.out.print("Enter a full line (String): ");
        String line = input.nextLine();         // reads the ENTIRE line

        System.out.print("Enter a character: ");
        char letter = input.next().charAt(0);   // take first char of the word

        System.out.println("\n----- You entered -----");
        System.out.println("rollno       = " + rollno);
        System.out.println("marks        = " + marks);
        System.out.println("largeDecimal = " + largeDecimal);
        System.out.println("isTrue       = " + isTrue);
        System.out.println("word         = " + word);
        System.out.println("line         = " + line);
        System.out.println("letter       = " + letter);

        input.close();
    }
}

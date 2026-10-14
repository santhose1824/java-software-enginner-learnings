import java.util.ArrayList;

public class StringFormattingAndOperators {

    public static void main(String[] args) {

        // ================= toString() =================
        // Whatever we put in println(), it internally calls toString() to print it.
        int[] arr = {1, 2, 3};
        System.out.println(arr);                    // [I@hashcode  -> type@hashcode (Object's default toString)
        System.out.println(new ArrayList<>(java.util.List.of(1, 2)));   // [1, 2] (ArrayList overrides toString)

        // ================= Formatting / Pretty Printing =================
        float a = 453.124f;
        System.out.printf("%.2f%n", a);             // rounds and prints exactly 2 digits after decimal -> 453.12

        System.out.printf("Hello my name is %s and I am %s%n", "Santhosh", "Cool");

        System.out.printf("%d | %5d | %-5d | %05d%n", 42, 42, 42, 42);   // width, left-align, zero pad
        System.out.printf("%c | %b | %x | %o | %e%n", 'A', true, 255, 8, 12345.678);
        System.out.printf("%,d%n", 1234567);                               // thousands separator

        // Common specifiers: %d int, %f float/double, %s String, %c char, %b boolean, %n new line

        // ================= Operators used in Strings =================
        System.out.println('a' + 'b');              // 195  -> chars converted to ASCII (97 + 98)
        System.out.println("a" + "b");              // ab   -> Strings are concatenated
        System.out.println('a' + 3);                // 100  -> 97 + 3
        System.out.println("a" + 1);                // a1   -> int is converted to String (wrapper -> toString)

        System.out.println("Santhosh" + new ArrayList<Integer>());       // Santhosh[]   -> toString() is called
        // So when we concatenate any object with a String, toString() is called and the result is concatenated.

        // Order matters!
        System.out.println(1 + 2 + "3");            // 33  (1+2 first = 3, then "3")
        System.out.println("1" + 2 + 3);            // 123 (all concatenation)
        System.out.println('a' + 'b' + "c");        // 195c
        System.out.println("c" + 'a' + 'b');        // cab

        // The '+' operator works only for primitives and when any one operand is a String.
        // This is a built-in "operator overloading" of '+' for Strings. Java does not allow us
        // to overload operators ourselves.
        // Object o1 = new Object(); Object o2 = new Object();
        // System.out.println(o1 + o2);             // ERROR - bad operand types

        // But + inside a loop is slow ("poor performance") -> see 12-StringBuilder
    }
}

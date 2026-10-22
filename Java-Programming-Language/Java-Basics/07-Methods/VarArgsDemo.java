import java.util.Arrays;

// Variable Length Arguments (varargs): data_type... arg_name
// - used when we don't know how many arguments will be passed
// - internally stored as an ARRAY
// - must always be the LAST parameter, and only one varargs per method
public class VarArgsDemo {

    static void fun(int... v) {
        System.out.println("Received " + v.length + " values: " + Arrays.toString(v));
    }

    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    // varargs must be at the end
    static void details(String name, int... marks) {
        System.out.println(name + " -> " + Arrays.toString(marks));
    }

    // static void wrong(int... a, String s) { }   // ERROR: varargs must be last

    public static void main(String[] args) {
        fun();                       // zero arguments is allowed
        fun(1);
        fun(1, 2, 3, 4, 5);
        fun(new int[]{9, 8, 7});     // an array can be passed too

        System.out.println("Sum = " + sum(10, 20, 30));
        details("Santhosh", 90, 85, 77);
    }
}

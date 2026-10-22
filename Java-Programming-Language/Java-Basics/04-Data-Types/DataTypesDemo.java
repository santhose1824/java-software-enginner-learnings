public class DataTypesDemo {

    public static void main(String[] args) {

        // ---- The 8 primitive data types ----
        int     rollno        = 64;                  // integers
        char    letter        = 'S';                 // single character (single quotes)
        float   marks         = 98.656f;             // smaller decimal values  -> needs f
        double  largeDecimals = 65.124678912;        // larger decimal values   (default for decimals)
        long    largeInteger  = 3468712367981L;      // larger integers         -> needs L
        boolean check         = true;                // true / false
        byte    bit           = 125;                 // -128 to 127
        short   sht           = 347;                 // -32,768 to 32,767

        System.out.println("int     : " + rollno);
        System.out.println("char    : " + letter);
        System.out.println("float   : " + marks);
        System.out.println("double  : " + largeDecimals);
        System.out.println("long    : " + largeInteger);
        System.out.println("boolean : " + check);
        System.out.println("byte    : " + bit);
        System.out.println("short   : " + sht);

        // ---- Ranges using the wrapper classes ----
        System.out.println("\n--- Ranges (from wrapper classes) ---");
        System.out.println("byte   : " + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);
        System.out.println("short  : " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("int    : " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("long   : " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("float  : " + Float.MIN_VALUE + " to " + Float.MAX_VALUE);
        System.out.println("double : " + Double.MIN_VALUE + " to " + Double.MAX_VALUE);
        System.out.println("char   : " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);

        // ---- Why f and L? ----
        // By default decimals are double and integers are int.
        // float f = 5.5;          // ERROR: possible lossy conversion from double to float
        float f = 5.5f;            // OK
        // long big = 3468712367981; // ERROR: integer number too large (it is treated as int)
        long big = 3468712367981L; // OK
        System.out.println("\nf = " + f + ", big = " + big);

        // ---- Default values (instance/static variables and array elements) ----
        System.out.println("\n--- Default values ---");
        System.out.println("int     : " + defaults.i);
        System.out.println("double  : " + defaults.d);
        System.out.println("boolean : " + defaults.b);
        System.out.println("char    : " + (int) defaults.c + " (the null character)");
        System.out.println("String  : " + defaults.s);

        // ---- Wrapper classes have lots of useful methods ----
        System.out.println("\n--- Wrapper class methods ---");
        System.out.println(Integer.parseInt("123") + 1);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.compare(5, 10));
        System.out.println(Character.isDigit('7'));
        System.out.println(Double.parseDouble("3.14"));
        System.out.println(Boolean.parseBoolean("true"));

        // ---- float vs double precision ----
        System.out.println("\n--- float vs double precision ---");
        float  ff = 1.123456789f;
        double dd = 1.123456789;
        System.out.println("float  : " + ff);   // ~7 digits precision
        System.out.println("double : " + dd);   // ~15-16 digits precision
        System.out.println(0.1 + 0.2);          // 0.30000000000000004 (binary floating point)
    }

    // helper class just to show default values
    static class defaults {
        static int i;
        static double d;
        static boolean b;
        static char c;
        static String s;
    }
}

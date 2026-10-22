public class StringBasics {

    public static void main(String[] args) {

        // A String is a sequence of characters. "Santhosh" is a String.
        int a = 10;                          // primitive -> stored in the stack
        int[] arr = {10, 20, 30};            // array (object) -> reference in stack, object in heap
        String name = "Santhosh";            // same as array: reference in stack, object in heap

        // String is a CLASS and a data type. Every string we create is an object of String.
        //   String name = "Santhosh";
        //   ^ class/type  ^ reference variable   ^ object

        // ---- String Pool (inside the heap) ----
        String s1 = "Santhosh";
        String s2 = "Santhosh";              // same value -> JVM reuses the object from the pool
        System.out.println("s1 == s2 : " + (s1 == s2));              // true (same object in the pool)

        // ---- new String(...) creates a NEW object OUTSIDE the pool ----
        String s3 = new String("Santhosh");
        String s4 = new String("Santhosh");
        System.out.println("s3 == s4 : " + (s3 == s4));              // false (different objects)
        System.out.println("s1 == s3 : " + (s1 == s3));              // false
        System.out.println("s3.equals(s4) : " + s3.equals(s4));      // true  (same VALUE)

        // intern() -> put/get the string from the pool
        String s5 = s3.intern();
        System.out.println("s1 == s5 : " + (s1 == s5));              // true

        // ---- Immutability ----
        // If we change the data, a NEW object is created - the original is never modified.
        // Why? Many references can point to the same pooled object. If one changed it,
        // all the others would see the change - so Strings are immutable (also good for security,
        // thread safety and caching hashCode).
        String x = "Sam";
        String y = x;
        x = x + "uel";                       // creates a new object, x now points to it
        System.out.println("x = " + x + ", y = " + y);                // x = Samuel, y = Sam

        String z = "Hello";
        z.concat(" World");                  // result is thrown away - z unchanged
        System.out.println("z = " + z);                              // Hello
        z = z.concat(" World");
        System.out.println("z = " + z);                              // Hello World

        // ---- Compile-time constants are pooled too ----
        String c1 = "Hel" + "lo";            // computed at compile time -> "Hello" from pool
        String c2 = "Hello";
        System.out.println("c1 == c2 : " + (c1 == c2));              // true

        String part = "Hel";
        String c3 = part + "lo";             // computed at runtime -> new object
        System.out.println("c3 == c2 : " + (c3 == c2));              // false
    }
}

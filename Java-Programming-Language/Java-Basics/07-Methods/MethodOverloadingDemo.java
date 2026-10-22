// Method Overloading: same method name, different parameters
//   - different number of arguments, OR
//   - different types of arguments, OR
//   - different order of types
// Return type alone is NOT enough to overload.
// Which method runs is decided at COMPILE time (compile-time / static polymorphism).
public class MethodOverloadingDemo {

    static void fun(int a) {
        System.out.println("fun(int) -> " + a);
    }

    static void fun(String name) {
        System.out.println("fun(String) -> " + name);
    }

    static void fun(int a, int b) {
        System.out.println("fun(int, int) -> " + (a + b));
    }

    static void fun(int a, String s) {
        System.out.println("fun(int, String) -> " + a + s);
    }

    static void fun(String s, int a) {
        System.out.println("fun(String, int) -> " + s + a);
    }

    static void fun(double d) {
        System.out.println("fun(double) -> " + d);
    }

    // static int fun(int a) { return a; }   // ERROR: same signature, only return type differs

    public static void main(String[] args) {
        fun(10);              // fun(int)
        fun("Java");          // fun(String)
        fun(5, 6);            // fun(int, int)
        fun(1, "A");          // fun(int, String)
        fun("A", 1);          // fun(String, int)
        fun(3.5);             // fun(double)
        fun('a');             // char widens to int -> fun(int) with 97
        fun(10L);             // long widens to double -> fun(double)
    }
}

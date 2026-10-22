public class MethodsDemo {

    // access_modifier  return_type  method_name(parameters) { ... return ...; }

    // 1. No parameters, no return value (void)
    static void sum() {
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
    }

    // 2. Parameters, no return value
    static void sum(int a, int b) {
        int sum = a + b;
        System.out.println(sum);
    }

    // 3. No parameters, returns a String
    static String name() {
        String name = "Santhosh";
        return "My name is " + name;
    }

    // 4. Parameter + return value
    static String name(String name) {
        return "My name is " + name;
    }

    // 5. Return an int
    static int multiply(int a, int b) {
        return a * b;
    }

    // 6. void with early return (return just ends the method)
    static void checkAge(int age) {
        if (age < 0) {
            System.out.println("Invalid age");
            return;                    // method call is over
        }
        System.out.println("Age is " + age);
    }

    public static void main(String[] args) {
        // call / use the method
        sum();
        sum(5, 6);
        System.out.println(name());
        System.out.println(name("Kumar"));
        int result = multiply(4, 5);
        System.out.println("4 x 5 = " + result);
        checkAge(-1);
        checkAge(20);
    }
}

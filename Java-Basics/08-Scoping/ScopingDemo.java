public class ScopingDemo {

    static int number = 100;   // class-level ("global") variable

    // ---------- 1. Method scope ----------
    // Variables (and parameters) created inside a method can only be used inside that method.
    static void methodScope(int arg) {
        int local = 5;                          // visible only in this method
        System.out.println("local = " + local + ", arg = " + arg);
    }
    // static void other() { System.out.println(local); }   // ERROR: cannot find symbol

    // ---------- 2. Block scope ----------
    static void blockScope() {
        int a = 10;                             // created OUTSIDE the block (same method)
        {
            a = 20;                             // we can MODIFY it inside the block
            // int a = 30;                      // ERROR: already defined - cannot re-declare
            int b = 50;                         // created INSIDE the block
            System.out.println("inside block  a = " + a + ", b = " + b);
        }
        // System.out.println(b);               // ERROR: b is not visible outside the block
        System.out.println("outside block a = " + a);
    }

    // ---------- 3. Loop scope ----------
    static void loopScope() {
        int total = 0;                          // created outside the loop
        for (int i = 0; i < 3; i++) {
            int square = i * i;                 // new variable inside the loop
            total += square;                    // can use/modify outside variable
        }
        // System.out.println(i);               // ERROR: i is not visible after the loop
        // System.out.println(square);          // ERROR
        System.out.println("total = " + total);
    }

    // ---------- 4. Scope begins when the variable is declared/initialised ----------
    static void scopeBegins() {
        // System.out.println(x);               // ERROR: x is not declared yet
        int x = 10;
        System.out.println("x = " + x);
    }

    // ---------- 5. Shadowing ----------
    // A variable with the same name in an inner scope hides the outer (class-level) one.
    static void shadowing() {
        int number = 5;                         // shadows the static field 'number'
        System.out.println("local number     = " + number);                   // 5
        System.out.println("class-level value = " + ScopingDemo.number);      // 100 (use ClassName.field)
    }

    public static void main(String[] args) {
        methodScope(1);
        blockScope();
        loopScope();
        scopeBegins();
        shadowing();
        System.out.println("global number = " + number);
    }
}

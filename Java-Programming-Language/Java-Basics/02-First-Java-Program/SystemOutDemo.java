// Understanding System.out.println
//   System  -> a class in the java.lang package
//   out     -> a static variable (object reference) of type PrintStream inside System
//   println -> a method of the PrintStream class
public class SystemOutDemo {

    public static void main(String[] args) {
        System.out.println("println prints and moves to the next line");
        System.out.print("print stays on the same line ");
        System.out.print("(see?)\n");
        System.out.printf("printf formats: %d + %d = %d%n", 2, 3, 2 + 3);
    }
}

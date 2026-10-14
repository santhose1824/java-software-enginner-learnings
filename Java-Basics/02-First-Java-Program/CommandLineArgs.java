// Compile : javac CommandLineArgs.java
// Run     : java CommandLineArgs Santhosh 25 Java
//           (the words after the class name are the command line arguments)
public class CommandLineArgs {

    public static void main(String[] args) {
        System.out.println("Number of arguments: " + args.length);

        if (args.length == 0) {
            System.out.println("No arguments passed. Try: java CommandLineArgs hello world");
            return;
        }

        // print the first argument
        System.out.println("First argument: " + args[0]);

        // print all arguments
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}

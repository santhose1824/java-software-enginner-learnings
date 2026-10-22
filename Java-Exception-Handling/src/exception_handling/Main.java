package exception_handling;

public class Main {
    public static void main(String[] args) {
        int a = 8;
        int b = 0;
        // What you want to perform is on the try block
        try{
            int c = divide(a, b);
            System.out.println(c);
        } catch (Exception e) {
            // What will do with the exception is comes in the block.
            System.out.println(e.getMessage());
        }finally{
            // It will always run whether exception is happen or not.
            System.out.println("Always run");
        }
    }

    // Explicitly you want to throw an error,
    static int divide(int a, int b)throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("Please don't divide by 0");
        }
        return a / b;
    }
}

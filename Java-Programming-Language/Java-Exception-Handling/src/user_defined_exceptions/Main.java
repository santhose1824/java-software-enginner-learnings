package user_defined_exceptions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // This is custom exception example that shows exception when we enter String instead of numbers.
        String message = "Please enter a number";
        Scanner sc = new Scanner(System.in);
        try {
            if(!sc.hasNextInt()){
                throw  new UserDefinedException(message);
            }
            int a = sc.nextInt();
            System.out.println("Number is entered "+a);

        }catch (UserDefinedException e ){
            System.out.println(e.getMessage());
        }finally {
            sc.close();
        }
    }
}

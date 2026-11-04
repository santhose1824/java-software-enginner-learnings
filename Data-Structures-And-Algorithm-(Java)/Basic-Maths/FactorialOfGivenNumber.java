import java.util.Scanner;

public class FactorialOfGivenNumber{
    static int factorial(int N){
        int result = 1;
        for(int i = 1; i <=N; i++){
            result*=i;
        }

        return result;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int fact = factorial(number);
        System.out.println("The factorial of given number is : "+fact);
    }
}
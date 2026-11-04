import java.util.Scanner;
// Fibonacci number at given position
public class FibonacciSeries{
    static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int position = input.nextInt();
        System.out.println(fib(position));
    }
}
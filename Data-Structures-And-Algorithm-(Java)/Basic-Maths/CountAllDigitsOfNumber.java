import java.util.Scanner;

public class CountAllDigitsOfNumber{
    // Method 1
    static int counAllDigitsOfNumber(int N){
        int count = 0;
        while( N > 0){
            N/=10;
            count++;
        }
        return count;
    }

    //Method 2
    static int digitCounts(int N){
        return (int)Math.log10(N)+1;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int digitsCount = counAllDigitsOfNumber(number);
        System.out.println("The No.of digits in the given number is : "+ digitsCount);
    }
}
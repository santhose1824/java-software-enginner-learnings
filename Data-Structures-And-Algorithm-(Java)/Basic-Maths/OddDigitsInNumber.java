import java.util.Scanner;

public class OddDigitsInNumber{

    static int counAllOddDigitsOfNumber(int N){
        int count = 0;
        while( N > 0){
            int digit = N % 10;
            if(digit % 2 != 0){
                count++;
            }
            N/=10;
            
        }
        return count;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int digitsCount = counAllOddDigitsOfNumber(number);
        System.out.println("The No.of odd digits in the given number is : "+ digitsCount);
    }
}
import java.util.Scanner;

public class ReverseANumber{
    static long reverse(long N){
        long reverse = 0;
        while(N > 0){
            long digit = N % 10;
            reverse = (reverse*10)+digit;
            N/=10;
        }

        return reverse;

    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        long number = input.nextLong();

        long reverseANumber = reverse(number);
        System.out.println("The reverse version of given number is : "+reverseANumber);
    }
}
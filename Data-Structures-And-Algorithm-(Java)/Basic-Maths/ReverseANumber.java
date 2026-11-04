import java.util.Scanner;

public class ReverseANumber{
    static int reverse(int N){
        int reverse = 0;
        while(N > 0){
            int digit = N % 10;
            reverse = (reverse*10)+digit;
            N/=10;
        }

        return reverse;

    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int reverseANumber = reverse(number);
        System.out.println("The reverse version of given number is : "+reverseANumber);
    }
}
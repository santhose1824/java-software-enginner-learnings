import java.util.Scanner;

public class ReturnLargestDigit{
    static int returnLargestDigit(int N){
        int max  = 0 ;
        while(N > 0){
            int digit = N % 10;
            if(digit > max){
                max = digit;
            }
            N/=10;
        }
        return max;
    }
    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int largestDigit = returnLargestDigit(number);
        System.out.println("The largest digit in the given number is  : "+largestDigit);
    }
}
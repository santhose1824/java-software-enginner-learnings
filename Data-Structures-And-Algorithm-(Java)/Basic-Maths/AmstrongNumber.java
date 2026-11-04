import java.util.Scanner;

public class AmstrongNumber{
    static boolean isAmstrongNumber(int N){
        int copy = N;
        int countOfDigits = (int)Math.log10(N)+1;
        int value = 0;
        while(N > 0){
            int digit = N % 10;
            value = (value)+ (int)Math.pow(digit,countOfDigits);
            N/=10;
        }
        return value == copy;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if(isAmstrongNumber(number)){
            System.out.println("The given number is Amstrong Number");
        }else{
            System.out.println("The given number is not Amstrong Number");
        }
    }
}
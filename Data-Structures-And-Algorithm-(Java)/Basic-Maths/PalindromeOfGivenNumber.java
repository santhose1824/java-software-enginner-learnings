import java.util.Scanner;

public class PalindromeOfGivenNumber{
    static boolean plaindrome(int N){
        int copy = N;
        int reverse = 0;
        while(N > 0){
            int digit = N % 10;
            reverse = (reverse*10)+digit;
            N/=10;
        }

        return reverse == copy;

    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

       if(plaindrome(number)){
        System.out.println("The given number is Palindrome");
       }else{
        System.out.println("The given number is not Palindrome");
       }
    }
}
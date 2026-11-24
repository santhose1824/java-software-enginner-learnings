import java.util.Scanner;

public class PalindromeOfGivenNumber{
    static boolean plaindrome(int N){
        // This will rject negative numbers and 100,10,200 etc 
       if((N < 0) || (N % 10 == 0 && N != 0)) return false;

       int half = 0;
       while (N > half){
            System.out.println("N Value before divide by 10 : "+N);
            half = half * 10 + (N % 10);
            System.out.println("Half Value : "+half);
            N = N/10;
            System.out.println("N Value after divide by 10 : "+N);
       }

       boolean valOne =  N==half;
       boolean valTwo = N == half/10;

       System.out.println("N == half : "+ valOne);
       System.out.println("N == half/10 : "+  valTwo);

       return N == half || N == half/10;
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
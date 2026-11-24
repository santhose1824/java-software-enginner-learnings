import java.util.Scanner;

public class SumOfDigitsOfGivenNumber{
    static int digitSum(int n){
        if(n == 0) return 0;
        return n % 10 + digitSum(n/10);
    }

    static int digitRoot(int n){
        int s = digitSum(n);
        if (s < 10) return s;
        return digitRoot(s);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(digitRoot(n));
    }
}
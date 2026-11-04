import java.util.Scanner;

public class SumOfDigitsOfGivenNumber{
    static int sum(int n){
        if(n == 0){
            return 0;
        }

        int digit = n % 10;
        int sum = 0;
        sum+=digit;

        return sum + sum(n/10);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(sum(n));
    }
}
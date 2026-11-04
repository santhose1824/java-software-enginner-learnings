import java.util.Scanner;

public class DivisorsOfNumber{
    static void divisors(int N){
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        divisors(n);
    }
}
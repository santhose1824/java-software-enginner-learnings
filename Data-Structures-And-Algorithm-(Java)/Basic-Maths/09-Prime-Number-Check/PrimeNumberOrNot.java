import java.util.Scanner;

public class PrimeNumberOrNot{
    static boolean isPrime(int N){
        if(N <= 1) return false;
        // Sometimes i*i gives long values.
        for(int i = 2; (long)i*i <= N ; i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(isPrime(number)){
            System.out.println("The given number is Prime Number");
        }else{
           System.out.println("The given number is not a Prime Number"); 
        }
    }
}
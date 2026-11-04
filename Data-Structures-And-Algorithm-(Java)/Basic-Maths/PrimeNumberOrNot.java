import java.util.Scanner;

public class PrimeNumberOrNot{
    static boolean isPrime(int N){
        for(int i = 2; i <= Math.sqrt(N); i++){
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
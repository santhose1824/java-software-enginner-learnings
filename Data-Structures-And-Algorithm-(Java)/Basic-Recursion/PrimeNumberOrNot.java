import java.util.Scanner;

public class PrimeNumberOrNot{
    static boolean isPrime(int num, int i){
        if(i> Math.sqrt(num)){
            return true;
        }

        if(num % i == 0){
            return false;
        }

        return isPrime(num,i+1);
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(isPrime(n,2));
    }
}
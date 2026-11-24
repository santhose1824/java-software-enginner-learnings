import java.util.Scanner;

public class CountAllPrimeNumberUptoN{
    static boolean isPrime(int N){
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(N % i == 0){
                return false;
            }
        }
        return true;
    }

    static int countOfPrimeNumber(int N){
        int count = 0;
        for(int i = 2; i <= N; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int primeNumbersCount = countOfPrimeNumber(number);
        System.out.println("The total no.of prime numbers from 2 to "+number+" is : "+primeNumbersCount);
    }
}
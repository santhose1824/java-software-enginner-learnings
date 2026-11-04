import java.util.Scanner;

public class PerfectNumber{
    static boolean isPerfectNumber(int N){
        int copy = N;
        int value = 0;
        for(int i = 1; i <= N-1; i++){
            if(N % i == 0){     
                value+=i;
            }
        }

        return value == copy;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        
        if(isPerfectNumber(number)){
            System.out.println("The given number is perfect number");
        }else{
            System.out.println("The given number is not perfect number");
        }
    }
}
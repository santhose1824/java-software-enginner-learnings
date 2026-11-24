import java.util.Scanner;

public class PerfectNumber{
    static boolean isPerfectNumber(int N){
        if(N <= 1) return 1;
        int value = 1;
        for(int i = 2; i*i <= N; i++){
            if(N % i == 0){     
                value+=i;
                if(i != N/i){
                    value+=i;
                }
            }
        }

        return value == N;
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
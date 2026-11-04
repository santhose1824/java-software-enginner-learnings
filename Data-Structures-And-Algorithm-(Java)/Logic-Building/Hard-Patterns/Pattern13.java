import java.util.Scanner;

public class Pattern13{
    static void pattern(int N){
        int value = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(value);
                value++;
            }
            System.out.println("");
        }
    }
    
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
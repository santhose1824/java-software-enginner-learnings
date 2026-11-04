import java.util.Scanner;

public class Pattern11{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            int value = 1;
            if(i % 2 == 0){
                value = 0;
            }
            for(int j = 1; j <= i; j++){
                System.out.print(value);
                value = 1 - value;
            }
            System.out.println();
        }
    }

    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
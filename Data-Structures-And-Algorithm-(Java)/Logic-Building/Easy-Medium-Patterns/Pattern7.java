import java.util.Scanner;

public class Pattern7{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            // Spaces
            for(int j = 1; j <= N-i; j++){
                System.out.print(" ");
            }
            // Stars
            for(int k = 1; k <= 2*i-1; k++){
                System.out.print("*");
            }

            // Spaces
            for(int l = 1; l <= N-i; l++){
                System.out.print("");
            }
            System.out.println();
        }
    }

    public static void main(String a []){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
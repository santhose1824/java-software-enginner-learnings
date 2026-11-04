import java.util.Scanner;

public class Pattern19{

    static void upperPattern(int N){
        for(int i = 0; i <= N-1; i++){
            for(int j = 1; j <= N-i; j++){
                System.out.print("*");
            }

            for(int k = 1; k <= 2*i; k++){
                System.out.print(" ");
            }

            for(int j = 1; j <= N-i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void belowPattern(int N){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int k = 1; k <= 2*N - 2*i; k++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        upperPattern(N);

        belowPattern(N);
    }
}
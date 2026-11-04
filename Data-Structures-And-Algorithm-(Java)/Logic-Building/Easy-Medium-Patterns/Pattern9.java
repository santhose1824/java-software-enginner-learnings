import java.util.Scanner;

// For this problem I noticed it is the repitation of pattern 7 and pattern 8.

public class Pattern9{
    static void pattern1(int N){
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
    static void pattern2(int N){
        for(int i = 0; i < N; i++){
            //Spaces
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            //Stars
            for(int k = 0; k < (2*N-1)-(2*i); k++){
                System.out.print("*");
            }
            //Spaces
            for(int j = 0; j < i; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern1(N);
        pattern2(N);
    }
}
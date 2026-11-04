import java.util.Scanner;

public class Pattern8{
    // For this problem I start iterators with 0 because based on logic that is how it works.
    // There might be different  solution withoud using 0 as start.
    static void pattern(int N){
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

    public static void main(String a []){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
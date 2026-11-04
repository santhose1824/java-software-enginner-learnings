import java.util.Scanner;

public class Pattern4{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String a[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
import java.util.Scanner;

public class Pattern18{
    static void pattern(int N){
        for(int i = N; i >=1; i--){
            int val = 0;
            val = 90 - 26 + i;
            for(int j = 1; j <= N-i+1; j++){
                System.out.print((char)val+" ");
                val+=1;
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
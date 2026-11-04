import java.util.Scanner;

public class Pattern16{
    static void pattern(int N){
        char ch = 'A';
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(ch);
            }
            System.out.println();
            ch++;
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
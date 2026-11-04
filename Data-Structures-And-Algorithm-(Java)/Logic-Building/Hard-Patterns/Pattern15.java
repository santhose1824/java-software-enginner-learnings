import java.util.Scanner;

public class Pattern15{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            char ch = 'A';
            for(int j = 1; j <= N-i+1; j++){
                System.out.print(ch);
                ch++;
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
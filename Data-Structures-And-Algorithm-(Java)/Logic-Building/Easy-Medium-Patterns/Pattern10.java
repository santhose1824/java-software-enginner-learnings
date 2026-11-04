import java.util.Scanner;

// Here the combination of same Pattern2 and Pattern5 but one catch for Pattern5 we send N-1 because we already have ****** line in pattern1() so that's why we do like this for pattern2().
public class Pattern10{

    static void pattern1(int N){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void pattern2(int N){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N-i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern1(N);
        pattern2(N-1);
    }
}
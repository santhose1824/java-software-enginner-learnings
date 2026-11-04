import java.util.Scanner;

public class Pattern21{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            if(i == 1 || i == N){
                for(int j = 1; j <= N; j++){
                    System.out.print("*");
                }
            }else{
                for(int j = 1; j <= N; j++){
                    if(j == 1 || j == N){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
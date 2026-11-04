import java.util.Scanner;

public class Pattern12{
    static void pattern(int N){
        
        for(int i = 1; i <= N; i++){
            //Numbers
            for(int j = 1; j <=i; j++){
                System.out.print(j);
            }
            
            // Spaces
            for(int k = 1; k <= 2*N-2*i; k++){
                System.out.print(" ");
            }
            //Numbers
            for(int j = 1; j <=i; j++){
                System.out.print(j);
            }
            System.out.println("");
        }
    }

    public static void main(String a[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
import java.util.Scanner;

public class Pattern17{
    static void pattern(int N){
        for(int i = 1; i <= N; i++){
            // Spaces
            for(int j = 1; j <= N-i; j++){
                System.out.print(" ");
            }
            char ch = 'A';
            // Alphabets - Don't print inside the if condition.(You get confused because of that.).
            for(int k = 1; k <= 2*i-1; k++){
                System.out.print(ch);
                if(k < i){
                    ch++;   
                }else{
                    ch--;
                }
            }
            // Spaces
            for(int j = 1; j <= N-i; j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        pattern(N);
    }
}
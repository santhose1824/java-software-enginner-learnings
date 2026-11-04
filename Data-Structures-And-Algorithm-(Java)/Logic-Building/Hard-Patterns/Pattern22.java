import java.util.Scanner;

public class Pattern22{
    static void pattern(int N){
        for(int i = 0; i < 2*N-1; i++){
            for(int j = 0; j < 2*N-1; j++){
                int top = i;
                int left = (2*N-2)-i;
                int right = j;
                int bottom = (2*N-2)-j;

                int min = Math.min(Math.min(top,bottom),Math.min(right,left));

                System.out.print(N-min);
            }
            System.out.println("");
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        pattern(N);
    }                                                                                                                                                                         
}
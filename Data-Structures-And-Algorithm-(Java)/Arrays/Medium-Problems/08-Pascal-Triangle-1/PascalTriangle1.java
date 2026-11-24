import java.util.Scanner;

public class PascalTriangle1{
    static int elementOfGivenRowandColumnInPascalTriangle(int row, int col){
        int n = row-1;
        int r = col-1;

        int element = 1;

        for(int i = 0; i < r; i++){
            element = element*(n-i);
            element = element/(i+1);
        }

        return element;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

        System.out.println(elementOfGivenRowandColumnInPascalTriangle(row,col));
    }
}
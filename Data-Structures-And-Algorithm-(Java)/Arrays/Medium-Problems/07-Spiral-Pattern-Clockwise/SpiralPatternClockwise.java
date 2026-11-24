import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class SpiralPatternClockwise{
    static List<Integer> printSpiralPattern(int matrix[][]){
        List<Integer> ans = new ArrayList();
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while(top <= bottom && left <= right){
            for(int i = left; i <= right; i ++){
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;

    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();
        int [][] matrix = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = input.nextInt();
            }
        }

       System.out.println(printSpiralPattern(matrix));
        
    }
}
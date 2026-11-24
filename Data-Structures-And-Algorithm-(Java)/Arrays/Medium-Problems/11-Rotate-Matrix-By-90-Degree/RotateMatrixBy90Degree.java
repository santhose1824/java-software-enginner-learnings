import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RotateMatrixBy90Degree{
    static void swap(int [][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }


    static void rotateMatrix(int [][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[0].length; j++){
                swap(matrix,i,j);
            }
        }

        for(int i = 0; i < matrix.length; i++){
            reverse(matrix[i]);
        }

    }

    static void reverse(int[]row){
        int start = 0;
        int end = row.length-1;

        while(start <= end){
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;

            start++;
            end--;
        }
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

       rotateMatrix(matrix);

       for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
       
    }
}
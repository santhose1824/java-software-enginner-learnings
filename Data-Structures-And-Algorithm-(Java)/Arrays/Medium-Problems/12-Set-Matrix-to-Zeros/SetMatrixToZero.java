import java.util.Scanner;

public class SetMatrixToZero{
    static void matrixToZero(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        boolean isRowHasZero = false;
        boolean isColumnHasZero = false;

        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                isRowHasZero = true;
            }
        }

        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                isColumnHasZero = true;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(matrix[i][0] == 0 || matrix[j][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isRowHasZero){
            for(int i = 0; i < m; i++){
                matrix[0][i] = 0;
            }
        }

        if(isColumnHasZero){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
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

       matrixToZero(matrix);

       for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println("");
        }

    }
}
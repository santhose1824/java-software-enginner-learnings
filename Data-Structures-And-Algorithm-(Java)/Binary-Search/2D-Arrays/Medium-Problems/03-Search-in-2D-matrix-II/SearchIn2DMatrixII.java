import java.util.Scanner;

public class SearchIn2DMatrixII{
    static boolean search(int[][] matrix, int target){
        int low = 0;
        int high = matrix[0].length-1;

        while(low < matrix.length && high >=0){
            if(matrix[low][high] == target){
                return true;
            }else if(matrix[low][high] < target){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();
        int col = input.nextInt();

        int[][] matrix = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                matrix[i][j] = input.nextInt();
            }
        }
        int target = input.nextInt();
        System.out.println(search(matrix,target));
    }
}
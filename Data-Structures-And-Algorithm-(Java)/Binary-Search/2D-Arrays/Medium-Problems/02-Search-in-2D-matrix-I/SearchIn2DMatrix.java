import java.util.Scanner;

public class SearchIn2DMatrix{
    static boolean search(int[][]matrix, int target){
        int low = 0;
        int high = matrix.length * matrix[0].length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = mid/matrix[0].length;
            int col = mid % matrix[0].length;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
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
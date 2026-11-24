import java.util.Scanner;
import java.util.Arrays;

public class FindAPeakElement{

    static int findMax(int[][]matrix,int col){
        int max = Integer.MIN_VALUE;
        int index  = -1;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][col] > max){
                max = matrix[i][col];
                index = i;
            }
        }

        return index;
    }

    static int[] findPeakElement(int[][]matrix){
        int low = 0;
        int high = matrix[0].length;

        while(low <= high){
            int mid = low + (high - low)/2;

            int row = findMax(matrix,mid);

            int left = mid >=0 ? matrix[row][mid-1] : Integer.MIN_VALUE;
            int right = mid < matrix[0].length ? matrix[row][mid+1] : Integer.MAX_VALUE;

            if(matrix[row][mid] > left && matrix[row][mid] > right){
                return new int[] {row,mid};
            }else if(matrix[row][mid] < left){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return new int[]{-1,-1};
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

        System.out.println(Arrays.toString(findPeakElement(matrix)));
    }
}
import java.util.Scanner;

public class FindARowWithMax1{


    static int lowerBount(int[]matrix, int x){
        int low = 0;
        int high = matrix.length-1;
        int ans = matrix.length;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[mid] >= x){
                ans = mid;
                high = mid-1;
                
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    static int maxOnes(int[][]matrix){
        int maxCount = 0;
        int index  = -1;

        for(int i = 0 ; i < matrix.length;i++){
            int count = matrix[0].length-lowerBount(matrix[i],1);
            if(count > maxCount){
                maxCount = count;
                index = i;
            }
        }

        return index;
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

        System.out.println(maxOnes(matrix));
    }

}
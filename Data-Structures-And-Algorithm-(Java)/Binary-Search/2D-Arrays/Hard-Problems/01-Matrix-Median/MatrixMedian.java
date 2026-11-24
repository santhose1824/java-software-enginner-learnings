import java.util.Scanner;
public class MatrixMedian{

    static int upperBound(int[]matrix,int x, int m){
        int low = 0;
        int high = matrix.length-1;
        int ans = m;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(matrix[mid] > x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }


    static int count(int[][]matrix,int n, int m, int mid){
        int len = 0;
        for(int i = 0; i < n; i++){
            len+=upperBound(matrix[i],mid,m);
        }
        return len;
    }

    static int findMedian(int[][]matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        int req = m *n /2;

        for(int i = 0; i < n; i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][m-1]);
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(count(matrix,n,m,mid) <= req) low = mid + 1;
            else high = mid - 1;
        }

        return low;
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
        System.out.println(findMedian(matrix));
    }
}
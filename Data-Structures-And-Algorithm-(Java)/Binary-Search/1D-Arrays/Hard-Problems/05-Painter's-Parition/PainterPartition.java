import java.util.Scanner;

public class PainterPartition{

    static boolean possiblePaint(int[]array, int mid, int A){
        int painters = 1;
        int units = 0;

        for(int val : array){
            if(units + val > mid){
                painters++;
                units = 0;
            } 

            units+=val;
        }

        return painters <= A;
    }

    static int minimumTimeRequried(int[]array, int A, int B){
        int low = Integer.MIN_VALUE;
        int high = 0;
        int ans = -1;

        for(int val : array){
            low = Math.max(low, val);
            high+=val;
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(possiblePaint(array,mid,A)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return (int) (ans * B) % 10000003;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int A = input.nextInt();
        int B = input.nextInt();
        System.out.println(minimumTimeRequried(array,A,B));
    }
}
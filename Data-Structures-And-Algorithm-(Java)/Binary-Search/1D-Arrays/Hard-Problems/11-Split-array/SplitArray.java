import java.util.Scanner;

public class SplitArray{

    static boolean countPartitions(int array[], int k, int mid){
        int total = 1;
        int sum = 0;

        for(int val : array){
            if(sum + val > mid){
                total++;
                sum = 0;
            }
            sum+=val;
        }

        return total <= k;
    }


    static int largestSubArraySum(int [] array, int k){
        int low = Integer.MIN_VALUE;
        int high = -1;
        int ans = -1;

        for(int val : array){
            low = Math.max(low, val);
            high+=val;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(countPartitions(array,k,mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(largestSubArraySum(array,k));
    }
}
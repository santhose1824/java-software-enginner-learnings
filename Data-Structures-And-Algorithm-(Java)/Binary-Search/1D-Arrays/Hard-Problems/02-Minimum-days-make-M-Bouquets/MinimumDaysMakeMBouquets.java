import java.util.Scanner;

public class MinimumDaysMakeMBouquets{


    static boolean minimumPossibleBouquets(int[]array, int mid, int m, int k){
        int flowers = 0;
        int bouquets = 0;

        for(int val : array){
            if(val <= mid){
                flowers++;
            }else{
                flowers = 0;
                bouquets = bouquets + (flowers/k);
            }
        }

        bouquets = bouquets + (flowers/k);

        return bouquets >= m;
    }

    static int minimumBouquets(int[]array, int m, int k){
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        if(array.length < m*k) return ans;

        for(int val : array){
            low = Math.min(low,val);
            high = Math.max(high,val);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(minimumPossibleBouquets(array,mid,m,k)){
                ans = mid;
                high = mid-1;
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
        int m = input.nextInt();
        int k = input.nextInt();
        System.out.println(minimumBouquets(array,m,k));
    }
}
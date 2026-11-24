import java.util.Scanner;

public class CapacityToShipDPackages{


    static boolean minimumPossibleCapacity(int array[], int days, int mid){
        int day = 1;
        int load = 0;

        for(int weight : array){
            if(load + weight > mid){
                day++;
                load = 0;
            }
            load+=weight;
        }

        return day <= days;
    }


    static int minimumCapacity(int [] array, int days){
        int low = Integer.MIN_VALUE;
        int high = -1;
        int ans = -1;

        for(int val : array){
            low = Math.max(low, val);
            high+=val;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(minimumPossibleCapacity(array,days,mid)){
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
        int days = input.nextInt();
        System.out.println(minimumCapacity(array,days));
    }
}
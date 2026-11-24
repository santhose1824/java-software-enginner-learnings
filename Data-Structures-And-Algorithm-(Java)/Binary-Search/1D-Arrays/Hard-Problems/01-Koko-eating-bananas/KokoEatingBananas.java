import java.util.Scanner;

public class KokoEatingBananas{

    static int minimumPossibleNoOfBananas(int[]array, int mid){
        int totalHoursForMinimumPossibleBananas = 0;
            
        for(int val : array){
            totalHoursForMinimumPossibleBananas += Math.ceil(
                (double)val/(double)mid
            );
        }

        return totalHoursForMinimumPossibleBananas;
    }

    static int minimumNoOfBananas(int[]array, int h){
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for(int val : array){
            high = Math.max(high,val);
        }

        while(low <= high){
           int mid = low + (high - low)/2;

           int guessedHour = minimumPossibleNoOfBananas(array,mid);

           if(guessedHour <= h){
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
        int h = input.nextInt();
        System.out.println(minimumNoOfBananas(array,h));
    }
}
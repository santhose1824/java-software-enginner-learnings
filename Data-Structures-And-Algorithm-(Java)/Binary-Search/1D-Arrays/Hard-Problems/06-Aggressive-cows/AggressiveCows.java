import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows{

    static boolean possibleDistance(int[]array,int k, int mid){
        int noOfCows = 1;
        int lastPosition = array[0];

        for(int i = 1; i < array.length; i++){
            if(array[i] - lastPosition >= mid){
                noOfCows++;
                lastPosition = array[i];
            } 
        }

        return noOfCows >= k;
    }

    static int maximumPossibleMinimumDistance(int[]array, int k){
        Arrays.sort(array);
        int low = 1;
        int high = array[array.length-1] - array[0];
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(possibleDistance(array,k,mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
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
        System.out.println(maximumPossibleMinimumDistance(array,k));
    }
}
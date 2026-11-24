import java.util.Scanner;

public class FindSmallestDivisor{

    static int sumOfAllElementsInArrayByPossibleDivisor(int[]array, int mid){
        int sum = 0;
        for(int val : array){
            sum += Math.ceil((double)val/(double)mid);
        }

        return sum;
    }

    static int smallestDivisor(int[]array,int limit){
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for(int val : array){
            high = Math.max(high,val);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int sum = sumOfAllElementsInArrayByPossibleDivisor(array, mid);
            if(sum <= limit){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
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
        int limit = input.nextInt();
        System.out.println(smallestDivisor(array,limit));
    }
}
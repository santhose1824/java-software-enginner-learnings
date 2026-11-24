import java.util.Scanner;

public class KthPositiveNumber{

    static int kthPositiveNumber(int[]array, int k){
        int low = 1;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            int missingpart = array[mid] - (mid+1);
            if(missingpart < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return low + k;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int k  = input.nextInt();
        System.out.println(kthPositiveNumber(array,k));
    }
}
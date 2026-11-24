import java.util.Scanner;
import java.util.Arrays;

public class FirstAndLastOccurance{

    static int lowerBound(int []array, int x){
        int low  = 0;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] >= x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    static int upperBound(int []array, int x){
        int low  = 0;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    static int[] firstAndLastOccurance(int[]array, int target){
        int first = lowerBound(array,target);
        if(first == array.length || array[first] != target){
            return new int[]{-1,-1};
        }
        int last = upperBound(array,target)-1;
        return new int[]{first,last};
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int target = input.nextInt();
        System.out.println(Arrays.toString(firstAndLastOccurance(array,target)));
    }
}
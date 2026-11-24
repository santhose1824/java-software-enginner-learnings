import java.util.Scanner;
import java.util.Arrays;

public class FloorAndCeil{
    static int floor(int[]array, int x){
        int low = 0;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(array[mid] <= x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        if(high < 0){
            return -1;
        }else{
            return array[high];
        }
    }

    static int ceil(int[]array, int x){
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

        if(low == array.length){
            return -1;
        }else{
            return array[low];
        }
    }

    static int[] getFloorAndCeil(int[]array,int x){
        int floor = floor(array,x);
        int ceil = ceil(array,x);

        return new int[]{floor,ceil};
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int x = input.nextInt();
        System.out.println(Arrays.toString(getFloorAndCeil(array,x)));
    }
}
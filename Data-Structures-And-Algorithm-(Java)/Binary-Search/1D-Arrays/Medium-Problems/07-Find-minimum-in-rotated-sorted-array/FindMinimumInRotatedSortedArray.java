import java.util.Scanner;

public class FindMinimumInRotatedSortedArray{

    static int findMinimum(int[]array){
        int low = 0;
        int high = array.length-1;

        int minimumElement = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(array[low] <= array[high]){
                minimumElement = Math.min(minimumElement, array[low]);
                low = mid + 1;
                break;
            }

            if(array[low] <= array[mid]){
                minimumElement = Math.min(minimumElement,array[low]);
                low = mid + 1;
            }else{
                minimumElement = Math.min(minimumElement,array[mid]);
                high = mid - 1;
            }
        }

        return minimumElement;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(findMinimum(array));
    }
}
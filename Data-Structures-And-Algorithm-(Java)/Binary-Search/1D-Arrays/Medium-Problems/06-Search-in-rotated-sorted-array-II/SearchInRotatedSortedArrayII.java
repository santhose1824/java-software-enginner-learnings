import java.util.Scanner;

public class SearchInRotatedSortedArrayII{

    static boolean search(int[]array, int k){
        int low = 0;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(array[mid] == k) return true;

            if(array[low] == array[mid] && array[mid] == array[high]){
                low = low + 1;
                high = high - 1;
                continue;
            }

            if(array[low] <= array[mid]){
                if(array[low] <= k && k <= array[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(array[mid] <= k && k <= array[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(search(array,k));
    }
}
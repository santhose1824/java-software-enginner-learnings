import java.util.Scanner;

public class FindPeakElement{

    static int findPeakElement(int[]array){
        int n = array.length;
        if(n == 1) return 0;
        if(array[0] > array[1]) return 0;
        if(array[n-2] < array[n-1]) return n-1;

        int low = 1;
        int high = n-2;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(array[mid-1] < array[mid] && array[mid+1] < array[mid]){
                return mid;
            }else if(array[mid-1] > array[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(findPeakElement(array));
    }
}
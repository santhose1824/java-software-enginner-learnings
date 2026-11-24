import java.util.Scanner;
import java.util.Arrays;

public class SortZerosOnesAndTwos{

    static void swap(int []array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void sortArray(int[] array){
        int low = 0;
        int mid = 0;
        int high = array.length-1;

        while(mid < high){
            if(array[mid] == 0){
                swap(array,low,mid);
                low++;
                mid++;
            }else if(array[mid] == 1){
                mid++;
            }else{
                swap(array,mid,high);
                high--;
            }
        }
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}
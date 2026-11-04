import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeSort{
    static void mergeSort(int [] array, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(array,low,mid);
        mergeSort(array,mid+1,high);
        merge(array, low, mid, high);
    }

    static void merge(int []array, int low, int mid, int high){
        List<Integer> temp = new ArrayList();
        int left = low;
        int right = mid+1;
        while(left <= mid+1 &&  right <= high){
            if(array[left] <= array[right]){
                temp.add(array[left]);
                left++;
            }else{
                temp.add(array[right]);
                right++;
            }

            while(left <= mid+1){
                temp.add(array[left]);
                left++;
            }

            while(right <= high){
                temp.add(array[right]);
                right++;
            }
        }

        for(int i = low; i <= high; i++){
            array[i] = temp.get(i-low);
        }
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       mergeSort(array,0,array.length-1);
       System.out.println(Arrays.toString(array));
    }
}
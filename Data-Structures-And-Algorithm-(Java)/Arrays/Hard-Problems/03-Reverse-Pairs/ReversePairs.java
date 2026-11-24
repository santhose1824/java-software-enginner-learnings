import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ReversePairs{


    static int mergeSort(int[]array,int low,int high){
        int count = 0; 
        if(low < high){
            int mid = (low + high)/2;
            count+= mergeSort(array,low,mid);
            count+= mergeSort(array,mid+1,high);
            count+= countPairs(array,low,mid,high);
            merge(array,low,mid,high);
        } 

        return count;  
    }


    static int countPairs(int[]array, int low, int mid, int high){
        int count  = 0;
        int right = mid+1;
        
        for(int i = low; i <= mid; i++){
            while(right <= high && array[i] > 2 * array[right]){
                right++;
            }
            count+= (right-(mid+1));
        }
        return count;
    }

    static void merge(int[]array, int low, int mid, int high){
        int left = low;
        int right = mid+1;

        List<Integer> tempList = new ArrayList();

        while(left <= mid && right <= high){
            if(array[left] <= array[right]){
                tempList.add(array[left]);
                left++;
            }else{
                tempList.add(array[right]);
                right++;
            }
        }

        while(left <= mid){
            tempList.add(array[left]);
            left++;
        }

        while(right <= high){
            tempList.add(array[right]);
            right++;
        }


        for(int i = low; i <= high; i++){
            array[i] = tempList.get(i-low);
        }
    }


    static int reversePairs(int[]array){
        return mergeSort(array,0,array.length-1);
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(reversePairs(array));

    }
}
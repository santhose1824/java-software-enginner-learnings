import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CountInversions{

    
    static int mergeSort(int []array, int low, int high){
        int count = 0;
        if(low < high){
            int mid = (low + high)/2;

            count+= mergeSort(array,low,mid);
            count+= mergeSort(array,mid+1,high);
            count+= merge(array,low,mid,high);

        }
        return count;
    }


    static int merge(int[]array,int low, int mid, int high){
        List<Integer> tempList = new ArrayList();
        int count = 0;

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(array[left] <= array[right]){
                tempList.add(array[left]);
                left++;
            }else{
                tempList.add(array[right]);
                right++;
                count += (mid-left+1);
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

        return count;

    }


    static int inversionsCount(int[]array){
        return mergeSort(array,0,array.length-1);
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(inversionsCount(array));

    }
}
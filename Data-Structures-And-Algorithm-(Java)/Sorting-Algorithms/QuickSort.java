import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class QuickSort{
    static void quickSort(int [] array, int low, int high){
        if(low >= high){
            return;
        }

        int pivot = findPivot(array,low,high);
        quickSort(array,low,pivot-1);
        quickSort(array,pivot+1,high);
    }


    static int findPivot(int [] array, int low, int high){

        int randomIndex = low + new Random().nextInt(high - low + 1);
        swap(array, low, randomIndex);

        int i = low;
        int j = high;

        int pivot = array[low];

        while(i < j){
            while(array[i] <= pivot && i <= high-1){
                i++;
            }

            while(array[j] > pivot && i >= low+1){
                j--;
            }

            if(i < j){
                swap(array,i,j);
            }
        }
        swap(array,low,j);
        return j;
    }

    static void swap(int[] array,int valOne,int valTwo){
        int temp = array[valOne];
        array[valOne] = array[valTwo];
        array[valTwo] = temp;
    }

    
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        quickSort(array,0,array.length-1);
       System.out.println(Arrays.toString(array));
    }
}
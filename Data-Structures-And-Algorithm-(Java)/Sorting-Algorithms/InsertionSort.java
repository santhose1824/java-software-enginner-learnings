import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort{

    static void insertionSort(int [] array){
        int n = array.length-1;
        for(int i = 0; i <= n; i++){
            int j = i;
            while(j > 0 && array[j-1] > array[j]){
                swap(array,j-1,j);
                j--;
            }
        }

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
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
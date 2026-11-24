import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort{
    static void selectionSort(int[] array){
        for(int i = 0; i <= array.length-2; i++){
            for(int j = i+1; j < array.length; j++){
                if(array[i] > array[j]){
                    swap(array,i,j);
                }
            }
        }
    }

    static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort{
    static void selectionSort(int[] array){
        int n = array.length;
        for(int i = 0; i < n-2; i++){
            int min = i;
            for(int j = i; j <= n-1; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }

            swap(array,i,min);
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
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
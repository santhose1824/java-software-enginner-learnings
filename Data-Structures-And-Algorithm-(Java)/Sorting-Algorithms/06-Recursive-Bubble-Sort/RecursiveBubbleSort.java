import java.util.Scanner;
import java.util.Arrays;

public class RecursiveBubbleSort {

    static int[] bubbleSort(int[] array) {

        bubbleSortHelper(array, array.length);
        return array;
    }

    static void bubbleSortHelper(int[] array, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {

            if (array[i] > array[i + 1]) {

                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        bubbleSortHelper(array, n - 1);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int [size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(bubbleSort(array)));

    }
}
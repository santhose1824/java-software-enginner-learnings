import java.util.Scanner;
import java.util.Arrays;
public class BubbleSort{
    static void bubbleSort(int[] array){
        boolean isSwap = true;
        for(int i = array.length-1; i >= 0; i--){
            isSwap = false;
            for(int j = 0; j <= i-1; j++){
                if(array[j] > array[j+1]){
                    System.out.println("run");
                    swap(array,j,j+1);
                    isSwap = true;
                }
            }

            if(!(isSwap)){
                System.out.println("Loop is breaking");
                break;
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
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
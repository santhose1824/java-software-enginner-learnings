import java.util.Scanner;
import java.util.Arrays;

public class MoveZerosToEnd{

    static void moveZerosToEnd(int [] array){
        int start = 0;
        int n = array.length;
    
        for(int end = 0; end < n; end++){
            if(array[end] != 0){
                swap(array,end,start);
                start++;
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
       moveZerosToEnd(array);
       System.out.println(Arrays.toString(array));
    }
}
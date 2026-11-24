import java.util.Scanner;
import java.util.Arrays;

public class ReverseAnArray{
    static void reverse(int [] array){
        int start = 0;
        int end = array.length-1;
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        System.out.println("The array before reverse "+Arrays.toString(array));
        reverse(array);
        System.out.println("The array after reverse "+Arrays.toString(array));

    }
}
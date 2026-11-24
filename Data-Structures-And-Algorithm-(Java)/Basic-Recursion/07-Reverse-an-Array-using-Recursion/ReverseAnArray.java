import java.util.Scanner;
import java.util.Arrays;

public class ReverseAnArray{
    static void reverse(int [] array, int start,int end){
        if(start >= end){
            return;
        }

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        reverse(array,start+1,end-1);
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        
        int size = input.nextInt();
        int [] array = new int[size];

        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        reverse(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
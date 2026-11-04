import java.util.Scanner;
import java.util.Arrays;

public class LeftRotateByOne{

    static void leftRotateByOne(int []array){
        int temp = array[0];
        for(int i  = 1; i < array.length; i++){
            array[i-1] = array[i];
        }

        array[array.length-1] = temp;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        leftRotateByOne(array);
        System.out.println(Arrays.toString(array));
    }
}
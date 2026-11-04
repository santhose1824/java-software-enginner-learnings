import java.util.Scanner;
import java.util.Arrays;

public class ReverseAString{
    static void reverse(char[] array, int start, int end){
        if(start >= end){
            return;
        }
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
        reverse(array,start+1,end-1);
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        char[] str = new char[size];
        for(int i = 0; i < size; i++){
            str[i] = input.next().charAt(0);
        }
        reverse(str,0,str.length-1);
        System.out.println(Arrays.toString(str));
    }
}
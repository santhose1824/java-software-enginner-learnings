import java.util.Scanner;
import java.util.Arrays;
public class LeftRotateByKPlaces{
    static void leftRotate(int [] array, int k){
        int n = array.length;
        k = k % n;

        reverse(array,0,k-1);
        reverse(array,k,n-1);
        reverse(array,0,n-1);
    }

    static void reverse(int [] array, int start, int end){
        while(start <= end){
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
        int k = input.nextInt();
       leftRotate(array,k);
       System.out.println(Arrays.toString(array));
    }
}
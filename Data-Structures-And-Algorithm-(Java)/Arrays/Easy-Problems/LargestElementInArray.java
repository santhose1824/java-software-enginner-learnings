import java.util.Scanner;

public class LargestElementInArray{

    static int largestElementInArray(int [] array){
        int max = Integer.MIN_VALUE;
        for(int val : array){
            if(val > max){
                max = val;
            }
        }

        return max;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       System.out.println(largestElementInArray(array));
    }
}
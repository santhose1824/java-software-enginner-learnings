import java.util.Scanner;

public class SecondLargestElementInArray{

    static int secondLargestElementInArray(int [] array){
        int max = Integer.MIN_VALUE;
        int secondMax = 0;
        for(int val : array){
            if(val > max){
                secondMax = max;
                max = val;
            }else if(val != max && val > secondMax){
                secondMax = val;
            }
        }

        return secondMax == Integer.MIN_VALUE ? -1 :secondMax;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       System.out.println(secondLargestElementInArray(array));
    }
}
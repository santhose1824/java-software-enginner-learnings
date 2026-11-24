import java.util.Scanner;

public class MaximumProductInSubarray{

    static int usingKadneAlgo(int [] array){
        int max = Integer.MIN_VALUE;
        int sum = 1;
        for(int i = 0; i < array.length; i++){
            sum = sum * array[i];

            if(sum > max){
                max = sum;
            }

            if(sum < max){
                sum = 0;
            }
        }

        return max;
    }


    static int maxProduct(int[]array){
        int prefix = 1;
        int suffix = 1;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix*array[i];
            suffix = suffix*array[array.length-i-1];

            max = Math.max(max, Math.max(prefix,suffix));
        }

        return max;
    }


    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(maxProduct(array));

    }
}
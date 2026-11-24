import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class LargestSubarraySumZero{


    static int largestSubarraySumZero(int[]array){
        Map<Integer,Integer> map = new HashMap();

        int sum = 0;
        int length = 0;

        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];

            if(sum ==  0){
                length = Math.max(length,i+1);
            }

            if(map.containsKey(sum)){
                int val = i - map.get(sum);
                length = Math.max(length,val);
            }else{
                map.put(sum,i);
            }
        }

        return length;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(largestSubarraySumZero(array));
    }
}
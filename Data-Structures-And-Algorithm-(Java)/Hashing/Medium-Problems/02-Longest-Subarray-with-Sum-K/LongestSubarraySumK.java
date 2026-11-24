import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;


public class LongestSubarraySumK{

    static int longestSubarraySumK(int[]array,int k){
        Map<Integer,Integer> map = new HashMap();

        int sum = 0;
        int length = 0;
        
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];

            if(sum == k){
                length = Math.max(length,i+1);
            }

            int rem = sum - k;

            if(map.containsKey(rem)){
                int val = i - map.get(rem);
                length = Math.max(length,val);
            }

            if(!map.containsKey(sum)){
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
        int k = input.nextInt();
        System.out.println(longestSubarraySumK(array,k));
    }
}
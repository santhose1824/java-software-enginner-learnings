import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CountSubarraysSumK{


    static int countSubarraySumK(int[]array, int k){
        int sum = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];

            int diff = sum - k;

            count = count + (map.getOrDefault(diff,0));
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;
    }


    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(countSubarraySumK(array,k));
    }
}
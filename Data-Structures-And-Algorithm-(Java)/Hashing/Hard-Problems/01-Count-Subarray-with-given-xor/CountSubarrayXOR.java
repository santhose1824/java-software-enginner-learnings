import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CountSubarrayXOR{


    static int countSubarrayXORK(int[]array, int k){
        int xor = 0;
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        map.put(0,1);
        for(int i = 0; i < array.length; i++){
            xor = xor ^ array[i];

            int prevXor = xor  ^ k;

            count = count + (map.getOrDefault(prevXor,0));
            map.put(xor,map.getOrDefault(xor,0)+1);
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
        System.out.println(countSubarrayXORK(array,k));
    }
}
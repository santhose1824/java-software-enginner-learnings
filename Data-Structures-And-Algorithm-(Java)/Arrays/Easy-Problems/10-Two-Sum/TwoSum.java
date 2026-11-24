import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class TwoSum{
    static int [] twoSum(int [] array, int target){
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0; i < array.length; i++){
            int val = target - array[i];
            if(map.containsKey(val)){
                return new int[] {map.get(val),i};
            }

            map.put(array[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }

        System.out.println(Arrays.toString(twoSum(array,target)));
    }
}
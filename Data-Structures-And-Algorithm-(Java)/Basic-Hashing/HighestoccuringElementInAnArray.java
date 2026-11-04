import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class HighestoccuringElementInAnArray{
    static int highestOcuuring(int [] array){
        Map<Integer,Integer> map = new HashMap();
        int maxValue = 0;
        int highestOccurance = 0;

        for(int num : array){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer>value:map.entrySet()){
            int key = value.getKey();
            int val = value.getValue();
            
            if(val > maxValue){
                maxValue = val;
                highestOccurance = key;
            }
        }

        return highestOccurance;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int ans = highestOcuuring(array);
        System.out.println("The highest occuring element in the array is : "+ans);
    }
}
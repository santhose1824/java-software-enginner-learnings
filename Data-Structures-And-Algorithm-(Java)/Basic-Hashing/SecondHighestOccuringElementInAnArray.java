import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SecondHighestOccuringElementInAnArray{
    static int secondHighestOccuring(int [] array){
        Map<Integer,Integer> map = new HashMap();
        int maxValue = 0;
        int highestOccurance = 0;
        int secondMax = 0;
        int secondHighestOccurance = 0;
        for(int num : array){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val > maxValue){
                secondMax = maxValue;
                secondHighestOccurance = highestOccurance;
                maxValue = val;
                highestOccurance = key;
            }else if(val > secondMax && val < maxValue){
                secondMax = val;
                secondHighestOccurance = key;
            }
        }  

        return secondHighestOccurance;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int ans = secondHighestOccuring(array);
        System.out.println("The second highest occuring element in the array is : "+ans);
    }
}
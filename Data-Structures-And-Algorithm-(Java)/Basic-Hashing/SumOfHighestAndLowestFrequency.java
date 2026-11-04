import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SumOfHighestAndLowestFrequency{
    static int sumOfHighestAndLowestOcuuring(int [] array){
        Map<Integer,Integer> map = new HashMap();
        int highestOccurance = 0;
        int lowestOccurance = array.length;

        for(int num : array){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        //values() returns an array
        for(int val : map.values()){
            highestOccurance = Math.max(val,highestOccurance);
            lowestOccurance = Math.min(val,lowestOccurance);
        }

        int sum = highestOccurance + lowestOccurance;

        return sum;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int ans = sumOfHighestAndLowestOcuuring(array);
        System.out.println("The sum of highest occuring and lowest occuring element in the array is : "+ans);
    }
}
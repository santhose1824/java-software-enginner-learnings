import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class LongestConsecutiveSequence{

    static int longestSequence(int[]array){
        int longest = 1;
        Set<Integer> set = new HashSet();

        for(int val : array){
            set.add(val);
        }

        for(int val : set){
            if(!set.contains(val-1)){
                int count  = 1;
                int x = val;

                while(set.contains(x+1)){
                    x = x+1;
                    count = count+1;
                }
                longest = Math.max(longest,count);
            }
        }

        return longest;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(longestSequence(array));
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class KadaneAlgorithm{

    //Get the largest sum of subarray(sum of elements in subarray)
    static int kadandeAlgo(int []array){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum = sum + array[i];

            if(sum > max){
                max = Math.max(sum,max);
            }

            if(max < 0){
                sum = 0;
            }
        }
        return max;
    }

    // Get the largest sum of subarray(extact subarray)
    static List<Integer> kadandeAlgoReturnArray(int []array){
        int ansStartIndex = -1;
        int ansEndIndex = -1;
        int start = -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(sum == 0) start = i;
            sum = sum + array[i];

            if(sum > max){
                max = Math.max(sum,max);
                ansStartIndex = start;
                ansEndIndex = i;
            }

            if(max < 0){
                sum = 0;
            }
        }

        List<Integer> ans = new ArrayList();

        for(int i = ansStartIndex; i <= ansEndIndex; i++){
            ans.add(array[i]);
        }

        return ans;
        
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(kadandeAlgoReturnArray(array));
    
    }
}
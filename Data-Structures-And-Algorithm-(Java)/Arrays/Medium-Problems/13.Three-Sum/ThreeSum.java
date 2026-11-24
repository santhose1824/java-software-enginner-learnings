import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class ThreeSum{

    static List<List<Integer>> threeSum(int [] array){
        List<List<Integer>> triplets = new ArrayList();
        Arrays.sort(array);

        for(int i = 0; i < array.length; i++){

            if(i > 0 && array[i] == array[i-1]) continue;

            int j = i+1;
            int k = array.length-1;

            while(j <= k){
                int sum = array[i] + array[j] + array[k];
                
                if(sum == 0){
                    List<Integer>tempList = new ArrayList();
                    tempList.add(array[i]);
                    tempList.add(array[j]);
                    tempList.add(array[k]);

                    triplets.add(tempList);
                    
                    j++;
                    k--;
                    while(j < k && array[j] == array[j-1]) j++;
                    while(j < k && array[k] == array[k-1]) k--;
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }

        return triplets;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(threeSum(array));
    }
}
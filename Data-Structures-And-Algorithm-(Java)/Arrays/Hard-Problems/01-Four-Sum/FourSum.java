import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum{


    static List<List<Integer>> fourSum(int [] array, int target){
        List<List<Integer>> qudraplets = new ArrayList();
        for(int i = 0; i < array.length; i++){
            if(i > 0 && array[i] == array[i-1]) continue;
            for(int j = i+1; j < array.length; j++){
                if(j > 0 && array[j] == array[j-1]) continue;

                int k = j+1;
                int l = array.length-1;

                while(k < l){
                    int sum = array[i] + array[j] + array[k] + array[l];

                    if(sum == target){
                        List<Integer> tempList = new ArrayList();
                        tempList.add(array[i]);
                        tempList.add(array[j]);
                        tempList.add(array[k]);
                        tempList.add(array[l]);
                        
                        qudraplets.add(tempList);

                        k++;
                        l--;

                        while(k < l && array[k] == array[k-1])k++;
                        while(k < l && array[l] == array[l-1])l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }

        return qudraplets;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(fourSum(array,target));
    }
}
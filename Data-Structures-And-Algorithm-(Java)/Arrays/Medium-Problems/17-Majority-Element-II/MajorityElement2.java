import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MajorityElement2{


    static List<Integer> majorityElement(int []array){
        int count1 = 0;
        int count2 = 0;

        int element1 = 0;
        int element2 = 0;

        for(int i = 0; i < array.length; i++){
            if(count1 == 0 && array[i] != element2){
                count1++;
                element1 = array[i];
            }else if(count2  == 0 && array[i] != element1){
                count2++;
                element2 = array[i];
            }else if(array[i] == element1){
                count1++;
            }else if(array[i] == element2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int i = 0; i < array.length; i++){
            if(element1 == array[i]){
                count1++;
            }else if(element2 == array[i]){
                count2++;
            }
        }

        int min = (int)(array.length/3)+1;

        List<Integer> ans = new ArrayList();

        if(count1 >= min && element1 != element2){
            ans.add(element1);
            ans.add(element2);
        }else{
            ans.add(element2);
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
        System.out.println(majorityElement(array));
    }
}   
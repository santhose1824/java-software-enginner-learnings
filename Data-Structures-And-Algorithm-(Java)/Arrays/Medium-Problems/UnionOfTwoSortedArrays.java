import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class UnionOfTwoSortedArrays{

    static int [] unionOfArray(int[] arrayOne, int[] arrayTwo){
        int i = 0; 
        int j = 0;

        int n1 = arrayOne.length;
        int n2 = arrayTwo.length;

        List<Integer> unionList = new ArrayList();

        while(i < n1 && j < n2){
            if(arrayOne[i] <= arrayTwo[j]){
                if(unionList.isEmpty() || unionList.get(unionList.size()-1) != arrayOne[i]){
                    unionList.add(arrayOne[i]);
                }
                i++;
            }else{
                if(unionList.isEmpty() || unionList.get(unionList.size()-1) != arrayTwo[j]){
                    unionList.add(arrayTwo[j]);
                }
                j++;
            }
        }

        while(i < n1){
            if(unionList.isEmpty() || unionList.get(unionList.size()-1) != arrayOne[i]){
                    unionList.add(arrayOne[i]);
            }
            i++;
        }

        while(j < n2){
            if(unionList.isEmpty() || unionList.get(unionList.size()-1) != arrayTwo[j]){
                    unionList.add(arrayTwo[j]);
            }
            j++;
        }

        int [] array = new int[unionList.size()];
        int index = 0;
        for(int num : unionList){
            array[index] = num;
            index++;
        }

        return array;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sizeOne = input.nextInt();
        int [] arrayOne = new int[sizeOne];
        for(int i = 0; i < sizeOne; i++){
            arrayOne[i] = input.nextInt();
        }
        int sizeTwo = input.nextInt();
        int [] arrayTwo = new int[sizeTwo];
        for(int i = 0; i < sizeTwo; i++){
            arrayTwo[i] = input.nextInt();
        }
       System.out.println(Arrays.toString(unionOfArray(arrayOne,arrayTwo)));
    }
}
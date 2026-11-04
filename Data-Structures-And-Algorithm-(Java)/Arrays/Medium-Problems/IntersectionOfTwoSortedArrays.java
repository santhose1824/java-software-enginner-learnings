import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays{
    static int [] intersectionOfArray(int [] arrayOne, int [] arrayTwo){
        int i = 0;
        int j = 0;
        int n1 = arrayOne.length;
        int n2 = arrayTwo.length;

        List<Integer> intersectionList = new ArrayList();

        while(i < n1  && j < n2){
            if(arrayOne[i] < arrayTwo [j]){
                i++;
            }else if(arrayTwo[j] > arrayOne[i]){
                j++;
            }else{
                intersectionList.add(arrayOne[i]);
                i++;
                j++;
            }
        }

        int [] array = new int[intersectionList.size()];
        int index = 0;
        for(int num : intersectionList){
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
       System.out.println(Arrays.toString(intersectionOfArray(arrayOne,arrayTwo)));
    }
}
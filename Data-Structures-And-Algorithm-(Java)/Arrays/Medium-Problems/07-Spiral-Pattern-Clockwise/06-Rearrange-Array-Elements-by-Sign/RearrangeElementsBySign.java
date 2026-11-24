import java.util.Scanner;
import java.util.Arrays;
public class RearrangeElementsBySign{

    static int [] rearrangeElementsBySign(int[]array){
        int positiveIndex = 0;
        int negativeIndex = 1;
        int [] newArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                newArray[negativeIndex] = array[i];
                negativeIndex+=2;
            }else{
                newArray[positiveIndex] = array[i];
                positiveIndex+=2;
            }
        }
        return newArray;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int sizeOne = input.nextInt();
        int [] arrayOne = new int[sizeOne];
        for(int i = 0; i < sizeOne; i++){
            arrayOne[i] = input.nextInt();
        }
       System.out.println(Arrays.toString(rearrangeElementsBySign(arrayOne)));
    }
}

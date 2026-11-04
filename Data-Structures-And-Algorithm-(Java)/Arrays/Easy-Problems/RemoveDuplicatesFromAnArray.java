import java.util.Scanner;

public class RemoveDuplicatesFromAnArray{

    static int removeDuplicatesAndReturnSizeOfCountOfUniqueElements(int []array){
        int j = 0;
        int count = 0;
        for(int i = 1; i < array.length; i++){
            if(array[i] != array[j]){
                count++;
            }
            j++;
        }
        return count+1;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       System.out.println(removeDuplicatesAndReturnSizeOfCountOfUniqueElements(array));
    }
}
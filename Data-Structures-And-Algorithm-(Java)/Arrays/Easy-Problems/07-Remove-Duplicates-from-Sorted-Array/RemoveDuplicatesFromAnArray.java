import java.util.Scanner;

public class RemoveDuplicatesFromAnArray{

    static int removeDuplicatesAndReturnSizeOfCountOfUniqueElements(int []array){
       if(array.length == 0) return 0;
       int start = 0;
       for(int end = 1; end <= array.length-1; end++){
            if(array[start] != array[end]){
                start++;
                array[i] = array[j];
            }
       }

       return start+1;
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
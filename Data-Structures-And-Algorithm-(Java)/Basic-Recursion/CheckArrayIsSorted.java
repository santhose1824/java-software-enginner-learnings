import java.util.Scanner;

public class CheckArrayIsSorted{
    static boolean isSorted(int [] array, int i, int j){
        if(i >= array.length-1){
            return true;
        }

        if(array[j] < array[i]){
            return false;
        }

        return isSorted(array,i+1,j+1);
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }

        System.out.println(isSorted(array,0,1));
    }
}
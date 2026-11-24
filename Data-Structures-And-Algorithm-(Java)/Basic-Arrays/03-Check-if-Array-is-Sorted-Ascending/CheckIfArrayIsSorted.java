import java.util.Scanner;

public class CheckIfArrayIsSorted{
    static boolean isSorted(int [] array){
        for(int i = 1; i <= array.length-1; i++){
            if(array[i] < array[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        if(isSorted(array)){
            System.out.println("The given array is sorted");
        }else{
            System.out.println("The given array is not sorted");
        }
    }
}
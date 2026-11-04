import java.util.Scanner;
public class LinearSearch{

    static int linearSearch(int [] array, int target){
        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }
        return -1;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int target = input.nextInt();
       System.out.println(linearSearch(array,target));
    }
}
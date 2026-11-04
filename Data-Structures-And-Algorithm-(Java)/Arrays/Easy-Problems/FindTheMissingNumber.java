import java.util.Scanner;

public class FindTheMissingNumber{
    static int missingNumber(int[]array){
        int xor1 = 0;
        int xor2 = 0;
        
        for(int i = 0; i < array.length-1; i++){
            xor1 = xor1 ^ (i+1);
            xor2 = xor2 ^ array[i];
        }

        return xor1 ^ xor2;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
       System.out.println(missingNumber(array));
    }
}
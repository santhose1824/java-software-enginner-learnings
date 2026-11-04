import java.util.Scanner;

public class CountOddNumbersInArray{
    static int countOfOddElements(int [] array){
        int oddCount =  0;
        for(int i = 0; i <= array.length-1; i++){
            if(array[i] % 2 != 0){
                oddCount++;
            }
        }
        return oddCount;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int odd = countOfOddElements(array);
        System.out.println("The Odd count in the given array is : "+odd);
    }
}
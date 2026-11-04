import java.util.Scanner;

public class SumOfElementsInArray{
    static int sumOfElements(int [] array){
        int sum =  0;
        for(int i = 0; i <= array.length-1; i++){
            sum+=array[i];
        }
        return sum;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        int sum = sumOfElements(array);
        System.out.println("The Sum of all the elements in the given array is : "+sum);
    }
}
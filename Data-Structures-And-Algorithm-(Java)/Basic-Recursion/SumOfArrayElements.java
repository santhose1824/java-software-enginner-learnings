import java.util.Scanner;

public class SumOfArrayElements{
    static int sumOfElements(int [] array, int index){
        if(index >= array.length){
            return 0;
        }

        return array[index] + sumOfElements(array, index+1);

    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int [] array = new int[size];
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        System.out.println(sumOfElements(array,0));
    }
}
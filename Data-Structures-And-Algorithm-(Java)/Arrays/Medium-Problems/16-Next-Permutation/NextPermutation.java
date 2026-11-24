import java.util.Scanner;

public class NextPermutation{

    static void swap(int[]array,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void reverse(int [] array, int i, int j){
        while(i < j){
            swap(array,i,j);
            i++;
            j--;
        }
    }

    static void nextPermutation(int[] array){
        int n = array.length;
        int index = -1;

        for(int i = n-2; i >=0; i--){
            if(array[i] < array[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(array,0,n-1);
        }

        for(int i = n-1; i >=0; i--){
            if(array[i] > array[index]){
                swap(array,i,index);
                break;
            }
        }

        reverse(array,index+1,n-1);
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        nextPermutation(array);

        for(int i = 0; i < n; i++){
           System.out.print(array[i]+" ");
        }
    }
}
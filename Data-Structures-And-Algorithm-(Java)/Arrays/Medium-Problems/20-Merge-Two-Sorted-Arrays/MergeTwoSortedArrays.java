import java.util.Scanner;
import java.util.Arrays;

public class MergeTwoSortedArrays{

    static void mergeTwoSortedArrays(int[]array1,int[]array2,int m, int n){
        int index = (m+n)-1;

        int left = m-1;
        int right = n-1;
        
        while(right >= 0){
            if(left  >= 0 && array1[left] >= array2[right]){
                array1[index] = array1[left];
                index--;
                left--;
            }else{
                array1[index] = array2[right];
                index--;
                right--;
            }
        }
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[]array1 = new int[m+n];
        int[]array2 = new int[n];

        for(int i = 0; i < m; i++){
            array1[i] = input.nextInt();
        }

        for(int i = 0; i < n; i++){
            array2[i] = input.nextInt();
        }

        mergeTwoSortedArrays(array1,array2,m,n);

        System.out.println(Arrays.toString(array1));

    }
}
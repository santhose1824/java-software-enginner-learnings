import java.util.Scanner;

public class UpperBound{

    static int upperBound(int []array, int x){
        int low  = 0;
        int high = array.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int x = input.nextInt();
        System.out.println(upperBound(array, x));
    }
}
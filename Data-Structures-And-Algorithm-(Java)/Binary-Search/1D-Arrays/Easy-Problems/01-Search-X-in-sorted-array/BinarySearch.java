import java.util.Scanner;

public class BinarySearch{


    static int binarySearchInRecursion(int[]array,int x,int low, int high){
        if(low > high){
            return -1;
        }

        int mid = low + (high - low)/2;
        if(array[mid] == x){
            return mid;
        }else if (array[mid] > x){
            return binarySearchInRecursion(array,x,low,mid-1);
        }else{
            return binarySearchInRecursion(array,x,mid+1,high);
        }
    }

    static int binarySearch(int[]array,int x){

        int low  = 0;
        int high = array.length-1; 
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(array[mid] == x){
                return mid;
            }else if(array[mid] > x){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int x = input.nextInt();
        System.out.println(binarySearch(array,x));
        System.out.println(binarySearchInRecursion(array,x,0,array.length-1));
    }
}
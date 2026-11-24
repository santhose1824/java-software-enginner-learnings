import java.util.Scanner;

public class SingleElementInSortedArray{
    
    static int singleElement(int[]array){
        int low =  0;
        int high = array.length-1;

        if(array.length == 1) return array[0];

        if(array[0] != array[1]) return array[0];

        if(array[array.length-1] != array[array.length-2]) return array[array.length-1];

        while(low <= high){
            int mid = low + (high - low)/2;

            if(array[mid] != array[mid-1] && array[mid] != array[mid+1]){
                return array[mid];
            }

            if(
                (mid % 2 == 1 && array[mid-1] == array[mid]) ||
                (mid % 2 == 0 && array[mid] == array[mid+1])
            ){
                low = mid + 1;
            }else{
                high = mid - 1;
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
        System.out.println(singleElement(array));
    }
}
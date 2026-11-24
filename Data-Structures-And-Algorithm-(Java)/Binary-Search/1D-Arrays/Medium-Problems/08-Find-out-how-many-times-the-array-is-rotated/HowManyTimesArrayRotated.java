import java.util.Scanner;

public class HowManyTimesArrayRotated{
    
    static int howManyTimesRotated(int[]array){
        int low = 0;
        int high = array.length-1;

        int minimumElement = Integer.MAX_VALUE;
        int indexOfMinmiumElement = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(array[low] <= array[high]){
                if(array[low] < minimumElement){
                    minimumElement = array[low];
                    indexOfMinmiumElement = low;
                }
                break;
            }

            if(array[low] <= array[mid]){
                if(array[low] < minimumElement){
                    minimumElement = array[low];
                    indexOfMinmiumElement = low;
                }

                low = mid + 1;
            }else{
                if(array[mid] < minimumElement){
                    minimumElement = array[mid];
                    indexOfMinmiumElement = mid;
                }

                high = mid - 1;
            }
        }

        return indexOfMinmiumElement;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(howManyTimesRotated(array));
    }
}
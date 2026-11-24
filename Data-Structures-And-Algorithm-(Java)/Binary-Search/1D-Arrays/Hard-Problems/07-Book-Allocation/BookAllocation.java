import java.util.Scanner;

public class BookAllocation{

    static int noOfStudents(int []array, int m, int mid){
        int students = 1;
        int pages = 0;

        for(int val : array){
            if(pages+val > mid){
                students++;
                pages = 0;
            }
            pages+=val;
        }

        return students;
    }

    static int maxPages(int[]array, int m){
        int n = array.length;
        int ans = -1;
        if(n < m) return ans;

        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int val : array){
            low = Math.max(low,val);
            high += val;
        }

        while(low <= high){
            int mid = low + (high - low)/2;

            if(noOfStudents(array,m,mid) <= m){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return ans;
    }


    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int m = input.nextInt();
        System.out.println(maxPages(array,m));
    }
}
import java.util.Scanner;

public class FindASquareRootOfANumber{
    static int findASquareRootOfANumber(int n){
        int low = 1;
        int high = n;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(mid * mid <= n){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high;

    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(findASquareRootOfANumber(n));
    }
}
import java.util.Scanner;

public class FindNthRootOfNumber{

    static int power(int mid, int m, int n){
        int result = 1;
        int base = mid;

        while(n > 0){
            if(n % 2 == 1){
                result = result * base;
                if(result > m) return 2;
                n--;
            }else{
                n =  n/2;
                base = base * base;
                if(base > m) return 2;
            }
        }

        if(result == m) return 0;

        return 1;
    }

    static int nthRoot(int m, int n){
        int low = 1;
        int high = m;

        while(low <= high){
            int mid = low + (high - low)/2;
            int value = power(mid,m,n);
            if(value == 0) return mid;
            else if(value == 1) low = mid + 1;
            else high = mid - 1;
        }

        return -1;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        System.out.println(nthRoot(m,n));
    }
}
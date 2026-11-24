import java.util.Scanner;

public class MedianOfSortedArrays{

    static double medianOfTwoSortedArrays(int[]array1,int[]array2){
        int n1 = array1.length;
        int n2 = array2.length;

        int n = n1+n2;

        int leftPart = (n+1)/2;

        int low = 0;
        int high = n1-1;

        while(low <= high){
            int mid1 = low + (high - low)/2;
            int mid2 = leftPart - mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;

            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;


            if(mid1 > 0) l1 = array1[mid1-1];
            if(mid2 > 0) l2 = array2[mid2-1];

            if(mid1 < n1) r1 = array1[mid1];
            if(mid2 < n2) r2 = array2[mid2];


            if(l1 <= r2 && l2 <= r1){
                if(n % 2 == 1){
                    return Math.max(l1,l2);
                }else{
                    return (double)((
                        (Math.max((double)l1,(double)l2))  + 
                        (Math.min((double)r1,(double)r2))
                    )/2);
                }
            }else if(l1 > r2){
                low = mid1 + 1;
            }else{
                high = mid1 - 1;
            }
        }

        return 0.0;
    }
    
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        int[]array1 = new int[n1];
        int[]array2 = new int[n2];
        for(int i = 0; i < n1; i++){
            array1[i] = input.nextInt();
        }
        for(int i = 0; i < n2; i++){
            array2[i] = input.nextInt();
        }
        System.out.println(medianOfTwoSortedArrays(array1,array2));
    }
}
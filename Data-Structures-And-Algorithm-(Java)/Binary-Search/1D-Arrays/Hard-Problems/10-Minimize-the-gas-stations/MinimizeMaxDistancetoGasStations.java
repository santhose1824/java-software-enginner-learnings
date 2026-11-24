import java.util.Scanner;
public class MinimizeMaxDistancetoGasStations{


    static int canWePutGasStations(int[]array, int k, double mid){
        int count =  0;
        for(int i = 1; i < array.length; i++){
            count+=(int)(Math.ceil(((double)array[i] - (double)array[i-1])/mid))-1;
        }

        return count;
    }

    static double gasStations(int[]array, int k){
        double low = 0;
        double high = Integer.MIN_VALUE;

        for(int i = 0; i < array.length-1; i++ ){
            high = Math.max(high,array[i+1] - array[i]);
        }

        double limit = 1e-6;

        while(high - low > limit){
            double mid = low + (high - low)/2.0;
            int count = canWePutGasStations(array,k,mid);
            if(count <= k){
                high = mid;
            }else{
               low= mid;
            }
            return high;
        }
        return 0.0;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        int k = input.nextInt();
        System.out.println(gasStations(array,k));
    }
}
import java.util.Scanner;
import java.util.Arrays;

public class FindMissingAndRepeating{

    static int [] findMissingAndRepeating(int[]array){
        int n = array.length;
        int sumOfAllElements = 0;
        int sumOfSquaresOfAllElements = 0;
        int sumOfNaturalNumbers = (n*(n+1))/2;
        int sumOfSquaresOfNaturalNumbers = (n*(n+1)*(2*n+1))/6;;

        for(int i = 0; i < n; i++){
            sumOfAllElements+=array[i];
            sumOfSquaresOfAllElements+= array[i]*array[i];
        }

        int equationOne = sumOfAllElements - sumOfNaturalNumbers;
        int equationTwo = sumOfSquaresOfAllElements - sumOfSquaresOfNaturalNumbers;

        equationTwo = equationTwo / equationOne;

        int x = (equationOne + equationTwo)/2;
        int y = x - equationOne;

        int [] ans = new int[2];

        ans[0] = x;
        ans[1] = y;


        return ans;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[]array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(findMissingAndRepeating(array)));
    }
}
import java.util.Scanner;

public class LargestOddNumberInString{
    static String largestOddNumber(String s){

        int firstOddIndex = -1;
        int n = s.length();

        for(int i = n-1; i >=0; i--){
            if((s.charAt(i)-'0')%2!=0){
                firstOddIndex = i;
                break;
            }
        }

        if(firstOddIndex == -1){
            return "";
        }

        int firstNonZeroIndex = 0;
        while(firstNonZeroIndex <= firstOddIndex && s.charAt(firstNonZeroIndex) == '0'){
            firstNonZeroIndex++;
        }

        return s.substring(firstNonZeroIndex,firstOddIndex+1);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String oddNumber = largestOddNumber(s);
        System.out.println(oddNumber);
    }
}
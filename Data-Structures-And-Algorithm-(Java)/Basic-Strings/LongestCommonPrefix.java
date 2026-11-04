import java.util.Scanner;
import java.util.Arrays;

public class LongestCommonPrefix{
    static String longestPrefix(String[] s){
        Arrays.sort(s);

        String firstString = s[0];
        String secondString = s[s.length-1];

        int minLength = Math.min(firstString.length(),secondString.length());

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < minLength; i++){
            if(firstString.charAt(i) != secondString.charAt(i)){
                break;
            }
            builder.append(firstString.charAt(i));
        }

        return builder.toString();
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();

        String [] s = new String[size];

        for(int i = 0; i < size; i++){
            s[i] = input.next();
        }

        System.out.println(longestPrefix(s));
    }
}
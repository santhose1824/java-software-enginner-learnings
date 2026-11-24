import java.util.Scanner;
import java.util.Arrays;

public class LongestCommonPrefix{
    static String longestPrefix(String[] s){
       if(s.length == 0) return " ";
       for(int i = 0; i <= s[0].length()-1; i++){
            char ch = s[0].charAt(i);
            for(String str : s){
                if(i == str.length() || str.charAt(i) != ch){
                    return s[0].substring(0,i);
                }
            }
       }

       return s[0];
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
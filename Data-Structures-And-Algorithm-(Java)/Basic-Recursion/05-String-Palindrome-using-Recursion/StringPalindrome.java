import java.util.Scanner;

public class StringPalindrome{
    static boolean isPalindrome(String s, int start, int end){
        if(start >= end){
            return true;
        }
        if(s.charAt(start) != s.charAt(end)){
            return false;
        }

        return isPalindrome(s,start+1,end-1);
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(isPalindrome(s,0,s.length()-1));
    }
}
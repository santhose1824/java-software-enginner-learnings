import java.util.Scanner;

public class Palindrome{
    static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(isPalindrome(s));
    }
}
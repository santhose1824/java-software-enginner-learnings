import java.util.Scanner;

public class ValidAnagram{
    static boolean isValidAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int [] array = new int[26];
        for(char ch: s.toCharArray()){
            array[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            array[ch-'a']--;
        }

        for(int num: array){
            if(num != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = input.next();

        System.out.println(isValidAnagram(s,t));
    }
}
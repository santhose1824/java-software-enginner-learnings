import java.util.Scanner;

public class IsomorphicString{
    static boolean isIsomorphic(String s,String t){
        if(s.length() != t.length()){
            return false;
        }

        int [] arrayOne = new int[256];
        int [] arrayTwo = new int[256];

        for(int i = 0; i < s.length(); i++){
            if(arrayOne[s.charAt(i)] != arrayTwo[t.charAt(i)]){
                break;
            }

            arrayOne[s.charAt(i)]++;
            arrayTwo[t.charAt(i)]++;
        }
        return true;
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String t = input.next();

        System.out.println(isIsomorphic(s,t));
    }
}
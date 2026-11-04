import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReverseAString{
    static void reverse(List<Character> s){
        int start = 0;
        int end = s.size()-1;

        while(start < end){
            char temp = s.get(start);
            s.set(start,s.get(end));
            s.set(end,temp);

            start++;
            end--;
        }
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        List<Character> s = new ArrayList();
        for(int i = 0; i < size; i++){
            s.add(input.next().charAt(0));
        }

        System.out.println("The string array before reverse : "+s);
        reverse(s);
        System.out.println("The string array after reverse : "+s);

    }
}
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SortCharactersByFrequency{
    static char[] sortCharatersByFrequency(String s){
        Map<Character,Integer> map = new HashMap();

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        System.out.println(map);

        System.out.println(map.keySet());

        List<Character> uniqueCharacters = new ArrayList(map.keySet());

        uniqueCharacters.sort((a,b) ->{
            int frequencyA = map.get(a);
            int frequencyB = map.get(b);

            return a-b;
        });

        System.out.println(uniqueCharacters);

        char [] chars = new char[uniqueCharacters.size()];

        for(int i = 0; i < chars.length; i++){
            chars[i] = uniqueCharacters.get(i);
        }

        return chars;
    }


    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(Arrays.toString(sortCharatersByFrequency(s)));
    }
}   
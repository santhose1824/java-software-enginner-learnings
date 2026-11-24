import java.util.Scanner;

public class StringRotation{
    static boolean isRotate(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(s);
        builder.append(s);

        String combinedString = builder.toString();

        return combinedString.contains(goal);
    }

    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        String s = input.next();
        String goal = input.next();

        System.out.println(isRotate(s,goal));
    }
}
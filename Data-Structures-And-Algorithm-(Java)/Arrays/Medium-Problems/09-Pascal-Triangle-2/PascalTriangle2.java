import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle2{
    static List<Integer> generateNthRow(int row){
        List<Integer> nthRow = new ArrayList();

        nthRow.add(1);
        int element = 1;
        for(int i = 1; i < row; i++){
            element = element*(row-i);
            element = element/(i);
            nthRow.add(element);
        }

        return nthRow;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int row = input.nextInt();

        System.out.println(generateNthRow(row));
    }
}
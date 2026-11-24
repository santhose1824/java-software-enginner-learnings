import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PascalTriangle3{

    static List<Integer> generateRow(int row){
        List<Integer> ithRow = new ArrayList();
        ithRow.add(1);
        int element = 1;
        for(int i = 1; i < row; i++){
            element = element*(row-i);
            element = element/(i);
            ithRow.add(element);
        }
        return ithRow;
    }

    static List<List<Integer>> drawPascalTriangleForGivenN(int n){
        List<List<Integer>> pascalTriangle = new ArrayList();
        for(int i = 1; i <= n; i++){
            pascalTriangle.add(generateRow(i));
        }
        return pascalTriangle;
    }

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        System.out.println(drawPascalTriangleForGivenN(n));
    }
}
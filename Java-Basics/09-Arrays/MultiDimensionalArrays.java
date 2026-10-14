import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArrays {

    public static void main(String[] args) {

        // ---- 2D array: [rows][cols] ----
        int[][] arr = new int[2][2];          // 2 rows, 2 cols
        arr[0][0] = 1; arr[0][1] = 2;
        arr[1][0] = 3; arr[1][1] = 4;

        // ---- directly write ----
        int[][] arr2 = { {1, 2}, {3, 4}, {5, 6} };

        // ---- Accessing ----
        System.out.println("1st array, 1st element: " + arr2[0][0]);   // 1
        System.out.println("2nd array, 1st element: " + arr2[1][0]);   // 3

        // ---- Column size is NOT necessary ----
        // A 2D array is an "array of arrays". Each inner array lives somewhere else in the heap,
        // so the size of each inner array does not matter - they can differ (jagged array).
        int[][] jagged = new int[3][];        // only rows specified
        jagged[0] = new int[]{1, 2, 3};
        jagged[1] = new int[]{4, 5};
        jagged[2] = new int[]{1};

        int[][] jagged2 = { {1, 2, 3}, {4, 5}, {1} };

        // In 2D arrays arr.length gives the number of ROWS; arr[i].length gives columns of row i
        System.out.println("rows = " + jagged2.length);
        for (int i = 0; i < jagged2.length; i++) {
            System.out.println("row " + i + " has " + jagged2[i].length + " columns");
        }

        // ---- Input from user ----
        Scanner input = new Scanner(System.in);
        int[][] in = new int[2][3];
        System.out.println("Enter 6 numbers (2 rows x 3 cols):");
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                in[i][j] = input.nextInt();
            }
        }

        // ---- Output 1: element by element ----
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                System.out.print(in[i][j] + " ");
            }
            System.out.println();
        }

        // ---- Output 2: row by row using Arrays.toString ----
        for (int i = 0; i < in.length; i++) {
            System.out.println(Arrays.toString(in[i]));
        }

        // ---- Output 3: for-each ----
        for (int[] row : in) {
            System.out.println(Arrays.toString(row));
        }

        // ---- Output 4: Arrays.deepToString for multi-dimensional arrays ----
        System.out.println(Arrays.deepToString(in));

        // ---- 3D array ----
        int[][][] cube = new int[2][3][4];
        System.out.println("3D: " + cube.length + " x " + cube[0].length + " x " + cube[0][0].length);

        input.close();
    }
}

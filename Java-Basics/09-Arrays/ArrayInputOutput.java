import java.util.Arrays;
import java.util.Scanner;

public class ArrayInputOutput {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];

        // ---- Take array input ----
        // arr.length gives the overall length. Index runs 0 -> length-1
        // (if length = 5 we add elements up to index 4; using index 5 -> error)
        System.out.println("Enter 5 numbers:");
        for (int index = 0; index <= arr.length - 1; index++) {
            arr[index] = input.nextInt();
        }

        // ---- Output 1: with index ----
        for (int index = 0; index <= arr.length - 1; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();

        // ---- Output 2: for-each (no index, data only) ----
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ---- Output 3: Arrays.toString (java.util) ----
        System.out.println(Arrays.toString(arr));

        // ---- Array of objects (String array input) ----
        String[] strArray = new String[3];
        System.out.println("Enter 3 words:");
        for (int i = 0; i <= strArray.length - 1; i++) {
            strArray[i] = input.next();
        }
        System.out.println(Arrays.toString(strArray));

        input.close();
    }
}

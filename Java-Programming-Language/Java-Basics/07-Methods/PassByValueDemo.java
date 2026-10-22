import java.util.Arrays;

// In Java there is ONLY pass by value - no pass by reference.
//  1. Primitives  -> the value itself is copied
//  2. Objects / Strings / arrays -> the VALUE OF THE REFERENCE (an address) is copied
public class PassByValueDemo {

    static void changePrimitive(int x) {
        x = 100;                                   // changes only the local copy
        System.out.println("inside changePrimitive: x = " + x);
    }

    static void changeArrayContent(int[] arr) {
        arr[0] = 999;                              // same object -> change IS visible outside
    }

    static void reassignArray(int[] arr) {
        arr = new int[]{7, 7, 7};                  // only the local reference now points elsewhere
        System.out.println("inside reassignArray: " + Arrays.toString(arr));
    }

    static void changeString(String s) {
        s = s + " World";                          // Strings are immutable -> new object, outside unchanged
        System.out.println("inside changeString: " + s);
    }

    static void changeStringBuilder(StringBuilder sb) {
        sb.append(" World");                       // mutates the same object -> visible outside
    }

    public static void main(String[] args) {
        int a = 10;
        changePrimitive(a);
        System.out.println("after changePrimitive: a = " + a);         // still 10

        int[] arr = {1, 2, 3};
        changeArrayContent(arr);
        System.out.println("after changeArrayContent: " + Arrays.toString(arr));   // [999, 2, 3]

        reassignArray(arr);
        System.out.println("after reassignArray: " + Arrays.toString(arr));        // unchanged

        String s = "Hello";
        changeString(s);
        System.out.println("after changeString: " + s);                // Hello

        StringBuilder sb = new StringBuilder("Hello");
        changeStringBuilder(sb);
        System.out.println("after changeStringBuilder: " + sb);        // Hello World
    }
}

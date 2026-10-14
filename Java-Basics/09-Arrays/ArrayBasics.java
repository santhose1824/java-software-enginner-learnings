import java.util.Arrays;

public class ArrayBasics {

    public static void main(String[] args) {

        // Syntax:  dataType[] arrayName = new dataType[size];

        // 1. Declaration (stack: only a reference variable) + initialisation (heap: the object)
        int[] roll;                 // declaration  -> reference variable "roll" in the STACK (points to nothing yet)
        roll = new int[5];          // object created in the HEAP (runtime) - dynamic memory allocation

        // 2. Declaration + creation in one line
        int[] marks = new int[5];

        // 3. Directly write the values
        int[] rollNos = {23, 12, 45, 12, 2};

        // ---- default values ----
        System.out.println("int[] default    : " + Arrays.toString(new int[3]));
        System.out.println("double[] default : " + Arrays.toString(new double[3]));
        System.out.println("boolean[] default: " + Arrays.toString(new boolean[3]));
        System.out.println("String[] default : " + Arrays.toString(new String[3]));   // null

        // ---- index: 0 to (size - 1) ----
        int[] arr = {3, 8, 19, 12, 7, 28, 33};
        System.out.println("length   : " + arr.length);                  // 7  (property, not a method)
        System.out.println("arr[0]   : " + arr[0]);                      // 3  -> first
        System.out.println("arr[6]   : " + arr[6]);                      // 33 -> last (length - 1)
        System.out.println("last     : " + arr[arr.length - 1]);

        // ---- update ----
        arr[0] = 100;
        System.out.println("updated  : " + Arrays.toString(arr));

        // ---- going out of bounds ----
        try {
            System.out.println(arr[7]);                                  // index 7 does not exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // ---- null: reference types start as null ----
        String[] names = new String[3];
        System.out.println("names[0] = " + names[0]);                    // null
        // String s = null; fine.   int x = null; ERROR - null only for non-primitives
        names[0] = "Santhosh";
        System.out.println(Arrays.toString(names));

        // ---- arrays are objects: two references to same array ----
        int[] a = {1, 2, 3};
        int[] b = a;                     // b points to the SAME array
        b[0] = 99;
        System.out.println("a = " + Arrays.toString(a));                // [99, 2, 3]
        int[] copy = Arrays.copyOf(a, a.length);   // real copy
        copy[0] = 1;
        System.out.println("a = " + Arrays.toString(a) + ", copy = " + Arrays.toString(copy));

        // ---- useful java.util.Arrays methods ----
        int[] nums = {5, 2, 9, 1};
        Arrays.sort(nums);
        System.out.println("sorted       : " + Arrays.toString(nums));
        System.out.println("binarySearch : " + Arrays.binarySearch(nums, 9));
        System.out.println("equals       : " + Arrays.equals(new int[]{1, 2}, new int[]{1, 2}));
        int[] filled = new int[4];
        Arrays.fill(filled, 7);
        System.out.println("fill         : " + Arrays.toString(filled));

        // printing an array directly shows type@hashcode - not useful
        System.out.println("direct print : " + nums);   // e.g. [I@6d06d69c
    }
}

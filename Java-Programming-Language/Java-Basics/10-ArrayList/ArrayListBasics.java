import java.util.ArrayList;

// Dynamic array: Java manages the size for us.
// Syntax: ArrayList<WrapperClass> name = new ArrayList<>();
//         (we can also pass an initial capacity: new ArrayList<>(50))
public class ArrayListBasics {

    public static void main(String[] args) {

        // ArrayList stores OBJECTS - so use wrapper classes: Integer, Double, Character, Boolean ...
        // ArrayList<int> list = new ArrayList<>();       // ERROR: primitives not allowed
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>(50);    // initial capacity 50 (size is still 0)

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);                         // [10, 20, 30]  - toString() is overridden
        System.out.println("size = " + list.size());      // 0-based index, size is the number of items
        System.out.println("names.size() = " + names.size());

        // input from user would be:  list.add(input.nextInt());

        // loops
        for (int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.println();
        for (int x : list) System.out.print(x + " ");
        System.out.println();

        // Autoboxing: int <-> Integer happens automatically
        int first = list.get(0);

        // GOTCHA: remove(int index) vs remove(Object)
        list.remove(1);                                   // removes at INDEX 1  -> [10, 30]
        list.remove(Integer.valueOf(10));                 // removes the OBJECT 10 -> [30]
        System.out.println(list);

        // ArrayList can hold other ArrayLists (2D)
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) matrix.get(i).add(i * 3 + j);
        }
        System.out.println(matrix);
    }
}

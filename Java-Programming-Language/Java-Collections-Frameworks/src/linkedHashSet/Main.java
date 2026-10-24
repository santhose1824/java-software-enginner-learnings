package linkedHashSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creating the object of LinkedHashSet
        // Everything we used in hashSet is there the only difference is it is sorted.
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 1; i <= 10; i++) {
            // add the elements.
            set.add(i);
        }
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.print(set+" ");
        System.out.println();

        // subset
        Set<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            set2.add(i*2);
        }
        // subset - returns a subset if present
        System.out.println(set.containsAll(set2));

        // union - Add all the elements from set to set2.
        set.addAll(set2);
        System.out.println(set);

        // difference - remove the common elements in both set and set2.
        set.removeAll(set2);
        System.out.println(set);

        // intersection - return the common elements in set and set2.
        set.retainAll(set2);
        System.out.println(set);

        // clear the set.
        set.clear();
        set2.clear();
        System.out.println(set);
        System.out.println(set2);

    }
}

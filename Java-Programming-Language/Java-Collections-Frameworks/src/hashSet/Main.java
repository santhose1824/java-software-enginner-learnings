package hashSet;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creating the object of hasSet.
        // Duplicates are not allowed.
        Set<Integer> set = new HashSet<>();

        // Add the elements
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(set);

        // subset
        Set<Integer> set2 = new HashSet<>();
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


        // No ordering for set.
        for (int i = 0; i < 10; i++) {
            set2.add(i*2);
        }

        for(Integer i : set2){
            System.out.print(i+" ");
        }

    }
}

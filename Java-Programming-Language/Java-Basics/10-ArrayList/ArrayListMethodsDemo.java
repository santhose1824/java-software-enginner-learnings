import java.util.*;
import java.util.function.Predicate;

/**
 * Example of EVERY ArrayList method (from my notes) - one static method per ArrayList method.
 * Run:  java ArrayListMethodsDemo.java
 */
public class ArrayListMethodsDemo {

    static void title(String t) {
        System.out.println("\n=== " + t + " ===");
    }

    // helper to build a fresh list for each demo
    static ArrayList<Integer> fresh() {
        return new ArrayList<>(Arrays.asList(10, 20, 30, 20, 40));
    }

    // 1. add(element)  -> boolean
    static void addDemo() {
        title("add(element) : adds item at the END, returns boolean");
        ArrayList<Integer> list = new ArrayList<>();
        boolean r = list.add(5);
        list.add(6);
        System.out.println(list + " returned " + r);
    }

    // 1b. add(index, element) -> void
    static void addAtIndexDemo() {
        title("add(index, element) : inserts at a position, shifts the rest, returns void");
        ArrayList<Integer> list = fresh();
        list.add(1, 99);
        System.out.println(list);
    }

    // 2. addAll(collection) -> boolean
    static void addAllDemo() {
        title("addAll(collection) : adds a collection of items, returns boolean");
        ArrayList<Integer> list = fresh();
        ArrayList<Integer> other = new ArrayList<>(List.of(1, 2, 3));
        boolean r = list.addAll(other);
        System.out.println(list + " returned " + r);
        list.addAll(0, List.of(-1, -2));                       // addAll(index, collection)
        System.out.println("addAll(0, [-1,-2]) -> " + list);
    }

    // 3. clear() -> void
    static void clearDemo() {
        title("clear() : removes all items, returns void");
        ArrayList<Integer> list = fresh();
        list.clear();
        System.out.println(list + " size = " + list.size());
    }

    // 4. clone() -> Object
    static void cloneDemo() {
        title("clone() : shallow copy of the ArrayList, returns Object");
        ArrayList<Integer> list = fresh();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> copy = (ArrayList<Integer>) list.clone();   // cast needed - returns Object
        copy.add(1000);
        System.out.println("original = " + list);
        System.out.println("clone    = " + copy);
    }

    // 5. contains(element) -> boolean
    static void containsDemo() {
        title("contains(element) : does the item exist?");
        ArrayList<Integer> list = fresh();
        System.out.println("contains(30) = " + list.contains(30));
        System.out.println("contains(99) = " + list.contains(99));
    }

    // 6. ensureCapacity(n) -> void
    static void ensureCapacityDemo() {
        title("ensureCapacity(n) : increases capacity to fit n items (size unchanged), returns void");
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(1000);
        System.out.println("size after ensureCapacity(1000) = " + list.size() + " (capacity is internal)");
    }

    // 7. forEach(action) -> void
    static void forEachDemo() {
        title("forEach(action) : performs an action on each element, returns void");
        ArrayList<Integer> list = fresh();
        list.forEach(x -> System.out.print(x * 2 + " "));
        System.out.println();
        list.forEach(System.out::println);                     // method reference
    }

    // 8. get(index) -> T
    static void getDemo() {
        title("get(index) : returns the item at a specific position");
        ArrayList<Integer> list = fresh();
        System.out.println("get(0) = " + list.get(0) + ", get(4) = " + list.get(4));
        try {
            list.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("get(10) -> " + e.getMessage());
        }
    }

    // 9. indexOf(element) -> int
    static void indexOfDemo() {
        title("indexOf(element) : position of FIRST occurrence (-1 if absent)");
        ArrayList<Integer> list = fresh();
        System.out.println("indexOf(20) = " + list.indexOf(20));
        System.out.println("indexOf(99) = " + list.indexOf(99));
    }

    // 10. isEmpty() -> boolean
    static void isEmptyDemo() {
        title("isEmpty() : is the list empty?");
        System.out.println(new ArrayList<Integer>().isEmpty() + " / " + fresh().isEmpty());
    }

    // 11. iterator() -> Iterator
    static void iteratorDemo() {
        title("iterator() : returns an Iterator object for the ArrayList");
        ArrayList<Integer> list = fresh();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int v = it.next();
            if (v == 20) it.remove();                          // safe removal while looping
        }
        System.out.println(list);
    }

    // 12. lastIndexOf(element) -> int
    static void lastIndexOfDemo() {
        title("lastIndexOf(element) : position of LAST occurrence");
        ArrayList<Integer> list = fresh();
        System.out.println("lastIndexOf(20) = " + list.lastIndexOf(20));
    }

    // 13. listIterator() -> ListIterator
    static void listIteratorDemo() {
        title("listIterator() : ListIterator - can move forward AND backward, add, set");
        ArrayList<Integer> list = fresh();
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int idx = it.nextIndex();
            int v = it.next();
            if (v == 30) it.set(300);                          // replace current
            if (idx == 0) it.add(15);                          // insert after current
        }
        System.out.println("forward  : " + list);
        System.out.print("backward : ");
        while (it.hasPrevious()) System.out.print(it.previous() + " ");
        System.out.println();
    }

    // 14. remove(index) / remove(Object) -> E / boolean
    static void removeDemo() {
        title("remove() : removes an item from the list");
        ArrayList<Integer> list = fresh();
        int removed = list.remove(0);                          // by INDEX -> returns the removed element
        System.out.println("remove(0) removed " + removed + " -> " + list);
        boolean b = list.remove(Integer.valueOf(20));          // by OBJECT -> returns boolean (first match only)
        System.out.println("remove(Integer.valueOf(20)) = " + b + " -> " + list);
    }

    // 15. removeAll(collection) -> boolean
    static void removeAllDemo() {
        title("removeAll(collection) : removes every item that is present in the given collection");
        ArrayList<Integer> list = fresh();
        boolean r = list.removeAll(List.of(20, 40));
        System.out.println(list + " returned " + r);
    }

    // 16. removeIf(predicate) -> boolean
    static void removeIfDemo() {
        title("removeIf(condition) : removes all items which meet the condition");
        ArrayList<Integer> list = fresh();
        Predicate<Integer> greaterThan25 = x -> x > 25;
        boolean r = list.removeIf(greaterThan25);
        System.out.println(list + " returned " + r);
    }

    // 17. replaceAll(operator) -> void
    static void replaceAllDemo() {
        title("replaceAll(operator) : replaces each item with the result of an operation on that item");
        ArrayList<Integer> list = fresh();
        list.replaceAll(x -> x + 1);
        System.out.println(list);
    }

    // 18. retainAll(collection) -> boolean
    static void retainAllDemo() {
        title("retainAll(collection) : removes all elements which do NOT belong to the collection");
        ArrayList<Integer> list = fresh();
        list.retainAll(List.of(20, 40, 99));
        System.out.println(list);
    }

    // 19. set(index, element) -> T (returns the old value)
    static void setDemo() {
        title("set(index, element) : replaces item at a position, returns the OLD item");
        ArrayList<Integer> list = fresh();
        int old = list.set(2, 333);
        System.out.println("old = " + old + ", list = " + list);
    }

    // 20. size() -> int
    static void sizeDemo() {
        title("size() : number of items in the list");
        System.out.println(fresh().size());
    }

    // 21. sort(comparator) -> void
    static void sortDemo() {
        title("sort() : sorts the list");
        ArrayList<Integer> list = fresh();
        list.sort(null);                                       // null = natural (ascending) order
        System.out.println("ascending  : " + list);
        list.sort(Comparator.reverseOrder());
        System.out.println("descending : " + list);
        Collections.sort(list);                                // another way
        System.out.println("Collections.sort : " + list);
    }

    // 22. spliterator() -> Spliterator
    static void spliteratorDemo() {
        title("spliterator() : returns a Spliterator (for traversing / splitting for parallel processing)");
        ArrayList<Integer> list = fresh();
        Spliterator<Integer> sp = list.spliterator();
        System.out.println("estimated size = " + sp.estimateSize());
        sp.tryAdvance(x -> System.out.println("first element = " + x));
        sp.forEachRemaining(x -> System.out.print(x + " "));
        System.out.println();
    }

    // 23. subList(from, to) -> List
    static void subListDemo() {
        title("subList(from, to) : view of a range (from inclusive, to exclusive)");
        ArrayList<Integer> list = fresh();
        List<Integer> sub = list.subList(1, 4);
        System.out.println(sub);
        sub.set(0, 777);                                       // it is a VIEW - changes the original too
        System.out.println("original after change = " + list);
    }

    // 24. toArray() -> Object[]
    static void toArrayDemo() {
        title("toArray() : returns an array containing the list's items");
        ArrayList<Integer> list = fresh();
        Object[] objs = list.toArray();                         // Object[]
        Integer[] ints = list.toArray(new Integer[0]);          // typed array
        System.out.println(Arrays.toString(objs) + " | " + Arrays.toString(ints));
    }

    // 25. trimToSize() -> void
    static void trimToSizeDemo() {
        title("trimToSize() : reduces the capacity of the list to match the number of items");
        ArrayList<Integer> list = new ArrayList<>(100);
        list.add(1);
        list.add(2);
        list.trimToSize();
        System.out.println("size = " + list.size() + " (capacity trimmed from 100 to 2 internally)");
    }

    // ---- Bonus methods commonly asked ----
    static void bonusDemo() {
        title("BONUS: containsAll, equals, hashCode, Collections helpers, stream");
        ArrayList<Integer> list = fresh();
        System.out.println("containsAll([10,20]) = " + list.containsAll(List.of(10, 20)));
        System.out.println("equals               = " + list.equals(new ArrayList<>(List.of(10, 20, 30, 20, 40))));
        System.out.println("Collections.max      = " + Collections.max(list));
        System.out.println("Collections.min      = " + Collections.min(list));
        Collections.reverse(list);
        System.out.println("Collections.reverse  = " + list);
        Collections.swap(list, 0, 1);
        System.out.println("Collections.swap     = " + list);
        System.out.println("frequency of 20      = " + Collections.frequency(list, 20));
        System.out.println("stream sum           = " + list.stream().mapToInt(Integer::intValue).sum());
        System.out.println("fixed-size List.of   -> add() would throw UnsupportedOperationException");
    }

    public static void main(String[] args) {
        addDemo();
        addAtIndexDemo();
        addAllDemo();
        clearDemo();
        cloneDemo();
        containsDemo();
        ensureCapacityDemo();
        forEachDemo();
        getDemo();
        indexOfDemo();
        isEmptyDemo();
        iteratorDemo();
        lastIndexOfDemo();
        listIteratorDemo();
        removeDemo();
        removeAllDemo();
        removeIfDemo();
        replaceAllDemo();
        retainAllDemo();
        setDemo();
        sizeDemo();
        sortDemo();
        spliteratorDemo();
        subListDemo();
        toArrayDemo();
        trimToSizeDemo();
        bonusDemo();
    }
}

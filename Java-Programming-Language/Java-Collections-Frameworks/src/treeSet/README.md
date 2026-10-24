# SortedSet, NavigableSet and TreeSet

## What I learnt
A `TreeSet` is a `Set` that is always **sorted**. It is built on top of the `SortedSet` and `NavigableSet` interfaces, which let us ask questions like "what is the smallest element that is >= 25?".

## My notes

### SortedSet
1. It **extends the `Set` interface** to provide functionality for handling **sorted sets**.
2. Since the elements are sorted, **travelling** the set either using the for-each loop or an iterator will access the elements **according to the ordering used by the set**.
3. Methods:
   1. `E first()`
   2. `E last()`

### NavigableSet
1. **Extends the `SortedSet` interface** with **navigation methods** to find the **closest matches** for specific search targets.
2. By **navigation**, we mean operations that require **searching for elements** in the navigable set.
3. In the absence of elements, these operations **return `null`** rather than throw `NoSuchElementException`.

| Method | Meaning |
|--------|---------|
| `E pollFirst()` | remove and return the **first** (smallest) element |
| `E pollLast()` | remove and return the **last** (largest) element |
| `E ceiling(E e)` | **least** element **>= e** |
| `E floor(E e)` | **greatest** element **<= e** |
| `E higher(E e)` | least element **> e** |
| `E lower(E e)` | greatest element **< e** |

## Example (verified)
```java
TreeSet<Integer> ts = new TreeSet<>(List.of(50, 10, 40, 20, 30));
System.out.println(ts);                          // [10, 20, 30, 40, 50]   (sorted automatically)
System.out.println(ts.first() + " " + ts.last());// 10 50

System.out.println(ts.ceiling(25));              // 30  (least >= 25)
System.out.println(ts.floor(25));                // 20  (greatest <= 25)
System.out.println(ts.higher(30));               // 40  (least > 30)
System.out.println(ts.lower(30));                // 20  (greatest < 30)

System.out.println(ts.headSet(30));              // [10, 20]        (elements < 30)
System.out.println(ts.tailSet(30));              // [30, 40, 50]    (elements >= 30)
System.out.println(ts.subSet(20, 40));           // [20, 30]        (from inclusive, to exclusive)
System.out.println(ts.descendingSet());          // [50, 40, 30, 20, 10]
System.out.println(new TreeSet<Integer>().pollFirst());   // null   (no exception)
// new TreeSet<Integer>().first();               // NoSuchElementException
```

### Custom ordering with a `Comparator`
```java
TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
set.add("java"); set.add("JAVA"); set.add("Python");
System.out.println(set);          // [java, Python]  -> "JAVA" counted as a duplicate!
```
A `TreeSet` decides "duplicate" using **`compareTo` / `compare` returning 0**, **not** `equals()`.

### Extra (not in my notes yet)
- Backed by a **`TreeMap`** (a **red-black tree**, self-balancing).
- `add`, `remove`, `contains` are **O(log n)**.
- **No `null`** elements (`NullPointerException`).
- Elements must be **`Comparable`**, or you pass a **`Comparator`** (else `ClassCastException`).
- Not thread-safe (`ConcurrentSkipListSet` is the concurrent version).

## Interview Questions
1. **What is a `TreeSet`?**
   A sorted `Set` implementation backed by a red-black tree (via `TreeMap`).
2. **How does it keep elements sorted?**
   Using the natural ordering (`Comparable.compareTo`) or a `Comparator` given in the constructor.
3. **Time complexity of `add`, `remove`, `contains`?**
   O(log n).
4. **Can `TreeSet` hold `null`?**
   No, `NullPointerException`.
5. **How does `TreeSet` detect duplicates?**
   If `compareTo`/`compare` returns 0 the elements are treated as equal. `equals()` is not used.
6. **What if my class is not `Comparable`?**
   `ClassCastException` at runtime on the first `add` - make it `Comparable` or pass a `Comparator`.
7. **`ceiling` vs `floor` vs `higher` vs `lower`?**
   `ceiling` >=, `floor` <=, `higher` >, `lower` <. All return `null` if none exists.
8. **`first()` vs `pollFirst()`?**
   `first()` returns the smallest (throws `NoSuchElementException` if empty); `pollFirst()` removes and returns it (returns `null` if empty).
9. **`SortedSet` vs `NavigableSet`?**
   `NavigableSet` adds navigation methods (`ceiling`, `floor`, `higher`, `lower`, `pollFirst`, `pollLast`, `descendingSet`).
10. **`HashSet` vs `LinkedHashSet` vs `TreeSet`?**
    No order & O(1); insertion order & O(1); sorted order & O(log n).
11. **How do you sort in descending order?**
    `new TreeSet<>(Comparator.reverseOrder())` or `descendingSet()`.
12. **What are `headSet`, `tailSet`, `subSet`?**
    Views of the elements below / from / between given bounds.
13. **Comparable vs Comparator?**
    `Comparable`: natural order inside the class (`compareTo`). `Comparator`: external order (`compare`).
14. **Is `TreeSet` thread-safe?**
    No. `Collections.synchronizedSortedSet()` or `ConcurrentSkipListSet`.

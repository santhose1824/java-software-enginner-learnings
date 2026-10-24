# List, ArrayList and Vector

## What I learnt
`List` is the most used collection type. An `ArrayList` is a **dynamic array**: use it when you don't know what the size of the array is going to be.

## My notes

### `List` interface
1. Lists are collections that **maintain their elements in order** and can **contain duplicates**.
2. The elements in a list are **ordered**.
3. Each element is **position based**, starting from index 0.

### List methods (`E` = generic type)
1. `E get(int index)`
2. `E set(int index, E element)`
3. `void add(int index, E element)`
4. `boolean addAll(int index, Collection<? extends E> c)`
5. `E remove(int index)`

### Three implementations of `List` (in `java.util`)
1. `ArrayList`
2. `LinkedList`
3. `Vector`

These are **classes** that implement the **`List` interface**, which extends the **`Collection` interface**, which extends the **`Iterable` interface**.

### 1. ArrayList
1. It is a **dynamic array**.
2. To be used when we don't know what is going to be the size of the array.
3. Internally it uses a **normal array**, set to some **default capacity**.
4. When the capacity is reached, it creates a **new array of bigger size (50% of its current capacity)** and **copies all the elements** from the old array to the new array.
5. The new array's reference is used for its internal usage.

### 2. Vector class
1. The `Vector` class is a **legacy class** which implements the `List` interface.
2. `Vector` and `ArrayList` are implemented using **dynamically resizable arrays**, providing **fast random access** (position-based access) and fast list traversal - very much like an ordinary array.
3. Unlike `ArrayList`, the `Vector` class is **thread safe**: concurrent calls to the vector will not compromise its integrity.
4. `ArrayList` and `Vector` offer **comparable performance**, but `Vector` suffers a slight performance penalty due to **synchronisation**.

### Rule: use the interface as the reference type
```java
List<String> list = new ArrayList<>();
```

(`ArrayList` vs `LinkedList` is in the `linkedList` folder. `ListIterator` is in the `iterators` folder.)

## ArrayList programs: methods with examples
Method-by-method examples (add, addAll, clear, clone, contains, ensureCapacity, forEach, get, indexOf, isEmpty, iterator, lastIndexOf, listIterator, remove, removeAll, removeIf, replaceAll, retainAll, set, size, sort, spliterator, subList, toArray, trimToSize) are in `Java/10-ArrayList/ArrayListMethodsDemo.java` in my basics repo.

```java
List<Integer> list = new ArrayList<>();
list.add(10); list.add(20); list.add(30);
list.add(1, 99);                      // [10, 99, 20, 30]
list.set(0, 5);                       // [5, 99, 20, 30]
list.remove(1);                       // removes INDEX 1      -> [5, 20, 30]
list.remove(Integer.valueOf(30));     // removes the OBJECT 30 -> [5, 20]
```

### Extra (not in my notes yet)
- Default capacity is **10** (created on the first `add`). New capacity = old + old/2 (**1.5x**), which matches "50% of its current capacity" in my notes.
- `Vector` grows by **doubling** by default (capacity starts at 10 as well).
- `ArrayList` allows `null` and duplicates and is **not** thread safe.
- Thread-safe options: `Collections.synchronizedList(list)` or `CopyOnWriteArrayList`.

## Interview Questions
1. **What is an `ArrayList`? How is it different from an array?**
   A resizable array implementation of `List`. An array has a fixed size and can hold primitives. `ArrayList` grows automatically and holds only objects.
2. **How does `ArrayList` work internally?**
   It keeps an `Object[]`. When it is full it makes a new array about 1.5x bigger, copies the elements over, and drops the old array.
3. **What is the default capacity?**
   10, allocated lazily when the first element is added.
4. **Size vs capacity?**
   Size = number of elements stored. Capacity = length of the internal array.
5. **`ArrayList` vs `Vector`?**
   `Vector` is legacy and synchronised (slower), grows 2x. `ArrayList` is not synchronised and grows 1.5x.
6. **Is `ArrayList` thread-safe? How to make it so?**
   No. `Collections.synchronizedList()` or `CopyOnWriteArrayList`.
7. **`ArrayList` vs `LinkedList`?**
   See the `linkedList` README.
8. **Time complexity of `get`, `add`, `remove`, `contains`?**
   `get` O(1), `add` at end amortised O(1), add/remove in the middle O(n), `contains` O(n).
9. **Why `List<String> list = new ArrayList<>()` and not `ArrayList<String> list = ...`?**
   Programming to the interface makes it easy to swap implementations.
10. **`list.remove(1)` vs `list.remove(Integer.valueOf(1))` on a `List<Integer>`?**
    The first removes the element at **index** 1; the second removes the **value** 1.
11. **Can an `ArrayList` hold `null` and duplicates?**
    Yes, both.
12. **How do you sort an `ArrayList`?**
    `Collections.sort(list)`, `list.sort(null)`, or `list.sort(Comparator.reverseOrder())`.
13. **How do you convert `ArrayList` to an array and an array to `ArrayList`?**
    `list.toArray(new Integer[0])` and `new ArrayList<>(Arrays.asList(arr))`.
14. **How do you remove duplicates from an `ArrayList`?**
    `new ArrayList<>(new LinkedHashSet<>(list))` (keeps order).
15. **What is `ConcurrentModificationException` and how do you avoid it?**
    See the `iterators` README: use `Iterator.remove()` or `removeIf()`.
16. **Why is `Vector` called a legacy class?**
    It existed before the Collections Framework (Java 1.0) and was retrofitted to implement `List`.
17. **What does `subList()` return - a copy or a view?**
    A view of the original list; changes show in both.

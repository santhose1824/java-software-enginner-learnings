# 10 - Dynamic Arrays (ArrayList)

## What I learnt

If we **don't know how big** the array needs to be, we use `ArrayList`. Java will handle the size for us.

### Syntax
```java
ArrayList<WrapperClass> arrayName = new ArrayList<>();      // we can pass an initial size (capacity)
ArrayList<Integer> list = new ArrayList<>();
```
- Only objects (wrapper classes) can be stored: `ArrayList<Integer>`, not `ArrayList<int>`.

### Methods of ArrayList (all of them have an example in `ArrayListMethodsDemo.java`)

| Method | What it does | Return type |
|--------|--------------|-------------|
| `add(element)` | Add item to list | boolean (`add(index, e)` -> void) |
| `addAll(collection)` | Add a collection of items | boolean |
| `clear()` | Remove all items from list | void |
| `clone()` | Create a copy of the ArrayList | Object |
| `contains(element)` | Checks whether an item exists | boolean |
| `ensureCapacity(n)` | Increase capacity of the list to fit a specified no. of items | void |
| `forEach(action)` | Perform an action on each element | void |
| `get(index)` | Return the item at a specific position | T |
| `indexOf(element)` | Return the position of the first occurrence of an item | int |
| `isEmpty()` | Checks whether the list is empty | boolean |
| `iterator()` | Return an Iterator object for the ArrayList | Iterator |
| `lastIndexOf(element)` | Return the position of the last occurrence of an item in the list | int |
| `listIterator()` | Return a ListIterator object for the ArrayList | ListIterator |
| `remove()` | Remove an item from the list | boolean / T |
| `removeAll(collection)` | Remove a collection of items from the list | boolean |
| `removeIf(condition)` | Remove all items from the list which meet a specific condition | boolean |
| `replaceAll(operator)` | Replace each item in the list with the result of an operation on the item | void |
| `retainAll(collection)` | Remove all elements from the list which do **not** belong to the specified collection | boolean |
| `set(index, element)` | Replace an item at a specified position in the list | T (old value) |
| `size()` | Return the number of items in the list | int |
| `sort()` | Sort the list | void |
| `spliterator()` | Return a Spliterator of the ArrayList | Spliterator |
| `subList(from, to)` | Return a sublist which provides access to a range of the list's items | List |
| `toArray()` | Return an array containing the list's items | Object[] |
| `trimToSize()` | Reduce the capacity of the list to match the number of items if necessary | void |

### Internal working
```
Stack            Heap
arr ───────────► [ ref, ref, ref ] ──► each element is an object
```
- Internally it is the **same as an array**. The question is: how is the size handled?
1. Size is actually **fixed internally** (an `Object[]` with a capacity).
2. When the array is filled, it creates a **new, bigger array**, copies all the elements to the new one, and the old one is discarded (garbage collected).

> Correction to my note: the default initial capacity is **10** (allocated on the first `add`), and the new capacity is about **1.5x** the old one (`old + old >> 1`), not exactly double. (`Vector` is the one that doubles by default.)

## Programs

| File | Shows |
|------|-------|
| `ArrayListBasics.java` | creating, adding, looping, `remove(int)` vs `remove(Object)`, 2D ArrayList |
| `ArrayListMethodsDemo.java` | **an example for every method** in the table above (+ a few bonus helpers) |

## Interview Questions

1. **What is an ArrayList? How is it different from an array?**
   A resizable array implementation of `List`. Arrays are fixed-size and can hold primitives; ArrayList grows dynamically and holds only objects.
2. **How does ArrayList work internally?**
   It uses an `Object[]`; when full it allocates a bigger array (about 1.5x), copies the elements and discards the old one.
3. **What is the default capacity of an ArrayList?**
   10 (lazily allocated on first add).
4. **Difference between size and capacity?**
   Size = number of elements stored. Capacity = length of the internal array.
5. **Can an ArrayList store primitives?**
   No - only wrapper objects (autoboxing hides this).
6. **Difference between `ArrayList` and `LinkedList`?**
   ArrayList: fast random access `O(1)`, slow inserts/removals in the middle `O(n)`. LinkedList: fast insert/remove at known node, slow access `O(n)`.
7. **Difference between `ArrayList` and `Vector`?**
   Vector is synchronized (thread-safe, slower, legacy); ArrayList is not.
8. **Is ArrayList thread-safe? How to make it so?**
   No. Use `Collections.synchronizedList(list)` or `CopyOnWriteArrayList`.
9. **Time complexity of get, add, remove?**
   `get` O(1); `add` at end amortised O(1); `add/remove` in the middle O(n); `contains/indexOf` O(n).
10. **`remove(int index)` vs `remove(Object o)` with `ArrayList<Integer>`?**
    `list.remove(1)` removes by index; `list.remove(Integer.valueOf(1))` removes the value 1.
11. **Difference between `iterator()` and `listIterator()`?**
    Iterator: forward only. ListIterator: both directions and can `add`/`set` during iteration.
12. **What is `ConcurrentModificationException`?**
    Thrown when the list is structurally modified while iterating (use `Iterator.remove()` or `removeIf`).
13. **How do you remove duplicates from an ArrayList?**
    `new ArrayList<>(new LinkedHashSet<>(list))`.
14. **How do you convert an ArrayList to an array and back?**
    `list.toArray(new Integer[0])` and `new ArrayList<>(Arrays.asList(arr))`.
15. **What does `clone()` do - deep or shallow copy?**
    Shallow copy - the elements themselves are shared, not duplicated.
16. **What is `subList()` - copy or view?**
    A view backed by the original list; changes reflect in both.
17. **`ensureCapacity` vs `trimToSize`?**
    `ensureCapacity` pre-allocates to avoid repeated resizing; `trimToSize` shrinks capacity to the current size.
18. **How do you sort an ArrayList (ascending / descending)?**
    `Collections.sort(list)` / `list.sort(null)`; `list.sort(Comparator.reverseOrder())`.
19. **Can an ArrayList contain `null` and duplicates?**
    Yes to both.
20. **`List<Integer> a = new ArrayList<>()` vs `ArrayList<Integer> a = new ArrayList<>()`?**
    Programming to the `List` interface is preferred - you can switch implementations easily.

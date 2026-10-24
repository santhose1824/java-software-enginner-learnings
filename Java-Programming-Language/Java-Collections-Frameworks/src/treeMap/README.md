# SortedMap, NavigableMap and TreeMap

## What I learnt
A `TreeMap` is a `Map` whose **keys are always sorted**. It is the map version of `TreeSet`, and it lets us find the **closest key** to a given one.

## My notes

### Sorted Map
1. The `SortedMap` and `NavigableMap` interfaces are the **analogs** of the `SortedSet` and the `NavigableSet` interfaces, respectively.
2. The `SortedMap` interface **extends the `Map` interface** to provide the functionality for implementing maps with **sorted keys**. Its operations are analogous to those of the `SortedSet` interface.

Methods:
1. `K firstKey()`
2. `K lastKey()`

### NavigableMap
1. It **extends the `SortedMap` interface** with **navigation methods** to find the **closest matches** for specific search targets.
2. In addition to the methods of the `SortedMap` interface, the `NavigableMap` interface adds new methods.

**1. First and last elements**
1. `Map.Entry<K,V> pollFirstEntry()`
2. `Map.Entry<K,V> pollLastEntry()`
3. `Map.Entry<K,V> firstEntry()`
4. `Map.Entry<K,V> lastEntry()`

**2. Other methods**
1. `Map.Entry<K,V> ceilingEntry(K key)`
2. `K ceilingKey(K key)`
3. `Map.Entry<K,V> floorEntry(K key)`
4. `K floorKey(K key)`
5. `Map.Entry<K,V> higherEntry(K key)`
6. `K higherKey(K key)`
7. `Map.Entry<K,V> lowerEntry(K key)`
8. `K lowerKey(K key)`

(Same meaning as in `NavigableSet`: ceiling = least key **>=**, floor = greatest key **<=**, higher = least key **>**, lower = greatest key **<**.)

### TreeMap
1. The `TreeMap` class **implements the `NavigableMap` interface**, and thereby the `SortedMap` interface.
2. By default, operations on sorted maps rely on the **natural ordering of the keys**.
3. However, a **total ordering** can be specified by passing a **customised `Comparator`** to the constructor.
4. The `TreeMap` implementation uses **balanced trees**, which deliver excellent performance for all operations.
5. However, **searching in a `HashMap` can be faster** than in a `TreeMap`, as hashing algorithms usually offer better performance than the search algorithms for balanced trees.

## Example (verified)
```java
TreeMap<Integer, String> tm = new TreeMap<>();
tm.put(10, "ten"); tm.put(20, "twenty"); tm.put(30, "thirty"); tm.put(40, "forty");
System.out.println(tm);                  // {10=ten, 20=twenty, 30=thirty, 40=forty}

tm.firstKey();                           // 10
tm.lastKey();                            // 40
tm.firstEntry();                         // 10=ten
tm.lastEntry();                          // 40=forty

tm.ceilingKey(25);                       // 30   (least key >= 25)
tm.floorKey(25);                         // 20   (greatest key <= 25)
tm.ceilingKey(20);                       // 20   (equal counts for ceiling/floor)
tm.higherKey(20);                        // 30   (strictly greater)
tm.lowerKey(20);                         // 10   (strictly less)
tm.higherKey(40);                        // null (nothing bigger - no exception)
tm.ceilingEntry(25);                     // 30=thirty

tm.pollFirstEntry();                     // 10=ten  (removed) -> {20=twenty, 30=thirty, 40=forty}
tm.pollLastEntry();                      // 40=forty (removed) -> {20=twenty, 30=thirty}
```

### Custom ordering
```java
TreeMap<String, Integer> desc = new TreeMap<>(Comparator.reverseOrder());
desc.put("b", 2); desc.put("a", 1); desc.put("c", 3);
System.out.println(desc);                // {c=3, b=2, a=1}
```

### Empty map behaviour (verified)
| Call | Result |
|------|--------|
| `firstEntry()` / `pollFirstEntry()` | `null` |
| `firstKey()` / `lastKey()` | `NoSuchElementException` |
| `put(null, v)` | `NullPointerException` |
| `put(k, null)` | allowed |

### Extra (not in my notes yet)
- A **red-black tree** (self-balancing binary search tree) - the "balanced tree" in my notes.
- `put`, `get`, `remove`, `containsKey` are **O(log n)**.
- **No null keys** (with natural ordering). Not thread-safe (`ConcurrentSkipListMap` is the concurrent version).
- Other views: `headMap(k)`, `tailMap(k)`, `subMap(a, b)`, `descendingMap()`, `descendingKeySet()`.
- Key uniqueness is decided by `compareTo`/`compare` returning 0, **not** `equals()`.

## Interview Questions
1. **What is a `TreeMap`?**
   A `Map` that keeps its entries **sorted by key**, implemented with a red-black tree.
2. **How does `TreeMap` sort?**
   By natural ordering (`Comparable`) or by a `Comparator` passed to the constructor.
3. **Time complexity of `get`, `put`, `remove`?**
   O(log n).
4. **`HashMap` vs `TreeMap`?**

   | | HashMap | TreeMap |
   |---|---------|---------|
   | Order | none | sorted by key |
   | Speed | O(1) average | O(log n) |
   | null key | one | not allowed |
   | Structure | hash table | red-black tree |
   | Extra methods | - | `firstKey`, `ceilingKey`, `headMap`, ... |

5. **`SortedMap` vs `NavigableMap`?**
   `NavigableMap` extends `SortedMap` and adds navigation methods (`ceiling`, `floor`, `higher`, `lower`, `pollFirstEntry`, `pollLastEntry`, `descendingMap`).
6. **Difference between `ceilingKey` and `higherKey`?**
   `ceilingKey(k)` is the least key **>= k**; `higherKey(k)` is the least key **> k**.
7. **Difference between `floorKey` and `lowerKey`?**
   `floorKey(k)` is the greatest key **<= k**; `lowerKey(k)` is the greatest key **< k**.
8. **What do the navigation methods return when there is no match?**
   `null` (not an exception). But `firstKey()`/`lastKey()` throw `NoSuchElementException` on an empty map.
9. **Can `TreeMap` have `null` keys/values?**
   Null keys: no. Null values: yes.
10. **How do you sort a `TreeMap` in descending order of keys?**
    `new TreeMap<>(Comparator.reverseOrder())` or `descendingMap()`.
11. **How does `TreeMap` decide that two keys are the same?**
    When `compareTo`/`compare` returns 0.
12. **What if the key class is not `Comparable` and no `Comparator` is passed?**
    `ClassCastException`.
13. **When would you choose `TreeMap`?**
    When you need keys in sorted order, range queries (`subMap`), or "nearest key" lookups (leaderboard, time-based lookups).
14. **Is `TreeMap` thread-safe?**
    No. Use `Collections.synchronizedSortedMap()` or `ConcurrentSkipListMap`.
15. **Which is faster for searching: `HashMap` or `TreeMap`?**
    Usually `HashMap` (hashing is O(1) on average; balanced-tree search is O(log n)) - exactly what my notes say.
16. **What data structure does `TreeMap` use?**
    A red-black tree.

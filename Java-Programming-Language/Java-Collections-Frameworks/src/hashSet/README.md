# Set Interface and HashSet

## What I learnt
A `Set` is a **collection of unique elements** - it never stores a duplicate. `HashSet` is the fastest `Set`, but it does not keep any order.

## My notes

### Set operations (a collection of unique elements)
| Method | Meaning in set theory |
|--------|----------------------|
| `containsAll(c)` | **subset** (is `c` a subset of this set?) |
| `addAll(c)` | **union** |
| `removeAll(c)` | **difference** |
| `retainAll(c)` | **intersection** |
| `clear()` | **empty set** |

(`Set` and `SortedSet` / `NavigableSet` are in the hierarchy: `Set` -> `SortedSet` -> `NavigableSet`. See the `treeSet` folder.)

## Example (verified)
```java
Set<Integer> a = new TreeSet<>(List.of(1, 2, 3, 4));
Set<Integer> b = new TreeSet<>(List.of(3, 4, 5));

Set<Integer> union = new TreeSet<>(a);        union.addAll(b);        // [1, 2, 3, 4, 5]
Set<Integer> diff  = new TreeSet<>(a);        diff.removeAll(b);      // [1, 2]
Set<Integer> inter = new TreeSet<>(a);        inter.retainAll(b);     // [3, 4]
a.containsAll(List.of(1, 2));                                          // true (subset)
```
(I used `TreeSet` just so the output is printed in a fixed order. The same code works on a `HashSet`.)

```java
Set<String> set = new HashSet<>();
set.add("Java");                      // true
set.add("Java");                      // false -> duplicate rejected
set.add(null);                        // allowed (one null)
set.contains("Java");                 // true
set.remove("Java");                   // true
```

### Not in my notes yet - to learn
- **`HashSet` is backed by a `HashMap`**: your elements are the **keys**, the value is a dummy constant.
- Order is **not guaranteed**.
- Allows **one `null`**. Not thread-safe.
- `add`, `remove`, `contains` are **O(1) on average**.
- Uniqueness depends on **`hashCode()` and `equals()`**. If you put your own objects in a `HashSet` you must override both, otherwise two "equal" objects are stored twice.
- Default capacity 16, load factor 0.75 (same as `HashMap`).

```java
class Student {
    String name;
    Student(String name) { this.name = name; }
    @Override public boolean equals(Object o) { return o instanceof Student s && s.name.equals(name); }
    @Override public int hashCode() { return name.hashCode(); }
}
```

## Interview Questions
1. **What is a `Set`? Difference from a `List`?**
   A `Set` has no duplicates and (generally) no positions. A `List` is ordered, indexed and allows duplicates.
2. **How does `HashSet` work internally?**
   It uses a `HashMap`. `add(e)` does `map.put(e, PRESENT)`. If the key already exists the set is unchanged.
3. **How does `HashSet` detect duplicates?**
   Using `hashCode()` to find the bucket, then `equals()` to compare.
4. **What does `add()` return for a duplicate?**
   `false`.
5. **Is the order maintained?**
   No. Use `LinkedHashSet` (insertion order) or `TreeSet` (sorted).
6. **Can `HashSet` hold `null`?**
   Yes, one.
7. **Time complexity of `add`, `remove`, `contains`?**
   O(1) average, O(log n) worst case (Java 8+, treeified buckets).
8. **Is `HashSet` thread-safe?**
   No. `Collections.synchronizedSet()` or `ConcurrentHashMap.newKeySet()`.
9. **What if you do not override `equals` and `hashCode` for your class?**
   Object identity is used, so two logically equal objects are both stored.
10. **What happens if you modify an object after adding it to a `HashSet` (changing a field used in `hashCode`)?**
    It ends up in the wrong bucket; `contains` and `remove` may fail to find it.
11. **How do you do union, intersection and difference with sets?**
    `addAll`, `retainAll`, `removeAll` (on a copy).
12. **How do you remove duplicates from a list?**
    `new HashSet<>(list)` (or `LinkedHashSet` to keep order).
13. **`HashSet` vs `HashMap`?**
    `HashSet` stores single elements; `HashMap` stores key-value pairs. `HashSet` uses `HashMap` internally.
14. **`HashSet` vs `TreeSet`?**
    Unordered O(1) vs sorted O(log n); `TreeSet` does not allow `null`.

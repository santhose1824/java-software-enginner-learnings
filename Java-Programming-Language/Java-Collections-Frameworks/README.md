# Java Collections Framework

My notes, example programs and interview questions while learning the Java Collections Framework.
Every folder under `src/` has its own `README.md` with three parts:

1. **What I learnt** - the concept in my own words
2. **My notes** - what I wrote in my notebook for that topic (cleaned up)
3. **Interview questions** - likely questions with short answers

## Topics

| Folder | Topic | README |
|--------|-------|--------|
| `src/enums` | Enums (constants, `ordinal()`, `values()`, constructors, EnumMap) | [open](./src/enums/README.md) |
| `src/iterators` | `Iterable`, `Iterator`, `ListIterator`, for-each internals, fail-fast | [open](./src/iterators/README.md) |
| `src/arrayList` | `List` interface, `ArrayList`, `Vector` | [open](./src/arrayList/README.md) |
| `src/linkedList` | `LinkedList`, ArrayList vs LinkedList | [open](./src/linkedList/README.md) |
| `src/stack` | `Stack` (LIFO), `Stack` vs `ArrayDeque` | [open](./src/stack/README.md) |
| `src/queue` | `Queue` interface (`add/offer`, `remove/poll`, `element/peek`) | [open](./src/queue/README.md) |
| `src/arrayDeque` | `Deque` interface, `ArrayDeque` | [open](./src/arrayDeque/README.md) |
| `src/priorityQueue` | `PriorityQueue` (heap, Comparator) | [open](./src/priorityQueue/README.md) |
| `src/hashSet` | `Set` interface, set operations, `HashSet` | [open](./src/hashSet/README.md) |
| `src/linkedHashSet` | `LinkedHashSet` (insertion order) | [open](./src/linkedHashSet/README.md) |
| `src/treeSet` | `SortedSet`, `NavigableSet`, `TreeSet` | [open](./src/treeSet/README.md) |
| `src/hashMap` | `Map` interface, `Map.Entry`, `HashMap`, `Hashtable`, `LinkedHashMap` | [open](./src/hashMap/README.md) |
| `src/treeMap` | `SortedMap`, `NavigableMap`, `TreeMap` | [open](./src/treeMap/README.md) |

Suggested reading order: Enums -> Iterators -> ArrayList -> LinkedList -> Stack -> Queue -> ArrayDeque -> PriorityQueue -> HashSet -> LinkedHashSet -> TreeSet -> HashMap -> TreeMap.

---

## What I learnt (overview)

### What is the Collections Framework?
1. A **collection** allows a group of objects to be treated as a **single unit**.
2. The Java Collections Framework provides a set of **standard utility classes** for managing various kinds of collections. The core framework is in the **`java.util`** package and has 3 main parts:
   1. The **core interfaces**
   2. A set of **implementations** (concrete classes) of the core interfaces
   3. **Static utility methods** in the `Collections` and `Arrays` classes, used to perform operations like sorting, searching and creating customised collections

### Core interfaces and hierarchy

```
Iterable<E>                       (java.lang - top of the chain)
  └── Collection<E>
        ├── List<E>        ── ArrayList, LinkedList, Vector ── Stack
        ├── Queue<E>       ── PriorityQueue
        │     └── Deque<E> ── ArrayDeque, LinkedList
        └── Set<E>         ── HashSet ── LinkedHashSet
              └── SortedSet<E>
                    └── NavigableSet<E> ── TreeSet

Map<K,V>      (NOT a Collection, not Iterable)
  ├── HashMap ── LinkedHashMap
  ├── Hashtable
  ├── EnumMap
  └── SortedMap<K,V>
        └── NavigableMap<K,V> ── TreeMap
```

### My notes on the interface chain
1. `Iterable` is at the top of the collections chain. It is part of `java.lang`.
2. `Collection` extends `Iterable`.
3. `List`, `Queue` and `Set` extend `Collection`.
4. `Deque` extends `Queue`.
5. `SortedSet` and `NavigableSet` extend `Set` (`NavigableSet` extends `SortedSet`).
6. `Map` is an interface, extended by `SortedMap` and then `NavigableMap`.
7. **`Map` does not extend the `Collection` interface.**

Note: when an interface extends another interface, the one it extends lets us use that interface's methods too.

### Methods on the `Collection` interface
| Method | Meaning |
|--------|---------|
| `boolean containsAll(Collection<?> c)` | is `c` a subset of this collection? |
| `boolean addAll(Collection<? extends E> c)` | add every element of `c` |
| `boolean removeAll(Collection<?> c)` | remove every element that is also in `c` |
| `boolean retainAll(Collection<?> c)` | keep only the elements that are also in `c` |
| `void clear()` | remove everything |

### Rule I follow
Use the **interface as the reference type** and the **concrete class as the object type**:
```java
List<String> list = new ArrayList<>();
```

### Corrections to my handwritten notes
These are marked in the folder READMEs too:
| In my notebook | Correct version |
|----------------|-----------------|
| "There is also an interface called Iterator extended by Collection" | `Collection` extends **`Iterable`**. `Iterable` has a method `iterator()` that **returns** an `Iterator`. `Collection` does not extend `Iterator`. |
| "Map, SortedMap and NavigableMap implements Map and Collections, Iterable" | `Map` does **not** extend `Collection` or `Iterable` (my own note 7 says so too). `SortedMap` extends `Map`, `NavigableMap` extends `SortedMap`. |
| "Pole()" | `poll()` |
| "Dequeue" | `Deque` |
| "List interface also extends the ListIterator" | `List` has methods **returning** a `ListIterator` (`listIterator()` and `listIterator(int index)`). `ListIterator` extends `Iterator`. |
| Enum constructor "private or default" | An enum constructor is always **private**. If you write no modifier it is still implicitly private. |
| "Whenever we need a stack use ArrayDeque, but use Stack because it is easy" | Both work for learning, but in real code and interviews **prefer `ArrayDeque`** (`Stack` is legacy and synchronised). |

---

## Cheat sheet: which collection do I use?

| I need... | Use |
|-----------|-----|
| A resizable array, fast access by index | `ArrayList` |
| Lots of inserts/removes at both ends | `ArrayDeque` (or `LinkedList`) |
| A stack (LIFO) | `ArrayDeque` (`Stack` is legacy) |
| A normal FIFO queue | `ArrayDeque` / `LinkedList` |
| Always get the smallest/largest element next | `PriorityQueue` |
| Unique elements, fastest, order does not matter | `HashSet` |
| Unique elements, keep insertion order | `LinkedHashSet` |
| Unique elements, always sorted | `TreeSet` |
| Key -> value lookup, fastest | `HashMap` |
| Key -> value, keep insertion order (or LRU cache) | `LinkedHashMap` |
| Key -> value, keys sorted | `TreeMap` |
| Thread-safe map | `ConcurrentHashMap` (not `Hashtable`) |
| Keys are enum constants | `EnumMap` |

## Time complexity cheat sheet

| Collection | get / contains | add | remove | Ordered? | Null allowed? |
|------------|----------------|-----|--------|----------|---------------|
| `ArrayList` | `get` O(1), `contains` O(n) | end: O(1) amortised, middle: O(n) | O(n) | insertion | yes |
| `LinkedList` | O(n) | ends O(1) | ends O(1), middle O(n) to find | insertion | yes |
| `ArrayDeque` | - | ends O(1) | ends O(1) | insertion | **no** |
| `PriorityQueue` | `peek` O(1), `contains` O(n) | O(log n) | `poll` O(log n) | heap order only | **no** |
| `HashSet` / `HashMap` | O(1) average | O(1) average | O(1) average | none | one null (HashMap: one null key) |
| `LinkedHashSet` / `LinkedHashMap` | O(1) | O(1) | O(1) | insertion (or access) | one null |
| `TreeSet` / `TreeMap` | O(log n) | O(log n) | O(log n) | sorted | **no null key** (TreeMap allows null values) |

---

## Top interview questions across the whole framework

1. **What is the Collections Framework? What are its 3 parts?**
   A set of interfaces, implementations and utility algorithms in `java.util` for storing and processing groups of objects.
2. **What is the difference between `Collection` and `Collections`?**
   `Collection` is the root interface. `Collections` is a utility class with static methods (`sort`, `reverse`, `max`, `unmodifiableList`, ...).
3. **Why is `Map` not part of the `Collection` hierarchy?**
   A `Collection` holds single elements (`add(E)`), a `Map` holds key-value pairs (`put(K,V)`), so the contracts do not fit.
4. **Difference between `List`, `Set` and `Map`?**
   `List`: ordered, duplicates allowed, index access. `Set`: unique elements. `Map`: unique keys mapped to values.
5. **Why does `Collection` extend `Iterable`?**
   So every collection can return an `Iterator` and be used in a for-each loop.
6. **`ArrayList` vs `LinkedList`? `ArrayList` vs `Vector`?**
   See the `arrayList` and `linkedList` folders.
7. **`HashMap` vs `Hashtable` vs `LinkedHashMap` vs `TreeMap`?**
   See the `hashMap` and `treeMap` folders.
8. **`HashSet` vs `LinkedHashSet` vs `TreeSet`?**
   Unordered O(1) / insertion-ordered O(1) / sorted O(log n).
9. **What are fail-fast iterators?**
   Iterators that throw `ConcurrentModificationException` if the collection is structurally modified during iteration (except through the iterator itself).
10. **`Comparable` vs `Comparator`?**
    `Comparable` (`compareTo`) = natural order, inside the class. `Comparator` (`compare`) = custom order, outside the class.
11. **Which collections do not allow `null`?**
    `ArrayDeque`, `PriorityQueue`, `TreeSet`, keys of `TreeMap`, `Hashtable` (keys and values).
12. **How do you make a collection read-only?**
    `Collections.unmodifiableList(list)` or `List.of(...)`.
13. **How do you make a collection thread-safe?**
    `Collections.synchronizedList(...)`, or use `CopyOnWriteArrayList` / `ConcurrentHashMap`.
14. **What is the difference between `Iterator` and `ListIterator`?**
    `Iterator`: forward only. `ListIterator`: both directions, can `add` and `set`.
15. **Which data structure is used internally by `ArrayList`, `LinkedList`, `HashMap`, `TreeMap`, `PriorityQueue`?**
    Resizable array, doubly linked list, array of buckets (linked list / tree), red-black tree, binary heap.

# Map Interface, Map.Entry, HashMap, Hashtable and LinkedHashMap

## What I learnt
A `Map` stores **key -> value** pairs. Keys are unique. We get a value by giving its key. `HashMap` is the most used `Map`.

## My notes

### Maps
1. A map defines **mapping from keys to values**.
2. The `<key, value>` pair is called an **entry**.
3. A map **does not allow duplicate keys**; in other words, the keys are **unique**.
4. Both keys and values **must be objects**, with primitive values being wrapped in their respective **primitive wrapper objects** when they are put in a map.
5. A map is **not a `Collection`**, and the `Map` interface doesn't extend the `Collection` interface.
6. However, the mappings can be **viewed as a collection** in various ways: a **key set**, a **value collection** or an **entry set**.

### Map methods
1. `Object put(Object key, Object value)`
2. `Object get(Object key)`
3. `Object remove(Object key)`
4. `boolean containsKey(Object key)`
5. `boolean containsValue(Object value)`
6. `int size()`
7. `boolean isEmpty()`
8. `void putAll(Map<? extends K, ? extends V> map)`
9. `void clear()`
10. `Set<K> keySet()`
11. `Collection<V> values()`
12. `Set<Map.Entry<K,V>> entrySet()`

### `Map.Entry` interface
```java
interface Entry<K, V> {
    K getKey();
    V getValue();
    V setValue(V value);
}
```
1. Each `<key, value>` in the **entry set view** is represented by an object implementing the **nested `Map.Entry`** interface.
2. An entry in the entry set view can be **manipulated** by the methods defined in this interface.

### Implementations
1. `HashMap`  } -> **unordered** maps
2. `Hashtable` }
3. `LinkedHashMap` -> **ordered** maps
4. `TreeMap` -> **sorted** maps (see the `treeMap` folder)

### HashMap vs Hashtable (my notes)
1. `HashMap` is **not thread safe** and permits **one null key**.
2. `Hashtable` is **thread safe** and permits **non-null keys and values only**.

### LinkedHashMap (my notes)
3. A `LinkedHashMap` can also maintain its elements in **access order**, i.e. the order in which its entries are accessed, from **least recently accessed to most recently accessed** entries.
4. This ordering mode can be specified in one of the constructors of the `LinkedHashMap` class (**LRU cache**).
5. **Add, remove, find** an entry based on a **key** is **constant time**.
6. **Finding an entry with a particular value** is **linear time**.

(`HashMap` search can be faster than `TreeMap` search - see the `treeMap` folder.)

## Examples (verified)
```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.put("a", 2);                 // returns the old value 1, replaces it
map.put("b", 3);                 // returns null (new key)
map.get("z");                    // null
map.getOrDefault("z", 0);        // 0
map.putIfAbsent("a", 99);        // keeps 2
map.merge("a", 10, Integer::sum);// a = 12   (great for counting)
map.containsKey("a");            // true
map.containsValue(3);            // true  (linear search)

// Looping
for (String key : map.keySet())           System.out.println(key);
for (int value : map.values())            System.out.println(value);
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
    e.setValue(e.getValue() * 2);          // changes the value inside the map
}
map.forEach((k, v) -> System.out.println(k + " " + v));
```

### Word count
```java
Map<String, Integer> count = new HashMap<>();
for (String w : "to be or not to be".split(" ")) count.merge(w, 1, Integer::sum);
// {not=1, or=1, be=2, to=2}  (this is what I got - HashMap order is not guaranteed)
```

### LRU cache with `LinkedHashMap` (verified)
```java
LinkedHashMap<String, Integer> lru = new LinkedHashMap<>(16, 0.75f, true) {   // true = access order
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > 3;                                                    // capacity 3
    }
};
lru.put("A", 1); lru.put("B", 2); lru.put("C", 3);
lru.get("A");                    // A becomes most recently used
lru.put("D", 4);                 // B was least recently used -> removed
System.out.println(lru);         // {C=3, A=1, D=4}
```

### Null handling (verified)
| Map | null key | null value |
|-----|----------|-----------|
| `HashMap` | one | yes |
| `LinkedHashMap` | one | yes |
| `Hashtable` | **NullPointerException** | **NullPointerException** |
| `TreeMap` | **NullPointerException** | yes |

### Not in my notes yet - HashMap internals
- Array of **buckets**; default capacity **16**, load factor **0.75**.
- `index = (n - 1) & hash(key)`; capacity is always a **power of 2**.
- When `size > capacity * 0.75` the table **doubles** and entries are re-distributed (**rehash**).
- Collisions: entries in the same bucket form a **linked list**; since Java 8 a bucket with **>= 8** entries (and table size >= 64) becomes a **red-black tree**.
- `get`/`put` are **O(1) average**, O(log n) worst case.
- Keys should be **immutable**; override both `equals()` and `hashCode()` for custom key classes.
- Iteration order is **not guaranteed**.

## Interview Questions
1. **What is a `Map`? Why is it not a `Collection`?**
   A structure of unique keys mapped to values. It stores pairs (`put(K,V)`), not single elements, so it does not extend `Collection`.
2. **How does `HashMap` work internally?**
   Hashes the key, finds a bucket with `(n-1) & hash`, then uses `equals()` to find or replace the entry. Collisions use a linked list (tree from 8 entries).
3. **What is a collision? How is it handled?**
   Two different keys landing in the same bucket. They are chained in a list/tree.
4. **What is the default capacity and load factor?**
   16 and 0.75.
5. **What happens when the `HashMap` becomes 75% full?**
   It doubles its capacity and rehashes all entries.
6. **What is the `equals()` and `hashCode()` contract?**
   Equal objects must have equal hash codes. If you override one, override both.
7. **`HashMap` vs `Hashtable`?**

   | | HashMap | Hashtable |
   |---|---------|-----------|
   | Thread safe | no | yes (synchronised) |
   | null key / value | one null key, null values | no nulls |
   | Speed | faster | slower |
   | Since | 1.2 | 1.0 (legacy) |

8. **`HashMap` vs `ConcurrentHashMap`?**
   `ConcurrentHashMap` is thread-safe with fine-grained locking and does not allow nulls; much better than `Hashtable`.
9. **`HashMap` vs `LinkedHashMap` vs `TreeMap`?**
   Unordered O(1) / insertion (or access) order O(1) / sorted by key O(log n).
10. **How do you build an LRU cache?**
    `LinkedHashMap` with `accessOrder = true` and an overridden `removeEldestEntry`.
11. **How do you iterate over a `Map`?**
    `entrySet()` (best), `keySet()`, `values()`, or `forEach`.
12. **Can a key be `null`? Can a value be `null`?**
    In `HashMap`: one null key, many null values.
13. **What does `put()` return?**
    The previous value for that key, or `null` if none.
14. **What is `Map.Entry`?**
    The nested interface for a key-value pair, with `getKey()`, `getValue()`, `setValue()`.
15. **Why should map keys be immutable?**
    If a key's `hashCode` changes after insertion, the entry becomes unreachable.
16. **Is the iteration order of `HashMap` guaranteed?**
    No.
17. **Is `HashMap` thread-safe? What happens with concurrent modification?**
    No. It can lose updates and throw `ConcurrentModificationException` during iteration.
18. **What is the time complexity of `containsValue()`?**
    O(n) - it must scan all entries.
19. **How do you sort a `HashMap` by key or by value?**
    By key: `new TreeMap<>(map)`. By value: stream the `entrySet()` and sort with `Map.Entry.comparingByValue()`.
20. **What is the difference between `keySet()`, `values()` and `entrySet()`?**
    A `Set` of keys, a `Collection` of values, and a `Set` of `Map.Entry` pairs - all are **views** backed by the map.

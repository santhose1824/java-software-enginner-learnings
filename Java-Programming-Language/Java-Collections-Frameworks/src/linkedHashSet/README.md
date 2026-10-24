# LinkedHashSet

## What I learnt
`LinkedHashSet` is a `HashSet` that **remembers the order in which elements were inserted**.

## My notes
My notebook does not have a separate page for `LinkedHashSet`. What I have:
1. In my collections diagram `LinkedHashSet` sits under `HashSet`, which implements `Set`.
2. A `Set` is a collection of **unique** elements (see `hashSet` notes: `containsAll`, `addAll`, `removeAll`, `retainAll`, `clear`).
3. The same idea for maps from my notes: *"`LinkedHashMap` -> ordered maps"*, versus `HashMap` -> unordered maps. A `LinkedHashSet` is the Set version.

## Example (verified)
```java
Set<String> hash   = new HashSet<>(List.of("banana", "apple", "cherry", "apple"));
Set<String> linked = new LinkedHashSet<>(List.of("banana", "apple", "cherry", "apple"));

System.out.println(linked);   // [banana, apple, cherry]   <- insertion order, duplicate removed
System.out.println(hash);     // order NOT guaranteed (but the duplicate is removed too)
```

### Extra (not in my notes yet)
- It **extends `HashSet`** and is backed by a **`LinkedHashMap`** (a hash table **plus a doubly linked list** that records the insertion order).
- Re-inserting an element that is already present does **not** change its position.
- `add`, `remove`, `contains` are **O(1)**, slightly slower than `HashSet`, with more memory.
- Allows one `null`. Not thread-safe.

### Use cases
Remove duplicates but **keep the original order** (`new ArrayList<>(new LinkedHashSet<>(list))`), keep a history of unique visited items, and predictable output order for printing.

## Interview Questions
1. **What is a `LinkedHashSet`?**
   A `Set` that keeps unique elements in **insertion order**.
2. **How is it different from `HashSet`?**
   `HashSet` has no order. `LinkedHashSet` keeps a doubly linked list through its entries to remember insertion order.
3. **How is it different from `TreeSet`?**
   `TreeSet` keeps elements **sorted**, not in insertion order, and is O(log n).
4. **What data structure does it use internally?**
   A `LinkedHashMap` = hash table + doubly linked list.
5. **Does re-adding an existing element change its position?**
   No.
6. **Time complexity of `add`/`remove`/`contains`?**
   O(1).
7. **Does it allow `null`?**
   Yes, one.
8. **Which is faster: `HashSet` or `LinkedHashSet`?**
   `HashSet`, because it has no extra linked-list bookkeeping.
9. **How do you remove duplicates from a list and keep the order?**
   `new ArrayList<>(new LinkedHashSet<>(list))`.
10. **Is it thread-safe?**
    No. Wrap with `Collections.synchronizedSet()`.
11. **Does iteration order of a `LinkedHashSet` depend on capacity?**
    No - unlike `HashSet`, iteration is in insertion order, and it is also not affected by capacity.

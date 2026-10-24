# PriorityQueue

## What I learnt
A `PriorityQueue` is a queue that **works on priority** - the element removed next is not the oldest, it is the one with the **highest priority** (by default, the smallest value).

## My notes
1. It works on **priority**.
2. The implementation is based on a **priority heap**, a tree-like structure that yields an element at the **head of the queue** according to its **priority ordering**, which is defined either by the **natural ordering** of its elements or by a **`Comparator`**.
3. In the case of several elements having the **same priority**, one of them is chosen **arbitrarily**.
4. Elements of a `PriorityQueue` are **not sorted**.
5. The queue **only guarantees** that the elements can be **removed in priority order**, and any **traversal using an iterator does not**.

(`PriorityQueue` is one of the two implementations of `Queue` in my notes: `PriorityQueue` and `LinkedList`.)

## Example (verified)
```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int x : new int[]{5, 1, 4, 2, 3}) pq.offer(x);

System.out.println(pq);          // [1, 2, 4, 5, 3]   <- heap order, NOT sorted!
System.out.println(pq.peek());   // 1

while (!pq.isEmpty()) System.out.print(pq.poll() + " ");   // 1 2 3 4 5  <- priority order
```
The printed order `[1, 2, 4, 5, 3]` is the internal heap array. Only `poll()` gives sorted order.

### Max-heap (largest first)
```java
PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
max.addAll(List.of(5, 1, 4, 2, 3));
System.out.println(max.peek());  // 5
```

### Custom objects with a `Comparator`
```java
record Task(String name, int priority) { }

PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt(Task::priority));
tasks.offer(new Task("Write report", 3));
tasks.offer(new Task("Fix bug", 1));
tasks.offer(new Task("Lunch", 2));
System.out.println(tasks.poll().name());   // Fix bug
```
If the elements are not `Comparable` and no `Comparator` is given, `add` throws `ClassCastException`.

### Extra (not in my notes yet)
- Internally a **binary min-heap stored in an array** (default initial capacity 11).
- `offer` and `poll` are **O(log n)**, `peek` is **O(1)**, `remove(Object)` and `contains` are **O(n)**.
- **Does not allow `null`** (`NullPointerException`). Not thread-safe (`PriorityBlockingQueue` is).
- For equal priorities there is **no FIFO guarantee**.

## Interview Questions
1. **What is a `PriorityQueue`?**
   A queue where elements are ordered by priority (natural ordering or a `Comparator`) and the head is always the smallest/highest priority element.
2. **How is it implemented?**
   A binary heap in an array.
3. **Is a `PriorityQueue` sorted?**
   No. Only the head is guaranteed. `poll()` returns sorted order; iteration and `toString()` do not.
4. **How do you make a max-heap?**
   `new PriorityQueue<>(Collections.reverseOrder())` or a custom `Comparator`.
5. **What is the time complexity of `offer`, `poll`, `peek`?**
   O(log n), O(log n), O(1).
6. **Can it hold `null`? Duplicates?**
   `null`: no. Duplicates: yes.
7. **What if two elements have the same priority?**
   One is chosen arbitrarily (no FIFO guarantee).
8. **Is `PriorityQueue` thread-safe?**
   No; use `PriorityBlockingQueue`.
9. **What happens if elements are not `Comparable` and there is no `Comparator`?**
   `ClassCastException`.
10. **`Comparable` vs `Comparator` here?**
    `Comparable` = the class's natural order. `Comparator` = custom order passed to the constructor.
11. **How would you find the k-th largest element?**
    Keep a min-heap of size k; the head is the answer. O(n log k).
12. **Use cases?**
    Task scheduling, Dijkstra's algorithm, merging sorted lists, top-K problems, event simulation.
13. **Why is iterating a `PriorityQueue` not in order?**
    The iterator walks the heap array, which only keeps the parent <= children property.

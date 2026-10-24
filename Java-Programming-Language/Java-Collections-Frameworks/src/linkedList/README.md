# LinkedList

## What I learnt
`LinkedList` is a `List` that is built as a **doubly linked list**, and it also works as a `Deque` (so it can be a stack or a queue).

## My notes

### 3. LinkedList
1. The `LinkedList` implementation uses a **doubly linked list**.
2. **Insertions and deletions** in a doubly linked list are **very efficient**.

### ArrayList vs LinkedList
1. **Position-based access** has **constant time** performance for the `ArrayList` and `Vector` classes.
2. Position-based access is in **linear time** for `LinkedList`, owing to traversal in a doubly linked list.
3. When **frequent insertions and deletions** occur inside a list, a `LinkedList` can be worth considering.
4. Overall, the `ArrayList` implementation is the **best choice** for implementing lists.
5. In addition to the `List` interface, the `LinkedList` class also **implements the `Deque` interface** that allows it to be used for **stacks and different kinds of queues**.

### Rule from my notes
Always use the reference variable as the type of the **interface** and the object type of the **concrete class**:
```java
List<String> list = new LinkedList<>();
```

### Where I use `LinkedList`
- Whenever we need a **normal queue** (First In First Out), use the `LinkedList` class.
- `LinkedList` implements `Deque`, which implements `Queue`.

## Example
```java
LinkedList<String> list = new LinkedList<>();
list.add("B");
list.addFirst("A");         // [A, B]
list.addLast("C");          // [A, B, C]
list.get(1);                // "B"  (walks the nodes - O(n))
list.removeFirst();         // "A"
list.removeLast();          // "C"

Queue<Integer> queue = new LinkedList<>();    // FIFO queue
queue.offer(1); queue.offer(2);
queue.poll();                                  // 1
```

### Extra (not in my notes yet)
- Each element is stored in a **node** with `item`, `prev` and `next` references (extra memory per element).
- Allows `null` and duplicates; **not** thread safe.
- Adding/removing at the **ends** is O(1). Adding in the **middle** is O(1) only once you are at the node; **finding** the position is O(n).
- In practice, `ArrayList` is often faster even for inserts because arrays are cache-friendly.

## Interview Questions
1. **How is `LinkedList` implemented?**
   As a doubly linked list - every node has the element, a reference to the previous node and a reference to the next node.
2. **`ArrayList` vs `LinkedList`?**

   | | ArrayList | LinkedList |
   |---|-----------|------------|
   | Internal structure | resizable array | doubly linked list |
   | `get(i)` | O(1) | O(n) |
   | add/remove at the end | O(1) amortised | O(1) |
   | add/remove at the start | O(n) | O(1) |
   | add/remove in the middle | O(n) (shifting) | O(n) to find, O(1) to link |
   | Memory | less | more (two references per node) |
   | Implements | `List` | `List` and `Deque` |

3. **When would you use `LinkedList` over `ArrayList`?**
   Many insertions/removals at the beginning or ends and few random reads. Or when you need a queue/deque.
4. **Which interfaces does `LinkedList` implement?**
   `List`, `Deque` (and therefore `Queue`), `Cloneable`, `Serializable`.
5. **Why can `ListIterator` go backwards on a `LinkedList`?**
   Because each node knows its previous node (doubly linked).
6. **Is `LinkedList` thread safe?**
   No. Use `Collections.synchronizedList()` or a concurrent queue.
7. **Can `LinkedList` hold `null`?**
   Yes (unlike `ArrayDeque`).
8. **How do you use `LinkedList` as a stack or queue?**
   Stack: `push()` / `pop()` / `peek()`. Queue: `offer()` / `poll()` / `peek()`.
9. **Why is `get(index)` slow in `LinkedList`?**
   It must walk from the head (or the tail, whichever is closer) node by node.
10. **What is the time complexity of `contains()` in `LinkedList`?**
    O(n).
11. **Which would you pick for a normal FIFO queue?**
    From my notes `LinkedList`; many people prefer `ArrayDeque` when `null` is not needed because it is faster.

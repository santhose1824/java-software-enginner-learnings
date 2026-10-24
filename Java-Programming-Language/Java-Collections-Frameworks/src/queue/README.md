# Queue Interface

## What I learnt
A **queue** is **FIFO** - First In, First Out (like a line at a ticket counter). The `Queue` interface adds methods to the `Collection` interface for adding at the tail and removing from the head.

## My notes

The `Queue` interface extends the `Collection` interface with the following methods:
1. `boolean add(E element);`
2. `boolean offer(E element);`

### The methods, one by one
| # | Method | What it does | On failure |
|---|--------|--------------|------------|
| 1 | `add()` | adds an element | **throws `IllegalStateException`** when the queue is full |
| 2 | `offer()` | adds an element - **always use this** | **does not throw** an exception (returns `false`) |
| 3 | `poll()` | removes the head element | **does not throw** if the queue is empty (returns `null`) |
| 4 | `remove()` | removes the head element | **throws** an exception when the queue is empty |
| 5 | `peek()` | gets the element (top/head) without removing | **does not throw** if the queue is empty (returns `null`) |
| 6 | `element()` | gets the element (top/head) without removing | **throws** an exception if the queue is empty |

(In my notebook I wrote `Pole()`. The real method name is **`poll()`**.)

### What I use
- `offer()` to **add**
- `peek()` to **get the top element**
- `poll()` to **remove**

### Implementations of Queue
1. `PriorityQueue`
2. `LinkedList` -> implements the `Deque` interface, which extends `Queue`.

(Next: the `Deque` interface - see the `arrayDeque` folder.)

## Summary table (2 styles for each operation)
| Operation | Throws an exception | Returns a special value |
|-----------|--------------------|-------------------------|
| Insert | `add(e)` | `offer(e)` |
| Remove | `remove()` | `poll()` |
| Examine | `element()` | `peek()` |

## Example
```java
Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
queue.offer("C");
System.out.println(queue.peek());     // A  (head, not removed)
System.out.println(queue.poll());     // A  (removed)
System.out.println(queue);            // [B, C]

Queue<String> empty = new LinkedList<>();
System.out.println(empty.poll());     // null
System.out.println(empty.peek());     // null
empty.remove();                       // NoSuchElementException
empty.element();                      // NoSuchElementException
```

## Interview Questions
1. **What is a queue? What principle does it follow?**
   A collection that holds elements before processing, normally FIFO.
2. **Difference between `add()` and `offer()`?**
   Both insert. If the queue is capacity-restricted and full, `add()` throws `IllegalStateException` and `offer()` returns `false`.
3. **Difference between `remove()` and `poll()`?**
   Both remove the head. On an empty queue `remove()` throws `NoSuchElementException`; `poll()` returns `null`.
4. **Difference between `element()` and `peek()`?**
   Both return the head without removing. On an empty queue `element()` throws; `peek()` returns `null`.
5. **Which methods are "safe" (no exception)?**
   `offer`, `poll`, `peek`.
6. **Is `Queue` a class or an interface? Name implementations.**
   Interface. `LinkedList`, `ArrayDeque`, `PriorityQueue` (and concurrent ones like `LinkedBlockingQueue`).
7. **Does `Queue` allow `null`?**
   `LinkedList` allows it, but it is discouraged because `poll()` and `peek()` use `null` to mean "empty". `PriorityQueue` and `ArrayDeque` do not allow `null`.
8. **Queue vs Stack?**
   FIFO vs LIFO.
9. **Queue vs Deque?**
   `Deque` is a double-ended queue: insert/remove at both ends. It also works as a stack.
10. **Is `PriorityQueue` FIFO?**
    No, it returns elements in priority order.
11. **How would you implement a queue using two stacks?**
    Push into stack A. For dequeue, if stack B is empty move all of A into B, then pop B.
12. **Use cases for a queue?**
    Task scheduling, BFS, printer queues, message queues, buffering.

# Deque Interface and ArrayDeque

## What I learnt
A **Deque** (pronounced "deck") is a **double-ended queue**: we can add and remove elements at **both the head and the tail**.

## My notes

### Deque interface
1. The `Deque` interface **extends the `Queue` interface** to allow a **double-ended queue**.
2. It allows operations not just at the **head**, but also at its **tail**.
3. Elements can be **inserted at or removed from either end**.
4. A `Deque` can be used as a **FIFO queue**, where elements added at the tail are presented at the head for inspection or removal in the same order, thus implementing FIFO order.

### Deque methods

**1. Adding elements**
1. `offerFirst(E element)`
2. `offerLast(E element)`
3. `push(E element)`
4. `addFirst(E element)`
5. `addLast(E element)`

**2. Removing elements**
1. `E pollFirst()`
2. `E pollLast()`
3. `E pop()`
4. `E remove()`
5. `E removeFirst()`
6. `E removeLast()`

**3. Get elements**
1. `E peekFirst()`
2. `E peekLast()`
3. `E getFirst()`
4. `E getLast()`

### Implementations of Deque
1. `ArrayDeque`
2. `LinkedList`

### Which one to use?
1. Whenever we need a **normal queue** (First In First Out) use the **`LinkedList`** class.
2. Whenever we need a **stack** use **`ArrayDeque`**. (But I use `Stack` while learning, because it is easy to use.)
3. Whenever we want a **double-ended queue** use **`ArrayDeque`**.

## Method behaviour table (extra)
| Operation | Throws exception | Returns special value |
|-----------|------------------|-----------------------|
| Insert at head | `addFirst(e)` | `offerFirst(e)` |
| Insert at tail | `addLast(e)` | `offerLast(e)` |
| Remove from head | `removeFirst()` | `pollFirst()` |
| Remove from tail | `removeLast()` | `pollLast()` |
| Examine head | `getFirst()` | `peekFirst()` |
| Examine tail | `getLast()` | `peekLast()` |

Equivalents:
| Queue method | Deque method | Stack method | Deque method |
|--------------|--------------|--------------|--------------|
| `add(e)` | `addLast(e)` | `push(e)` | `addFirst(e)` |
| `offer(e)` | `offerLast(e)` | `pop()` | `removeFirst()` |
| `remove()` | `removeFirst()` | `peek()` | `peekFirst()` |
| `poll()` | `pollFirst()` | | |
| `element()` | `getFirst()` | | |
| `peek()` | `peekFirst()` | | |

## Example
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(2);          // [2]
deque.addFirst(1);          // [1, 2]
deque.addLast(3);           // [1, 2, 3]
deque.offerLast(4);         // [1, 2, 3, 4]

deque.peekFirst();          // 1
deque.peekLast();           // 4
deque.pollFirst();          // 1   -> [2, 3, 4]
deque.pollLast();           // 4   -> [2, 3]

// empty deque
new ArrayDeque<Integer>().peekFirst();   // null
new ArrayDeque<Integer>().getFirst();    // NoSuchElementException
new ArrayDeque<Integer>().addFirst(null);// NullPointerException
```

### Extra (not in my notes yet)
- `ArrayDeque` is a **resizable circular array**. No capacity limit, so `addFirst/addLast` never throw `IllegalStateException`.
- It does **not allow `null`** (`null` is used as the "empty" signal by `poll`/`peek`).
- Not thread-safe.
- Usually **faster than `Stack`** (as a stack) and **faster than `LinkedList`** (as a queue).

## Interview Questions
1. **What is a `Deque`?**
   A double-ended queue that supports insertion and removal at both ends. It extends `Queue`.
2. **Name the classes that implement `Deque`.**
   `ArrayDeque` and `LinkedList`.
3. **`ArrayDeque` vs `LinkedList`?**
   `ArrayDeque` uses a resizable array: faster, less memory, no `null`. `LinkedList` uses linked nodes: allows `null`, also implements `List`.
4. **`ArrayDeque` vs `Stack`?**
   `ArrayDeque` is faster, not synchronised, and is the recommended stack. `Stack` is a legacy synchronised class.
5. **How do you use `Deque` as a stack? As a queue?**
   Stack: `push/pop/peek`. Queue: `offer/poll/peek` (add at tail, remove at head).
6. **Difference between `addFirst()` and `offerFirst()`?**
   `addFirst` throws if capacity is restricted and full, `offerFirst` returns `false`. For `ArrayDeque` both always succeed.
7. **Difference between `getFirst()` and `peekFirst()`?**
   On an empty deque `getFirst` throws `NoSuchElementException`; `peekFirst` returns `null`.
8. **Difference between `removeFirst()` and `pollFirst()`?**
   Same idea: exception vs `null`.
9. **What does `pop()` do?**
   Removes and returns the first element (`removeFirst()`). `push(e)` is `addFirst(e)`.
10. **Does `ArrayDeque` accept `null`?**
    No: `NullPointerException`.
11. **Is `ArrayDeque` thread-safe?**
    No.
12. **How is `ArrayDeque` implemented?**
    A circular array with head and tail indexes that doubles in size when full.
13. **Time complexity of `addFirst`, `addLast`, `pollFirst`, `pollLast`?**
    Amortised O(1).
14. **Deque use cases?**
    Sliding-window problems, palindrome check, undo/redo, work-stealing, browser history.
15. **Implement a palindrome check with a `Deque`.**
    Add all characters, then compare `pollFirst()` and `pollLast()` until one or zero characters remain.

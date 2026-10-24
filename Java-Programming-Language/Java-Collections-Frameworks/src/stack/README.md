# Stack

## What I learnt
A **stack** is **LIFO** - Last In, First Out (like a pile of plates: the last plate you put on top is the first one you take).

## My notes
My handwritten notes do not have a separate page on `Stack`. These are the parts that mention it:

1. From my collections diagram: `Stack` **extends `Vector`**, and `Vector` implements `List`.
2. From the Deque notes:
   - Whenever we need a **stack**, use `ArrayDeque`.
   - "But use `Stack`, because it is easy to use."
3. `LinkedList` also implements `Deque`, so it can be used for stacks too.
4. `Vector` (the parent of `Stack`) is a **legacy class** and **thread safe** (synchronised, with a slight performance penalty).

## Stack methods (extra - to add to my notes)
| Method | What it does | On an empty stack |
|--------|--------------|-------------------|
| `push(E e)` | put on top | - |
| `pop()` | remove and return the top | `EmptyStackException` |
| `peek()` | look at the top, do not remove | `EmptyStackException` |
| `empty()` | is the stack empty? | - |
| `search(Object o)` | position from the top (1 = top), -1 if absent | - |

## Examples
```java
Stack<Integer> stack = new Stack<>();
stack.push(1); stack.push(2); stack.push(3);
System.out.println(stack);            // [1, 2, 3]   (top is the LAST element)
System.out.println(stack.peek());     // 3
System.out.println(stack.search(1));  // 3  (1 is third from the top)
System.out.println(stack.pop());      // 3
```

### Preferred in real code: `ArrayDeque` as a stack
```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(1); stack.push(2); stack.push(3);
System.out.println(stack);            // [3, 2, 1]   (top is the FIRST element)
System.out.println(stack.peek());     // 3
System.out.println(stack.pop());      // 3
```
Notice the difference in how they print: `Stack` shows the top **last**, `ArrayDeque` shows the top **first**.
An empty `ArrayDeque.pop()` throws `NoSuchElementException`, an empty `Stack.pop()` throws `EmptyStackException`.

### Where stacks are used
Undo/redo, browser back button, balanced brackets check, expression evaluation, DFS, method call stack.

```java
// Balanced brackets
static boolean isBalanced(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') stack.push(c);
        else {
            if (stack.isEmpty()) return false;
            char open = stack.pop();
            if ((c == ')' && open != '(') || (c == '}' && open != '{') || (c == ']' && open != '[')) return false;
        }
    }
    return stack.isEmpty();
}
```

## Interview Questions
1. **What is a stack? Which principle does it follow?**
   A linear structure that follows LIFO.
2. **Which class implements a stack in Java? What does it extend?**
   `java.util.Stack`, which extends `Vector`.
3. **Why is `Stack` discouraged?**
   It is a legacy class, extends `Vector` (so you can also call `get(i)`, `add(i, e)`, which breaks the stack idea), and every method is synchronised (slow).
4. **What should be used instead?**
   `Deque<Integer> stack = new ArrayDeque<>();` with `push`, `pop`, `peek`.
5. **`Stack.pop()` vs `Stack.peek()`?**
   `pop` removes and returns the top, `peek` only returns it.
6. **What happens on `pop()` of an empty `Stack`? Of an empty `ArrayDeque`?**
   `EmptyStackException`; `NoSuchElementException`.
7. **Is `Stack` thread-safe?**
   Yes (synchronised through `Vector`), but that is not a good reason to use it.
8. **What is the time complexity of `push`, `pop`, `peek`?**
   O(1).
9. **How do you check balanced parentheses with a stack?**
   See the example above.
10. **How would you implement a stack using a `LinkedList`?**
    `addFirst` / `removeFirst` / `peekFirst`, or `push` / `pop` / `peek`.
11. **What does `search()` return?**
    The 1-based distance from the top, or -1 if not found.
12. **Stack vs Queue?**
    Stack: LIFO. Queue: FIFO.

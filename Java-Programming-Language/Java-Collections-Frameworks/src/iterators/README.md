# Iterable and Iterator

## What I learnt
When we create our **own custom list (or any collection)** we have a problem: we cannot loop over it with a for-each loop.
To solve this we implement two interfaces: **`Iterable`** and **`Iterator`**.

## My notes

### `Iterable` and `Iterator`
| Interface | What it does |
|-----------|--------------|
| `Iterable` | It **iterates (traverses)** our list or collection. It gives the method `iterator()` whose return type is `Iterator`. |
| `Iterator` | Represents a **stateful cursor** traversing a data structure. |

- `Iterable` -> `iterator()` returns an `Iterator`.
- `Iterator` -> `hasNext()` and `next()`.
  - `hasNext()` -> `boolean` -> tells whether there is any element next in the list/collection.
  - `next()` -> `<T>` -> gives the next element in the list/collection.

### Final conclusion
A class that implements `Iterable` (and returns an `Iterator`) can use the **for-each loop** to traverse it.

What for-each actually does:
```java
Iterator<Integer> iterator = list.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```
Instead of this we write:
```java
for (int num : integerList) {
    System.out.println(num);
}
```

### Why does the `Collection` interface extend `Iterable`?
Because once the `Collection` interface is implemented in a particular class, that class can use the `iterator()` method (the for-each loop).

> Correction: in my notebook I wrote "there is also an interface called Iterator extended by Collection". The correct statement is: **`Collection` extends `Iterable`**, and `Iterable.iterator()` returns an `Iterator`.

### `ListIterator`
1. The `List` interface has methods that return a `ListIterator`. `ListIterator` **extends the `Iterator` interface**.
2. So `ListIterator` already has `hasNext()` and `next()`.
3. What else it has: **`hasPrevious()`** and **`previous()`**.
4. `List` provides two methods (**method overloading**):
   1. `ListIterator<E> listIterator()`
   2. `ListIterator<E> listIterator(int index)` (start from a position)
5. `ListIterator` is a **bidirectional iterator** for lists. It allows the list to be traversed in either direction using `next()` and `previous()`. (The reason it is bidirectional is that `LinkedList` is a doubly linked list.)

## Example programs
```java
// 1. Iterator - forward
List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    if (it.next() % 2 == 0) it.remove();      // safe removal
}
System.out.println(list);                      // [1, 3]

// 2. ListIterator - backwards
ListIterator<Integer> li = new ArrayList<>(List.of(1, 2, 3)).listIterator(3);  // start at the end
while (li.hasPrevious()) System.out.print(li.previous() + " ");               // 3 2 1

// 3. A custom class that works in for-each
class MyList implements Iterable<Integer> {
    private final int[] data = {10, 20, 30};

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int index = 0;                                       // the "stateful cursor"
            public boolean hasNext() { return index < data.length; }
            public Integer next()    { return data[index++]; }
        };
    }
}
for (int x : new MyList()) System.out.print(x + " ");           // 10 20 30
```

### Fail-fast gotcha (extra)
```java
for (int x : list) {
    if (x == 2) list.remove(Integer.valueOf(x));   // ConcurrentModificationException
}
```
Removing from the collection while for-each (an iterator) is running throws `ConcurrentModificationException`. Use `it.remove()` or `list.removeIf(...)`.

## Interview Questions
1. **Difference between `Iterable` and `Iterator`?**
   `Iterable` is something that can be iterated; it has `iterator()`. `Iterator` is the cursor object with `hasNext()`, `next()` and `remove()`.
2. **Why does `Collection` extend `Iterable`?**
   So that every collection can return an `Iterator` and work with the for-each loop.
3. **How does the for-each loop work internally?**
   The compiler converts it to `iterator()` + a `while (hasNext()) next()` loop.
4. **What are the methods of `Iterator`?**
   `hasNext()`, `next()`, `remove()` (optional), and `forEachRemaining()`.
5. **Difference between `Iterator` and `ListIterator`?**
   `ListIterator` works only on lists, goes both directions (`hasPrevious`, `previous`), gives indexes (`nextIndex`, `previousIndex`) and can `add` / `set` / `remove`.
6. **Why is `ListIterator` bidirectional?**
   Lists have positions, and `LinkedList` is a doubly linked list.
7. **What is fail-fast? What is `ConcurrentModificationException`?**
   Iterators of `ArrayList`, `HashMap`, etc. check a modification count and throw this exception if the collection is changed during iteration by anything other than the iterator.
8. **How do you remove elements safely while iterating?**
   `Iterator.remove()`, `removeIf()`, or iterate over a copy.
9. **What is fail-safe?**
   Iterators of concurrent collections (`CopyOnWriteArrayList`, `ConcurrentHashMap`) work on a snapshot / weakly-consistent view and do not throw the exception.
10. **Can we use for-each on a Map?**
    Not directly (`Map` is not `Iterable`). Use `map.entrySet()`, `keySet()` or `values()`.
11. **How do you make your own class usable in for-each?**
    Implement `Iterable<T>` and return an `Iterator<T>` from `iterator()`.
12. **Can an `Iterator` go back to the start?**
    No. Get a new iterator.
13. **What is `forEach()` on `Iterable`?**
    A default method that applies an action to each element: `list.forEach(System.out::println)`.

# 13 - StringBuffer

## What I learnt

`StringBuffer` is a class similar to `String` / `StringBuilder`.

```java
StringBuffer buffer = new StringBuffer();
buffer.append("Sam");
System.out.println(buffer.toString());
```
- It is a **mutable** sequence of characters.
- `String a = "Santhosh";` - we can't change it; if we change it, it creates a **new object**.

### Advantages
1. **Mutable**
2. **Efficient**
3. **Thread safe** (Process) - when one thread is working on data it **prevents other threads** from working on the same data at the same time (more in Java threads).
   -> This makes StringBuffer **slower**. If multiple threads are working on the same data, use StringBuffer.

### StringBuilder vs StringBuffer
`StringBuilder` is **not thread safe** - that is the **only difference** between StringBuilder and StringBuffer.

| | String | StringBuilder | StringBuffer |
|---|--------|---------------|--------------|
| Mutable | No | Yes | Yes |
| Thread-safe | Yes (immutable) | No | Yes (synchronized) |
| Speed | Slow for modifications | Fastest | Slower than StringBuilder |
| Since | 1.0 | 1.5 | 1.0 |
| Use when | value doesn't change | single thread, many changes | multi-thread, shared changes |

### Constructors
```java
// Constructor 1
StringBuffer buffer = new StringBuffer();
// Constructor 2
StringBuffer bf = new StringBuffer("Santhosh");
// Constructor 3 (capacity)
StringBuffer bf = new StringBuffer(30);
```
**Default capacity of StringBuffer is 16.**

### Random character
```java
for (int i = 0; i < 26; i++) {
    int ch = 97 + (int) (random.nextFloat() * 26);
    sb.append((char) ch);
}
```

### Methods
Methods of String, StringBuilder and StringBuffer have examples of each in this repo:
`append, insert, delete, deleteCharAt, replace, reverse, setCharAt, charAt, length, setLength, capacity, ensureCapacity, trimToSize, indexOf, lastIndexOf, substring, subSequence, toString, compareTo, isEmpty, chars, appendCodePoint, codePointAt, getChars`.

## Programs

| File | Shows |
|------|-------|
| `StringBufferMethodsDemo.java` | **an example for every method** and all constructors |
| `ThreadSafetyDemo.java` | StringBuffer vs StringBuilder with two threads (race condition) |

## Interview Questions

1. **What is StringBuffer?**
   A mutable, thread-safe sequence of characters.
2. **Why is StringBuffer thread-safe?**
   Its methods are `synchronized`, so only one thread can run a method on the object at a time.
3. **StringBuffer vs StringBuilder?**
   Same API; StringBuffer is synchronized (slower, thread-safe), StringBuilder is not (faster).
4. **StringBuffer vs String?**
   String is immutable; StringBuffer is mutable.
5. **Which would you use in a single-threaded program?**
   StringBuilder - no synchronization overhead.
6. **Default capacity of StringBuffer?**
   16 (a `new StringBuffer("abc")` has 16 + 3 = 19).
7. **How does the capacity grow?**
   `(oldCapacity + 1) * 2`, i.e. `(old * 2) + 2`.
8. **Is `StringBuffer.equals()` overridden?**
   No - it compares references.
9. **Why does StringBuffer make things slower?**
   Locking (acquiring/releasing the monitor) on every method call.
10. **Is StringBuffer still used?**
    Rarely - for shared mutable text across threads; modern code prefers StringBuilder (per-thread) or other concurrency utilities.
11. **How to convert between String, StringBuilder and StringBuffer?**
    `new StringBuffer(str)`, `sb.toString()`, `new StringBuilder(buffer)` / `new StringBuffer(builder.toString())`.
12. **What is a race condition? Show it with StringBuilder.**
    Two threads modify shared data at once and lose updates - see `ThreadSafetyDemo.java`.

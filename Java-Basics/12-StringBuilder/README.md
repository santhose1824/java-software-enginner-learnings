# 12 - StringBuilder

## What I learnt

### The problem: String performance
```java
String series = "";
for (int i = 0; i < 26; i++) {
    char ch = (char) ('a' + i);
    series += ch;
}
System.out.println(series);
```
How does this work internally? It is **not a good solution**.

```
series = "";
i = 0: series = "" + a   = a
i = 1: series = "a" + b  = ab
i = 2: series = "ab" + c = abc
...
```
Every time we do this it **creates a new String object** (because Strings are immutable) and uses a lot of memory.

`[a, ab, abc, abcd, abcde, ... abcdefghi...y]` - all of these intermediate strings have **no reference variable** at the end -> **memory wastage**.

### The solution: `StringBuilder`
It is also a **class in Java**.
```java
StringBuilder builder = new StringBuilder();
for (int i = 0; i < 26; i++) {
    char ch = (char) ('a' + i);
    builder.append(ch);
}
System.out.println(builder.toString());   // abcdefghijklmnopqrstuvwxyz
```
- It is **mutable** (the same object is modified).
- Not thread-safe -> faster than `StringBuffer`.

### Random character example
```java
for (int i = 0; i < 26; i++) {
    int ch = 97 + (int) (random.nextFloat() * 26);
    sb.append((char) ch);
}
```

### Default capacity
`new StringBuilder()` -> capacity **16**. When full, new capacity = `(oldCapacity * 2) + 2`.

## Methods covered (`StringBuilderMethodsDemo.java`)
`append, insert, delete, deleteCharAt, replace, reverse, setCharAt, charAt, length, setLength, capacity, ensureCapacity, trimToSize, indexOf, lastIndexOf, substring, subSequence, toString, compareTo, equals (gotcha), isEmpty, chars, appendCodePoint, codePointAt, getChars` + all 4 constructors.

## Programs

| File | Shows |
|------|-------|
| `StringPerformanceDemo.java` | String `+=` problem vs StringBuilder, timing comparison, random characters |
| `StringBuilderMethodsDemo.java` | **an example for every method** |

## Interview Questions

1. **Why do we need StringBuilder when we have String?**
   Strings are immutable, so repeated modification creates many objects. StringBuilder modifies one object in place.
2. **Difference between `String` and `StringBuilder`?**
   Immutable vs mutable; StringBuilder is efficient for frequent modifications.
3. **Difference between `StringBuilder` and `StringBuffer`?**
   StringBuffer is synchronized (thread-safe, slower); StringBuilder is not synchronized (faster). Otherwise same API.
4. **Is StringBuilder thread-safe?**
   No.
5. **When would you use StringBuilder over `+`?**
   Concatenating in loops. (For simple one-line concatenation the compiler already optimises `+`.)
6. **What is the default capacity of StringBuilder? How does it grow?**
   16; grows to `(old * 2) + 2` when needed.
7. **How do you reverse a String efficiently?**
   `new StringBuilder(s).reverse().toString()`.
8. **Does StringBuilder override `equals()`?**
   No - `sb1.equals(sb2)` compares references. Compare `sb1.toString().equals(sb2.toString())` or use `compareTo`.
9. **How do you convert StringBuilder to String?**
   `sb.toString()`.
10. **What does `append()` return? Why does chaining work?**
    It returns `this` (the same StringBuilder).
11. **Difference between `length()` and `capacity()`?**
    `length()` = number of characters present; `capacity()` = how many it can hold before resizing.
12. **How does StringBuilder compare in time complexity for N appends?**
    O(N) amortised vs O(N^2) for repeated String concatenation.
13. **What's the difference between `delete()` and `deleteCharAt()`?**
    `delete(start, end)` removes a range (end exclusive); `deleteCharAt(i)` removes one char.
14. **Can a StringBuilder be used as a HashMap key?**
    Not recommended - it is mutable and has no value-based `equals/hashCode`.

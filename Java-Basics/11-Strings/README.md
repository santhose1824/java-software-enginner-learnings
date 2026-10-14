# 11 - Strings

## What I learnt

A String is a **sequence of characters**. `"Santhosh"` is a String.

```java
int a = 10;                    // primitive: stored in the stack
int[] arr = {10, 20, 30};      // array (object): reference variable in stack, object created in heap (non-primitive)
String name = "Santhosh";      // same as array: reference variable in stack, object created in heap
```

### Internal working
1. `String` is a **class**.
2. Every string we create is actually an **object of String**.
```
String name = "Santhosh";
 |      |        └─ object
 |      └─ reference variable
 └─ class / data type
```
3. How is it stored internally? - **String Pool** (a special memory area inside the heap)
```java
String a = "Santhosh";
String b = "Santhosh";
```
Both `a` and `b` point to **the same object** in the pool - no new object is created for the same value.

### Why are Strings immutable?
- If `a` and `b` point to the same object and one of them changed the data, the other would change too.
- So it doesn't make sense to change for others - that is why **Strings are immutable in Java**.
- If we change the data, a **new object** is created; the old one is not touched.
- (Extra benefits: security, thread-safety, hashCode caching, safe as `HashMap` keys.)

### String comparison - two ways
1. `==` comparator -> checks whether both **reference variables point to the same object**
2. `.equals()` method -> checks the **value**

```java
String a = "Kunal";
String b = "Kunal";
a == b        // true  (same pooled object)

String c = new String("Kunal");
String d = new String("Kunal");
c == d        // false (new objects created)
c.equals(d)   // true
```
When you only need to check the value, use `.equals()`.

### How to create different objects of the same value?
```java
String a = new String("Santhosh");
String b = new String("Santhosh");
```
Creates objects **outside the pool** (in the normal heap) -> `a == b` is `false`.

### Accessing an index
`a.charAt(0)` -> `'S'`

### toString()
- Whatever data we put in `println()`, it internally calls `toString()` to print it.
- For an object (array / class) the default prints a "random" value like `[I@5acf9800`: `type@hashcode` (`[I` = int array).
- Classes like `String`, `ArrayList` override `toString()`.

### Formatting / pretty printing
```java
float a = 453.124f;
System.out.printf("%.2f", a);       // 453.12  (rounds, exactly 2 digits after decimal)

System.out.printf("Hello my name is %s and I am %s", "Santhosh", "Cool");
// Hello my name is Santhosh and I am Cool
```

### Operators used in Strings
```java
System.out.println('a' + 'b');    // 195 -> convert a and b to ASCII values and add them
System.out.println("a" + "b");    // ab  -> given as Strings, so just concatenate
System.out.println('a' + 3);      // 100 -> ASCII of 'a' is 97, 97 + 3 = 100
System.out.println("a" + 1);      // a1  -> int is converted (wrapper class) then toString() is called
System.out.println("Santhosh" + new ArrayList<>());   // Santhosh[]
```
- With characters, `+` converts the char to its ASCII value and adds.
- If it's a String, it concatenates.
- When any object is concatenated with a String, `toString()` is called and the result is concatenated.
- `+` is only applicable for primitives, and if any one of the operands is a String. This is **operator overloading** (built into the language only for `+` on Strings).
- But concatenation in loops leads to **poor performance** -> see `12-StringBuilder`.

## Programs

| File | Shows |
|------|-------|
| `StringBasics.java` | stack vs heap, String pool, `new String`, `intern`, immutability |
| `StringComparison.java` | `==` vs `equals`, `equalsIgnoreCase`, `compareTo`, null-safe compare |
| `StringMethodsDemo.java` | **every common String method** with output |
| `StringFormattingAndOperators.java` | `toString()`, `printf`/format specifiers, `+` operator puzzles |

### String methods covered in `StringMethodsDemo.java`
`length, isEmpty, isBlank, charAt, indexOf, lastIndexOf, substring, contains, startsWith, endsWith, toUpperCase, toLowerCase, trim, strip, stripLeading, stripTrailing, replace, replaceAll, replaceFirst, split, join, concat, repeat, toCharArray, valueOf, chars, compareTo, equals, equalsIgnoreCase, matches, hashCode, intern, format, formatted, codePointAt, getBytes, lines, text blocks, copyValueOf, contentEquals, regionMatches` + reverse (via StringBuilder) and palindrome check.

## Interview Questions

1. **What is a String in Java? Is it a primitive?**
   A sequence of characters; it is a class (object), not a primitive.
2. **Why are Strings immutable?**
   Because many references share the pooled object; immutability gives safety, thread-safety, caching of hashCode, and lets the String pool work.
3. **What is the String pool?**
   A special area in the heap where string literals are stored and reused.
4. **`==` vs `.equals()` for Strings?**
   `==` compares references (same object?), `.equals()` compares content.
5. **`String s = "abc"` vs `String s = new String("abc")`?**
   The literal uses/creates one pooled object. `new` always creates a new object on the heap (plus the literal in the pool if not present).
6. **How many objects are created by `new String("abc")`?**
   Up to 2 - one in the pool (if "abc" isn't there already) and one on the heap.
7. **What does `intern()` do?**
   Returns the canonical pooled instance of the string.
8. **Can we change a String? What does `s.concat("x")` do without assignment?**
   No; it returns a new String, and the original remains unchanged.
9. **Difference between `String`, `StringBuilder` and `StringBuffer`?**
   String is immutable; StringBuilder is mutable and not thread-safe (fast); StringBuffer is mutable and thread-safe (slower).
10. **How do you reverse a String?**
    `new StringBuilder(s).reverse().toString()` or loop through chars from the end.
11. **How do you check if a String is a palindrome?**
    Compare with its reverse, or use two pointers from both ends.
12. **Output of `System.out.println('a' + 'b')`? And `"a" + 'b'`? And `1 + 2 + "3"`?**
    `195`, `ab`, `33`.
13. **What is `toString()`? What does printing an object show by default?**
    Method of `Object` returning a String representation; default is `ClassName@hexHashCode`.
14. **`length()` vs `length` vs `size()`?**
    String -> `length()`; array -> `length`; collections -> `size()`.
15. **Difference between `equals()` and `compareTo()`?**
    `equals` returns boolean; `compareTo` returns an int ordering (0 = equal).
16. **`trim()` vs `strip()`?**
    `strip()` is Unicode-aware (Java 11+); `trim()` removes only characters <= U+0020.
17. **How to compare ignoring case?**
    `equalsIgnoreCase()` / `compareToIgnoreCase()`.
18. **How do you split a string and join it back?**
    `s.split(",")` and `String.join(",", parts)`.
19. **Why is `"admin".equals(input)` safer than `input.equals("admin")`?**
    Avoids `NullPointerException` when `input` is null.
20. **Why is String concatenation in a loop bad?**
    Each `+=` creates a new String object (immutability) - O(n^2) time/memory. Use `StringBuilder`.
21. **How does `printf("%.2f")` work?**
    Formats the number rounded to 2 decimal places.
22. **Is `String` thread-safe?**
    Yes - because it is immutable.
23. **What is the difference between `replace()` and `replaceAll()`?**
    `replace` works with literal characters/sequences; `replaceAll` takes a regex.
24. **How to convert String to int and back?**
    `Integer.parseInt(s)` and `String.valueOf(i)` / `Integer.toString(i)`.
25. **Can String be used in `switch`?**
    Yes (Java 7+).

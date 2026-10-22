# 03 - Taking Input (Scanner)

## What I learnt

We take input using the **`Scanner`** class from the `java.util` package.

```java
import java.util.Scanner;

Scanner input = new Scanner(System.in);
int rollno = input.nextInt();
```

Breaking it down:

| Part | Meaning |
|------|---------|
| `Scanner` | Class (data type) |
| `input` | Object reference variable |
| `new` | Keyword that creates the object |
| `Scanner(System.in)` | Constructor. `System.in` is the standard input stream (keyboard) - from `java.lang`. |
| `input.nextInt()` | Method of the Scanner class called via the object reference |

### Methods for each type

| Type | Method |
|------|--------|
| int | `input.nextInt()` |
| byte | `input.nextByte()` |
| short | `input.nextShort()` |
| long | `input.nextLong()` |
| float | `input.nextFloat()` |
| double | `input.nextDouble()` |
| boolean | `input.nextBoolean()` |
| String (single word) | `input.next()` |
| String (entire line) | `input.nextLine()` |
| char | `input.next().charAt(0)` (get the character at index 0 - Strings concept) |

### Literal vs identifier

```java
int a = 10;
//  ^ identifier (name)    ^ literal (value)
```

### Gotcha: `nextLine()` after `nextInt()`
`nextInt()` leaves the newline in the buffer, so a following `nextLine()` returns an empty string. Call `input.nextLine()` once to consume it (see `ScannerInput.java`).

## Programs

| File | Shows |
|------|-------|
| `ScannerInput.java` | Reading different types incl. the `nextLine()` gotcha |
| `ScannerAllTypes.java` | One input for every primitive type |

## Interview Questions

1. **How do you take input in Java?**
   Using `Scanner` (`java.util`), `BufferedReader`, or `Console`. Scanner is the simplest.
2. **What does `System.in` represent?**
   The standard input stream (an `InputStream`) - the keyboard.
3. **Difference between `next()` and `nextLine()`?**
   `next()` reads one word (stops at whitespace). `nextLine()` reads the whole line.
4. **Why does `nextLine()` sometimes get skipped after `nextInt()`?**
   `nextInt()` does not consume the newline; the next `nextLine()` consumes that leftover newline and returns "".
5. **How do you read a `char` with Scanner?**
   There is no `nextChar()`; use `input.next().charAt(0)`.
6. **Which package contains Scanner?**
   `java.util`.
7. **What exception is thrown when wrong input is given (e.g. text for `nextInt()`)?**
   `InputMismatchException`.
8. **Why should we close the Scanner?**
   To release the underlying resource (`input.close()`). Note: closing a Scanner on `System.in` closes `System.in` itself.
9. **Scanner vs BufferedReader?**
   Scanner parses types and is easier but slower; `BufferedReader` is faster for large input but only reads Strings.
10. **What is a constructor?**
    A special method that runs when an object is created with `new` (covered in OOPs).

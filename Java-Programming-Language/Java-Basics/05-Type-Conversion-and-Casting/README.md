# 05 - Type Conversion and Type Casting

## What I learnt

### Type Conversion (widening / implicit)
When one type of data is assigned to another type of variable, conversion happens **automatically** if:

1. The two types are **compatible**.
2. The **destination type is greater** than the source type.

```java
int num = 67;
float f = num;     // type conversion
```

Java also performs automatic conversion when a **literal integer constant** is assigned to types like `byte`, `short`, `float`, `long`, even `char` sometimes (`byte b = 10;`).

### Type Casting (narrowing / explicit)
To convert float -> int (bigger to smaller) we must cast. Also called **narrowing conversion**.

```java
int num = (int) 67.9f;   // 67  (decimal part is dropped)
```

### Narrowing with overflow
```java
int a = 257;
byte b = (byte) a;   // 1
```
A `byte` holds 256 different values, so Java effectively does modulo: `257 % 256 = 1`.
(Formula from my notes: `stored value = value % size of type`. For signed types the result is then mapped into the signed range, e.g. `(byte) 130 = -126`.)

### Automatic type promotion in expressions

**Case 1** - `int a = 257; byte b = (byte) a;` -> output `1`.

**Case 2** -
```java
byte a = 40, b = 50, c = 100;
int d = (a * b) / c;   // (40 * 50) / 100 = 20
```
`40 * 50 = 2000` does not fit in a byte. To avoid this, Java automatically **promotes `byte` -> `int`** while evaluating the expression.

**Case 3** -
```java
byte b = 50;
b = b * 10;     // ERROR - b * 10 is an int, we explicitly need to convert
b = (byte)(b * 10);  // fix
```

### Order (lower -> higher)

```
byte -> short -> int -> long -> float -> double
        char  -> int
```
> Note: in my handwritten list `long` came after `double`. The correct widening order is `byte < short < int < long < float < double` (`char` widens to `int`). `boolean` is not convertible to/from any number.

### Rules
- All `byte`, `short`, `char` are promoted to `int`.
- If any one of the operands is `long` / `float` / `double`, the whole expression is converted to that type.

### Example
```java
byte b = 42; char c = 'a'; short s = 1024; float f = 5.67f; double d = 0.1234;
double result = (f * b) + (i / c) - (d - s);
//               float      int        double   -> overall double
```

## Programs

| File | Shows |
|------|-------|
| `TypeConversionDemo.java` | Widening, casting, overflow, promotion cases 1-3, expression type rules |

## Interview Questions

1. **Difference between type conversion and type casting?**
   Conversion is automatic (widening, small -> big). Casting is explicit, done by the programmer (narrowing, big -> small).
2. **What is widening and narrowing?**
   Widening: small type to big type (safe). Narrowing: big to small (may lose data).
3. **What is the output of `(byte) 257`?**
   `1`.
4. **Why does `byte b = 50; b = b * 10;` give an error?**
   `b * 10` is promoted to `int`; assigning an `int` to a `byte` needs an explicit cast.
5. **Why does `byte b = 50; b *= 10;` compile?**
   Compound assignment operators (`+=`, `*=`, ...) include an implicit cast.
6. **What is automatic type promotion?**
   `byte`, `short`, `char` operands are promoted to `int` (or to the biggest operand type) during expression evaluation.
7. **What is the result type of `byte + byte`? `int + long`? `int + float`?**
   `int`, `long`, `float`.
8. **What is the result of `(int) 67.9`?**
   `67` (truncation, not rounding).
9. **Can we convert `boolean` to `int`?**
   No, not by casting or conversion.
10. **Can `long` be assigned to `float` without a cast? Why?**
    Yes - float has a larger range, but precision may be lost.
11. **What is `char c = 65;`?**
    `'A'` - the int literal fits in char, so it is implicitly converted.
12. **`System.out.println('a' + 'b')` prints?**
    `195` (chars are promoted to int).

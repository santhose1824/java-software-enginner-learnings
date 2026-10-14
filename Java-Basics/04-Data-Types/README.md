# 04 - Data Types

## What I learnt

**Primitive data types** are the ones we cannot break down further.
`String` is **not** primitive, because we can break it further into characters (it is a class/object).

| # | Type | Used for | Size | Example |
|---|------|----------|------|---------|
| 1 | `int` | integers | 4 bytes | `int rollno = 64;` |
| 2 | `char` | single letter | 2 bytes | `char letter = 'S';` |
| 3 | `float` | smaller decimal values | 4 bytes | `float marks = 98.656f;` |
| 4 | `double` | longer decimal values | 8 bytes | `double d = 65.124678912;` |
| 5 | `long` | longer integers | 8 bytes | `long l = 3468712367981L;` |
| 6 | `boolean` | true / false | JVM dependent (1 bit of info) | `boolean check = true;` |
| 7 | `byte` | smaller integers (-128 to 127) | 1 byte | `byte bit = 125;` |
| 8 | `short` | integers bigger than byte, smaller than int | 2 bytes | `short sht = 347;` |

### Why `f` in float and `L` in long?
- By default, **decimal values are treated as `double`**.
- By default, **integers are treated as `int`**.
- So `float f = 5.5;` is an error, we write `5.5f`. And a number bigger than int range needs `L`.

### Wrapper classes
- For every primitive type there is a **wrapper class** (`Integer`, `Double`, `Character`, `Boolean`, ...).
- They have many useful methods (`Integer.parseInt`, `Integer.MAX_VALUE`, ...).

### Which to use for decimals?
- Prefer `double` for decimal values. `float` has less precision and gives rounding errors sooner.
- (For money, use `BigDecimal` - `double` itself is also not exact, e.g. `0.1 + 0.2`.)

### Primitives are stored in the stack
`int a = 10;` - the value lives in the stack. Arrays/Strings/objects - the reference is in the stack and the object is in the heap.

### Default values
`int` -> 0, `double` -> 0.0, `boolean` -> false, `char` -> '\u0000', reference types -> `null`. (Local variables have **no** default and must be initialised.)

## Programs

| File | Shows |
|------|-------|
| `DataTypesDemo.java` | All 8 primitives, ranges, f/L suffix, default values, wrapper methods, float vs double |

## Interview Questions

1. **How many primitive data types are in Java? Name them.**
   8 - `byte, short, int, long, float, double, char, boolean`.
2. **Is String a primitive type?**
   No, it is a class (reference type).
3. **What is the default type of `3.14` and `10` in Java?**
   `double` and `int`.
4. **Why do we write `f` / `L`?**
   To tell the compiler the literal is a `float` / `long` instead of the default `double` / `int`.
5. **What are the sizes and ranges of byte, short, int, long?**
   1, 2, 4, 8 bytes -> `-128..127`, `-32,768..32,767`, `-2^31..2^31-1`, `-2^63..2^63-1`.
6. **Difference between `float` and `double`?**
   `float` is 32-bit (~7 digits precision), `double` is 64-bit (~15 digits). Double is default.
7. **What is a wrapper class? Why do we need it?**
   An object version of a primitive (`Integer` for `int`). Needed for collections (`ArrayList<Integer>`), utility methods, and `null` values.
8. **What are autoboxing and unboxing?**
   Automatic conversion between primitive and wrapper (`int -> Integer` and back).
9. **Default value of an `int` field vs local variable?**
   Field: 0. Local variable: none - compile error if used before assigning.
10. **What is the size of `boolean`?**
    Not precisely defined by the spec; JVM dependent (commonly 1 byte).
11. **Can `char` hold numbers?**
    Yes, `char` is an unsigned 16-bit integer (0-65535) holding a Unicode code point.
12. **Why is `0.1 + 0.2 != 0.3`?**
    Decimal fractions can't be represented exactly in binary floating point.
13. **Difference between a literal and an identifier?**
    In `int a = 10;` - `a` is the identifier (name), `10` is the literal (value).
14. **Where are primitives stored?**
    Local primitives in the stack; fields of objects live inside the object in the heap.

# Java Wrapper Classes: Methods with Examples

A single, runnable Java file, `WrapperClassMethods.java`, that demonstrates **every non-deprecated public constant and method** of the 8 wrapper classes, with an example for each.

| Primitive | Wrapper Class | Size | Range / Notes |
|-----------|---------------|------|---------------|
| `byte`    | `Byte`        | 8-bit  | -128 to 127 |
| `short`   | `Short`       | 16-bit | -32,768 to 32,767 |
| `int`     | `Integer`     | 32-bit | -2³¹ to 2³¹-1 |
| `long`    | `Long`        | 64-bit | -2⁶³ to 2⁶³-1 |
| `float`   | `Float`       | 32-bit | IEEE 754 single precision |
| `double`  | `Double`      | 64-bit | IEEE 754 double precision |
| `char`    | `Character`   | 16-bit | Unsigned UTF-16 code unit (0 to 65,535) |
| `boolean` | `Boolean`     | JVM-dependent | `true` / `false` |

---

## Requirements

- Java 8 or newer (JDK for `javac`)

## How to run

```bash
# Compile
javac WrapperClassMethods.java

# Run all 8 wrapper classes
java WrapperClassMethods

# Run only selected wrapper classes (case-insensitive)
java WrapperClassMethods Integer
java WrapperClassMethods Byte Boolean Character
```

On Java 11+ you can skip the compile step:

```bash
java WrapperClassMethods.java Integer
```

Every line of output has the form `expression -> result`, so you can match each example to its output.

---

## What is covered

The file is organised into one demo method per wrapper class. Each demo is split into sections.

### Common to all numeric wrappers (`Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`)

| Group | Methods |
|-------|---------|
| Constants | `MIN_VALUE`, `MAX_VALUE`, `SIZE`, `BYTES`, `TYPE` |
| Creating | `valueOf(primitive)`, `valueOf(String)`, `valueOf(String, radix)` (integral types), autoboxing / unboxing |
| Parsing | `parseXxx(String)`, `parseXxx(String, radix)`, `decode(String)` (integral types) |
| To String | `toString()`, `toString(primitive)` |
| Number conversion | `byteValue()`, `shortValue()`, `intValue()`, `longValue()`, `floatValue()`, `doubleValue()` |
| Comparison | `compareTo()`, `compare()`, `equals()` |
| Hash code | `hashCode()`, `hashCode(primitive)` |

### Extra methods per class

| Class | Additional methods demonstrated |
|-------|---------------------------------|
| **Byte** | `toUnsignedInt`, `toUnsignedLong` |
| **Short** | `reverseBytes`, `toUnsignedInt`, `toUnsignedLong` |
| **Integer** | `parseUnsignedInt`, `toBinaryString`, `toOctalString`, `toHexString`, `toUnsignedString`, `toUnsignedLong`, `compareUnsigned`, `divideUnsigned`, `remainderUnsigned`, `sum`, `max`, `min`, `signum`, `bitCount`, `highestOneBit`, `lowestOneBit`, `numberOfLeadingZeros`, `numberOfTrailingZeros`, `reverse`, `reverseBytes`, `rotateLeft`, `rotateRight`, `getInteger` (3 overloads) |
| **Long** | Same set as `Integer` (`parseUnsignedLong`, `toXxxString`, unsigned ops, bit ops, `getLong` with 3 overloads, ...) |
| **Float** | `MIN_NORMAL`, `POSITIVE_INFINITY`, `NEGATIVE_INFINITY`, `NaN`, `MAX_EXPONENT`, `MIN_EXPONENT`, `toHexString`, `isNaN` (static + instance), `isInfinite` (static + instance), `isFinite`, `sum`, `max`, `min`, `floatToIntBits`, `floatToRawIntBits`, `intBitsToFloat` |
| **Double** | Same as `Float`, with `doubleToLongBits`, `doubleToRawLongBits`, `longBitsToDouble` |

### Character

| Group | Methods |
|-------|---------|
| Constants | `MIN_VALUE`, `MAX_VALUE`, `MIN_RADIX`, `MAX_RADIX`, `SIZE`, `BYTES`, `TYPE`, `MIN_CODE_POINT`, `MAX_CODE_POINT`, `MIN_SUPPLEMENTARY_CODE_POINT` |
| Basics | `valueOf`, `charValue`, `toString`, `compareTo`, `compare`, `equals`, `hashCode` |
| Testing | `isDigit`, `isLetter`, `isLetterOrDigit`, `isAlphabetic`, `isUpperCase`, `isLowerCase`, `isTitleCase`, `isWhitespace`, `isSpaceChar`, `isISOControl`, `isDefined`, `isMirrored`, `isIdeographic` |
| Identifiers | `isJavaIdentifierStart/Part`, `isUnicodeIdentifierStart/Part`, `isIdentifierIgnorable` |
| Case | `toUpperCase`, `toLowerCase`, `toTitleCase` |
| Digits | `digit`, `forDigit`, `getNumericValue` |
| Metadata | `getType`, `getDirectionality`, `getName`, `UnicodeBlock.of`, `UnicodeScript.of`, `reverseBytes` |
| Surrogates / code points | `isSurrogate`, `isHighSurrogate`, `isLowSurrogate`, `isSurrogatePair`, `isSupplementaryCodePoint`, `isBmpCodePoint`, `isValidCodePoint`, `charCount`, `toCodePoint`, `highSurrogate`, `lowSurrogate`, `codePointAt`, `codePointBefore`, `codePointCount`, `offsetByCodePoints`, `toChars` |

### Boolean

`TRUE`, `FALSE`, `TYPE`, `valueOf` (boolean / String), `parseBoolean`, `booleanValue`, `toString`, `compare`, `compareTo`, `equals`, `hashCode`, `logicalAnd`, `logicalOr`, `logicalXor`, `getBoolean`.

---

## Key concepts worth remembering

**Autoboxing and unboxing**: Java converts automatically between primitives and wrappers.

```java
Integer boxed = 42;     // autoboxing   (int -> Integer)
int plain = boxed;      // unboxing     (Integer -> int)
```

**Use `equals()`, not `==`, to compare wrapper objects.** `Integer` values from -128 to 127 are cached, so `==` can appear to work for small numbers and fail for larger ones.

```java
Integer a = 127, b = 127;   // a == b  -> true  (cached)
Integer c = 128, d = 128;   // c == d  -> false (different objects)
c.equals(d);                // true
```

**Different wrapper types are never `equals()`.** `Integer.valueOf(10).equals(10L)` is `false`.

**`NaN` is special.** `NaN == NaN` is `false`, but `Double.valueOf(Double.NaN).equals(Double.NaN)` is `true`. Always use `isNaN()` to test for it.

**`Boolean.parseBoolean` never throws.** Anything other than `"true"` (case-insensitive) gives `false`. By contrast, `Integer.parseInt("abc")` throws `NumberFormatException`.

**Narrowing conversions can overflow.** `Integer.valueOf(255).byteValue()` returns `-1`, and `Long.intValue()` silently drops high bits.

**Unsigned operations.** Java's integral types are signed, but `Integer`, `Long`, `Byte` and `Short` provide helper methods (`toUnsignedInt`, `compareUnsigned`, `divideUnsigned`, ...) for treating the bits as unsigned.

**Constructors are deprecated.** `new Integer(5)` and similar have been deprecated for removal since Java 9. Use `valueOf(...)` or autoboxing instead. This file avoids them on purpose.

---

## Sample output

```
======================================================================
  3. Integer  (primitive: int)
======================================================================

--- Constants ---
  Integer.MIN_VALUE                                    -> -2147483648
  Integer.MAX_VALUE                                    -> 2147483647
  Integer.SIZE (bits)                                  -> 32
  ...
--- Bit manipulation ---
  Integer.bitCount(255)                                -> 8
  Integer.highestOneBit(100)                           -> 64
```

---




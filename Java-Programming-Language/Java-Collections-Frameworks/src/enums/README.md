# Enums in Java

## What I learnt
An **enum** is like a group of variables (constants) that **we can't change**. We use it when a value must be one of a fixed set, like days of the week or levels.

```java
enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

## My notes

### Syntax
```java
enum name {
    constants
}
```
- Enum constants are always **`public static final`**.
- The **type** of each constant is the **name of the enum** (`Week day = Week.MONDAY;`).
- `ordinal()` -> gets the **position** (index, starts at 0).
- `values()` -> gets **all** the enum values (as an array).
- An enum **can have a constructor**, but it cannot be `public` or `protected`. It is either `private` or default. (Fix: it is **always private** - with no modifier it is implicitly private.)
- Internally it works like this:
  ```java
  public static final Week MONDAY = new Week();
  ```

### Enum inheritance and interfaces
1. All enums inherit the **`java.lang.Enum`** class.
2. An enum **cannot be a parent class** (nothing can extend it).
3. An enum **can implement interfaces**.

## Example
```java
enum Week { MONDAY, TUESDAY, WEDNESDAY }

enum Level {
    LOW(1), HIGH(3);                       // constants call the constructor

    private final int value;
    Level(int value) { this.value = value; }   // implicitly private
    int getValue() { return value; }
}

for (Week w : Week.values()) {
    System.out.print(w + "(" + w.ordinal() + ") ");   // MONDAY(0) TUESDAY(1) WEDNESDAY(2)
}
Week.valueOf("TUESDAY");        // TUESDAY
Week.valueOf("SUNDAY");         // IllegalArgumentException (not defined in this enum)
Level.HIGH.getValue();          // 3
```
Other useful methods: `name()`, `compareTo()` (compares by ordinal: `MONDAY.compareTo(WEDNESDAY)` = -2), `toString()`.

`EnumMap` (from my collections diagram) is a `Map` whose keys are enum constants. It is kept in **enum order**:
```java
EnumMap<Week, String> em = new EnumMap<>(Week.class);
em.put(Week.WEDNESDAY, "w");
em.put(Week.MONDAY, "m");
System.out.println(em);        // {MONDAY=m, WEDNESDAY=w}
```

## Interview Questions
1. **What is an enum? Why use it instead of constants?**
   A special class for a fixed set of constants. It is type-safe (a method taking `Week` cannot be given a random `int`), readable, and can have fields and methods.
2. **Can an enum have a constructor? What access modifier?**
   Yes, always private (implicit). You cannot call `new Week()`.
3. **Can an enum extend a class? Implement an interface?**
   It cannot extend a class (it already extends `java.lang.Enum`), but it can implement interfaces.
4. **Can we extend an enum?**
   No.
5. **What does `values()` return? And `valueOf()`?**
   `values()` returns an array of all constants in declaration order. `valueOf(String)` returns the constant with that exact name, else throws `IllegalArgumentException`.
6. **What does `ordinal()` return?**
   The zero-based position of the constant.
7. **How do you compare enums: `==` or `equals()`?**
   Both work. `==` is preferred - each constant is a singleton, and `==` is null-safe and checked at compile time.
8. **Can an enum be used in a `switch`?**
   Yes: `switch (day) { case MONDAY -> ... }`.
9. **Are enum constants really `public static final`?**
   Yes. Internally each constant is a `public static final` instance of the enum.
10. **Can an enum have abstract methods?**
    Yes - each constant must then implement them with its own body.
11. **What are `EnumMap` and `EnumSet`?**
    Fast, compact `Map`/`Set` implementations for enum keys/elements, kept in the enum's natural order.
12. **How can you create a singleton with an enum?**
    `enum Singleton { INSTANCE; }` - thread-safe and safe against reflection and serialisation tricks.
13. **Can you create an enum object with `new`?**
    No.
14. **Why can an enum not be a parent class?**
    The compiler makes it effectively final (constants are the only instances).

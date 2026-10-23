# `lambda_functions`: lambda expressions and functional interfaces

## Files

| File | Purpose |
|------|---------|
| `LambdaFunctions.java` | Fills an `ArrayList<Integer>` with 1..10, prints doubles with `forEach`, sums with a lambda, then builds `add`, `sub`, `mul` lambdas of the custom interface `Operation` and passes them to an `operate` method. |
| `Operation` (same file) | `interface Operation { int operations(int a, int b); }`, a custom functional interface. |

## What I learned

- A **lambda expression** is a concise, functional-style anonymous function: `(parameters) -> what to do`. It is **inline**, no method name needed. Example: `(num1, num2) -> num1 + num2`.
- `list.forEach(...)` takes a `Consumer` type, so I can pass a lambda: `list.forEach(item -> System.out.print(item * 2 + " "))`.
- A lambda can be stored in a variable of a **functional interface** type (an interface with exactly one abstract method): `Operation add = (a, b) -> a + b;`
- Passing behaviour as a parameter: `operate(3, 4, add)` returns `7`, `sub` returns `-1`, `mul` returns `12`.
- Lambdas replace verbose anonymous classes (seen in `compare_objects`).

### Expected output

```
2 4 6 8 10 12 14 16 18 20 
[55]
7
-1
12
```

## Things to be careful about

- Lambdas can only use local variables that are **final or effectively final**. That is why the sum uses `int[] sum = {0};` and `sum[0] += item`: the array reference doesn't change, only its content. A plain `int sum` modified inside the lambda would not compile. (Streams, `list.stream().mapToInt(i -> i).sum()`, avoid this trick.)
- Add `@FunctionalInterface` on `Operation` so the compiler enforces "one abstract method".
- `operate` is `private`, which is fine because `main` is in the same class.
- Inside a lambda, `this` refers to the **enclosing** class; inside an anonymous class it refers to the anonymous object.

## Interview questions and answers

**1. What is a lambda expression?**
A short anonymous function with parameters and a body: `(a, b) -> a + b`. It provides an implementation for a functional interface (Java 8+).

**2. What is a functional interface?**
An interface with exactly one abstract method (default/static methods are allowed). Examples: `Runnable`, `Comparator`, `Consumer`, `Function`, `Predicate`, `Supplier`.

**3. What does `@FunctionalInterface` do?**
Compile-time check that the interface has a single abstract method; it is optional but recommended.

**4. Name the common built-in functional interfaces.**
`Consumer<T>` (takes T, returns nothing), `Supplier<T>` (no input, returns T), `Function<T,R>`, `Predicate<T>` (returns boolean), `BiFunction<T,U,R>`, `UnaryOperator<T>`, `BinaryOperator<T>`.

**5. Why must captured local variables be effectively final?**
Lambdas may run later or on another thread; allowing mutation of captured locals would cause inconsistent or unsafe state. Fields and array contents can be modified.

**6. Lambda vs anonymous class?**
Lambda: shorter, works only for functional interfaces, `this` = enclosing instance, compiled via `invokedynamic`. Anonymous class: can implement any interface/abstract class, has its own `this` and fields.

**7. What is `forEach` and what does it accept?**
A method on `Iterable` that takes a `Consumer<? super T>` and applies it to every element.

**8. What is a method reference?**
A shorter lambda for an existing method: `list.forEach(System.out::println)`.

**9. Can a lambda throw a checked exception?**
Only if the functional interface's method declares it.

**10. Write a lambda that sorts strings by length.**
`list.sort((a, b) -> Integer.compare(a.length(), b.length()));` or `list.sort(Comparator.comparingInt(String::length));`

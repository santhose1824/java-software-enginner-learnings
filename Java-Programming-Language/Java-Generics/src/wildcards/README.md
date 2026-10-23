# `wildcards`: bounded types and `?` wildcards

## Files

| File | Purpose |
|------|---------|
| `WildCardsExample.java` | A generic list `WildCardsExample<T extends Number>` plus a method `getList(List<? extends Number> list)` that fills it from any list of numbers. `main` passes an `ArrayList<Integer>`. |

## What I learned

- **Bounded type parameter**: `class WildCardsExample<T extends Number>` allows only `Number` or its subclasses (`Integer`, `Double`, ...). `WildCardsExample<String>` will not compile.
- **Wildcards** use `?` for an **unknown type** and are mostly used in **method arguments** to add flexibility while staying type-safe:

| Wildcard | Meaning | Use for | Notes |
|----------|---------|---------|-------|
| `<?>` | Unbounded, any type | Type doesn't matter | Can read as `Object` |
| `<? extends Type>` | `Type` or a **subclass** (upper bound) | **Reading** from a collection | Safe to read items as `Type` |
| `<? super Type>` | `Type` or a **superclass** (lower bound) | **Writing** into a collection | Safe to add `Type` (or its subclasses) |

- `getList(List<? extends Number> list)` accepts `List<Integer>`, `List<Double>`, ... and reads the elements as `Number`.
- Generic **interfaces** can also be created.

## Things to be careful about

- `T extends Number` is a **bounded type parameter**, not a wildcard. Wildcards are the `?` forms. Interviewers do ask this distinction.
- With `List<? extends Number>` you **cannot add** elements (except `null`) because the compiler doesn't know the exact type. With `? super Integer` you can add `Integer` but read only `Object`.
- In `getList`, `array = list.toArray()` replaces the internal array, so the capacity now equals the list size; the next `add` will trigger a resize. Also a `WildCardsExample<Integer>` could be filled with `Double`s through this method, which weakens type safety. Fine for practice.
- `new WildCardsExample()` without `<>` in `main` is a raw type (warning). Prefer `new WildCardsExample<>()`.

## Interview questions and answers

**1. What is a wildcard in Java generics?**
The `?` symbol representing an unknown type, used in generic type arguments (mostly method parameters).

**2. Name the three kinds of wildcards.**
Unbounded `<?>`, upper-bounded `<? extends T>`, lower-bounded `<? super T>`.

**3. Why is `List<Integer>` not a `List<Number>`?**
Generics are invariant. If it were allowed you could add a `Double` through the `List<Number>` view and corrupt the `List<Integer>`. Use `List<? extends Number>` for read-only access.

**4. What is PECS?**
"Producer Extends, Consumer Super": use `? extends T` when the collection *produces* values you read, `? super T` when it *consumes* values you write.

**5. `<T extends Number>` vs `<? extends Number>`?**
`T extends Number` declares a named type parameter you can reuse inside the class/method. `? extends Number` is an anonymous unknown type used at the usage site; you can't refer to it by name.

**6. Can I add an element to `List<? extends Number>`?**
No (except `null`). The actual list could be `List<Double>` while you try to add an `Integer`.

**7. When to use `List<?>`?**
When the code works only with methods that don't depend on the element type (e.g. `size()`, `clear()`, printing as `Object`).

**8. Can a bounded type have multiple bounds?**
Yes: `<T extends Number & Comparable<T>>`: at most one class (first) plus any number of interfaces.

**9. What is a generic interface? Example?**
An interface with type parameters, e.g. `Comparable<T>`, `List<E>`, `Map<K, V>`.

**10. What happens to wildcards at runtime?**
Nothing; they are erased. They exist only for compile-time checking.

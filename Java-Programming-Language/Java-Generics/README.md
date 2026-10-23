# Java Generics

Practice project from my Java interview-prep series. It starts from a hand-written `ArrayList` that only stores `int`, turns it into a generic one, then covers wildcards, comparing objects (`Comparable` / `Comparator`) and lambda expressions.

## Project structure

```
Java-Generics/
└── src/
    ├── custom_arrayList/    -> int-only list, then generic list <T>
    ├── wildcards/           -> bounded type <T extends Number>, List<? extends Number>
    ├── compare_objects/     -> sorting Student objects, Comparable vs Comparator
    └── lambda_functions/    -> lambdas, forEach, custom functional interface
```

| Folder | What it teaches | README |
|--------|-----------------|--------|
| `custom_arrayList` | Why generics exist, building a resizable array list, `T` and `Object[]` | [README](src/custom_arrayList/README.md) |
| `wildcards` | Bounded types and wildcards (`?`, `? extends`, `? super`) | [README](src/wildcards/README.md) |
| `compare_objects` | Sorting objects with `Comparable` and `Comparator` | [README](src/compare_objects/README.md) |
| `lambda_functions` | Lambda syntax, functional interfaces, `forEach` | [README](src/lambda_functions/README.md) |

## One-page summary of my notes

- **Generics** let classes, interfaces and methods work with different data types while giving **compile-time type safety**. They use type parameters such as `T` (type), `E` (element), `K` (key), `V` (value).
- Benefits: (1) less explicit casting, (2) one class works with many reference types, (3) incompatible types are caught at compile time, (4) code is easier to read (`ArrayList<String>` says what it holds).
- Before generics, collections stored `Object`, so reading needed a cast and a wrong cast caused `ClassCastException` at **runtime**.
- Generics work only with **classes (reference types), not primitives** (`ArrayList<Integer>`, not `ArrayList<int>`).
- Declaring a generic class: `class ClassName<T>`; `T` is replaced by the type provided.
- **Wildcards** use `?`: unbounded `<?>`, upper-bounded `<? extends Type>` (read), lower-bounded `<? super Type>` (write).
- **Comparable**: `compareTo()` defines the natural ordering used by `Arrays.sort`.
- **Lambda**: `(params) -> what to do`, an inline anonymous function; `forEach` takes a `Consumer`.

## Top interview questions (rapid-fire)

1. Why were generics introduced?
2. What is type erasure?
3. `List<Object>` vs `List<?>` vs `List<? extends Number>`?
4. `Comparable` vs `Comparator`?
5. What is a functional interface?

Detailed answers are in the folder READMEs.

## How to run

```bash
cd src
javac custom_arrayList/*.java && java custom_arrayList.CustomGenericArrayList
javac wildcards/*.java && java wildcards.WildCardsExample
javac compare_objects/*.java && java compare_objects.Main
javac lambda_functions/*.java && java lambda_functions.LambdaFunctions
```

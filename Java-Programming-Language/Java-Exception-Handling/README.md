# Java Exception Handling

Practice project from my Java interview-prep series. It covers how Java deals with runtime problems: the `Throwable` hierarchy, `try / catch / finally`, `throw` vs `throws`, and writing my own exception class.

## Project structure

```
Java-Exception-Handling/
└── src/
    ├── exception_handling/        -> try / catch / finally, throw, throws
    └── user_defined_exceptions/   -> custom (user-defined) exception
```

| Folder | What it teaches | README |
|--------|-----------------|--------|
| `exception_handling` | Handling `ArithmeticException`, `finally`, `throw` / `throws` | [README](src/exception_handling/README.md) |
| `user_defined_exceptions` | Creating a custom checked exception and using it with `Scanner` input | [README](src/user_defined_exceptions/README.md) |

## One-page summary of my notes

- **Exception handling** is a mechanism to deal with exceptional conditions that occur while the program runs.
- Everything that can be thrown is a `Throwable`, which is a child of `Object`. `Throwable` splits into:
    - `Exception` (things my code can handle), which splits again into **checked** (verified at compile time) and **unchecked** (only show up while the program is running).
    - `Error` (serious JVM-level problems, normally not handled).
- `try { ... }` holds what I want to do. `catch (Exception e) { ... }` receives whatever exception comes and lets me show or handle it. `finally { ... }` always runs.
- `throw` actually throws an exception. `throws` *declares* that a method may throw one.
- Multiple `catch` blocks are allowed, but the **more specific exception must come first**, then the general `Exception`.

## Top interview questions (rapid-fire)

1. What is the difference between `Error` and `Exception`?
2. Checked vs unchecked exceptions: examples of each?
3. `throw` vs `throws`?
4. Does `finally` always run?
5. How do you create a custom exception, and when should it be checked vs unchecked?

Detailed answers are in the two folder READMEs.

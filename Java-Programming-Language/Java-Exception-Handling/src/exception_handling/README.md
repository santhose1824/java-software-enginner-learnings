# `exception_handling`: try, catch, finally, throw, throws

## Files

| File | Purpose |
|------|---------|
| `Main.java` | Divides two numbers. A helper method explicitly throws `ArithmeticException` when the divisor is `0`; `main` catches it and prints the message. `finally` prints "Always run". |

## What I learned

- **Why handle exceptions?** Without handling, `8 / 0` would crash the program. With `try/catch` the program keeps running and I decide what to do.
- **`try`**: the code I want to run. **`catch (Exception e)`**: receives whatever exception arrives; I can print `e.getMessage()` or handle it. **`finally`**: runs whether or not an exception happened.
- **`throw`** creates and throws an exception object right now:
  `throw new ArithmeticException("Please don't divide by 0");`
- **`throws`** is part of the method signature and *declares* that the method may throw that exception:
  `static int divide(int a, int b) throws ArithmeticException`
- **Hierarchy** (from my notes): `Object -> Throwable -> { Exception, Error }`, and `Exception -> { Checked, Unchecked }`.
    - *Checked*: compiler forces me to handle or declare them.
    - *Unchecked*: only detected while the program is running.
- **Multiple catch blocks** are allowed, but put the stricter (more specific) exception first and the general `Exception` last.

### Expected output of `Main`

```
Please don't divide by 0
Always run
```

## Things to be careful about

- `ArithmeticException` is **unchecked**, so the `throws ArithmeticException` in the signature is optional. It is there for documentation. For a checked exception (e.g. `IOException`) it would be mandatory.
- Catching plain `Exception` is fine for learning, but in real code catch the most specific type so you don't hide unrelated bugs.
- Printing only `e.getMessage()` loses the stack trace. Use `e.printStackTrace()` or a logger when debugging.
- `finally` is skipped only if the JVM stops (`System.exit()`, crash, power loss) or the thread is killed. A `return` inside `try` still runs `finally` first (I verified this).
- Don't put `return` inside `finally`; it silently overrides the value returned (or the exception thrown) from `try`.

## Interview questions and answers

**1. What is an exception?**
An event that disrupts the normal flow of the program at runtime. In Java it is an object of a class that extends `Throwable`.

**2. Explain the exception hierarchy.**
`Object -> Throwable -> Exception` (checked + unchecked/`RuntimeException`) and `Throwable -> Error`.

**3. Difference between checked and unchecked exceptions?**
Checked exceptions (e.g. `IOException`, `SQLException`) are verified at compile time; you must catch or declare them. Unchecked exceptions are subclasses of `RuntimeException` (e.g. `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException`) and are not enforced by the compiler.

**4. Difference between `Error` and `Exception`?**
`Error` represents serious JVM/system problems (`OutOfMemoryError`, `StackOverflowError`) that an application normally can't recover from. `Exception` represents conditions the application can reasonably handle.

**5. `throw` vs `throws`?**
`throw` is a statement that throws one exception object. `throws` is a clause in the method signature that declares which exceptions the method might throw.

**6. Does `finally` always execute?**
Almost always: after normal completion, after a caught or uncaught exception, even after a `return` in `try`. Not when `System.exit()` is called or the JVM crashes.

**7. Can I have `try` without `catch`?**
Yes, if there is a `finally` (or it is try-with-resources). `try` alone is a compile error.

**8. In multiple catch blocks, what order is required?**
Child (specific) first, then parent. Putting `catch (Exception e)` before `catch (ArithmeticException e)` is a compile error because the second is unreachable.

**9. `final` vs `finally` vs `finalize`?**
`final` is a modifier (constants / no override / no inheritance). `finally` is a block that always runs after try/catch. `finalize()` was an `Object` method called by the garbage collector before reclaiming an object; it is deprecated and should not be used.

**10. What happens if an exception is not caught anywhere?**
It propagates up the call stack; if `main` doesn't handle it either, the thread terminates and the JVM prints the stack trace.

**11. `e.getMessage()` vs `e.printStackTrace()`?**
`getMessage()` returns only the message text; `printStackTrace()` prints the exception type, message and the full call stack.

**12. Should I catch `Exception` or a specific class?**
A specific class whenever possible, so that only the failures I expect are handled and unexpected bugs still surface.

**13. What is try-with-resources? (follow-up)**
`try (Scanner sc = new Scanner(System.in)) { ... }` automatically closes any `AutoCloseable` resource, so no manual `finally { sc.close(); }` is needed.

**14. Can an overriding method throw a broader checked exception? (follow-up)**
No. The overriding method may throw the same exception, a narrower one, or none, but not a broader checked exception.
# `user_defined_exceptions`: creating my own exception

## Files

| File | Purpose |
|------|---------|
| `UserDefinedException.java` | My custom exception: `class UserDefinedException extends Exception` that passes its message to `super(message)`. |
| `Main.java` | Reads input with `Scanner`. If the user types something that is **not an integer**, it throws `UserDefinedException("Please enter a number")`, otherwise it prints the number. `finally` closes the scanner. |

## What I learned

- To make a custom exception, **extend `Exception`** (or `RuntimeException`) and call `super(message)` in the constructor so `getMessage()` works.
- Because mine extends `Exception` (not `RuntimeException`), it is a **checked exception**: anything that throws it must either `catch` it or declare `throws`.
- I can throw it myself with `throw new UserDefinedException(message);` when my own validation fails. `Scanner.hasNextInt()` is used to check input *before* reading, so no `InputMismatchException` occurs.
- `finally` is the right place to release resources such as `sc.close()`.

### Sample runs

```
Input: 42      ->  Number is entered 42
Input: hello   ->  Please enter a number
```

## Things to be careful about

- The field `String message;` in `UserDefinedException` is **never used**; the message is stored by the parent `Exception` class via `super(message)`. It can be removed.
- Add a `serialVersionUID` (IDE warning) because `Throwable` is `Serializable`.
- Closing `Scanner(System.in)` also closes the standard input stream. That is fine in a small program but a problem if input is needed later. Try-with-resources is the modern pattern for real resources (files, sockets).
- Choose checked vs unchecked deliberately: checked for conditions the caller can reasonably recover from, unchecked (`extends RuntimeException`) for programming errors or when forcing `throws` everywhere would be noise.

## Interview questions and answers

**1. How do you create a custom exception?**
Create a class that extends `Exception` (checked) or `RuntimeException` (unchecked), and provide constructors that call `super(message)` and optionally `super(message, cause)`.

**2. Why create a custom exception at all?**
To give a meaningful, domain-specific name to a failure (`InsufficientBalanceException`), let callers catch exactly that case, and carry extra data (error code, field name).

**3. Checked vs unchecked custom exception: which should I choose?**
Checked if the caller is expected to recover (retry, ask the user again). Unchecked for programming errors or unrecoverable conditions. Many modern frameworks (e.g. Spring) prefer unchecked.

**4. What is the role of `throw` and `throws` here?**
`throw new UserDefinedException(...)` raises it. If the method that throws it does not catch it, its signature must declare `throws UserDefinedException`.

**5. What is exception chaining?**
Passing the original exception as the *cause* to the new one: `throw new UserDefinedException("msg", e);` so the root cause is preserved in the stack trace (`getCause()`).

**6. What does `super(message)` do in the constructor?**
It calls `Exception(String message)`, which stores the text so `getMessage()` and the stack trace can show it.

**7. Can a `finally` block change the result?**
Yes, and that is why it should stay simple: an exception thrown from `finally` hides the one from `try`/`catch`.

**8. What happens if I forget to handle a checked custom exception?**
Compile error: "unreported exception ... must be caught or declared to be thrown".

**9. How would you validate numeric input without exceptions?**
Exactly what `Main` does: check `sc.hasNextInt()` first. Exceptions are for exceptional situations, not ordinary control flow.

**10. Is it OK to catch `Exception` and swallow it silently?**
No. At minimum log it; swallowing hides bugs.
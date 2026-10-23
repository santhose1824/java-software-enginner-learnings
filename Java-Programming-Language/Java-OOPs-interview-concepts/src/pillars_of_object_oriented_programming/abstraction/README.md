# `abstraction`: abstract classes

## Files

| File | Purpose |
|------|---------|
| `Parent.java` | `abstract class Parent`: has a constructor, two abstract methods (`career`, `partner`), a `static` method and a normal method. |
| `Son.java`, `Daughter.java` | Concrete subclasses that **must override** both abstract methods; they call `super(age)`. |
| `Main.java` | Calls methods on `Son` / `Daughter`, calls `Parent.staticMethod()`, and uses `Parent parent = new Son(24);` (runtime polymorphism). |

## What I learned

- **Abstraction**: the process of **hiding implementation details and showing only the essential features** of an object. The user calls `career(...)` without caring how it is implemented.
- Any class that has **one or more abstract methods must be declared `abstract`**:

  ```java
  abstract class ClassName {
      abstract returnType methodName(parameters);   // abstract method: no body
  }
  ```
- Use it when you **know the method will be overridden in subclasses**, so you only declare it in the parent.
- Q&A from my notes:
  1. Constructor in an abstract class? **Yes.** (called through `super(...)` by the child)
  2. Create an object of an abstract class? **No**, not directly.
  3. Abstract constructors? **No.**
  4. Abstract static methods? **No**: static can't be overridden but abstract must be.
  5. Static methods in an abstract class? **Yes.**
  6. Normal (concrete) methods? **Yes.**
  7. `final` abstract class? **No.** (`final` forbids inheritance; abstract requires it.)
  8. `final` and `static` properties/variables? **Yes.**
- Even though I can't create a `Parent` object, I can write `Parent parent = new Son(24);` and `parent.career(...)` runs **Son's** version (runtime polymorphism decides by object type).
- Abstract classes **don't support multiple inheritance** (a class can extend only one class); use interfaces for that (see `../../interfaces`).

## Things to be careful about

- A subclass that doesn't implement **all** abstract methods must itself be declared `abstract`.
- Abstract methods can't be `private`, `static` or `final` either (they must be overridable).
- Constructors of abstract classes are still needed to initialise the parent's fields (here `age`). `Son` and `Daughter` each declare another `int age`, which **hides** the parent's `age`. The value set via `super(age)` goes to `Parent.age`, while `Son.age` stays `0`. Remove the duplicate field unless hiding is intended.
- The text printed in `Son.partner` says "she" for a son's partner and in `Daughter` "he"; just sample text.
- Abstract class can have **state** (fields) and constructors, unlike an interface.

## Interview questions and answers

**1. What is abstraction? How is it achieved in Java?**
Hiding implementation and exposing only essential behaviour. Achieved through abstract classes (0-100% abstraction) and interfaces.

**2. What is an abstract class? Can it have a constructor?**
A class declared `abstract` that can't be instantiated and may contain abstract and concrete members. Yes, it can have constructors, called via `super` from subclasses.

**3. Can we instantiate an abstract class?**
No directly. We can create a subclass object and reference it with the abstract type (`Parent p = new Son()`), or use an anonymous subclass.

**4. Can an abstract class have no abstract methods?**
Yes (to prevent instantiation or provide a base).

**5. Can abstract methods be static, final or private?**
No. Each conflicts with the need to override.

**6. Can an abstract class be final?**
No.

**7. Abstract class vs interface?**

| | Abstract class | Interface |
|--|----------------|-----------|
| Methods | Abstract + concrete | Abstract, plus `default`/`static`/`private` (Java 8/9+) |
| Fields | Any kind | Only `public static final` constants |
| Constructors | Yes | No |
| Inheritance | `extends` one class | `implements` many |
| Use when | Related classes share state/code | Unrelated classes share a capability |

**8. When would you choose an abstract class?**
When subclasses share common state and implementation and you want to force them to provide specific behaviour.

**9. Does an abstract class support multiple inheritance?**
No, a class can extend only one class.

**10. What if a subclass doesn't override all abstract methods?**
Compile error unless the subclass is also abstract.

**11. Can an abstract class implement an interface without defining its methods?**
Yes; the remaining methods must be implemented by the first concrete subclass.

**12. Which method runs for `Parent parent = new Son(24); parent.career()`?**
`Son.career()` due to dynamic method dispatch.

**13. Abstraction vs encapsulation?**
See the `encapsulation` README: abstraction hides complexity at design level, encapsulation hides data at implementation level.

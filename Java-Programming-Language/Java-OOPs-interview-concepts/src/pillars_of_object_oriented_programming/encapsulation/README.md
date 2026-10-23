# `encapsulation`: access modifiers and getters/setters

## Files

| Folder | Classes | Shows |
|--------|---------|-------|
| `access_modifiers` | `AccessModifiers`, `Main` | A field of each access level (`private`, default, `protected`, `public`); getter/setter for the private `num`. |
| `student_grade_using_encapsulation` | `StudentData`, `StudentMarks`, `Main` | `StudentData` has `protected` fields with public getters/setters. `StudentMarks extends StudentData`, keeps marks and a `private grading()` method, and overrides `toString()` to print name, email, marks and grade. |

## What I learned

- **Encapsulation**: wrapping data and methods into a **single unit** (usually a class) and **restricting direct access** to the data from outside the class.
  1. Data members are hidden with the **`private`** access modifier.
  2. Access to data is provided through **getters and setters**.
  3. Improves **data security, maintainability and controlled access**.
- **Access modifiers** (4 types):

| Modifier | Class | Package | Subclass (same pkg) | Subclass (diff pkg) | World |
|----------|:-----:|:-------:|:-------------------:|:-------------------:|:-----:|
| `public` | yes | yes | yes | yes | yes |
| `protected` | yes | yes | yes | yes | no |
| default (no modifier) | yes | yes | yes | no | no |
| `private` | yes | no | no | no | no |

- In `student_grade_using_encapsulation`, the grade logic (`grading`) is **hidden inside the class**; callers only set values and print the result. The outside code never touches fields directly.
- Rules for overriding/implementing: the access modifier of an overridden method should be the **same or wider**.

## Encapsulation vs Abstraction (from my notes)

- Abstraction solves **design-level** issues; encapsulation solves **implementation-level** issues.
- Abstraction -> *gaining* information (showing only what is essential). Encapsulation -> *containing* information.
- Data hiding -> focused on data security. Encapsulation -> also hides the complexity of the system.

## Things to be careful about

- `private` means visible inside the **class** (my notes say "same file only"; a file can contain several classes, and private is per-class, with nested classes sharing access with their outer class).
- `StudentMarks` is declared **without `public`** (package-private) and its `marks` field is default. That compiles since `Main` is in the same package, but a class in another package couldn't use it. The comment above `grading` says "protected" but the code is `private`.
- Getters/setters alone don't give real encapsulation if a setter accepts invalid values. Validate inside setters (e.g. reject marks above 100 or below 0).
- Returning a reference to a mutable field (like an array) from a getter leaks internal state; return a copy.
- Protected fields in `StudentData` let subclasses read them directly; the code still uses getters, which is the safer style.

## Interview questions and answers

**1. What is encapsulation?**
Binding data and the methods that operate on it into one unit and restricting direct access to the data using access modifiers.

**2. How do you achieve it in Java?**
Declare fields `private` and expose controlled access with public getters/setters.

**3. Benefits?**
Data hiding/security, validation in one place, flexibility to change internals without affecting callers, easier maintenance and testing.

**4. Explain all four access modifiers.**
`private`: class only. default: same package. `protected`: same package + subclasses anywhere. `public`: everywhere.

**5. Difference between default and protected?**
Both allow the same package; `protected` also allows subclasses in other packages (through inheritance).

**6. Can a top-level class be private or protected?**
No, only `public` or default. Nested classes can use any.

**7. Encapsulation vs abstraction?**
Abstraction: hide *what is unnecessary* at design level (interfaces/abstract classes). Encapsulation: hide *how data is stored/accessed* at implementation level (private + getters/setters).

**8. Is a class with all private fields and no setters immutable?**
Close, but it needs also: `final` class, `final` fields, no mutator methods, and defensive copies of mutable fields (like `String` or `LocalDate`).

**9. Why use setters instead of public fields?**
To validate input, keep invariants, trigger side effects, and change representation later.

**10. What is a POJO / JavaBean?**
A class with private fields, a no-arg constructor and public getters/setters.

**11. Can a subclass access a `private` field of its parent?**
Not directly; only via the parent's public/protected methods.

**12. What does `protected` mean for objects in a different package?**
Access only through inheritance (a subclass using its own inherited member), not through a plain parent reference.

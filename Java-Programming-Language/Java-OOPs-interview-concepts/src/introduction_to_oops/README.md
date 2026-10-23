# `introduction_to_oops`: class, object, constructor, `this`, wrapper classes, `final`, GC

## Files

| File | Purpose |
|------|---------|
| `ClassAndObjects.java` | `StudentData` class (rollNumber, studentName), default values, `new`, reference variables, `this`, constructor overloading (no-arg, parameterised, copy, `this(...)` chaining), two references to one object. |
| `WrapperClasses.java` | `int` vs `Integer`, swap that doesn't work, `final` on references vs primitives, finalize + garbage collection loop (`FinalKeyword` class). |
| `WrapperClassMethods.java` | Runnable reference of every non-deprecated method of the 8 wrapper classes. |
| `WrapperClassREADME.md` | Existing README for the file above. |

## What I learned

### Class and object
- **Class**: a template / blueprint that combines a named group of properties and methods (example: `Car` has engine, price, seats; Tata, BMW, Benz are *objects* with different values).
- **Object**: an instance of a class; the *physical* form of a logical construct (a class is logical, an object occupies memory).
- An object has three essential properties: **state** (its values), **identity** (how it differs from another object) and **behaviour** (what its methods do).
- **Memory**: objects live in the **heap**; reference variables live in the **stack** (for local variables). `Student s;` only creates a reference (value `null`); `new Student()` allocates memory **at runtime** and returns the reference. Java can't manipulate addresses like C.
- Instance variables get **default values** if not assigned: `int` -> `0`, `String` (any object) -> `null`. Printing a reference prints something like `pkg.StudentData@53d8d10a`.
- Access members with the dot operator: `student.rollNumber`.

### Constructor
- A special method that runs when an object is created; it defines what happens at creation (no return type, same name as class).
- If I write no constructor, Java provides a **default (no-arg) constructor**. Once I write any constructor, the default is no longer added.
- **`this`** refers to the current object; needed when parameter names equal field names (`this.rollNumber = rollNumber`).
- **Constructor overloading**: no-arg, parameterised, and a **copy constructor** `StudentData(StudentData other)` that copies values from another object.
- **Constructor chaining**: `this(39, "default")` inside the no-arg constructor calls another constructor of the same class.
- **Reference copy**: `StudentData two = one;` makes two references to the *same* object, so a change through `two` is visible through `one`.

### Wrapper classes, `final`, GC
- **Wrapper classes** wrap a primitive inside an object: `Byte, Short, Integer, Long, Float, Double, Character, Boolean`. `int a = 10;` is a primitive, `Integer num = 10;` is an object with extra methods.
- Primitives aren't created with `new` because they aren't objects.
- **Swap doesn't work** in a method for either `int` or `Integer`.
- **`final`**: prevents modification. Convention: constants in CAPITAL letters; a `final` variable must be initialised. For objects, `final` stops me from **re-pointing the reference** but I can still change the object's fields (`finalKeyword.name = "..."` is allowed; `finalKeyword = other` is not).
- **Garbage collection**: when no reference points to a heap object, the GC reclaims it automatically. Java lets me define what happens at that moment with `finalize()`.

## Things to be careful about (corrections to my notes)

- **Why swap fails**: because Java is **pass-by-value** (the method gets copies of the values / references). It is *not* because `Integer` is final. `Integer` is also immutable, but pass-by-value alone already explains it. Even `swap(Integer, Integer)` can't change the caller's variables.
- "Primitives are stored in the stack": true for **local** primitives. A primitive **field** of an object lives inside the object on the heap.
- `finalize()` is **deprecated** (Java 9) and marked for removal in later versions. Don't rely on it; use `try-with-resources` / `Cleaner`. There is also no guarantee when (or if) it runs. Your 1-billion-iteration loop is a way to force GC to run, but the output isn't guaranteed.
- In `FinalKeyword`, `final int FINAL_VARIABLE = 10;` is an *instance* field, so every object carries its own copy. For a true constant shared by all objects use `static final`.
- `Integer` caches values from -128 to 127: `Integer a=127,b=127; a==b` is `true`, but for `128` it is `false` (I verified). Always compare wrappers with `equals()`.

## Interview questions and answers

**1. What is OOP? Advantages?**
Programming based on objects containing data and behaviour. Advantages: reusability, maintainability, scalability, easier to understand.

**2. Class vs object?**
Class = blueprint/template (logical). Object = instance of the class, occupying memory in the heap.

**3. What are the three characteristics of an object?**
State, identity, behaviour.

**4. What does `new` do?**
Dynamically allocates memory for the object on the heap at runtime, runs the constructor, and returns a reference.

**5. Where are objects and references stored?**
Objects in the heap; local reference variables in the stack frame of the method.

**6. What is the default value of an uninitialised instance variable?**
`0` / `0.0` / `false` / `'\u0000'` for primitives, `null` for references. (Local variables have **no** default and must be initialised.)

**7. What is a constructor? Can it be private? Can it be overloaded? Can it be inherited?**
A special method to initialise an object. Yes it can be private (used by singleton). Yes it can be overloaded. No, constructors are not inherited (but a subclass calls the parent's via `super`).

**8. What is the default constructor?**
The no-arg constructor the compiler adds only when the class declares no constructors.

**9. What is a copy constructor? Does Java have one built in?**
A constructor taking an object of the same class and copying its fields. Java has no automatic one (unlike C++); you write it.

**10. What does `this` mean? Difference between `this` and `this()`?**
`this` is the current object reference. `this(...)` calls another constructor of the same class and must be the **first statement**.

**11. What happens if two references point to the same object?**
Changes via either reference affect the one object.

**12. What are wrapper classes? Why needed?**
Object versions of primitives. Needed for generics/collections (`ArrayList<Integer>`), utility methods, and `null` values.

**13. What are autoboxing and unboxing?**
Automatic conversion between primitive and wrapper (`Integer x = 10;` and `int y = x;`). Unboxing a `null` wrapper throws `NullPointerException`.

**14. Is Java pass-by-value or pass-by-reference?**
Always pass-by-value. For objects the *reference* is copied, so you can modify the object it points to but not re-point the caller's variable.

**15. What does `final` do on a variable, method and class?**
Variable: assigned once. Method: can't be overridden. Class: can't be extended (e.g. `String`, `Integer`).

**16. If a reference is `final`, can the object change?**
Yes, its state can change; only re-assignment of the reference is blocked.

**17. What is garbage collection? Can we force it?**
Automatic reclamation of unreachable heap objects. `System.gc()` is only a hint.

**18. Why is `String` immutable? / `==` vs `equals` on Strings?** (common follow-up)
Immutability gives thread safety, string-pool sharing, security, and cached hash codes. `==` compares references, `equals` compares content.

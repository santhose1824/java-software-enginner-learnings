# `packages_static_non_static_singleton`: packages, `static`, inner classes, singleton

## Files

| Path | Purpose |
|------|---------|
| `Message.java` | Class with a `public static void message()` printing "Good evening". |
| `a/Greetings.java` | Package `...a`; uses `import static ...Message.message;` and calls `message()` directly. |
| `b/Greetings.java` | Another class **named `Greetings`** in package `...b`, showing that packages allow the same class name. |
| `staticExample/Human.java` | `static long population` incremented in the constructor: shared by all objects. |
| `staticExample/Main.java` | Creates two `Human`s, prints `Human.population`; shows static method vs non-static method access. |
| `staticExample/StaticBlockExample.java` | `static int a`, `static` block, order of static initialisation. |
| `staticExample/InnerClass.java` | `static class Test` nested in `InnerClass`; instantiating it from `main`. |
| `singleton/Example.java` | Singleton: private constructor, private static `instance`, `getInstance()`. |
| `singleton/Main.java` | Calls `getInstance()` three times and shows `instance1 == instance2` is `true`. |

## What I learned

### Packages
- A package is just a **container for classes**, like a folder, so files can be stored hierarchically. The first line of the file states where it lives: `package com.folder.path;`.
- Two classes with the same name can exist in different packages (`a.Greetings`, `b.Greetings`).
- Built-in packages (from my notes): `java.lang` (essentials like `System`, `String`, auto-imported), `java.io` (input/output, file handling), `java.util` (collections and utilities), `java.awt` (GUI), `java.net` (networking).
- `import static` lets me call a static method without the class name.

### `static`
- Properties **not related to an individual object** are static: common to all objects. Access them via the **class name** (`Human.population`), not through an object.
- Both variables and methods can be static.
- Without `static`, each object gets its own `population` (value `1` for both). With `static`, there is one copy: after two objects it is `2`.
- **Why `public static void main`?** `main` must run without creating an object, so it's static.
- A static method can use only static data. Non-static things belong to an object; without an instance they can't be used. Inside static methods `this` can't be used. A non-static method **can** call static members (`greetings()` calls `greet()`).
- **Static initialisation**: when the class loads, static variables and static blocks run **once, in order**, not for every object.
- **Inner (nested) class**: a class inside another. The **outer class can't be static**; only the inner can. A non-static inner class depends on an outer-class object. Making `Test` static removes that dependency. Its own fields (`name`) are still per-object, so `Santhose` and `Someone` print separately.

### Singleton
- Allow creating an object **only once**: make the constructor `private`, keep a `private static` instance, and expose `public static getInstance()` that creates it only if `null`. No matter how many times it's called, all references point to the same object.

## Things to be careful about

- In notes: "static variables are compile time, memory allocated at run time". More accurately: statics are initialised when the **class is loaded/initialised** by the JVM (once), not at compile time.
- `Human.population` was `long` and is updated in the constructor: if objects are created from multiple threads the `+=` is **not thread-safe**.
- The singleton as written is **not thread-safe**: two threads can both see `instance == null`. Fixes: make `getInstance` `synchronized`, use double-checked locking with a `volatile` field, the initialisation-on-demand holder idiom, or an `enum` singleton. Reflection and serialization can also break a naive singleton.
- `InnerClass` prints from a **static** nested class. For a non-static inner class from `static main`, you'd write `new InnerClass().new Test("x")`.
- Calling a static member via an object (`obj.population`) compiles but is misleading, so use the class name.

## Interview questions and answers

**1. What is a package? Why use it?**
A namespace/folder for related classes. Avoids name clashes, organises code, and enables access control (default/protected).

**2. What is the default package access?**
Members with no modifier are visible only inside the same package.

**3. What does `static` mean?**
The member belongs to the class, not to any instance; one shared copy.

**4. Why is `main` static?**
So the JVM can call it without creating an object of the class.

**5. Can a static method access non-static members? Vice versa?**
Static -> non-static: only through an object. Non-static -> static: yes, directly.

**6. Can we override static methods?**
No; they are hidden (method hiding), not overridden, because binding is by class at compile time.

**7. Can we use `this` / `super` in a static method?**
No; there is no current instance.

**8. What is a static block? When does it run?**
Code in `static { }` that runs once when the class is first loaded/initialised, before `main` and before any object. Used to initialise static variables.

**9. Order of initialisation?**
Static variables and static blocks (in textual order) -> instance variables and instance blocks -> constructor.

**10. Can a top-level class be static?**
No. Only nested classes can.

**11. Static nested class vs inner (non-static) class?**
Static nested: independent of outer instance, can't access outer instance members directly. Inner: tied to an outer instance and can access its members.

**12. What is a singleton and how do you implement it?**
A class with exactly one instance: private constructor, static instance field, public static accessor. Thread-safe variants: synchronized, double-checked locking with `volatile`, Bill Pugh holder, or enum.

**13. Where is the singleton pattern used?**
Loggers, configuration, connection pools, caches.

**14. How can a singleton be broken?**
Reflection (calling the private constructor), serialization/deserialization, cloning, multiple class loaders. Enum singletons resist most of these.

**15. Can we have two classes with the same name?**
Yes if they are in different packages.

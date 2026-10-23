# `inheritance`: single, multilevel, hierarchical (+ `super`)

## Files

| Folder | Classes | Shows |
|--------|---------|-------|
| `single_inheritance` | `Species` -> `Human` | One class extends another; constructors, `super(...)`, copy constructor, reference type vs object type |
| `multilevel_inheritance` | `Species` -> `Human` -> `Man` | A derived class becomes the parent of another class |
| `hirarechal_inheritance` | `Human` -> `Female`, `Male` | One parent, many children (same rules as single inheritance) |

## What I learned

- **Inheritance**: a class that can use the properties and methods of another class, using the `extends` keyword. The child (derived) class can have **additional** properties/methods.
- When I access `child.length`, Java first looks in the child class; if it isn't there it looks in the **parent**, and returns it from there.
- **Constructors and `super`**: to set parent properties through a child object, the child constructor calls the parent constructor with **`super(...)`**:

  ```java
  Human(int eyes, int hands, int legs, int age, String actions) {
      super(eyes, hands, legs, age);   // parent's constructor
      this.actions = actions;
  }
  ```
  `super()` calls the constructor of the **directly above** parent class. At the top of the chain the parent is `Object`.
- **Two uses of `super`**: (1) call the parent constructor; (2) access parent properties/methods (like `this`, but specifically the parent's, which matters when parent and child have the same member name).
- **Reference type decides what you can access**: `Species s = new Human(...)` can access only `Species` members, so `s.actions` is a compile error, although the object is a `Human`. The object type decides which *constructor/object* is created.
- `Human h = new Species(...)` is an **error**: a parent object can't be assigned to a child reference.
- **Private** members of the parent aren't accessible in the child.
- A **copy constructor** `Species(Species other)` copies values from another object.
- **Types of inheritance** (from notes):
  1. Single: one class extends another.
  2. Multilevel: `Species -> Human -> Man`.
  3. Multiple: a class derives from more than one parent: **not supported for classes in Java** (diamond problem: if `A.n = 5` and `B.n = 10`, which one is `C.n`?). Use **interfaces** instead.
  4. Hierarchical: one class inherited by two or more classes (`Human -> Female`, `Male`).
  5. Hybrid: combination of single and multiple; not available with classes either, achievable with interfaces.

## Things to be careful about

- If the parent has **no no-arg constructor**, every child constructor must explicitly call `super(args)` (otherwise compile error). In the code the parents have no-arg constructors, so `super()` is inserted implicitly.
- `this(...)` or `super(...)` must be the **first statement** in a constructor, and you can't use both in one constructor.
- Constructors are **not inherited**.
- In `multilevel_inheritance/Main.java`, `Human man2 = new Man(...)` can't access `man2.name` (commented out in code) for the same reference-type reason.
- A child field with the same name as a parent field **hides** it (field hiding); fields are resolved by reference type, methods by object type.
- Prefer composition over inheritance when the relation is "has-a", not "is-a".

## Interview questions and answers

**1. What is inheritance and why use it?**
Mechanism by which a class acquires fields and methods of another via `extends`. Gives code reuse and an "is-a" hierarchy that enables polymorphism.

**2. Which types of inheritance does Java support with classes?**
Single, multilevel, hierarchical. Multiple and hybrid only through interfaces.

**3. Why doesn't Java support multiple inheritance of classes?**
The diamond problem: ambiguity when two parents define the same member (`n=5` vs `n=10`, or same method), plus complexity in constructors/state. Interfaces avoid state ambiguity.

**4. What is `super`? List its uses.**
Reference to the parent: `super(...)` calls the parent constructor; `super.field` / `super.method()` access parent members.

**5. What is the order of constructor calls?**
Parent constructor first, then child (top of the chain, `Object`, runs first).

**6. What happens if the parent doesn't have a default constructor?**
The child must call a parent constructor explicitly with `super(args)` or compilation fails.

**7. Can a child access private members of the parent?**
Not directly. Use protected/public members or getters/setters.

**8. Is `Species s = new Human()` valid? What can `s` access?**
Valid (upcasting). `s` can access only members declared in `Species`, but overridden methods run the `Human` version.

**9. Is `Human h = new Species()` valid?**
No, compile error without a cast, and a cast would fail at runtime (`ClassCastException`).

**10. Can a constructor call another constructor?**
Yes: `this(...)` within the same class, `super(...)` for the parent; must be the first statement.

**11. Are constructors, static methods or private methods inherited?**
Constructors: no. Private: no. Static: inherited by access but can only be *hidden*, not overridden.

**12. What is the root of all classes?**
`java.lang.Object`.

**13. Inheritance vs composition?**
Inheritance = "is-a", tight coupling. Composition = "has-a", more flexible; prefer it unless there is a true is-a relationship.

**14. Can a class extend itself or a final class?**
No to both: cyclic inheritance isn't allowed and `final` classes can't be extended.

**15. How can you prevent a class from being inherited or a method from being overridden?**
`final` class / `final` method (also `private`/`static` methods can't be overridden).

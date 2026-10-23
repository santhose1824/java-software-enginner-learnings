# `polymorphism`: overloading and overriding

## Files

| Folder | Classes | Shows |
|--------|---------|-------|
| `complie_time_or_static_polymorphism_or_method_overloading` | `Numbers` | Two `sum` methods with different parameters; `toString()` overridden. |
| `run_time_or_dynamic_polymorphism_method_overriding` | `Shapes` -> `Circle`, `Square`, `Triangle`; `Main` | Each child overrides `area()`; `Shapes shape1 = new Square(); shape1.area();` prints the **Square** version. |

## What I learned

- **Polymorphism**: *poly* = many, *morphism* = ways to represent. A **single entity behaves differently in different situations**. (A language without polymorphism/inheritance is only "object-based", not object-oriented.) It occurs with inheritance: `Shapes.area()` acts differently for `Triangle`, `Square` and `Circle`.

### 1) Compile-time (static) polymorphism = method overloading (early binding)
- A class has **multiple methods with the same name but different parameters**. Constructors can be overloaded too (`new A()` vs `new A(10, 20)`).
- It is *compile time* because Java decides **which method/constructor to call at compile time**.
- Example: `sum(int, int)` and `sum(int, int, int)` in `Numbers`.

### 2) Run-time (dynamic) polymorphism = method overriding (late binding)
- A child class has the same method as the parent with **same name and parameters; only the body differs**. Mark with the `@Override` annotation.
- Whatever the **reference type** (`Shapes`), the method that runs is decided by the **object type** (`new Square()`), so `shape1.area()` prints the area of the square.
- Properties/fields are still accessed based on the **reference type**; only *which method to run* is decided by the object type.
- **How Java knows which to run: dynamic method dispatch**, a mechanism by which a call to an overridden method is resolved at **runtime** instead of compile time.
- **`final`** methods can't be overridden; a `final` class can't be inherited (all its methods are implicitly final).
- **Static methods can't be overridden**: they are inherited, but they don't depend on an object, while overriding does. Inherit yes, override no.

## Things to be careful about

- A note says that `Shapes shape = new Square();` prints the Square area "due to method overloading". It's **method overriding** (run-time polymorphism), not overloading.
- Overloading needs a **different parameter list** (number, types or order). **Return type alone** does not distinguish overloads (compile error).
- Overriding rules: same signature; return type same or *covariant* (a subtype); access level **not more restrictive**; can't throw broader checked exceptions; `private`, `static`, `final` methods can't be overridden.
- In the repo the `area()` methods are package-private (no modifier); this works because all classes are in the same package. In an interface-based design they'd be `public`.
- Fields are **not** polymorphic: with `Parent p = new Child()`, `p.field` reads the parent's field.

## Interview questions and answers

**1. What is polymorphism? Types?**
Ability of one entity to take many forms. Compile-time (overloading) and run-time (overriding).

**2. Overloading vs overriding?**

| | Overloading | Overriding |
|--|-------------|-----------|
| Where | Same class (or subclass) | Parent-child |
| Signature | Different parameters | Same parameters |
| Binding | Compile time (static/early) | Run time (dynamic/late) |
| Return type | May differ, but can't be the only difference | Same or covariant |
| Static/private/final | Can be overloaded | Cannot be overridden |

**3. What is dynamic method dispatch?**
Resolving a call to an overridden method at runtime based on the actual object type, not the reference type.

**4. `Shapes s = new Circle(); s.area();` which `area` runs? Why?**
`Circle.area()`, because the object is a `Circle` and the method is overridden.

**5. Can we override static methods? Private methods?**
No. Static methods are hidden, not overridden; private methods aren't visible to subclasses.

**6. Can we overload `main`?**
Yes, but JVM starts only with `public static void main(String[] args)`.

**7. Can we overload by return type only?**
No: compile error.

**8. What is `@Override` for?**
Compile-time check that I'm really overriding a parent method (catches typos or signature mismatches).

**9. What is the difference between early and late binding?**
Early: method call linked at compile time (overloaded, static, private, final methods). Late: linked at runtime (overridden instance methods).

**10. What is covariant return type?**
An overriding method may return a subtype of the parent method's return type.

**11. What is upcasting and downcasting?**
Upcasting: child reference -> parent type (`Shapes s = new Circle()`), implicit. Downcasting: parent -> child (`(Circle) s`), explicit, may throw `ClassCastException`; check with `instanceof`.

**12. Does polymorphism apply to variables?**
No, only to instance methods. Field access depends on the reference type.

**13. Can constructors be overridden or overloaded?**
Overloaded yes, overridden no.

**14. Is `toString()` in `Numbers` overloading or overriding?**
Overriding the method inherited from `Object`.

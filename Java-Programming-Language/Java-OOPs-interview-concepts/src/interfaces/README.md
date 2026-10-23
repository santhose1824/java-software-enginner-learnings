# `interfaces`: contracts, multiple inheritance, default/static methods, nested interfaces

## Files

| Folder | Files | Shows |
|--------|-------|-------|
| `interrface_example` | `Engine`, `Brakes`, `MediaPlayer`, `Car`, `MusicSystem`, `Main` | `Car implements Engine, Brakes` (multiple inheritance of type); interface constant `price`; interface-typed reference `MediaPlayer mp = new MusicSystem()`. |
| `different_class` | `Area`, `Circle`, `Square`, `Shapes`, `Main` | Two **unrelated** classes implementing the same interface. |
| `extends_interface` | `A`, `B`, `Main` | `interface B extends A`; `default` method in B; `static` method in A; implementing class must define everything. |
| `nested_interfaces` | `NestedInterfaceExample`, `Main` | A `protected interface` declared inside a class and implemented via `Outer.Inner`. |

(`interrface_example` is spelled this way in the folder name.)

## What I learned

- **Interface**: a **contract** that specifies the behaviour implementing classes are expected to provide. It's mainly used to achieve **abstraction** and to allow a class to implement multiple interfaces, which gives **multiple inheritance in Java** (and hybrid inheritance).
- Properties from my notes:
  1. Contains only abstract methods and they are public.
  2. Variables are **`public static final`** by default (`int price = 7800;` in `Engine`).
  3. **No objects** can be created for an interface.
  4. Use with the **`implements`** keyword.
  5. A class can implement **more than one** interface.
  6. Members are always public. (An implementing method must be public too: the access modifier of an overridden method should be the same or wider.)
- **Why multiple interfaces?** Brakes, Engine and MediaPlayer differ for every car. One `Car` can implement all three, with its own behaviour: `class Car implements Engine, Brakes`.
- **Interface as a reference type**: `MediaPlayer m = new MusicSystem();` can access **only what is declared in the interface**. Two unrelated classes can share the same interface, which makes interfaces more powerful than inheritance for that.
- **Interfaces can extend interfaces**: `interface B extends A`; a class implementing `B` must implement methods of both `B` and `A`.
- **Default methods** (Java 8+): give an interface method a body with the `default` keyword (`default void normalMethod() {...}`); implementing classes may override it.
- **Conflict rule from my notes**: when two interfaces have the same method, only one should supply the default; otherwise the class has to resolve it.
- **Static methods** in interfaces need a body and are called as `InterfaceName.method()` (`A.staticMethod()`).
- **Nested interface**: an interface inside a class, accessed as `ClassName.InterfaceName`. Unlike top-level interfaces (public or default only), a nested one can be `public`, `private` or `protected`.
- **Annotations** are really a special kind of interface (`@interface`).
- Performance remark from my notes: avoid interfaces in highly performance-optimised code because the call is resolved at runtime.

## Things to be careful about (corrections to my notes)

- My notes say "static methods can't be in interfaces". Actually they **can, since Java 8, if they have a body**; the code in `A.java` does exactly that. They are **not inherited** by implementing classes or sub-interfaces, so `obj.staticMethod()` doesn't work; use `A.staticMethod()`.
- "Contains only abstract methods": true before Java 8. Now also `default`, `static` and (Java 9) `private` methods.
- If a class implements two interfaces that both provide a **default method with the same signature**, the class **must override** it (and can pick one with `A.super.method()`). If only one has a default and the other abstract, the class must still implement it explicitly. That's the real rule behind the diamond problem for interfaces.
- `different_class/Main` calls `s.area()` twice and `Shapes` toggles between `Circle` and `Square`. It doesn't use the `Area` interface type directly; better demo: `Area a = new Circle(); a.area();`.
- A **protected nested interface** is accessible only within the package/subclasses, so `Main implements NestedInterfaceExample.NestedInterface` works only because it's in the same package.
- `Engine.price` is a constant; assigning to it gives a compile error.
- Cloning (`Cloneable`) and `Comparable` are interfaces you'll meet in `object_class` and Generics.

## Interview questions and answers

**1. What is an interface?**
A reference type that defines a contract (method signatures, constants) which implementing classes must fulfil.

**2. Can an interface have variables?**
Only constants: implicitly `public static final`.

**3. How does Java support multiple inheritance?**
Through interfaces: a class can `implement` many, and an interface can `extend` many interfaces.

**4. Why no multiple inheritance with classes, but allowed with interfaces?**
Classes carry state and implementation, which causes the diamond ambiguity. Interfaces historically had no state or implementation, so no ambiguity. With default methods the compiler forces the class to resolve conflicts.

**5. Abstract class vs interface? When to use which?**
See the table in `abstraction`. Interface for a capability shared by unrelated classes; abstract class for shared state/code among related classes.

**6. Can we create an object of an interface?**
No, but we can declare a reference of interface type and assign an implementing object (or an anonymous class / lambda).

**7. What are default methods? Why were they added?**
Methods with a body in an interface (Java 8) so interfaces can evolve without breaking existing implementations (e.g. `forEach` in `Iterable`).

**8. Can interfaces have static methods? Can they be overridden?**
Yes (Java 8) with a body; they're called via the interface name and aren't inherited or overridden.

**9. What if two interfaces have the same default method?**
Compile error until the class overrides it; inside you can call `InterfaceName.super.method()`.

**10. Can an interface extend a class? Another interface?**
Not a class. It can extend one or more interfaces.

**11. What is a marker interface?**
An empty interface that tags a class (`Cloneable`, `Serializable`).

**12. What is a functional interface?**
An interface with exactly one abstract method; usable with lambdas (see Generics -> `lambda_functions`).

**13. What access do interface methods have?**
`public` (implicitly). Implementations must be declared `public`.

**14. What is a nested interface?**
An interface declared inside a class or another interface; can have any access modifier when inside a class.

**15. Can an interface have a constructor? A `private` method?**
No constructor. Private methods are allowed since Java 9 (to share code between default methods).

**16. Can I use an interface-type reference to call a class-specific method?**
No, only methods declared in the interface (cast if needed).

**17. How many interfaces can a class implement?**
Any number, separated by commas.

# Java OOPs Interview Concepts

My learning repo for Object Oriented Programming in Java, built from handwritten interview notes plus runnable code for every concept.

## Project structure

```
Java-OOPs-interview-concepts/
└── src/
    ├── introduction_to_oops/                  -> class, object, constructor, this, wrapper classes, final, GC
    ├── packages_static_non_static_singleton/  -> packages, static, static block, inner class, singleton
    ├── pillars_of_object_oriented_programming/
    │   ├── inheritance/                       -> single, multilevel, hierarchical, super
    │   ├── polymorphism/                      -> overloading (compile time), overriding (run time)
    │   ├── encapsulation/                     -> access modifiers, getters/setters
    │   └── abstraction/                       -> abstract classes
    ├── interfaces/                            -> interface basics, extends, default/static, nested
    └── object_class/                          -> Object methods, equals/hashCode, clone (shallow/deep)
```

| Folder | README |
|--------|--------|
| `introduction_to_oops` | [README](src/introduction_to_oops/README.md) (also see the existing `WrapperClassREADME.md`) |
| `packages_static_non_static_singleton` | [README](src/packages_static_non_static_singleton/README.md) |
| `pillars_of_object_oriented_programming/inheritance` | [README](src/pillars_of_object_oriented_programming/inheritance/README.md) |
| `pillars_of_object_oriented_programming/polymorphism` | [README](src/pillars_of_object_oriented_programming/polymorphism/README.md) |
| `pillars_of_object_oriented_programming/encapsulation` | [README](src/pillars_of_object_oriented_programming/encapsulation/README.md) |
| `pillars_of_object_oriented_programming/abstraction` | [README](src/pillars_of_object_oriented_programming/abstraction/README.md) |
| `interfaces` | [README](src/interfaces/README.md) |
| `object_class` | [README](src/object_class/README.md) |

## What is OOP? (from my notes)

A programming paradigm based on **objects that contain data and behaviour**, designed to closely represent real-world entities. It improves **code reusability**, enhances **maintainability and scalability**, and makes programs easier to understand and manage.

### The four pillars

| Pillar | One-line meaning | Where |
|--------|------------------|-------|
| **Inheritance** | A class uses the properties and methods of another class (`extends`) | `inheritance` |
| **Polymorphism** | One entity behaves differently in different situations (overload / override) | `polymorphism` |
| **Encapsulation** | Wrap data + methods in one unit and restrict direct access (private + getters/setters) | `encapsulation` |
| **Abstraction** | Hide implementation, show only essential features (abstract class / interface) | `abstraction`, `interfaces` |

## Core interview questions (rapid-fire)

1. What is OOP and what are its four pillars?
2. Class vs object? Where are they stored in memory?
3. What is a constructor? Overloading? Copy constructor?
4. `static` vs non-static; why is `main` static?
5. Abstract class vs interface; why no multiple inheritance with classes?
6. Overloading vs overriding; how does runtime dispatch work?
7. `==` vs `equals()`; the equals/hashCode contract.
8. Shallow vs deep copy.
9. How do you make a class a singleton?
10. Encapsulation vs abstraction.

Answers are in the folder READMEs.

## How to run (any example)

```bash
cd src
javac <package_path>/*.java
java <package_path>.Main        # e.g. javac interfaces/extends_interface/*.java && java interfaces.extends_interface.Main
```

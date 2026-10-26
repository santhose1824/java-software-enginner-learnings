# SOLID Design Principles

## What I learned
The set of **5 design principles** aimed at improving **maintainability, scalability and robustness** of object-oriented software is known as **SOLID**.

### 1. Single Responsibility Principle (S)
- Only **one reason to change**; a **single responsibility**.
- **Example:** a `Logger` class only contains log-print logic. If you want to delete logs, create a *separate* class, so a future change in logger logic only touches that one class.

### 2. Open/Closed Principle (O)
- **Open for extension, closed for modification.**
- **Example:** once an abstract class is written, we don't modify it unless there is an extreme condition, but we allow as many child classes as needed to extend it.

### 3. Liskov Substitution Principle (L)
- **Subtypes (subclass) should be substitutable for their base types (base class)** without affecting the correctness of the program.
- **Violation example:** `Bird` has `fly()`, extended by `Sparrow` and `Penguin`.
  ```java
  Bird sparrow = new Sparrow(); sparrow.fly();   // fine
  Bird penguin = new Penguin(); penguin.fly();   // penguin can't fly: breaks correctness
  ```

### 4. Interface Segregation Principle (I)
- A class should **not be forced to implement interfaces it doesn't use**.
- It's the first principle (SRP), applied to **interfaces**.

### 5. Dependency Inversion Principle (D)
- **High-level modules should not depend on low-level modules; both should depend on abstractions.**
- High-level -> interfaces / abstract classes; low-level -> implement/extend them.
- Similar to the 2nd principle (OCP).

## Summary table
| Principle | Purpose | Key Benefit |
|---|---|---|
| SRP | One responsibility per class | Improves maintainability |
| OCP | Extend behaviour without modifying code | Enhances scalability |
| LSP | Subclass behaves consistently | Avoids unexpected behaviour |
| ISP | Class only implements needed methods | Reduces implementation overhead |
| DIP | Depend on abstractions, not concretes | Decouples high- and low-level code |

## Fixing the Bird/Penguin problem
```java
interface Bird { void eat(); }
interface FlyingBird extends Bird { void fly(); }
class Sparrow implements FlyingBird { public void eat(){} public void fly(){} }
class Penguin implements Bird      { public void eat(){} }
```

## Interview Questions
1. Explain SOLID with an example for each.
2. Give a real example that violates LSP and how you fix it.
3. How does OCP relate to polymorphism / abstract classes?
4. SRP vs separation of concerns?
5. DIP vs Dependency Injection vs Inversion of Control?
6. How does ISP prevent "fat interfaces"?
7. Which SOLID principle does Spring's `@Autowired` interface injection support?

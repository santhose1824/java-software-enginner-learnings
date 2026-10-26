# Composition

## What my notes say
A class can **have another class within it and owns it** (**strong relationship**). The inner object's life depends on the outer object.

## Code sketch
```java
class Engine { }

class Car {
    private final Engine engine = new Engine();  // Car creates & owns Engine
}
// If Car is destroyed, its Engine goes with it.
```
Typical sign: the container **creates** the inner object itself.

## Interview Questions
1. What is composition? Why is it a strong relationship?
2. Composition vs inheritance: why "favour composition over inheritance"?
3. Composition vs aggregation with an example.
4. What happens to the contained object when the owner is garbage collected?
5. Is composition "Has-A" or "Is-A"?

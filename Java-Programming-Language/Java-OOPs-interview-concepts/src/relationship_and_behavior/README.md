# Relationship and Behavior

## What I learned
**What are relationships between classes?** They describe *how objects interact with each other*.

### Types of relationships
1. **Association**
2. **Aggregation**
3. **Composition**

Each answers: *How do objects interact with each other? How do they use each other?*

| Type | Strength | Short idea |
|---|---|---|
| Association | Loose | Two independent classes where one object uses/interacts with the other; both can exist independently |
| Aggregation | Weak | Class has another class inside it but **does not own** it |
| Composition | Strong | Class has another class inside it and **owns** it |

**Can a class have multiple relationships?** Yes.

## Sub-folders
- [`association/`](association/README.md)
- [`aggregation/`](aggregation/README.md)
- [`composition/`](composition/README.md)

## Interview Questions
1. What are the types of relationships between classes in Java?
2. Difference between aggregation and composition?
3. Difference between association and aggregation?
4. What is the lifecycle dependency in composition?
5. Can one class have more than one relationship with another? Give an example.
6. Which relationship would you model for Car-Engine? Car-Driver? Why?
7. How do relationships relate to "Has-A" vs "Is-A"?

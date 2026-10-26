# Aggregation

## What my notes say
A class can **have another class within it, but doesn't own it** (**weak relationship**). The contained object can live without the container.

## Code sketch
```java
class Student { String name; }

class Department {
    List<Student> students;   // Department has students but doesn't own them
    Department(List<Student> students) { this.students = students; }
}
// If Department is deleted, Student objects can still exist.
```
Typical sign: the object is **passed in from outside** (constructor/setter).

## Interview Questions
1. What is aggregation? Why is it called a weak relationship?
2. Give a real-life example of aggregation.
3. Aggregation vs composition?
4. How do you spot aggregation in code?
5. Is aggregation a "Has-A" relationship?

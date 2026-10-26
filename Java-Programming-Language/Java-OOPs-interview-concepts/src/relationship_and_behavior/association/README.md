# Association

## What my notes say
Association is a relationship between **two independent classes** where one object uses or interacts with the other. **Both can exist independently of each other.**

### 1. One-to-One
An instance of Class A is associated with **exactly one** instance of Class B.
**Example:** `Person` knows about their `Passport`, but the `Passport` object doesn't care who owns it.

### 2. One-to-Many
An instance of Class A is associated with **more than one** instance of Class B.
**Example:** `College` knows how many students it has and their details, but a `Student` object doesn't care who owns it.

### 3. Many-to-Many
One Class A has multiple instances of Class B, and the same Class B has multiple instances of Class A.
**Example:** `Course` <-> `Student`.

## Code sketch
```java
class Passport { String number; }
class Person   { Passport passport; }          // one-to-one

class Student  { String name; }
class College  { List<Student> students; }     // one-to-many

class Course   { List<Student> students; }     // many-to-many
class Learner  { List<Course> courses; }       // (both sides hold lists)
```

## Interview Questions
1. What is association? Is it unidirectional or bidirectional?
2. Explain one-to-one, one-to-many and many-to-many with examples.
3. How do you implement many-to-many in Java? In a database?
4. Association vs aggregation vs composition?
5. Does deleting one associated object delete the other? (No, they are independent.)

# 07 - Methods in Java

## What I learnt

### Syntax
```java
access_modifier return_type method_name(parameter1, parameter2, ...) {
    // Block of code
    return value;
}
```

### Call / use a method
```java
method_name();
method_name(argument1, argument2);
```

### Return type
When the method call is finished, the kind of data it needs to give back is the **return type**.
If you don't want to return anything, use **`void`** (`return;` can be used to end the method early).

### Examples
```java
static void sum() {
    int a = 10;
    int b = 20;
    int sum = a + b;
    System.out.println(sum);
}

static String name() {
    String name = "Santhosh";
    return "My name is " + name;
}

// With arguments
static void sum(int a, int b) { int sum = a + b; System.out.println(sum); }
static String name(String name) { return "My name is " + name; }
```

### How are values passed to methods?
- Java has **only pass by value**, **no pass by reference**.
- When we pass a value as an argument we only pass the value; changing the argument inside the method does **not** reflect in the `main` method.
1. **Primitives** are just passed by value.
2. **Objects & Strings** - the *value of the reference variable* is passed (so changing the object's content is visible, but re-pointing the reference is not).

### Variable Length Arguments (varargs)
- When we don't know how many arguments we need: `data_type... arg_name`
- `static void fun(int... v) { }`
- Internally stored in an **array**.
- Variable arguments must always be put **at the end**.

### Method Overloading
- Two methods with the **same name** but **different arguments** (different type or different number of arguments).
- `static fun(int a) {}` and `static fun(String name, int a) {}`
- The selection of which method to run is done at **compile time**.

(Scoping is in the next folder: `08-Scoping`.)

## Programs

| File | Shows |
|------|-------|
| `MethodsDemo.java` | void / return / parameters / early return |
| `PassByValueDemo.java` | primitives, arrays, Strings, StringBuilder passed to a method |
| `VarArgsDemo.java` | variable length arguments |
| `MethodOverloadingDemo.java` | overloading by count / type / order, widening in overload resolution |

## Interview Questions

1. **What is a method?**
   A named block of code that performs a task and can be reused.
2. **What is the difference between a parameter and an argument?**
   Parameter: variable in the method definition. Argument: actual value passed at call time.
3. **Is Java pass by value or pass by reference?**
   Always pass by value. For objects, the value of the reference is passed.
4. **If I change an array inside a method, does it change outside?**
   Element changes: yes (same object). Re-assigning the parameter to a new array: no.
5. **What is method overloading?**
   Same name, different parameter lists in the same class.
6. **Can we overload by changing only the return type?**
   No - compile error (ambiguous at call site).
7. **Is overloading compile-time or runtime polymorphism?**
   Compile time (static binding).
8. **What are varargs? Rules?**
   `type... name`; treated as an array; must be the last parameter; only one per method.
9. **Can `main` be overloaded?**
   Yes, but the JVM only starts from `public static void main(String[])`.
10. **What does `void` mean?**
    The method returns nothing.
11. **What does `static` mean on a method?**
    Belongs to the class - can be called without an object.
12. **If you call `fun('a')` and only `fun(int)` and `fun(double)` exist, which runs?**
    `fun(int)` - `char` widens to the closest type (`int`).
13. **What is the difference between `return` and `void`?**
    `return` gives control (and optionally a value) back to the caller; `void` says no value is returned.

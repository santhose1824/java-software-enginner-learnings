# 06 - Conditionals and Loops

`sout` in my notes = shortcut for `System.out.println();` (IDE template, e.g. IntelliJ/Eclipse).

## What I learnt

### 1. `if` statement
```java
if (condition) {
    // Block of code
}
// Example
if (age >= 18)
    System.out.println("Eligible");
```

### 2. `if - else` statement
```java
if (condition) {
    // Block of code
} else {
    // Block of code
}
```

### 3. `if - else if` statement
```java
if (marks > 90) {
    System.out.println("Grade A");
} else if (marks >= 80) {
    System.out.println("Grade B");
} else if (marks >= 60) {
    System.out.println("Grade C");
} else {
    System.out.println("Fail");
}
```

### 4. `switch` statement
**Syntax 1 (classic)**
```java
switch (condition) {
    case 1:
        // Block of code
        break;
    case 2:
        // Block of code
        break;
    default:
        // Block of code
}
```
**Syntax 2 (arrow, Java 14+)**
```java
switch (day) {
    case 1 -> System.out.println("Monday");
    case 2 -> System.out.println("Tuesday");
    default -> System.out.println("Not Valid");
}
```
- Without `break` in the classic form, execution **falls through** to the next case.
- `switch` can be used with `int`, `char`, `byte`, `short`, `String`, `enum` (not `long`, `float`, `double`, `boolean`).

### 5. `for` loop
```java
for (datatype variable; condition; increment) {
    // Block of code
}
// Example
for (int i = 0; i <= 5; i++) {
    System.out.println(i);
}
```
A `;` immediately after `for(...)` ends the loop with an empty body - the following block will **not** be the loop body.

### 6. `while` loop
```java
while (condition) {
    // Block of code
}
while (true) { System.out.println("Name"); }   // infinite loop
```

### 7. `do while` loop
```java
do {
    // Block of code
} while (condition);
```
Runs the body **at least once** because the condition is checked after.

## Programs

| File | Shows |
|------|-------|
| `IfStatements.java` | if, if-else, else-if ladder, nested if, ternary |
| `SwitchStatements.java` | classic switch, arrow switch, switch expression, fall-through, String switch |
| `LoopsDemo.java` | for, while, do-while, for-each, break, continue, nested & labelled loops |

## Interview Questions

1. **Difference between `if-else` and `switch`?**
   `if-else` handles any boolean condition/range; `switch` compares one value against constants and is cleaner for many fixed options.
2. **What happens if we forget `break` in a switch?**
   Fall-through - the following cases also execute until a `break` or the end.
3. **Which data types are allowed in a switch?**
   `byte, short, char, int`, their wrappers, `String`, and `enum`.
4. **Is `default` mandatory in a switch? Does it have to be last?**
   No and no (but it is a convention to put it last).
5. **Difference between `while` and `do-while`?**
   `while` checks the condition first; `do-while` runs the body once before checking.
6. **Difference between `for` and for-each?**
   For-each iterates over every element without an index; `for` gives full control over index and step.
7. **What is the difference between `break` and `continue`?**
   `break` exits the loop; `continue` skips the current iteration.
8. **How do you write an infinite loop?**
   `while(true){}` or `for(;;){}`.
9. **What is the ternary operator?**
   `condition ? valueIfTrue : valueIfFalse`, a short if-else expression.
10. **What is a labelled break?**
    `break label;` exits the outer loop marked with `label:` from inside a nested loop.
11. **Can the condition in `if` be an `int` like in C (`if(1)`)?**
    No. It must be `boolean` in Java.
12. **Output of `for(int i=0;i<3;i++);` followed by a print block?**
    The print runs once - the `;` is the empty loop body.

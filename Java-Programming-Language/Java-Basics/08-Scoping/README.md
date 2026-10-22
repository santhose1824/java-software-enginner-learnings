# 08 - Scoping and Shadowing

## What I learnt

**Scope = where we can access our variables.**

There are 3 types of scoping (inside a class there is also the class/"global" scope):

1. **Method scope**
2. **Block scope**
3. **Loop scope**

Order (outer -> inner): `Global (class) scope > Method scope > Block scope > Loop scope`

### Method scope
Variables created inside a method can **only be used inside** that method. Same goes for arguments (parameters).

### Block scope
- If you create a variable **outside** the block (in the same method) we **cannot create a new variable with the same name** inside the block - we can just use/modify it.
- If we create a variable **inside** the block we **cannot use it outside** the block.

### Loop scope
- We can create new variables inside the loop but we **can't use them outside**.
- We can use variables created outside the loop, but we can't re-initialise (re-declare) them.

### When does scope begin?
A variable's scope begins when it is **declared/initialised** - you cannot use it above the line where it is declared.

### Shadowing
If we create a variable outside of the method scope (class level) and then use a variable with the **same name within a scope that overlaps**, the inner one *shadows* (hides) the outer one.
Practice of using the same variable name in an overlapping scope = **shadowing**.

> Java does **not** allow shadowing a local variable by another local variable inside a nested block (compile error). It only allows a local (or parameter) to shadow a **field**.

## Programs

| File | Shows |
|------|-------|
| `ScopingDemo.java` | method / block / loop scope, scope start, shadowing with `ClassName.field` |

## Interview Questions

1. **What is variable scope?**
   The region of code where a variable is visible and usable.
2. **Types of variable scope in Java?**
   Class (static/instance fields), method (local), block, and loop scope.
3. **Can we use a variable declared inside a loop after the loop?**
   No - it goes out of scope at the closing brace.
4. **What is variable shadowing?**
   A local variable/parameter has the same name as a field, hiding the field inside that scope.
5. **How do you access the shadowed static variable?**
   `ClassName.variableName` (or `this.variableName` for instance fields).
6. **Can two local variables with the same name exist in nested blocks?**
   No. Java gives "variable already defined". (Sibling blocks are fine.)
7. **What is the default value of a local variable?**
   None - it must be initialised before use.
8. **Difference between local, instance and static variable?**
   Local: inside a method, stack. Instance: one per object, heap. Static: one per class, shared.
9. **Where does a variable's scope start?**
   From its declaration line to the end of the enclosing block.
10. **Is a method parameter local to the method?**
    Yes, same as a local variable.

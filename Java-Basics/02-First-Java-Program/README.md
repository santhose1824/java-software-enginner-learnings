# 02 - First Java Program

## What I learnt

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

1. Every `.java` file has a **class**. Without a class we cannot run a Java program.
2. Class name and file name should be the same. We *can* have different names, but if the class is `public`, the file name **must** match the class name.
3. By convention the first letter of a class name is capital (`Main`, `StudentDetails`).
4. The class is `public` (access modifier) - more in OOPs.
5. Inside the class we need a `main` method.
6. To print we use `System.out.println("Hello World");`

### Compile and run

```bash
javac Main.java       # compiles, creates Main.class
java Main             # runs the program
```

### What each keyword means

| Keyword | Meaning |
|---------|---------|
| `public` | Access modifier - the class/method can be accessed from anywhere. |
| `class` | Named group of properties (variables) and functions (methods). |
| `Main` | Class name. If class is `public`, file name and class name must be the same. |
| `main` | **Entry point** of the Java program. If there is no `main`, the program will not run. |
| `static` | Normally we need an object to access methods/variables of a class. `main` is the very first thing that runs, before any object exists, so it must be `static` (belongs to the class, not an object). |
| `void` | Return type - `main` returns nothing. |
| `String[] args` | Command line arguments - a String array. |

### Why is `main()` public?
It is the entry point, so the JVM (which is outside our class/package) must be able to access it from anywhere.

### Why is `main()` static?
To call a normal method we need an object. To create an object, the program must already be running. `main` is the entry point - nothing executes before it - so it is `static` so the JVM can call it without creating an object.

### Command line arguments

```bash
javac CommandLineArgs.java
java CommandLineArgs Santhosh 25
```
`args[0]` = "Santhosh", `args[1]` = "25"

### Packages and `javac -d`

- A **package** is a folder where your Java files live. It gives folder-level / package-level security (see access modifiers later).
- Format: `com.folder_name` (each part is a folder).
- To keep `.class` files separate from `.java` files: `javac -d <path-to-save-class-files> FileName.java`

### Understanding `System.out.println("")`

- `System` - a class in package `java.lang`
- `out` - a variable (object reference) of type `PrintStream`
- `println` - a method of the `PrintStream` class

`PrintStream` adds functionality to an output stream - the ability to print representations of various data values conveniently.

## Programs

| File | Shows |
|------|-------|
| `Main.java` | Hello World |
| `CommandLineArgs.java` | Using `String[] args` |
| `SystemOutDemo.java` | print / println / printf |

## Interview Questions

1. **Can we run a Java program without a `main` method?**
   Not as a normal application - the JVM looks for `public static void main(String[] args)` as the entry point. (Older Java versions allowed a `static {}` block trick; modern versions do not.)
2. **Why is `main` `public`?**
   So the JVM can call it from outside the class/package.
3. **Why is `main` `static`?**
   So the JVM can call it without creating an object of the class.
4. **Why is `main` `void`?**
   The JVM does not use a return value from `main`. (Use `System.exit(code)` to signal status.)
5. **What is `String[] args`?**
   An array of command-line arguments passed when running the program.
6. **Can we change `args` to another name?**
   Yes (`String[] a`), the type matters, not the name. `String... args` also works.
7. **Can we overload the `main` method?**
   Yes, but the JVM only calls `public static void main(String[] args)`.
8. **Can the file name differ from the class name?**
   Yes, if the class is not public. If the class is `public`, they must match.
9. **Difference between `javac` and `java`?**
   `javac` compiles `.java` to `.class`; `java` launches the JVM and runs the class.
10. **What is `System.out.println`?**
    `System` is a class, `out` is a static `PrintStream` object in it, `println` is a method of `PrintStream`.
11. **Difference between `print`, `println` and `printf`?**
    `print` - no newline, `println` - adds newline, `printf` - formatted output.
12. **What is a package?**
    A folder-like namespace that groups related classes and provides access protection.
13. **What does `javac -d` do?**
    Puts the generated `.class` files in the given directory.
14. **Which package is imported by default?**
    `java.lang`.

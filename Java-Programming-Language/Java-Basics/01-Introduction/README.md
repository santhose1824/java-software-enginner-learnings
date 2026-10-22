# 01 - Introduction

## What I learnt

### How Java code executes

```
.java file  --(javac compiler)-->  .class file (byte code)  --(JVM interpreter / JIT)-->  Machine code (0s and 1s)
(source code)                      (not human readable)
```

- Source code (`.java`) cannot run directly on a system.
- The **compiler (`javac`)** converts the whole file into **byte code** (`.class`).
- The **JVM** converts byte code into machine code for the OS/hardware it is running on.
- This is why Java is called **platform independent**.

### Platform independence

- Byte code can run on all operating systems that have a JVM.
- After compiling C/C++ we get an `.exe`, which is **platform dependent**.
- In Java we get byte code, and the JVM converts it to machine code.
- **Java is platform independent, but the JVM is platform dependent** (there is a different JVM for Windows, Linux, macOS).

### JDK vs JRE vs JVM vs JIT

```
+----------------------------------------------+
| JDK = JRE + Development tools                |
|  +----------------------------------------+  |
|  | JRE = JVM + Library classes            |  |
|  |  +----------------------------------+  |  |
|  |  | JVM (Java Virtual Machine)       |  |  |
|  |  |   +--------------------------+   |  |  |
|  |  |   | JIT (Just In Time)       |   |  |  |
|  |  |   +--------------------------+   |  |  |
|  |  +----------------------------------+  |  |
|  +----------------------------------------+  |
+----------------------------------------------+
```

**JDK (Java Development Kit)** - provides the environment to *develop and run* Java programs. It includes:
1. Development tools
2. JRE (to execute your program)
3. Compiler - `javac`
4. Archiver - `jar`
5. Docs generator - `javadoc`
6. Interpreter / loader - `java`

**JRE (Java Runtime Environment)** - installation package that provides the environment to *only run* a program. It consists of:
1. Deployment technologies
2. User interface toolkits
3. Integration libraries
4. Base libraries
5. JVM

**JVM (Java Virtual Machine)** - runs the byte code. Contains the stack and heap memory areas.

**JIT (Just-In-Time compiler)** - part of the JVM. Frequently repeated methods are compiled to native machine code once, so they do not need to be re-interpreted. This makes execution faster.

### What happens after we get the `.class` file (at runtime)

1. **Class loader** loads all classes needed to execute the program.
2. JVM sends the code to the **Byte code verifier** to check the format of the code.
3. **Interpreter** executes line by line (JIT optimises hot/repeated methods).
4. Runs on the hardware. The **Garbage Collector** cleans unused objects.

### How the JVM works - Class Loader phases

| Phase | What happens |
|-------|--------------|
| **Loading** | Reads the `.class` file and generates binary data. An object of the class (`Class` object) is created in heap memory. |
| **Linking** | *Verification*: JVM verifies the `.class` file. *Preparation*: allocates memory for class (static) variables. *Resolution*: replaces symbolic references with direct references. |
| **Initialization** | All static variables are assigned their values defined in the code and static blocks run. |

### Interpreter vs JIT

| Interpreter | JIT |
|-------------|-----|
| Line by line execution | Compiles repeated (hot) methods to machine code |
| A method called many times is interpreted again and again | No re-interpretation needed for hot methods |
| Slower | Makes execution faster |

> Note: Since Java 11 Oracle/OpenJDK no longer ships a separate JRE download - you install the JDK. The concept (JDK > JRE > JVM) is still asked in interviews.

## Interview Questions

1. **How does Java code execute?**
   Source code -> `javac` compiles to byte code (`.class`) -> JVM loads, verifies, and interprets/JIT-compiles it into machine code -> runs on hardware.
2. **Why is Java platform independent?**
   Because the compiler produces byte code, not machine code, and any OS with a JVM can run that byte code ("Write Once, Run Anywhere").
3. **Is Java platform independent? Is the JVM platform independent?**
   Java (byte code) is platform independent. The JVM is platform dependent - each OS has its own JVM implementation.
4. **Difference between JDK, JRE and JVM?**
   JVM runs byte code. JRE = JVM + libraries (run only). JDK = JRE + development tools like `javac`, `jar`, `javadoc` (develop and run).
5. **What is the JIT compiler?**
   A part of the JVM that compiles frequently executed byte code into native machine code at runtime to improve performance.
6. **Is Java compiled or interpreted?**
   Both. Compiled to byte code by `javac`, then interpreted / JIT-compiled by the JVM.
7. **What is byte code?**
   The intermediate, platform-neutral instruction set stored in `.class` files.
8. **What does the class loader do? Explain loading, linking and initialization.**
   See the table above.
9. **What is the byte code verifier?**
   It checks that the loaded byte code is valid and safe (does not break access rules or corrupt the stack) before execution.
10. **What is the garbage collector?**
    A JVM component that automatically frees heap memory of objects that are no longer referenced.
11. **Where are stack and heap memory used?**
    Stack: method calls, local variables and references. Heap: objects (including arrays and Strings).
12. **Which tool compiles / archives / generates docs?**
    `javac` / `jar` / `javadoc`.

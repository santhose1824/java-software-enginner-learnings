# Java Learning Journey

My personal notes, example programs and interview questions while learning Java from scratch.

Each topic folder contains:

- `README.md` - what I learnt + possible interview questions (with short answers)
- `*.java` - runnable example programs for that topic (where applicable)

## Topics

| # | Topic | Programs |
|---|-------|----------|
| 01 | [Introduction (JDK / JRE / JVM / JIT)](./01-Introduction) | - (concept only) |
| 02 | [First Java Program](./02-First-Java-Program) | Yes |
| 03 | [Taking Input (Scanner)](./03-Taking-Input-Scanner) | Yes |
| 04 | [Data Types](./04-Data-Types) | Yes |
| 05 | [Type Conversion and Type Casting](./05-Type-Conversion-and-Casting) | Yes |
| 06 | [Conditionals and Loops](./06-Conditionals-and-Loops) | Yes |
| 07 | [Methods](./07-Methods) | Yes |
| 08 | [Scoping and Shadowing](./08-Scoping) | Yes |
| 09 | [Arrays](./09-Arrays) | Yes |
| 10 | [ArrayList (every method)](./10-ArrayList) | Yes |
| 11 | [Strings (every common method)](./11-Strings) | Yes |
| 12 | [StringBuilder (every method)](./12-StringBuilder) | Yes |
| 13 | [StringBuffer (every method)](./13-StringBuffer) | Yes |

## How to run any program

Java 11+ can run a single file directly:

```bash
java FileName.java
```

Or the classic way:

```bash
javac FileName.java      # compile  -> creates FileName.class
java FileName            # run
```

Programs that take keyboard input (Scanner) will wait for you to type values.

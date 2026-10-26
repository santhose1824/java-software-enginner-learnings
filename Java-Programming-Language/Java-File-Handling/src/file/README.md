# File class

## What I learned
The `File` class (`java.io`) represents a file or directory **path**, not its contents. It is used to create, check, delete and inspect files; actual reading/writing is done with streams. *(Add your own notes for this folder.)*

## Example
```java
File f = new File("data.txt");
if (!f.exists()) f.createNewFile();
System.out.println(f.getName() + " " + f.length());
```

## Interview Questions
1. What does the `File` class represent?
2. Does creating a `File` object create a file on disk?
3. `File` vs `Path`/`Files` (NIO)?
4. How to list files in a directory?
5. How do you delete a file or check if it is a directory?

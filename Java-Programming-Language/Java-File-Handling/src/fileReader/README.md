# FileReader

## What I learned
`FileReader` is a **character stream** (a `Reader` subclass) for reading text files character by character. It reads Unicode characters rather than raw bytes.

## Example
```java
try (FileReader fr = new FileReader("data.txt")) {
    int ch;
    while ((ch = fr.read()) != -1) System.out.print((char) ch);
}
```

## Interview Questions
1. What does `FileReader` read: bytes or characters?
2. What does `read()` return at end of file?
3. `FileReader` vs `FileInputStream`?
4. Why wrap it in `BufferedReader`?
5. What exception does it throw if the file is missing?

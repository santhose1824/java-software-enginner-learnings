# BufferedWriter

## What I learned
`BufferedWriter` is a **Writer subclass** that buffers characters before writing, making writes efficient. It implements `Flushable`, `Appendable`, `Closeable`.

## Example
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"))) {
    bw.write("Hello");
    bw.newLine();
    bw.flush();
}
```

## Interview Questions
1. Why use `BufferedWriter`?
2. What does `flush()` do and when is it needed?
3. What does `newLine()` do and why use it?
4. How to append to an existing file? (`new FileWriter(path, true)`)
5. `BufferedWriter` vs `PrintWriter`?

# BufferedReader

## What I learned
`BufferedReader` is a **Reader subclass** that wraps another Reader to add buffering. It reads text efficiently and offers `readLine()`.

## Example
```java
try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
    String line;
    while ((line = br.readLine()) != null) System.out.println(line);
}
```

## Interview Questions
1. Why is `BufferedReader` faster than `FileReader` alone?
2. What does `readLine()` return at end of stream?
3. `BufferedReader` vs `Scanner`?
4. How do you read console input with `BufferedReader`? (`new BufferedReader(new InputStreamReader(System.in))`)
5. What is the default buffer size?

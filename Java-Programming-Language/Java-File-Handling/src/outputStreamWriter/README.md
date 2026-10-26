# OutputStreamWriter

## What I learned
`OutputStreamWriter` is a **bridge from character streams to byte streams**: it encodes characters into bytes using a charset and writes them to an `OutputStream`.

## Example
```java
try (OutputStreamWriter w = new OutputStreamWriter(new FileOutputStream("out.txt"), "UTF-8")) {
    w.write("Hello");
}
```

## Interview Questions
1. What is `OutputStreamWriter` used for?
2. How does it handle character encoding?
3. `OutputStreamWriter` vs `FileWriter`?
4. Why wrap it in `BufferedWriter`?
5. What happens if you forget to close or flush?

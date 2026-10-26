# InputStreamReader

## What I learned
`InputStreamReader` is a **bridge from byte streams to character streams**: it reads bytes from an `InputStream` and decodes them into characters using a charset. Used with `System.in` for keyboard input.

## Example
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String name = br.readLine();
```

## Interview Questions
1. What is `InputStreamReader` used for?
2. How does it relate to `System.in`?
3. How do you specify a charset?
4. Why is it called a bridge?
5. `InputStreamReader` vs `FileReader`?

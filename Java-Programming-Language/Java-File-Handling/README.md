# Java-File-Handling

My learning repository for Java File Handling and I/O Streams, built from my handwritten notes and practice code.

## Folder Structure
```
Java-File-Handling/
|-- src/
|   |-- bufferReader/
|   |-- bufferWriter/
|   |-- file/
|   |-- fileReader/
|   |-- inputStreamReader/
|   `-- outputStreamWriter/
|-- .gitignore
`-- Java-File-Handling.iml
```

## What I Learned

### Streams
To understand file handling, first understand **streams** in Java.
1. A stream is a **sequence of data**: byte values or characters (Unicode).
2. Java performs input and output via streams.
3. It is just an **abstraction** that Java provides.
4. Java implements streams within a **class hierarchy in the `java.io` package**.

### Two kinds of streams
| | Byte Stream | Character Stream |
|---|---|---|
| Reads | Binary data: files, PDFs, images, etc. | Unicode characters |
| Base classes (abstract) | `InputStream`, `OutputStream` | `Reader`, `Writer` |
| Common methods | `read()`, `write()` | `read()`, `write()` |

- Any class ending with `InputStream`/`OutputStream` is a **byte stream**.
- Any class ending with `Reader`/`Writer` is a **character stream**.

### Subclasses
| Base | Subclasses | Implements |
|---|---|---|
| InputStream | AudioInputStream, ByteArrayInputStream, FileInputStream, FilterInputStream, InputStream, ObjectInputStream, SequenceInputStream, StringBufferInputStream, PipedInputStream | Closeable, AutoCloseable |
| OutputStream | ByteArrayOutputStream, FileOutputStream, FilterOutputStream, ObjectOutputStream, OutputStream, PipedOutputStream | Closeable, Flushable, AutoCloseable |
| Reader | BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader | Closeable, AutoCloseable, Readable |
| Writer | BufferedWriter, CharArrayWriter, FilterWriter, OutputStreamWriter, PipedWriter, PrintWriter, StringWriter | Closeable, Flushable, Appendable, AutoCloseable |

### IOException
Subclasses: `EOFException`, `FileNotFoundException`, `UnsupportedEncodingException`, `SocketException`, `UnsupportedDataTypeException`, `ZipException`. It implements `Serializable`.

### Predefined streams
1. `System.out`: standard **OutputStream** (console)
2. `System.in`: standard **InputStream** (keyboard)
3. `System.err`: standard **Error stream** (console)

All are `InputStream`/`OutputStream` types, i.e. **byte streams**.

### Scanner class
1. Implements `Iterator` and `Closeable`.
2. Takes an `InputStream` via its constructor.

```java
Scanner sc = new Scanner(System.in);
String line = sc.nextLine();
sc.close();
```

## Folders
- [`src/file`](src/file/README.md)
- [`src/fileReader`](src/fileReader/README.md)
- [`src/bufferReader`](src/bufferReader/README.md)
- [`src/bufferWriter`](src/bufferWriter/README.md)
- [`src/inputStreamReader`](src/inputStreamReader/README.md)
- [`src/outputStreamWriter`](src/outputStreamWriter/README.md)

> Note on "more efficient": my notes mark character streams as more efficient for text. More precisely, they are *more convenient* for text because they handle encoding. For raw binary data, always use byte streams.

## Interview Questions
1. What is a stream in Java?
2. Byte stream vs character stream? When do you use each?
3. Why are `InputStream` and `Reader` abstract?
4. What are `System.in`, `System.out`, `System.err`?
5. What is the `Closeable` / `AutoCloseable` interface? What is try-with-resources?
6. Why use `Flushable`? What does `flush()` do?
7. How does `Scanner` differ from `BufferedReader`?
8. `FileNotFoundException` vs `IOException`?
9. Which classes bridge byte and character streams? (`InputStreamReader`, `OutputStreamWriter`)
10. What is serialization? (`ObjectInputStream`/`ObjectOutputStream`, `Serializable`)

# 09 - Arrays

## What I learnt

### What is an array and why do we need it?
An array is a **data structure** used to store a **similar kind** of primitives, objects, or even complex data types (a collection of data).

### Syntax
```java
dataType[] arrayName = new dataType[size];

int[] roll = new int[5];                 // store 5 roll numbers
int[] roll = {23, 12, 45, 12, 2};        // directly write values
```

1. `data type` -> what type of data is stored in the array
2. All elements of the array should be the **same type**

`int[]` represents the reference variable `roll`, which points towards the array object that contains integers.

```java
int[] roll;            // declaration  -> defined in the stack (reference only)
roll = new int[5];     // here the OBJECT is created in memory (heap) - initialisation
```

### How an array actually works
```
int[] arr = new int[5];
 |           |
 |           └─ creating the object in the HEAP (at runtime)
 └─ reference variable in the STACK (known at compile time)
```
This is called **Dynamic Memory Allocation** - memory is allocated at runtime.

```
Stack            Heap
arr ───────────► [3 | 18 | 9 | 2 | 1]
```

### Index
- Starts at `0`, ends at `n - 1` (`size - 1`).
- `arr[0]` = first element, `arr[arr.length - 1]` = last element.
- Using index `5` in an array of size 5 -> `ArrayIndexOutOfBoundsException`.

### Are array elements contiguous in memory?
- In C/C++ the values are contiguous.
- In Java we don't have pointers; it depends on the JVM.
- Arrays are objects -> stored in the heap. The Java Language Specification does not guarantee contiguous layout of heap objects, so array objects *may or may not* be contiguous - it depends on the JVM. (In practice a single 1-D primitive array is normally laid out contiguously.)
- Declaration is at compile time, memory allocation at runtime.

### `new` keyword
Basically used to **create an object**.

### Default values
- `int[]` -> `0` (same for other numeric types; `boolean[]` -> `false`).
- `String[]` (any object array) -> `null`.
- `null` is not a data type, it is a keyword / special literal. It can be assigned only to **non-primitive** (reference) types:
  - `int a = null;` X  `int[] arr = null;` OK  `String s = null;` OK
- Any reference initialised is `null` until the object is created.

```java
String[] arr = new String[5];   // each element is a reference variable pointing to nothing (null)
```

### Take array input / output
```java
for (int index = 0; index <= arr.length - 1; index++) {
    arr[index] = input.nextInt();
}
// Output
for (int index = 0; index <= arr.length - 1; index++) {
    System.out.println(arr[index]);
}
// for-each (data only, no index)
for (int num : arr) { System.out.println(num); }

// Arrays.toString (java.util)
System.out.println(Arrays.toString(arr));
```
Why `length - 1`? Index goes from `0 -> length-1`. If `arr.length = 5` we add elements up to index 4.

### Array of objects
```java
String[] strArray = new String[5];
for (int i = 0; i <= strArray.length - 1; i++) strArray[i] = input.next();
System.out.println(Arrays.toString(strArray));
```
The array object is anywhere in the heap; each `*` is a reference to a String object.

### Multidimensional arrays (2D, 3D, ...)
```java
int[][] arr = new int[2][2];     // [rows][cols]
// {1 2}
// {3 4}
```
- `int[][] arr = { {1,2}, {3,4}, {5,6} };` - an **array of arrays**; each inner array is stored somewhere else in the heap.
- Accessing: `arr[0][0]` -> 1st array, 1st element. `arr[1][0]` -> 2nd array, 1st element.
- **Column size is not necessary**: the size of each individual array doesn't matter - e.g. `{ {1,2,3}, {4,5}, {1} }` (jagged array).
- In 2D arrays `arr.length` gives the **rows**; `arr[i].length` gives columns of row `i`.

```java
// Input
int[][] arr = new int[3][3];
for (int i = 0; i < arr.length; i++)
    for (int j = 0; j < arr[i].length; j++)
        arr[i][j] = input.nextInt();

// Output
for (int[] row : arr) System.out.println(Arrays.toString(row));
```

## Programs

| File | Shows |
|------|-------|
| `ArrayBasics.java` | creation, defaults, index, out-of-bounds, null, reference copy, `Arrays` utility methods |
| `ArrayInputOutput.java` | taking input, 3 ways to print, String array input |
| `MultiDimensionalArrays.java` | 2D, jagged, 3D arrays, input/output, `deepToString` |
| `ArrayOfObjects.java` | array of Strings and custom objects, null elements |

## Interview Questions

1. **What is an array? Why do we need it?**
   A fixed-size, indexed collection of same-type elements - to store many values under one name.
2. **Is an array an object in Java?**
   Yes. Arrays are objects, created on the heap with `new`, and the variable holds a reference.
3. **Where are arrays stored?**
   The reference variable in the stack (if local), the array object in the heap.
4. **What are the default values in an array?**
   0 for numeric, `false` for boolean, `'\u0000'` for char, `null` for objects.
5. **Can an array size be changed after creation?**
   No, it is fixed. Use `ArrayList` or create a new array and copy.
6. **What exception occurs when index is invalid?**
   `ArrayIndexOutOfBoundsException`.
7. **`length` vs `length()` vs `size()`?**
   `length` - property of arrays; `length()` - method of String; `size()` - method of collections like ArrayList.
8. **How do you print an array?**
   `Arrays.toString(arr)` (1D), `Arrays.deepToString(arr)` (multi-D), or a loop. Printing `arr` directly shows `[I@hash`.
9. **Difference between `int[] a` and `int a[]`?**
   Same meaning; the first is the preferred style.
10. **What is a jagged array?**
    A 2D array whose rows have different lengths.
11. **How do you copy an array?**
    `Arrays.copyOf`, `System.arraycopy`, `arr.clone()`. `b = a` only copies the reference.
12. **Are array elements stored contiguously in Java?**
    Not guaranteed by the language spec; JVM dependent (usually contiguous for 1-D primitives).
13. **How do you sort / search an array?**
    `Arrays.sort(arr)` and `Arrays.binarySearch(arr, key)` (array must be sorted first).
14. **Can we store different data types in an array?**
    Not for a typed array, but `Object[]` can hold any objects.
15. **What is `null` and can we assign it to `int`?**
    `null` is a literal meaning "no object"; only for reference types, not primitives.
16. **Why is a 2D array's column size optional?**
    Because it is an array of arrays; each row is a separate array created independently.

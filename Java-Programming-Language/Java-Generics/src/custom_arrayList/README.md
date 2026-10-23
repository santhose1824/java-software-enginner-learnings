# `custom_arrayList`: building my own ArrayList, then making it generic

## Files

| File | Purpose |
|------|---------|
| `CustomArrayList.java` | Version 1: wraps a plain `int[]`. Has `add`, `remove`, `get`, `set`, `isFull`, `resize`. Works **only for `int`**. |
| `CustomGenericArrayList.java` | Version 2: `CustomGenericArrayList<T>`. Same logic but stores an `Object[]` and exposes `T` in `add`, `get`, `remove`. Works for `Integer`, `String`, anything. |

## What I learned

- `ArrayList` internally uses a normal array. I copy that idea: a **private** array, a `DEFAULT_SIZE = 10`, and a `size` that tracks how many elements are really stored (not the array length).
- **Resize**: when `size == array.length`, create a new array of **double** length, copy elements, replace the old one.
- **`remove()` does not erase** the element; it only decrements `size`. The old value stays in the array until a new `add` overwrites it.
- **Why generics?** `CustomArrayList` works only for `int`. Making the element type a parameter `<T>` lets the same code store `Integer`, `String`, etc., and the compiler prevents mixing types:

  ```java
  CustomGenericArrayList<Integer> list  = new CustomGenericArrayList<>();
  CustomGenericArrayList<String>  list2 = new CustomGenericArrayList<>();
  ```
- **Why `Object[]` inside and not `T[]`?** The generic type `T` is not known at runtime (type erasure), so Java can't create `new T[10]`. Using `Object[]` (parent of all classes) and casting on the way out `(T) array[i]` is the standard workaround.
- Unused slots print as `null` because the array holds `Object` references.

### Sample output

```
CustomArrayList{array=[1, 2, 3, 4, null, null, null, null, null, null], size=4}
CustomArrayList{array=[Sam, Ram, Someone, null, null, null, null, null, null, null], size=3}
```

## Things to be careful about (found while reviewing)

- **Bug in `CustomGenericArrayList.set`**: the signature is `set(int index, int value)`, not `set(int index, T value)`. It compiles because of autoboxing, but it lets me put an `Integer` into a `CustomGenericArrayList<String>`; the later `get` then fails with `ClassCastException`. (I reproduced this.) Fix: `public void set(int index, T value)`.
- `get`/`set`/`remove` have **no bounds checking** against `size` (e.g. `get(11)` on a 3-element list returns `null` instead of throwing). Real `ArrayList` throws `IndexOutOfBoundsException`; `remove()` on an empty list gives `ArrayIndexOutOfBounds` (index -1).
- `(T) array[i]` produces an **unchecked cast warning**; it is safe here only because `add` accepts `T`.
- In `remove()`, setting the slot to `null` avoids holding an object reference unnecessarily (a memory-leak pattern called "loitering").
- `resize()` is O(n) but happens rarely, so `add` is **amortized O(1)**.

## Interview questions and answers

**1. Why were generics introduced?**
Before Java 5, collections stored `Object`; you had to cast when reading and a wrong cast failed at runtime with `ClassCastException`. Generics move the check to compile time and remove casts.

**2. What is type erasure?**
The compiler checks generics, then removes the type parameters and replaces `T` with its bound (`Object` by default) in the bytecode. That is why `new T[]`, `new T()` and `instanceof List<String>` are not allowed.

**3. Why can't generics use primitives?**
Type arguments must be reference types because they erase to `Object`/a bound. Use wrappers (`Integer`) and autoboxing.

**4. How does `ArrayList` grow internally?**
It holds an `Object[]` (default capacity 10 when first added to); when full it creates a larger array (about 1.5x in the JDK) and copies the elements. My version doubles it.

**5. What is the time complexity of `add`, `get`, `remove(index)` in an ArrayList?**
`add` amortized O(1), `get` O(1), `remove(index)` O(n) because later elements shift.

**6. ArrayList vs LinkedList?**
ArrayList: fast random access, slower inserts/removes in the middle. LinkedList: fast insert/remove at known node, O(n) access.

**7. What is a raw type and why avoid it?**
Using `ArrayList` without `<T>`. It disables generic type checks and brings back runtime `ClassCastException`.

**8. What does the diamond operator `<>` do?**
`new ArrayList<>()` lets the compiler infer the type arguments from the left side.

**9. What is a generic method? Write one.**
`static <T> void printAll(List<T> list) { for (T t : list) System.out.println(t); }`: the type parameter is declared before the return type.

**10. Is `List<Object>` a supertype of `List<String>`?**
No. Generics are **invariant**: `List<String>` is not a `List<Object>`, even though `String` is an `Object`. Wildcards solve this (see `wildcards`).

**11. Why does the custom list use `Object[]` instead of `T[]`?**
Because of type erasure arrays of `T` can't be created. `Object[]` plus casts is the common solution (`ArrayList` does the same).

**12. What happens when `remove()` is called here; is the element deleted?**
Only `size` is decremented. The element still sits in the array and will be overwritten by the next `add`.

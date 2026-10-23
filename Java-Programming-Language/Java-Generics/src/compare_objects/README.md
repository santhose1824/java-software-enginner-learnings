# `compare_objects`: sorting objects with Comparable / Comparator

## Files

| File | Purpose |
|------|---------|
| `Student.java` | Class with `roll_no` and `marks`, a constructor and `toString()`. The `implements Comparable<Student>` and `compareTo()` are written but **commented out**. |
| `Main.java` | Creates 6 students, puts them in a `Student[]`, sorts with `Arrays.sort(students, (o1, o2) -> (int)(o1.marks - o2.marks))` and prints before/after. |

## What I learned

- Primitives compare with `<`, `>`, but for objects Java doesn't know **which field** to compare (`roll_no` or `marks`?). I must define it.
- **`Comparable<T>`** (in `java.lang`): the class itself implements `compareTo(T other)` to define its **natural ordering**. Return `0` if equal, negative if `this` is smaller, positive if `this` is bigger. `Arrays.sort(array)` then uses it automatically.
- **`Comparator<T>`**: a separate object with `compare(o1, o2)`. `Arrays.sort(array, comparator)` sorts by whatever the comparator says, without changing the class. It can be written as a **lambda** (see the commented anonymous-class version in `Main`).
- The sort in `Main` is by **marks ascending**. The commented-out `compareTo` shows how the same rule would live inside `Student`.

## Things to be careful about (found while reviewing)

- `(int)(o1.marks - o2.marks)` **truncates**: marks `89.76` vs `89.2` give difference `0.56`, which becomes `0`, so Java treats them as equal. (Verified: `(int)(0.5f - 0.1f)` is `0`.) Use `Float.compare(o1.marks, o2.marks)`.
- Subtracting `int`s for comparison (`a.roll_no - b.roll_no`) can **overflow**; use `Integer.compare(a, b)`.
- The commented `compareTo` has the same truncation problem; also its comment about which side is "bigger" is easy to get backwards, so always test.
- `compareTo` should be **consistent with `equals`** where possible, especially if objects go into `TreeSet` / `TreeMap`.
- Fields are package-private (`int roll_no`); `Main` can read them only because it's in the same package. Prefer private fields with getters.

## Interview questions and answers

**1. `Comparable` vs `Comparator`?**
`Comparable` = one natural order defined inside the class (`compareTo`, package `java.lang`). `Comparator` = any number of external orders (`compare`, package `java.util`), no change to the class needed.

**2. When would you use each?**
`Comparable` for the obvious default order (e.g. by id). `Comparator` for alternative or multiple orders (by marks, by name), or when you can't modify the class.

**3. What does `compareTo` return?**
Negative if `this < other`, zero if equal, positive if `this > other`.

**4. How do you sort a `List<Student>` by marks descending, then roll number?**
`list.sort(Comparator.comparing((Student s) -> s.marks).reversed().thenComparing(s -> s.roll_no));`

**5. What happens if you call `Arrays.sort(students)` and `Student` isn't `Comparable`?**
`ClassCastException` at runtime ("cannot be cast to class java.lang.Comparable").

**6. Why is `Float.compare` better than subtracting?**
No truncation of fractions, no int overflow, and it handles `NaN`/`-0.0` consistently.

**7. Is `Arrays.sort` for objects stable?**
Yes. It uses TimSort (merge-sort based), so equal elements keep their original relative order.

**8. Can `Comparator` be a lambda? Why?**
Yes. It is a functional interface (one abstract method, `compare`).

**9. What is the sort order if `compareTo` is inconsistent with `equals` and I use a `TreeSet`?**
The set uses `compareTo`, not `equals`, to decide duplicates, so "equal by compare" items are dropped.

**10. How does this connect to generics?**
Both interfaces are generic (`Comparable<Student>`, `Comparator<Student>`), which gives the typed parameter instead of an `Object` that needs casting.

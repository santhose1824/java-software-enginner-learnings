# `object_class`: the `Object` class, `equals`, `hashCode`, `clone`

## Files

| File | Purpose |
|------|---------|
| `ObjectClassDemo.java` | Overrides `hashCode()`, `equals()`, `clone()`, `toString()`, `finalize()`; demonstrates `==` vs `equals`, `instanceof`, `getClass()`. |
| `ObjectCloningExample.java` | Implements `Cloneable`; `clone()` copies primitives and the `int[] arr` (a **deep** copy of the array). |
| `Main.java` | Clones an object, changes `twin.arr[0]` and prints both arrays to see whether the original changes. |

## What I learned

- `Object` is the **root of the class hierarchy**: every class has `Object` as a superclass.
- The main methods from my notes: `hashCode()` (returns `int`), `equals()` (`boolean`), `clone()` (`Object`), `toString()` (`String`), `finalize()` (`void`).
- **`hashCode()`**: gives a number representation of the object (default is based on identity/memory).
- **`equals()`**: checks whether the *content* of two objects is the same (default behaviour is `==`, so I override it). `==` compares references.
- **`instanceof`**: checks if an object belongs to a class: `obj instanceof ObjectClassDemo`.
- **`getClass()`**: returns class information (`class object_class.ObjectClassDemo`); it is `final` so it can't be overridden.
- **`clone()`**: copies an object. The class must implement the `Cloneable` marker interface (`java.lang`) and `clone()` throws `CloneNotSupportedException`.
- **Shallow copy**: primitives get new copies, but object fields (like an array) only copy the *reference*, so changing the clone's array changes the original's too.
- **Deep copy**: if an object contains other objects, create copies of those as well. In `ObjectCloningExample.clone()` I call `super.clone()` and then allocate a new array with `System.arraycopy`.
- A copy constructor is an alternative to `clone()`.

## Things to be careful about (found while reviewing)

- **equals/hashCode contract is broken in `ObjectClassDemo`**: `equals` compares only `num`, but `hashCode()` returns `super.hashCode()` (identity). Two "equal" objects have different hash codes, so `HashSet`/`HashMap` treat them as different. (Verified: `equals` is `true`, `set.contains(b)` is `false`.) Fix: `return Integer.hashCode(num);` or `Objects.hash(num)`.
- The comment says hashCode "will return the num we pass", but the code still calls `super.hashCode()`.
- `equals` casts blindly: `((ObjectClassDemo) obj).num` throws `ClassCastException` for another type and `NullPointerException` for `null`. Standard pattern: check `this == o`, `o == null`, `getClass() != o.getClass()` (or `instanceof`), then compare fields.
- A hash code is **not guaranteed unique**; equal objects must have equal hash codes, unequal objects *may* share one.
- In `Main`, the comment says "shallow copy" but the **current** `clone()` is deep for `arr` (the shallow version is commented out). With the deep version, `twin.arr[0] = 100` does **not** change the original. Switch to the commented version to see the shallow effect.
- `String name` is immutable, so sharing its reference in a shallow copy is safe.
- `finalize()` is deprecated; don't use it.
- `Object` has more than five methods: also `getClass()`, `wait()`, `notify()`, `notifyAll()` (all final).

## Interview questions and answers

**1. What is the `Object` class?**
The root of the Java class hierarchy. Every class extends it, implicitly if nothing else is specified.

**2. Name its methods.**
`toString`, `equals`, `hashCode`, `clone`, `finalize`, `getClass`, `wait`, `notify`, `notifyAll`.

**3. `==` vs `equals()`?**
`==` compares references (primitives: values). `equals()` compares logical content when overridden; default `Object.equals` is the same as `==`.

**4. What is the equals/hashCode contract?**
If `a.equals(b)` is true then `a.hashCode() == b.hashCode()`. Hash code must be consistent across calls. Equal hash codes do not imply equal objects.

**5. Why override `hashCode` when overriding `equals`?**
Hash-based collections (`HashMap`, `HashSet`) use the hash code first to pick a bucket; with inconsistent hash codes equal objects are not found.

**6. What does the default `toString()` return?**
`ClassName@hexHashCode`; override for readable output.

**7. What is `instanceof`?**
Operator that tests whether an object is an instance of a class/interface (including subclasses); returns `false` for `null`.

**8. What is `getClass()` and how does it differ from `instanceof`?**
`getClass()` returns the exact runtime class; `instanceof` is true for subclasses too.

**9. What is object cloning? How do you do it?**
Creating an exact copy: implement `Cloneable`, override `clone()` calling `super.clone()`, handle `CloneNotSupportedException`.

**10. Shallow vs deep copy?**
Shallow: copies field values; nested objects are shared. Deep: nested objects are copied too, so the copy is fully independent.

**11. What is the `Cloneable` interface?**
A marker interface (no methods). Without it `super.clone()` throws `CloneNotSupportedException`.

**12. Alternatives to `clone()`?**
Copy constructor, static factory method, serialization-based copy.

**13. Why is `getClass()` final?**
So that the runtime type information can't be altered by subclasses.

**14. What happens if you use a mutable object as a `HashMap` key and change a field used by `hashCode`?**
The object lands in the wrong bucket and can no longer be found. Use immutable keys.

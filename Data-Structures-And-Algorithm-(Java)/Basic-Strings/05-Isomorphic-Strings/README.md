# Isomorphic Strings

> **Section:** Basic Strings  |  **Your solution file:** `IsomorphicString.java`

## Question

```text
Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:
Input : s = "egg" , t = "add"

Output : true

Explanation :

The 'e' in string s can be replaced with 'a' of string t.

The 'g' in string s can be replaced with 'd' of t.

Hence all characters in s can be replaced to get t.

Example 2:
Input : s = "apple" , t = "bbnbm"

Output : false

Explanation :

Strings are matched index by index.

At index 0, 'a' maps to 'b'.

At index 1, 'p' also maps to 'b'.

This is invalid because two different characters (a and p) cannot map to the same character (b) in a one-to-one mapping.

Therefore, no valid mapping exists and the output is false.

Example 3:
Input : s = "paper" , t = "title"
```

## Approach 1 — Brute Force

### Idea — how to think about it

Two strings are isomorphic when positions that hold equal characters in `s` also hold equal characters in `t`, and vice-versa. Brute force: compare **every pair of positions (i, j)** and check `s[i]==s[j]  ⇔  t[i]==t[j]`.

### Pseudocode

```text
if length(s) != length(t) return false
for i = 0 to n-1:
    for j = i+1 to n-1:
        if (s[i] == s[j]) != (t[i] == t[j]): return false
return true
```

### Time & Space Complexity

**Time: O(n²)**  
Every pair (i, j) with i < j is examined: n(n−1)/2 pairs.

**Space: O(1)**  
No storage.

## Approach 2 — Optimal

### Idea — how to think about it

Instead of comparing pairs, remember **where each character was last seen**. Keep two arrays of size 256 (one per string; index = the character code). When we reach position i, `s[i]` and `t[i]` must have been last seen at the **same** earlier position — if not, the mapping is inconsistent. Then record `i+1` as the new 'last seen' for both (we store i+1 so that 0 can mean 'never seen').
This is exactly the algorithm in your notes: `arr1[s[i]] != arr2[t[i]] → false`, then both `= i+1`.

### Pseudocode

```text
if length(s) != length(t) return false
arr1[256] = 0 ; arr2[256] = 0
for i = 0 to n-1:
    if arr1[s[i]] != arr2[t[i]]: return false
    arr1[s[i]] = i + 1
    arr2[t[i]] = i + 1
return true
```

### Time & Space Complexity

**Time: O(n)**  
A single loop over the n characters; every array read/write is O(1).

**Space: O(1)**  
Two arrays of fixed size 256 — the size does not depend on n.

## Corrected Java

```java
static boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] a = new int[256], b = new int[256];
    for (int i = 0; i < s.length(); i++) {
        if (a[s.charAt(i)] != b[t.charAt(i)]) return false;   // inconsistent mapping
        a[s.charAt(i)] = i + 1;
        b[t.charAt(i)] = i + 1;
    }
    return true;
}
```

## Corrections to your notes / code

- **Code is wrong (confirmed by running it):** `isomorphic('apple','bbnbm')` printed `true` — it must be `false`. In `IsomorphicString.java` the arrays are incremented with `++` (counting) and the mismatch branch only `break`s, after which the method still returns `true`. Replace it with the algorithm from your own notes: **return false** on mismatch and store `i + 1`.

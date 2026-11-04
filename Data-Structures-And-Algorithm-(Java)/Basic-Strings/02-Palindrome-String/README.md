# Palindrome String

> **Section:** Basic Strings  |  **Your solution file:** `Palindrome.java`

## Question

```text
You are given a string s. Return true if the string is palindrome, otherwise false.

A string is called palindrome if it reads the same forward and backward.

Example 1:
Input : s = "hannah"

Output : true

Explanation :

The given string when read backward is -> "hannah", which is same as when read forward.

Hence answer is true.

Example 2:
Input : s = "aabbaaa"

Output : false

Explanation :

The given string when read backward is -> "aaabbaa", which is not same as when read forward.

Hence answer is false.
```

## Approach 1 — Brute Force

### Idea — how to think about it

A palindrome equals its own reverse. Build the reversed string by walking from the last character to the first, then compare with `equals`.

### Pseudocode

```text
reverse = ""
for i = n-1 down to 0:
    reverse = reverse + s[i]
return reverse equals s
```

### Time & Space Complexity

**Time: O(n²) with String +=   (O(n) with StringBuilder)**  
In Java a String is **immutable**: each `reverse += c` creates a brand-new string and copies all existing characters — the copies cost 1+2+3+…+n = n(n+1)/2 ≈ n². If you use a `StringBuilder` the appends are O(1) each and the total is O(n).

**Space: O(n)**  
The reversed string stores n characters.

## Approach 2 — Optimal

### Idea — how to think about it

We don't need the whole reverse — a palindrome only requires **s[i] == s[n-1-i]** for each pair. So put one pointer at each end and compare while moving inwards. The first mismatch proves it is not a palindrome (stop early). If the pointers cross with no mismatch → palindrome.

### Pseudocode

```text
start = 0 ; end = n - 1
while start < end:
    if s[start] != s[end]: return false
    start++ ; end--
return true
```

### Time & Space Complexity

**Time: O(n)**  
At most n/2 comparisons.

**Space: O(1)**  
Just two index variables.

## Corrections to your notes / code

- **Wrong complexity in the notes:** the brute force is written as 'TC: O(N), SC: O(1)'. With `reverse += s.charAt(i)` it is actually **O(n²) time and O(n) space** (new String objects are created every time). Use `StringBuilder` to make it O(n)/O(n), or use two pointers for O(n)/O(1).

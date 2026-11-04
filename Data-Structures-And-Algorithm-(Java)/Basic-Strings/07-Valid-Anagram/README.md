# Valid Anagram

> **Section:** Basic Strings  |  **Your solution file:** `ValidAnagram.java`

## Question

```text
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input : s = "anagram" , t = "nagaram"

Output : true

Explanation :

We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.

Example 2:
Input : s = "dog" , t = "cat"

Output : false

Explanation :

We cannot rearrange the characters of string s to get string t as frequency of all characters from both strings is not same.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Two strings are anagrams if they contain the same letters with the same counts, so after **sorting** both they must be identical.

### Pseudocode

```text
if length(s) != length(t) return false
sort(s) ; sort(t)
return s equals t
```

### Time & Space Complexity

**Time: O(n log n)**  
Sorting n characters costs n·log n (merge/quick sort idea: log n levels × n work); the comparison is O(n).

**Space: O(n)**  
Sorting needs char arrays of both strings.

## Approach 2 — Optimal

### Idea — how to think about it

Skip sorting — just **count letters**. Use an array of 26 counters (a–z): add 1 for every letter of `s`, subtract 1 for every letter of `t` (notes: `arr[ch-'a']++` then `arr[ch-'a']--`). If they are anagrams every counter returns to 0; any non-zero counter proves a mismatch.

### Pseudocode

```text
if length(s) != length(t) return false
count[26] = 0
for ch in s: count[ch - 'a']++
for ch in t: count[ch - 'a']--
for c in count:
    if c != 0: return false
return true
```

### Time & Space Complexity

**Time: O(n)**  
Two passes over the strings (n each) + one pass over a constant 26 counters = O(n + n + 26) = O(n).

**Space: O(1)**  
The counter array always has 26 entries no matter how long the strings are.

## Corrections to your notes / code

- Your solution works for lowercase letters only (as the question states). For any Unicode text use a `HashMap<Character,Integer>`.

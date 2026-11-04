# Longest Common Prefix

> **Section:** Basic Strings  |  **Your solution file:** `LongestCommonPrefix.java`

## Question

```text
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input : str = ["flowers" , "flow" , "fly", "flight" ]

Output : "fl"

Explanation :

All strings given in array contains common prefix "fl".

Example 2:
Input : str = ["dog" , "cat" , "animal", "monkey" ]

Output : ""

Explanation :

There is no common prefix among the given strings in array.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Take the first string as the 'candidate' prefix. For every other string, shorten the candidate until that string starts with it. What remains at the end is the common prefix.

### Pseudocode

```text
prefix = strs[0]
for each string s in strs[1..]:
    while s does not start with prefix:
        prefix = prefix without its last character
        if prefix is empty return ""
return prefix
```

### Time & Space Complexity

**Time: O(n · m²) worst case**  
n strings; per string we may shorten the prefix up to m times and each `startsWith` check costs up to m characters (m = length of the shortest string).

**Space: O(1)**  
Only the prefix reference.

## Approach 2 — Optimal

### Idea — how to think about it

Compare **column by column** (vertical scan). Look at character 0 of every string: all equal? then character 1 of every string, and so on. The first column where any string differs (or a string ends) stops the search; everything before that column is the answer. No character is ever compared twice.
**Your notes' trick:** sort the array and compare only the *first* and *last* string — in sorted order, the two most different strings are at the ends, so whatever they share is shared by all (flight, flow, flowers, fly → compare 'flight' and 'fly' → 'fl'). It is correct and elegant, but sorting costs O(n·m·log n), so it is not faster than the vertical scan below.

### Pseudocode

```text
for col = 0 to length(strs[0]) - 1:
    ch = strs[0][col]
    for each string s in strs[1..]:
        if col == length(s) or s[col] != ch:
            return strs[0].substring(0, col)
return strs[0]
```

### Time & Space Complexity

**Time: O(n · m)**  
In the worst case every string is identical for m characters (m = shortest length): m columns × n strings = n·m character comparisons, which is just the total input size.

**Space: O(1)**  
No extra storage (the answer is a substring of the first string).

## Corrections to your notes / code

- **Complexity of your sorting approach:** sorting n strings = O(n log n) comparisons, and each comparison can look at up to m characters → **O(n·m·log n)**, then O(m) for the first-vs-last comparison. The vertical scan is O(n·m).
- Empty input array / empty first string should return `""` — check before indexing `strs[0]`.

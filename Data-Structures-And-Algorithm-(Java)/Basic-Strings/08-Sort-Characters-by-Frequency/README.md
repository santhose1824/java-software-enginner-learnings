# Sort Characters by Frequency

> **Section:** Basic Strings  |  **Your solution file:** `SortCharactersByFrequency.java`

## Question

```text
You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.

If two or more characters have same frequency then arrange them in alphabetic order.

Example 1:
Input : s = "tree"

Output : ['e', 'r', 't' ]

Explanation :

The occurrences of each character are as shown below :

e --> 2

r --> 1

t --> 1.

The r and t have same occurrences , so we arrange them by alphabetic order.

Example 2:
Input : s = "raaaajj"

Output : ['a' , 'j', 'r' ]

Explanation :

The occurrences of each character are as shown below :

a --> 4

j --> 2

r --> 1

Example 3:
Input : s = "bbccddaaa"
```

## Approach 1 — Brute Force

### Idea — how to think about it

For each distinct character count its frequency by scanning the whole string, then repeatedly pick the unused character with the highest frequency (alphabetical on ties) and append it to the answer.

### Pseudocode

```text
unique = distinct characters of s
for ch in unique: freq[ch] = count of ch in s        // scan per char
result = []
repeat |unique| times:
    pick unused ch with highest freq (smallest ch if tie)
    result.add(ch)
return result
```

### Time & Space Complexity

**Time: O(n·k + k²)**  
k = number of distinct characters. Counting each by scanning costs n per character (n·k); picking the max k times from k candidates costs k². Since k ≤ 26 (or 256) this is bounded by a constant × n.

**Space: O(k)**  
Frequency values for the k distinct characters.

## Approach 2 — Optimal

### Idea — how to think about it

Count every character once in a `HashMap<Char,Integer>` (O(n)), put the distinct characters in a list, and **sort that list with a custom comparator**:
1. higher frequency first → `freq[b] - freq[a]`
2. if the frequencies are equal → alphabetical → `a - b`
Only the k distinct characters are sorted, never the n-length string.

### Pseudocode

```text
freq = HashMap char -> count
for c in s: freq[c] = freq.getOrDefault(c, 0) + 1
unique = list of freq.keySet()
sort unique with comparator(a, b):
    if freq[a] != freq[b]: return freq[b] - freq[a]     // DESCENDING frequency
    return a - b                                         // alphabetical on ties
return unique as char array
```

### Time & Space Complexity

**Time: O(n + k log k)**  
Counting = O(n). Sorting k distinct characters = k·log k comparisons. With a fixed alphabet (k ≤ 26/256) the sort is a constant, so overall O(n).

**Space: O(k)**  
Map and list hold the k distinct characters (≤ 26/256 → O(1) for a fixed alphabet).

## Corrected Java

```java
Map<Character,Integer> freq = new HashMap<>();
for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

List<Character> unique = new ArrayList<>(freq.keySet());
unique.sort((a, b) -> {
    int fa = freq.get(a), fb = freq.get(b);
    if (fa != fb) return fb - fa;      // higher frequency first
    return a - b;                      // alphabetical for equal frequency
});
```

## Corrections to your notes / code

- **Your `Questions.txt` is cut off:** Example 3 (`s = "bbccddaaa"`) has no output line. The expected answer is `['a', 'b', 'c', 'd']` (a→3, then b, c, d with 2 each in alphabetical order).
- **Wrong comparator in the notes:** you wrote `if (A != B) return A - B;` — that sorts frequency **ascending** (lowest first), but the question wants highest → lowest. It must be `return B - A;`, and the alphabetical tie-break `return a - b;` is missing.
- **Code is incomplete (confirmed):** your Java comparator never looks at frequencies, so `zzzay` printed `[a, y, z]` instead of `[z, a, y]`. (`tree` only looked right by luck because e,r,t is also alphabetical.)

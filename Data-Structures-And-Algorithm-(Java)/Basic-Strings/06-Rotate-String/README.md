# Rotate String

> **Section:** Basic Strings  |  **Your solution file:** `StringRotation.java`

## Question

```text
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.

Example 1:
Input : s = "abcde" , goal = "cdeab"

Output : true

Explanation :

After performing 2 shifts we can achieve the goal string from string s.

After first shift the string s is => bcdea

After second shift the string s is => cdeab.

Example 2:
Input : s = "abcde" , goal = "adeac"

Output : false

Explanation :

Any number of shift operations cannot convert string s to string goal.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Literally perform every possible shift: move the first character to the end, n times, and check after each shift whether the string equals `goal`.

### Pseudocode

```text
if length(s) != length(goal) return false
for k = 0 to n-1:
    if s equals goal return true
    s = s[1..] + s[0]            // one left shift
return false
```

### Time & Space Complexity

**Time: O(n²)**  
n possible shifts, and each shift/compare handles n characters.

**Space: O(n)**  
Each shift creates a new string of n characters.

## Approach 2 — Optimal

### Idea — how to think about it

Look at your notes' picture: `abcde` rotated gives `cdeab`. If you write the string twice — `abcdeabcde` — **every rotation of `s` appears inside it as a substring** (`cdeab` is right there at index 2). So `goal` is a rotation of `s` ⇔ lengths are equal and `(s + s)` contains `goal`.

### Pseudocode

```text
if length(s) != length(goal) return false
return (s + s).contains(goal)
```

### Time & Space Complexity

**Time: O(n) with a linear search (KMP); O(n²) worst case with Java's naive `contains`**  
Building s+s is O(n). Searching an n-length pattern in a 2n-length text takes O(n) with KMP; Java's `String.contains` uses a simple search that can take O(n·m) in adversarial inputs, but it is fast in practice.

**Space: O(n)**  
The doubled string has 2n characters.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

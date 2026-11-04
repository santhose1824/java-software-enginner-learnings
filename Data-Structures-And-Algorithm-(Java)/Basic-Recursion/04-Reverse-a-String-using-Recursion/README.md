# Reverse a String using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `ReverseAString.java`

## Question

```text
Given an input string as an array of characters, write a function that reverses the string.

Example 1:
Input : s = ["h", "e", "l", "l", "o"]

Output : ["o", "l", "l", "e", "h"]

Explanation : The given string is s = "hello" and after reversing it becomes s = "olleh".

Example 2:
Input : s = ["b", "y", "e" ]

Output : ["e", "y", "b"]

Explanation : The given string is s = "bye" and after reversing it becomes s = "eyb".
```

> There is only one sensible recursive approach (swap the ends, recurse on the inside); the loop version is covered in Basic-Strings.

## Solution (brute force = optimal here)

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

Reversing = swap the outer two characters, then reverse the inner part. Pass two indices `start`, `end` instead of building smaller strings. Base condition: `start >= end` (0 or 1 characters left — already reversed). Your notes' trace for `hello` : swap(0,4) → swap(1,3) → start=2,end=2 → stop.

### Pseudocode

```text
reverse(s, start, end):
    if start >= end: return
    swap s[start], s[end]
    reverse(s, start + 1, end - 1)

call: reverse(s, 0, n - 1)
```

### Time & Space Complexity

**Time: O(n)**  
Each call fixes two characters and the range shrinks by 2, so there are about n/2 calls.

**Space: O(n)**  
n/2 frames on the stack at the deepest point → O(n/2) = O(n). (The iterative two-pointer version needs only O(1).)

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

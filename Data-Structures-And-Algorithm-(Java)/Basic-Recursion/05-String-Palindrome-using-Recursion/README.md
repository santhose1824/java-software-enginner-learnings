# String Palindrome using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `StringPalindrome.java`

## Question

```text
Given a string s, return true if the string is palindrome, otherwise false.

A string is called palindrome if it reads the same forward and backward.

Example 1:
Input : s = "hannah"

Output : true

Explanation : The string when reversed is --> "hannah", which is same as original string , so we return true.

Example 2:
Input : s = "aabbaA"

Output : false

Explanation : The string when reversed is --> "Aabbaa", which is not same as original string, So we return false.
```

> One natural recursive approach: compare the two ends, then recurse inwards.

## Solution (brute force = optimal here)

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

A string is a palindrome if its first and last characters match **and** the string between them is a palindrome. Base condition: `start >= end` → nothing left to compare → **true**. Mismatch → false immediately.

### Pseudocode

```text
isPalindrome(s, start, end):
    if start >= end: return true
    if s[start] != s[end]: return false
    return isPalindrome(s, start + 1, end - 1)

call: isPalindrome(s, 0, n - 1)
```

### Time & Space Complexity

**Time: O(n)**  
At most n/2 calls, each doing one comparison.

**Space: O(n)**  
Up to n/2 pending frames on the call stack.

## Corrections to your notes / code

- **Notes bug:** the base case in your pseudocode says `if(start >= end) return;` — it must be **`return true`**; returning nothing would make the method fail to compile / give no answer.

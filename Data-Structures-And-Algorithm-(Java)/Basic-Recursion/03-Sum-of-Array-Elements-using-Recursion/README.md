# Sum of Array Elements using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `SumOfArrayElements.java`

## Question

```text
Given an array nums, find the sum of elements of array using recursion.

Example 1:
Input : nums = [1, 2, 3]

Output : 6

Explanation : The sum of elements of array is 1 + 2 + 3 => 6.

Example 2:
Input : nums = [5, 8, 1]

Output : 14

Explanation : The sum of elements of array is 5 + 8 + 1 => 14.
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

Sum of the array = (element at the current index) + (sum of the rest). Instead of copying the array into a smaller one, **pass an index**: `sum(arr, i)` means "sum of arr[i..end]". The base case is `i == n` (no elements left → 0). This avoids the extra `ArrayList` conversion drawn in your notes.

### Pseudocode

```text
sum(arr, i):
    if i == n: return 0
    return arr[i] + sum(arr, i + 1)

call:  sum(arr, 0)
```

### Time & Space Complexity

**Time: O(n)**  
One call per element (n calls) plus the base call; each does one addition.

**Space: O(n)**  
Call-stack depth reaches n before the base case is hit.

## Approach 2 — Optimal

### Idea — how to think about it

A loop with a running total does the same work with no call stack. Recursion is only used here for practice.

### Pseudocode

```text
sum = 0
for i = 0 to n-1: sum += arr[i]
return sum
```

### Time & Space Complexity

**Time: O(n)**  
Every element must be read once.

**Space: O(1)**  
No recursion.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

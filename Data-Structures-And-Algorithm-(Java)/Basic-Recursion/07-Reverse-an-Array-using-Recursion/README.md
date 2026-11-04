# Reverse an Array using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `ReverseAnArray.java`

## Question

```text
Given an array nums of n integers, return reverse of the array.

Example 1:
Input : nums = [1, 2, 3, 4, 5]

Output : [5, 4, 3, 2, 1]

Example 2:
Input : nums = [1, 3, 3, 3, 5]

Output : [5, 3, 3, 3, 1]
```

> Same as 'Reverse a String' — an array is just a character array of numbers (your notes: 'same logic as reverse string').

## Solution (brute force = optimal here)

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

Swap `arr[start]` and `arr[end]`, then reverse the sub-array `start+1 … end−1`. Base: `start >= end`.

### Pseudocode

```text
reverse(arr, start, end):
    if start >= end: return
    swap arr[start], arr[end]
    reverse(arr, start + 1, end - 1)
```

### Time & Space Complexity

**Time: O(n)**  
n/2 calls, one swap each.

**Space: O(n)**  
n/2 frames on the call stack.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

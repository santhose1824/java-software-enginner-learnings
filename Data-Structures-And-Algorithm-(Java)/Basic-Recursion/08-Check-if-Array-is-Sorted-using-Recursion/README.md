# Check if Array is Sorted using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `CheckArrayIsSorted.java`

## Question

```text
Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.

Example 1:
Input : nums = [1, 2, 3, 4, 5]

Output : true

Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

Example 2:
Input : nums = [1, 2, 1, 4, 5]

Output : false

Explanation : For i == 2 it does not hold nums[i] <= nums[i+1], hence it is not sorted and we return false.
```

> Same idea as the loop (check neighbours), expressed recursively.

## Solution (brute force = optimal here)

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

An array is sorted if the **current pair is in order** and **the rest is sorted**. Carry an index `i`; compare `arr[i]` with `arr[i−1]`. Base: `i == n` (all pairs passed) → true. A bad pair → false straight away.

### Pseudocode

```text
isSorted(arr, i):
    if i == n: return true
    if arr[i] < arr[i - 1]: return false
    return isSorted(arr, i + 1)

call: isSorted(arr, 1)
```

### Time & Space Complexity

**Time: O(n)**  
At most n−1 calls, one comparison each.

**Space: O(n)**  
Up to n frames on the stack.

## Corrections to your notes / code

- Empty / single-element arrays must return `true` — make sure the first call does not read `arr[-1]` (start at index 1).

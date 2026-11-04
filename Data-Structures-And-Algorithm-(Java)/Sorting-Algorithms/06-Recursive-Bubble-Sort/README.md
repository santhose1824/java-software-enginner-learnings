# Recursive Bubble Sort

> **Section:** Sorting  |  **Your solution file:** `RecursiveBubbleSort.java`

## Question

```text
Sort an array in ascending order using Bubble Sort implemented with recursion (no outer for-loop).

Example:
Input : [13, 2, 5, 100, 7]
Output: [2, 5, 7, 13, 100]
```

> Recursive bubble sort replaces the *outer loop* with recursion; complexity is the same as the iterative one.

## Solution (brute force = optimal here)

### Idea — how to think about it

The outer loop of bubble sort says "do a pass for range n, then n−1, then n−2 …". That is naturally recursive: `bubble(arr, n)` = one pass that pushes the maximum to index n−1, then `bubble(arr, n−1)`. Base condition: `n == 1` (one element is sorted).
Optional early exit: if the pass made no swap, return immediately.

### Pseudocode

```text
bubble(arr, n):
    if n == 1: return
    didSwap = false
    for j = 0 to n-2:
        if arr[j] > arr[j+1]: swap ; didSwap = true
    if not didSwap: return
    bubble(arr, n - 1)
```

### Time & Space Complexity

**Time: O(n²) worst, O(n) best (with the early exit)**  
Calls with n, n−1, …, 1 each run a pass of n−1, n−2, … comparisons: ≈ n²/2. With the early exit an already-sorted array needs one pass.

**Space: O(n)**  
Recursion depth up to n frames (the iterative version uses O(1)).

## Corrections to your notes / code

- Without the `didSwap` check (as in your file) the best case is also O(n²). Add the check to reach O(n) for sorted input.


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

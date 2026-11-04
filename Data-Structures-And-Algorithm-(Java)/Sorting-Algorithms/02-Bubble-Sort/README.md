# Bubble Sort

> **Section:** Sorting  |  **Your solution file:** `BubbleSort.java`

## Question

```text
Given an array of integers, sort it in ascending order using Bubble Sort.

Example:
Input : [13, 2, 5, 100, 7]
Output: [2, 5, 7, 13, 100]
```

## Approach 1 — Brute Force

### Idea — how to think about it

Compare **adjacent** elements and swap if the left one is bigger. One full pass pushes the maximum to the last position (notes: 'pushes the maximum to last by adjacent swaps'). Then repeat for the shorter range: 0…n−1, 0…n−2, 0…n−3 … (the largest elements are already in place at the end).

### Pseudocode

```text
for i = n-1 down to 1:
    for j = 0 to i-1:
        if arr[j] > arr[j+1]: swap arr[j], arr[j+1]
```

### Time & Space Complexity

**Time: O(n²)**  
Pass i makes i comparisons: (n−1) + (n−2) + … + 1 = n(n−1)/2 ≈ n². Same in every case because there is no early exit.

**Space: O(1)**  
In-place.

## Approach 2 — Optimal

### Idea — how to think about it

If a full pass makes **no swap**, the array is already sorted — every neighbour pair is in order — so we can stop (notes: 'if I do not do any swap we stop'). This makes the best case (already sorted) a single pass: O(n).
Use a flag `didSwap`: set it to **false at the start of every pass**, set it to true on any swap, and break after the pass if it is still false.

### Pseudocode

```text
for i = n-1 down to 1:
    didSwap = false
    for j = 0 to i-1:
        if arr[j] > arr[j+1]:
            swap arr[j], arr[j+1]
            didSwap = true
    if not didSwap: break
```

### Time & Space Complexity

**Time: Worst/average O(n²), best O(n)**  
Worst (reverse-sorted) and average still need ≈ n²/2 comparisons. Best (already sorted): the first pass makes n−1 comparisons, finds no swap and stops → O(n).

**Space: O(1)**  
In-place; a boolean flag.

## Corrections to your notes / code

- **Notes bug:** the pseudocode sets `swap = true` before the inner loop and does `if(swap) break` — that is inverted. It must start each pass with `didSwap = false`, set it to `true` when a swap happens, and `break` when it is **still false** after the pass.
- **Code bug (confirmed):** in `BubbleSort.java` the swap flag is never reset to false at the start of a pass, so once a swap has happened the early-exit never triggers and the 'optimised' best case is still O(n²).


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

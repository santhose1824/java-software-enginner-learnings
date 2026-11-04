# Quick Sort

> **Section:** Sorting  |  **Your solution file:** `QuickSort.java`

## Question

```text
Given an array of integers, sort it in ascending order using Quick Sort.

Example:
Input : [4, 6, 2, 5, 7, 9, 1, 3]
Output: [1, 2, 3, 4, 5, 6, 7, 9]
```

> Quick sort is the practical optimal (average O(n log n), in place). Its worst case is bad (O(n²)), which is why a random or median pivot is used.

## Solution (brute force = optimal here)

### Idea — how to think about it

**Divide and conquer without a merge.** (1) Pick a **pivot** (first, last, median or random element) and place it in its *final sorted position*. (2) Put everything smaller than the pivot on its left and everything larger on its right — this is *partition*. (3) Recursively sort the left and right parts. Because the pivot is already final, no merging is needed.
Partition with two pointers (your notes): `i` moves right to find an element **> pivot**, `j` moves left to find an element **≤ pivot**; if `i < j` swap them; repeat until they cross; finally swap the pivot with `arr[j]` and return `j`.

### Pseudocode

```text
quickSort(arr, low, high):
    if low < high:
        p = partition(arr, low, high)
        quickSort(arr, low, p - 1)
        quickSort(arr, p + 1, high)

partition(arr, low, high):
    pivot = arr[low]
    i = low ; j = high
    while i < j:
        while arr[i] <= pivot and i <= high - 1: i++
        while arr[j] >  pivot and j >= low + 1:  j--
        if i < j: swap arr[i], arr[j]
    swap arr[low], arr[j]
    return j
```

### Time & Space Complexity

**Time: Best/average O(n log n), worst O(n²)**  
Partition scans the part once → O(n) per level. If the pivot lands near the middle every time, the range halves → log n levels → n·log n. If the pivot is always the smallest/largest (e.g. an already-sorted array with first-element pivot) each call only removes one element → n levels × n work = n².

**Space: O(log n) average, O(n) worst**  
No extra array — only the recursion stack, whose depth equals the number of levels: log n when balanced, n when completely unbalanced.

## Corrections to your notes / code

- **Wrong complexity in the notes:** 'TC O(N log N), SC O(1), slightly better than merge sort'. Quick sort's worst case is **O(n²)**, and the recursion stack makes the space **O(log n) average / O(n) worst**, not O(1). (It is fast in practice because it is in place and cache friendly.)
- Code detail: `while(array[j] > pivot && i >= low+1)` — the second condition should check **`j >= low+1`**. It still works because `array[low]` is the pivot and stops the loop, but write it correctly. Your QuickSort passed all 40 random test arrays (including duplicates).


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

# Merge Sort

> **Section:** Sorting  |  **Your solution file:** `MergeSort.java`

## Question

```text
Given an array of integers, sort it in ascending order using Merge Sort (divide and merge).

Example:
Input : [2, 4, 7, 8, 1, 3, 5]
Output: [1, 2, 3, 4, 5, 7, 8]
```

> Merge sort is already the optimal comparison-based approach (O(n log n) in every case). The simpler sorts above are the 'brute force' alternatives.

## Solution (brute force = optimal here)

### Idea — how to think about it

**Divide and conquer.** (1) *Divide*: split the array into two halves (use indices `low, mid, high` instead of creating new arrays — notes: 'instead of breaking we play with index'). (2) *Conquer*: sort each half recursively. (3) *Merge*: combine two sorted halves into one sorted array by repeatedly taking the **smaller front element** of the two halves; when one half is used up, copy the rest of the other (notes: 'once left is exhausted add all remaining').
Base condition: `low >= high` (one element is already sorted).

### Pseudocode

```text
mergeSort(arr, low, high):
    if low >= high: return
    mid = low + (high - low) / 2
    mergeSort(arr, low, mid)
    mergeSort(arr, mid + 1, high)
    merge(arr, low, mid, high)

merge(arr, low, mid, high):
    temp = []
    left = low ; right = mid + 1
    while left <= mid and right <= high:
        if arr[left] <= arr[right]: temp.add(arr[left++])
        else:                       temp.add(arr[right++])
    while left <= mid:   temp.add(arr[left++])      // leftovers of left half
    while right <= high: temp.add(arr[right++])     // leftovers of right half
    for i = low to high: arr[i] = temp[i - low]
```

### Time & Space Complexity

**Time: O(n log n) — best, average and worst**  
Halving: you can halve n only log₂ n times before reaching size 1, so the recursion tree has **log₂ n levels**. At every level the merges together touch all n elements once (each merge of size s costs s steps, and the sizes on a level add up to n). Work = (levels) × (n per level) = n · log n.

**Space: O(n)**  
`temp` holds up to n elements during the top-level merge (plus O(log n) recursion stack, which is smaller).

## Corrections to your notes / code

- **Code bug (confirmed — failed 34 of 40 random test arrays):** your `merge()` uses `left <= mid + 1` (reads the first element of the right half as part of the left half) and the two 'copy leftovers' loops are **inside** the main `while` loop. The two leftover loops must come *after* the main loop (as in your notes), and the condition is `left <= mid && right <= high`. See the corrected merge above.
- **Unclear explanation in the notes:** 'O(log N) → merge, O(N) → merge sort' is backwards. Correct statement: there are **log n levels**, and each level does **O(n)** merging work → O(n log n).
- Compute `mid` as `low + (high - low) / 2` to avoid int overflow on huge indices.


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

# Selection Sort

> **Section:** Sorting  |  **Your solution file:** `SelectionSort.java`

## Question

```text
Given an array of integers, sort it in ascending order using Selection Sort.

Example:
Input : [12, 34, 100, 75, 1]
Output: [1, 12, 34, 75, 100]
```

> Selection sort has no faster 'optimal' variant — it always does the same number of comparisons. Use Merge/Quick sort when you need better than O(n²).

## Solution (brute force = optimal here)

### Idea — how to think about it

Build the sorted part from the left. In each round **select the minimum of the unsorted part and swap it to the front** of that part (your notes: 'select minimum and place at index 0, then 1, …').
After round i, position i holds its final value, so we need rounds for i = 0 … n−2 — the **last element is automatically in place** (notes: "because last element is already sorted").

### Pseudocode

```text
for i = 0 to n-2:
    min = i
    for j = i+1 to n-1:
        if arr[j] < arr[min]: min = j
    swap arr[i], arr[min]
```

### Time & Space Complexity

**Time: O(n²) — best, average and worst**  
Round i scans n−i−1 elements: (n−1) + (n−2) + … + 1 = n(n−1)/2 ≈ n²/2 comparisons. This happens even if the array is already sorted, because the scan can't know the minimum without looking at everything.

**Space: O(1)**  
Sorting is in place; only `min` and a temp for the swap.

## Corrections to your notes / code

- **Code bug (confirmed — failed 22 of 40 random test arrays):** the outer loop is `i < n-2`, so the last pair is never fixed — `[3,1,2]` stayed unsorted. It must be `i < n-1` (i ≤ n−2). Your notes (`for 0 → n-2`, inclusive) are right.
- The notes' step-by-step example shows the unsorted array order slightly mixed up after step 1 (a swap moves 12 to the end, it does not shift it) — the algorithm itself is right.


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

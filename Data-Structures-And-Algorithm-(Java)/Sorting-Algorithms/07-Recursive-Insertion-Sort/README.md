# Recursive Insertion Sort

> **Section:** Sorting  |  **Your solution file:** `RecursiveInsertionSort.java`

## Question

```text
Sort an array in ascending order using Insertion Sort implemented with recursion (no outer for-loop).

Example:
Input : [4, 2, 10, 6, 7, 1]
Output: [1, 2, 4, 6, 7, 10]
```

> Recursive insertion sort replaces the *outer loop* with recursion; complexity is the same as the iterative one.

## Solution (brute force = optimal here)

### Idea — how to think about it

Iterative insertion sort inserts element i into the sorted prefix. Recursively: sort the first i elements, **then** insert element i into them. `insertion(arr, i, n)`: if `i == n` stop; insert `arr[i]` into the sorted prefix by swapping left while the left neighbour is bigger; then call `insertion(arr, i+1, n)`.

### Pseudocode

```text
insertion(arr, i, n):
    if i == n: return
    j = i
    while j > 0 and arr[j-1] > arr[j]:
        swap arr[j-1], arr[j]
        j--
    insertion(arr, i + 1, n)

call: insertion(arr, 1, n)
```

### Time & Space Complexity

**Time: O(n²) worst, O(n) best**  
Element i may move i places: 1+2+…+(n−1) ≈ n²/2. Already sorted → each insertion stops immediately → n−1 steps.

**Space: O(n)**  
n recursive calls are stacked (iterative version: O(1)).

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

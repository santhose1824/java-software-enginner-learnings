# Insertion Sort

> **Section:** Sorting  |  **Your solution file:** `InsertionSort.java`

## Question

```text
Given an array of integers, sort it in ascending order using Insertion Sort.

Example:
Input : [4, 2, 10, 6, 7, 1]
Output: [1, 2, 4, 6, 7, 10]
```

## Approach 1 — Brute Force

### Idea — how to think about it

Think of sorting playing cards in your hand: take the next card and slide it left until it sits in the right place. The left part `arr[0..i-1]` is always sorted. For element i, **swap it with its left neighbour while the neighbour is bigger** (notes: 'takes an element and places it in its correct order').

### Pseudocode

```text
for i = 1 to n-1:
    j = i
    while j > 0 and arr[j-1] > arr[j]:
        swap arr[j-1], arr[j]
        j--
```

### Time & Space Complexity

**Time: O(n²) worst, O(n) best**  
Worst case (reverse-sorted): element i moves i places → 1+2+…+(n−1) = n(n−1)/2 ≈ n². Best case (already sorted): the `while` condition fails immediately for every i → n−1 comparisons = O(n).

**Space: O(1)**  
In-place.

## Approach 2 — Optimal

### Idea — how to think about it

Same comparisons, fewer writes: hold the element in `key`, **shift** bigger elements one step right (one write each instead of a 3-write swap), then drop `key` in the gap (your notes' 'right shift' diagram).

### Pseudocode

```text
for i = 1 to n-1:
    key = arr[i]
    j = i - 1
    while j >= 0 and arr[j] > key:
        arr[j+1] = arr[j]       // shift right
        j--
    arr[j+1] = key
```

### Time & Space Complexity

**Time: O(n²) worst, O(n) best**  
Same counting as above; only the constant factor (writes per step) improves.

**Space: O(1)**  
In-place.

## Corrections to your notes / code

- Your code uses the swap version, which is correct. Notes' 'O(N²) | O(N)' means worst | best — both are right.


---
*Problem statement written by the README generator: your Sorting-Algorithms folder has no Questions.txt.*

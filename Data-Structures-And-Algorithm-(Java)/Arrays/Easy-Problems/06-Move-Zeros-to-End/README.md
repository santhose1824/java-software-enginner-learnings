# Move Zeros to End

> **Section:** Arrays Easy  |  **Your solution file:** `MoveZerosToEnd.java`

## Question

```text
Given an integer array nums, move all the 0's to the end of the array. The relative order of the other elements must remain the same.

This must be done in place, without making a copy of the array.

Example 1:
Input: nums = [0, 1, 4, 0, 5, 2]

Output: [1, 4, 5, 2, 0, 0]

Explanation:

Both the zeroes are moved to the end and the order of the other elements stay the same

Example 2:
Input: nums = [0, 0, 0, 1, 3, -2]

Output: [1, 3, -2, 0, 0, 0]

Explanation:

All 3 zeroes are moved to the end and the order of the other elements stay the same
```

## Approach 1 — Brute Force

### Idea — how to think about it

Copy all non-zero elements, in order, into a temporary list; write them back to the start of the array; fill the remaining positions with 0.

### Pseudocode

```text
temp = []
for i = 0 to n-1:
    if arr[i] != 0: temp.add(arr[i])
for i = 0 to size(temp)-1: arr[i] = temp[i]
for i = size(temp) to n-1: arr[i] = 0
```

### Time & Space Complexity

**Time: O(n)  (≈ 2n)**  
Pass 1 reads n elements; pass 2 writes x non-zeros; pass 3 writes n−x zeros → n + x + (n−x) = 2n → O(n). (Your notes wrote it as O(N)+O(x)+O(N−x).)

**Space: O(x) ≤ O(n)**  
x = number of non-zero values stored in `temp`; if there are no zeros x = n.

## Approach 2 — Optimal

### Idea — how to think about it

Two pointers. `j` always points at the **first zero** (the slot waiting to receive the next non-zero). Walk `i` forward; when `arr[i]` is non-zero, **swap it with `arr[j]`** and move `j` right. Non-zero elements keep their relative order, and zeros bubble to the end.
Equivalent compact form (your code): `j` = next write position for non-zeros; when `arr[i] != 0` swap `arr[i]` and `arr[j]`, then `j++`.
Note `arr[i] != 0` (not `i != 0` as written in the notes' brute-force pseudocode).

### Pseudocode

```text
j = 0                         // next position for a non-zero
for i = 0 to n-1:
    if arr[i] != 0:
        swap arr[i], arr[j]
        j++
```

### Time & Space Complexity

**Time: O(n)**  
Single pass; `i` visits each element once, each swap is O(1).

**Space: O(1)**  
In place — only two indices.

## Corrections to your notes / code

- In the notes' brute-force pseudocode the condition is written `if(i != 0)`; it must test the **value**: `if (arr[i] != 0)`.
- If you find the first zero first (as in the notes) and no zero exists, `j = -1` — return immediately, otherwise the second loop starts at index 0 and swaps wrongly.

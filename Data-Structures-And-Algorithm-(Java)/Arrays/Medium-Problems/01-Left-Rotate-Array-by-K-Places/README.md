# Left Rotate Array by K Places

> **Section:** Arrays Medium  |  **Your solution file:** `LeftRotateByKPlaces.java`

## Question

```text
Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.

Example 1:
Input: nums = [1, 2, 3, 4, 5, 6], k = 2

Output: nums = [3, 4, 5, 6, 1, 2]

Explanation:

rotate 1 step to the left: [2, 3, 4, 5, 6, 1]

rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

Example 2:
Input: nums = [3, 4, 1, 5, 3, -5], k = 8

Output: nums = [1, 5, 3, -5, 3, 4]

Explanation:

rotate 1 step to the left: [4, 1, 5, 3, -5, 3]

rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]

rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]

rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]

rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]

rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]

rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]

rotate 8 steps to the left: [1, 5, 3, -5, 3, 4]
```

## Approach 1 — Brute Force

### Idea — how to think about it

**Step 0 — reduce k:** rotating by n returns the original array, so k and k % n give the same result (notes: 'K doesn't matter — d = d % n'; k=16 with n=6 is the same as 4).
Then: save the first d elements in `temp`, shift the remaining n−d elements d places to the left, and put `temp` into the last d positions.

### Pseudocode

```text
d = k % n
temp = first d elements of arr
for i = d to n-1:
    arr[i - d] = arr[i]              // shift left by d
for i = n-d to n-1:
    arr[i] = temp[i - (n - d)]       // put temp at the end
```

### Time & Space Complexity

**Time: O(n + d) ≈ O(n)**  
Copy d elements to `temp` (d) + shift n−d elements + copy d back (d) = d + (n−d) + d = n + d. Since d < n this is at most 2n → O(n).

**Space: O(d)**  
`temp` holds d elements (≤ n). (Your notes wrote O(N) in one place and O(d) in another — O(d) is the precise bound.)

## Approach 2 — Optimal

### Idea — how to think about it

**Reversal trick** — observe what a left rotation does to `[1 2 | 3 4 5 6]` with d=2 → `[3 4 5 6 | 1 2]`.
1. Reverse the first d elements: `[2 1 | 3 4 5 6]`
2. Reverse the remaining n−d elements: `[2 1 | 6 5 4 3]`
3. Reverse the whole array: `[3 4 5 6 1 2]` ✔
Reversing a block flips its internal order; reversing everything flips the blocks' order *and* undoes the internal flips, leaving each block in the original internal order but swapped in position.

### Pseudocode

```text
d = k % n
reverse(arr, 0, d - 1)
reverse(arr, d, n - 1)
reverse(arr, 0, n - 1)

reverse(arr, start, end):
    while start < end:
        swap arr[start], arr[end]
        start++ ; end--
```

### Time & Space Complexity

**Time: O(2n) = O(n)**  
Each of the three reversals touches its range once: d/2 + (n−d)/2 + n/2 swaps → n swaps ≈ 2n element moves. Linear.

**Space: O(1)**  
All swaps are in place.

## Corrections to your notes / code

- Guard `n == 0` before `k % n` (division by zero).
- Your code and notes for the reversal method are correct.

# Left Rotate Array by One

> **Section:** Arrays Easy  |  **Your solution file:** `LeftRotateByOne.java`

## Question

```text
Given an integer array nums, rotate the array to the left by one.

Note: There is no need to return anything, just modify the given array.

Example 1:
Input: nums = [1, 2, 3, 4, 5]

Output: [2, 3, 4, 5, 1]

Explanation:

Initially, nums = [1, 2, 3, 4, 5]

Rotating once to left -> nums = [2, 3, 4, 5, 1]

Example 2:
Input: nums = [-1, 0, 3, 6]

Output: [0, 3, 6, -1]

Explanation:

Initially, nums = [-1, 0, 3, 6]

Rotating once to left -> nums = [0, 3, 6, -1]
```

## Approach 1 — Brute Force

### Idea — how to think about it

Build a new array: elements 1…n−1 go to positions 0…n−2 and the first element goes to the end.

### Pseudocode

```text
res = new array of size n
for i = 1 to n-1: res[i-1] = arr[i]
res[n-1] = arr[0]
copy res back into arr
```

### Time & Space Complexity

**Time: O(n)**  
Each element copied once (twice with the copy back).

**Space: O(n)**  
Extra array of n elements.

## Approach 2 — Optimal

### Idea — how to think about it

The only element that has no place to go when everything shifts left is the **first** one, so save it in `temp`. Then shift: `arr[i-1] = arr[i]` for i = 1…n−1 (moving left to right so no value is overwritten before it has been copied). Finally put `temp` at index n−1. (Exactly your notes' diagram.)

### Pseudocode

```text
temp = arr[0]
for i = 1 to n-1:
    arr[i-1] = arr[i]
arr[n-1] = temp
```

### Time & Space Complexity

**Time: O(n)**  
One shifting loop of n−1 steps.

**Space: O(1)**  
Only `temp`. (Your notes: 'space used O(n) but extra space O(1)'.)

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

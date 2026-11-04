# Count Odd Numbers in an Array

> **Section:** Basic Arrays  |  **Your solution file:** `CountOddNumbersInArray.java`

## Question

```text
Given an array of n elements. The task is to return the count of the number of odd numbers in the array.

Example 1:
Input: n=5, array = [1,2,3,4,5]

Output: 3

Explanation: The three odd elements are (1,3,5).

Example 2:
Input: n=6, array = [1,2,1,1,5,1]

Output: 5

Explanation: The five odd elements are one 5 and four 1's.
```

> Brute force and optimal are the same: every element has to be checked once.

## Solution (brute force = optimal here)

### Idea — how to think about it

An integer is odd when `x % 2 != 0`. Walk through the array and increase a counter for each odd element.
Use `!= 0` rather than `== 1`, because in Java `-3 % 2` is `-1`, not 1 — `== 1` would miss negative odd numbers.

### Pseudocode

```text
count = 0
for i = 0 to n-1:
    if arr[i] % 2 != 0: count++
return count
```

### Time & Space Complexity

**Time: O(n)**  
One pass, n elements, constant work per element.

**Space: O(1)**  
Only `count`.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

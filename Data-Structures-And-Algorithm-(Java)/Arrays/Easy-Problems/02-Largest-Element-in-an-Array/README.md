# Largest Element in an Array

> **Section:** Arrays Easy  |  **Your solution file:** `LargestElementInArray.java`

## Question

```text
Given an array of integers nums, return the value of the largest element in the array

Example 1:
Input: nums = [3, 3, 6, 1]

Output: 6

Explanation: The largest element in array is 6

Example 2:
Input: nums = [3, 3, 0, 99, -40]

Output: 99

Explanation: The largest element in array is 99
```

> Every element could be the maximum, so each must be examined once — O(n) cannot be beaten for an unsorted array.

## Solution (brute force = optimal here)

### Idea — how to think about it

Keep a *champion*: start with the smallest possible value (`Integer.MIN_VALUE`, so any real element beats it) and compare it with every element; whenever an element is bigger, it becomes the new champion. (Alternative: start with `arr[0]`.)
Why not sort? Sorting costs O(n log n) just to read the last element.

### Pseudocode

```text
max = Integer.MIN_VALUE
for i = 0 to n-1:
    if arr[i] > max: max = arr[i]
return max
```

### Time & Space Complexity

**Time: O(n)**  
One pass; one comparison per element.

**Space: O(1)**  
One variable.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

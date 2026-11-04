# Linear Search

> **Section:** Arrays Easy  |  **Your solution file:** `LinearSearch.java`

## Question

```text
Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1

Example 1:
Input: nums = [2, 3, 4, 5, 3], target = 3

Output: 1

Explanation:

The first occurence of 3 in nums is at index 1

Example 2:
Input: nums = [2, -4, 4, 0, 10], target = 6

Output: -1

Explanation:

The value 6 does not occur in the array, hence output is -1
```

> With an unsorted array there is no shortcut: the target could be anywhere, so every element may have to be checked. (If the array were sorted, Binary Search would give O(log n).)

## Solution (brute force = optimal here)

### Idea — how to think about it

Check the elements from left to right. The question asks for the **smallest index**, so the first match is the answer — return immediately. If the loop ends, the target is absent → return −1 (your notes: target 3 appears at indices 1 and 4 → answer 1).

### Pseudocode

```text
for i = 0 to n-1:
    if nums[i] == target: return i
return -1
```

### Time & Space Complexity

**Time: O(n)**  
Worst case (target is last or missing) the loop runs n times, each iteration is one comparison.

**Space: O(1)**  
No extra storage.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

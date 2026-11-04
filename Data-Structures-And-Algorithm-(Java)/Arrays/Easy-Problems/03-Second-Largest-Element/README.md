# Second Largest Element

> **Section:** Arrays Easy  |  **Your solution file:** `SecondLargestElementInArray.java`

## Question

```text
Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

Example 1:
Input: nums = [8, 8, 7, 6, 5]

Output: 7

Explanation:

The largest value in nums is 8, the second largest is 7

Example 2:
Input: nums = [10, 10, 10, 10, 10]

Output: -1

Explanation:

The only value in nums is 10, so there is no second largest value, thus -1 is returned
```

## Approach 1 — Brute Force

### Idea — how to think about it

Sort the array in descending order, then walk from the front and return the first value that is **different from the largest**. If none exists return −1.

### Pseudocode

```text
sort(arr) in descending order
for i = 1 to n-1:
    if arr[i] != arr[0]: return arr[i]
return -1
```

### Time & Space Complexity

**Time: O(n log n)**  
Sorting dominates; the scan afterwards is O(n).

**Space: O(1) to O(n)**  
Depends on the sorting algorithm used.

## Approach 2 — Optimal

### Idea — how to think about it

Track both `max` and `secondMax` in a single pass. For every element x:
- `x > max` → the old max slides down to become `secondMax`, x becomes `max`;
- else if `x != max` and `x > secondMax` → x is the new `secondMax` (the `x != max` check stops duplicates of the maximum, e.g. [8,8,7] must give 7, not 8).
Dry run on [8,8,7,6,5] (your notes): 8 → max=8; 8 equals max → skip; 7 → second=7; 6, 5 smaller → skip. Answer 7.
If `secondMax` was never updated, there is no second largest → −1.

### Pseudocode

```text
max = MIN_VALUE ; secondMax = MIN_VALUE
for x in arr:
    if x > max:
        secondMax = max
        max = x
    else if x != max and x > secondMax:
        secondMax = x
return (secondMax == MIN_VALUE) ? -1 : secondMax
```

### Time & Space Complexity

**Time: O(n)**  
One pass, constant work per element (two comparisons).

**Space: O(1)**  
Two variables.

## Corrections to your notes / code

- **Notes:** `SMax = 0` as the starting value is wrong in principle — for an array of negatives such as `[-5,-3]` it would never be replaced correctly. Start it at `Integer.MIN_VALUE` (the final check `SMax == MIN ? -1 : SMax` already assumes that).
- Your Java works because the first element always overwrites the initial value, but fix the initial value so the logic is correct on its own.

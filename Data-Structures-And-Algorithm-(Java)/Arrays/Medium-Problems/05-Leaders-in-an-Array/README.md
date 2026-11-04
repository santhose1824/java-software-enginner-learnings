# Leaders in an Array

> **Section:** Arrays Medium  |  **Your solution file:** `LeaderOfAnArray.java`

## Question

```text
Given an integer array nums, return a list of all the leaders in the array.

A leader in an array is an element whose value is strictly greater than all elements to its right in the given array. The rightmost element is always a leader. The elements in the leader array must appear in the order they appear in the nums array.

Example 1:
Input: nums = [1, 2, 5, 3, 1, 2]

Output: [5, 3, 2]

Explanation:

2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]

Example 2:
Input: nums = [-3, 4, 5, 1, -4, -5]

Output: [5, 1, -4, -5]

Explanation:

-5 is the rightmost element, -4 is the largest element in the index range [4, 5], 1 is the largest element in the index range [3, 5] and 5 is the largest element in the range [2, 5]
```

## Approach 1 — Brute Force

### Idea — how to think about it

An element is a leader if **every** element to its right is strictly smaller. For each i, check all elements after it; if none is ≥ arr[i], add it. (The last element is always a leader.)

### Pseudocode

```text
ans = []
for i = 0 to n-1:
    leader = true
    for j = i+1 to n-1:
        if arr[j] >= arr[i]: leader = false ; break
    if leader: ans.add(arr[i])
return ans
```

### Time & Space Complexity

**Time: O(n²)**  
For each of the n elements we may scan the elements to its right: (n−1)+(n−2)+…+0 ≈ n²/2.

**Space: O(n) for the answer**  
Only leaders are stored.

## Approach 2 — Optimal

### Idea — how to think about it

Look from the **right**. The last element is always a leader. Moving left, an element is a leader exactly when it is **bigger than the maximum seen so far on its right**. So keep `max` (initially the minimum possible value), scan from n−1 down to 0, and whenever `arr[i] > max` add it and update `max`. The leaders come out right-to-left, so reverse the list at the end to restore the original order.

### Pseudocode

```text
max = MIN_VALUE ; ans = []
for i = n-1 down to 0:
    if arr[i] > max:
        ans.add(arr[i])
        max = arr[i]
reverse(ans)
return ans
```

### Time & Space Complexity

**Time: O(n)**  
One right-to-left pass (n) + one reversal of at most n elements (≤ n) = O(n).

**Space: O(n) for the answer, O(1) extra**  
Only `max` besides the answer list.

## Corrections to your notes / code

- **Wrong complexity in the notes:** the optimal approach is listed as 'TC: O(N log N)'. Nothing here is a sort — the pass is O(n) and the reversal is O(n), so the total is **O(n)**.
- **Notes (brute force):** the pseudocode adds `arr[i]` when `arr[i] > arr[j]` for *some* j — it must hold for **all** j to its right (use a `leader` flag and break at the first `arr[j] >= arr[i]`).

# Check if Array is Sorted (Ascending)

> **Section:** Basic Arrays  |  **Your solution file:** `CheckIfArrayIsSorted.java`

## Question

```text
Given an array arr of size n, the task is to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order. If the array is sorted then return True, else return False.

Example 1:
Input: n = 5, arr = [1,2,3,4,5]

Output: True

Explanation: The given array is sorted i.e Every element in the array is smaller than or equals to its next values, So the answer is True.

Example 2:
Input: n = 5, arr = [5,4,6,7,8]

Output: False

Explanation: The given array is Not sorted i.e Every element in the array is not smaller than or equal to its next values, So the answer is False. Here element 5 is not smaller than or equal to its future elements.
```

> Brute force and optimal are the same: any single adjacent pair could be out of order, so all n−1 pairs must be checked.

## Solution (brute force = optimal here)

### Idea — how to think about it

An array is sorted exactly when **no element is smaller than the one before it**. So compare each element with its left neighbour; the first time `arr[i] < arr[i-1]` we can stop and answer `false`.
We never need to compare non-neighbours — if every neighbouring pair is in order, the whole chain is in order (transitivity).

### Pseudocode

```text
for i = 1 to n-1:
    if arr[i] < arr[i-1]: return false
return true
```

### Time & Space Complexity

**Time: O(n)**  
Worst case (array is sorted) we compare all n−1 adjacent pairs. Best case it stops at the first pair (O(1)), but Big-O describes the worst case.

**Space: O(1)**  
No extra storage.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

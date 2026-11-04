# Rearrange Array Elements by Sign

> **Section:** Arrays Medium  |  **Your solution file:** `RearrangeElementsBySign.java`

## Question

```text
Given an integer array nums of even length consisting of an equal number of positive and negative integers.Return the answer array in such a way that the given conditions are met:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Example 1:
Input : nums = [2, 4, 5, -1, -3, -4]

Output : [2, -1, 4, -3, 5, -4]

Explanation:

The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions

Example 2:
Input : nums = [1, -1, -3, -4, 2, 3]

Output : [1, -1, 2, -3, 3, -4]

Explanation:

The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions
```

## Approach 1 — Brute Force

### Idea — how to think about it

Split the array into two lists (positives, negatives — each keeps the original order). The answer alternates: positives go to even indices (0,2,4…), negatives to odd indices (1,3,5…).

### Pseudocode

```text
pos = [] ; neg = []
for x in nums:
    if x > 0: pos.add(x) else neg.add(x)
for i = 0 to n/2 - 1:
    nums[2*i]     = pos[i]
    nums[2*i + 1] = neg[i]
```

### Time & Space Complexity

**Time: O(n) (≈ 2n)**  
One pass to split (n) + one pass to merge back (n/2 iterations writing 2 values = n) → 2n.

**Space: O(n)**  
`pos` and `neg` together hold n values.

## Approach 2 — Optimal

### Idea — how to think about it

We already know **where** every element must go: the k-th positive lands at index 2k, the k-th negative at index 2k+1 (equal numbers of each guarantee it fits). So skip the lists: keep two write indices, `posIdx = 0` and `negIdx = 1`, read the array once, and drop each element straight into a new answer array at its own index, then advance that index by 2.

### Pseudocode

```text
ans = new array of size n
posIdx = 0 ; negIdx = 1
for i = 0 to n-1:
    if nums[i] < 0:
        ans[negIdx] = nums[i] ; negIdx += 2
    else:
        ans[posIdx] = nums[i] ; posIdx += 2
return ans
```

### Time & Space Complexity

**Time: O(n)**  
One pass; each element is placed in O(1).

**Space: O(n)**  
The answer array. (An in-place O(1) version that also keeps the relative order is not possible in O(n) time, so O(n) is the accepted bound.)

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

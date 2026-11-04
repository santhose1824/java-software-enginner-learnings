# Maximum Consecutive Ones

> **Section:** Arrays Easy  |  **Your solution file:** `MaximumConsecutiveOnes.java`

## Question

```text
Given a binary array nums, return the maximum number of consecutive 1s in the array.

A binary array is an array that contains only 0s and 1s.

Example 1:
Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]

Output: 3

Explanation:

The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s

Example 2:
Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]

Output: 0

Explanation:

No 1s are present in nums, thus we return 0
```

## Approach 1 — Brute Force

### Idea — how to think about it

Start a run at every position that holds a 1 and extend it to the right while the next elements are 1; remember the longest run.

### Pseudocode

```text
best = 0
for i = 0 to n-1:
    if nums[i] == 1:
        j = i
        while j < n and nums[j] == 1: j++
        best = max(best, j - i)
return best
```

### Time & Space Complexity

**Time: O(n²) worst case**  
For an array of all ones every start index re-walks the rest of the array: n + (n−1) + … + 1 ≈ n²/2.

**Space: O(1)**  
Counters only.

## Approach 2 — Optimal

### Idea — how to think about it

One pass with a running `count`: a 1 extends the current run (`count++`), a 0 ends it (`count = 0`). **Update the maximum every time you see a 1** (`max = max(max, count)`).
Your notes first updated `max` only when a 0 appeared and then noticed the flaw — a run that ends at the *end of the array* (no 0 after it) would never be recorded. Updating on every 1 fixes that.

### Pseudocode

```text
count = 0 ; max = 0
for i = 0 to n-1:
    if nums[i] == 1:
        count++
        max = max(max, count)
    else:
        count = 0
return max
```

### Time & Space Complexity

**Time: O(n)**  
Each element is visited once.

**Space: O(1)**  
`count` and `max`.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

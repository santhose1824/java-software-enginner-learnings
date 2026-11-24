# Majority Element (> n/2)

> **Section:** Arrays Medium  |  **Your solution file:** `MajortyElementI.java`

## Question

```text
Given an integer array nums of size n, return the majority element of the array.

The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.

Example 1:
Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]

Output: 7

Explanation:

The number 7 appears 5 times in the 9 sized array

Example 2:
Input: nums = [1, 1, 1, 2, 1, 2]

Output: 1

Explanation:

The number 1 appears 4 times in the 6 sized array
```

## Approach 1 — Brute Force

### Idea — how to think about it

Pick each element and count how many times it occurs in the whole array; the first one whose count is **greater than n/2** is the majority element. (A middle option is a HashMap of counts: O(n) time but O(n) space.)

### Pseudocode

```text
for i = 0 to n-1:
    c = 0
    for j = 0 to n-1:
        if arr[j] == arr[i]: c++
    if c > n / 2: return arr[i]
```

### Time & Space Complexity

**Time: O(n²)**  
n choices × an O(n) count for each.

**Space: O(1)**  
A counter.

## Approach 2 — Optimal

### Idea — how to think about it

**Moore's Voting Algorithm.** Imagine every element votes for itself. Whenever two *different* elements meet they cancel each other out. The majority element appears more than n/2 times, so it has more votes than all other elements combined and **cannot be fully cancelled** — it is the one left standing.
Implementation: keep a `candidate` and a `count`. If `count == 0` take the current element as the new candidate (count = 1); else if the element equals the candidate `count++`; otherwise `count--`.
Because the candidate is only guaranteed when a majority exists, **verify** it by counting (notes: 'step 2 – verify it is greater than n/2 times'; if it is not, return −1).

### Pseudocode

```text
count = 0 ; el = none
for i = 0 to n-1:
    if count == 0:            count = 1 ; el = nums[i]
    else if nums[i] == el:    count++
    else:                     count--
// verify
c = 0
for i = 0 to n-1:
    if nums[i] == el: c++
return (c > n / 2) ? el : -1
```

### Time & Space Complexity

**Time: O(n)**  
First pass: n steps. Verification pass: n steps. 2n → O(n).

**Space: O(1)**  
`count`, `el`, `c`.

## Corrections to your notes / code

- **Code bug:** your verification uses `count >= n/2`; a majority needs **strictly more** than n/2 (`> n/2`) — your notes have `>`. E.g. `[1,2]` has no majority but `>=` would accept it.

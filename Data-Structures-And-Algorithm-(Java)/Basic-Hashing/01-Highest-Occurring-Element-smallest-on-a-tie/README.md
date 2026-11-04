# Highest Occurring Element (smallest on a tie)

> **Section:** Basic Hashing  |  **Your solution file:** `HighestoccuringElementInAnArray.java`

## Question

```text
Given an array nums of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. If there are multiple elements that appear a maximum number of times, find the smallest of them.

Please note that this section might seem a bit difficult without prior knowledge on what hashing is, we will soon try to add basics concepts for your ease! If you know the concepts already please go ahead to give a shot to the problem. Cheers!

Example 1:
Input: nums = [1, 2, 2, 3, 3, 3]

Output: 3

Explanation: The number 3 appears the most (3 times). It is the most frequent element.

Example 2:
Input: nums = [4, 4, 5, 5, 6]

Output: 4

Explanation: Both 4 and 5 appear twice, but 4 is smaller. So, 4 is the most frequent element
```

## Approach 1 — Brute Force

### Idea — how to think about it

For every element, scan the whole array and count how many times it appears; remember the element with the biggest count (smaller value wins ties). It works but repeats the same counting again and again for equal elements.

### Pseudocode

```text
bestElement = arr[0] ; bestCount = 0
for i = 0 to n-1:
    c = 0
    for j = 0 to n-1:
        if arr[j] == arr[i]: c++
    if c > bestCount or (c == bestCount and arr[i] < bestElement):
        bestCount = c ; bestElement = arr[i]
return bestElement
```

### Time & Space Complexity

**Time: O(n²)**  
The outer loop picks each of the n elements; for each one the inner loop scans all n elements → n × n comparisons.

**Space: O(1)**  
No extra storage.

## Approach 2 — Optimal

### Idea — how to think about it

The slow part is re-counting. Count **once** by storing `element → frequency` in a hash map: look up the element, add 1. (Notes: `map.put(x, map.getOrDefault(x,0)+1)`.)
Then one pass over the map finds the maximum frequency. A hash map lookup/insert is O(1) on average, so the whole thing becomes linear.
Tie rule: when two elements have the same frequency, keep the **smaller** element.

### Pseudocode

```text
map = empty HashMap
for x in arr:
    map[x] = map.getOrDefault(x, 0) + 1
bestElement = none ; bestCount = 0
for (key, freq) in map:
    if freq > bestCount or (freq == bestCount and key < bestElement):
        bestCount = freq ; bestElement = key
return bestElement
```

### Time & Space Complexity

**Time: O(n) average**  
Building the map: n elements × O(1) average per put/get = O(n). Scanning the map: at most n distinct keys = O(n). Total O(n). (Worst case O(n²) with many hash collisions in theory — as your notes say 'O(1) best/average, O(N) worst' per operation; Java 8+ trees buckets, giving O(log n) worst per op.)

**Space: O(n)**  
In the worst case all elements are distinct, so the map holds n entries.

## Corrections to your notes / code

- **Missing tie-break in the code:** you only test `val > maxValue`. For `[4,4,5,5,6]` the answer must be 4 (the smaller). Your run happened to print 4 only because `HashMap` iterates small integer keys in ascending order — that is not guaranteed in general. Add `|| (val == maxValue && key < result)`.
- Alternative: use `TreeMap` (sorted keys) and a strict `>` comparison; the first key reaching the max is then automatically the smallest.

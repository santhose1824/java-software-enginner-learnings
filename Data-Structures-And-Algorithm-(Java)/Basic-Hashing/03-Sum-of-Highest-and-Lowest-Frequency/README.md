# Sum of Highest and Lowest Frequency

> **Section:** Basic Hashing  |  **Your solution file:** `SumOfHighestAndLowestFrequency.java`

## Question

```text
Given an array of n integers, find the sum of the frequencies of the highest occurring number and lowest occurring number.

Example 1:
Input: arr = [1, 2, 2, 3, 3, 3]

Output: 4

Explanation: The highest frequency is 3 (element 3), and the lowest frequency is 1 (element 1). Their sum is 3 + 1 = 4.

Example 2:
Input: arr = [4, 4, 5, 5, 6]

Output: 3

Explanation: The highest frequency is 2 (elements 4 and 5), and the lowest frequency is 1 (element 6). Their sum is 2 + 1 = 3.
```

## Approach 1 — Brute Force

### Idea — how to think about it

For each element count how often it appears (scan the array), track the maximum and minimum count, add them.

### Pseudocode

```text
maxF = 0 ; minF = n
for i = 0 to n-1:
    c = count of arr[i] in arr     // inner scan
    maxF = max(maxF, c) ; minF = min(minF, c)
return maxF + minF
```

### Time & Space Complexity

**Time: O(n²)**  
n elements × an O(n) count each.

**Space: O(1)**  
Two integers.

## Approach 2 — Optimal

### Idea — how to think about it

Count once with a hash map, then look only at the frequency values: `maxFreq = max(freq)`, `minFreq = min(freq)`. The answer is their sum (your notes: `Math.max(freq, maxFreq)`, `Math.min(freq, minFreq)`). Start `minFreq` at a very large value (n or Integer.MAX_VALUE), `maxFreq` at 0.

### Pseudocode

```text
build map x -> freq
maxF = 0 ; minF = infinity
for each freq f in map:
    maxF = max(maxF, f)
    minF = min(minF, f)
return maxF + minF
```

### Time & Space Complexity

**Time: O(n)**  
Map build O(n); a pass over ≤ n frequencies O(n).

**Space: O(n)**  
Map of up to n distinct values.

## Corrections to your notes / code

- Edge case: if all elements are equal (single key), max = min = n, so the answer is 2n — that is correct by the definition, just be aware.

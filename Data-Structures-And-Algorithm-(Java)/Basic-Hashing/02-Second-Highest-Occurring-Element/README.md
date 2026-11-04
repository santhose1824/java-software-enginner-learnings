# Second Highest Occurring Element

> **Section:** Basic Hashing  |  **Your solution file:** `SecondHighestOccuringElementInAnArray.java`

## Question

```text
Given an array of n integers, find the second most frequent element in it.

If there are multiple elements that appear second most frequent times, find the smallest of them.

If second most frequent element does not exist return -1.

Example 1:
Input: arr = [1, 2, 2, 3, 3, 3]

Output: 2

Explanation:

The number 2 appears the second most (2 times) and number 3 appears the most(3 times). 

Example 2:
Input: arr = [4, 4, 5, 5, 6, 7]

Output: 6

Explanation:

Both 6 and 7 appear second most times, but 6 is smaller.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Count each element's frequency by scanning (O(n) per element). Then find the largest frequency, and next find the largest frequency that is **strictly smaller** than it.

### Pseudocode

```text
compute freq[i] for each i by scanning the array     // n × n
maxF = max of freq
secondF = max of all freq values that are < maxF
pick the smallest element whose freq == secondF
if no such element: return -1
```

### Time & Space Complexity

**Time: O(n²)**  
Counting by scanning costs n for each of n elements.

**Space: O(n)**  
Frequency values stored per element.

## Approach 2 — Optimal

### Idea — how to think about it

Build the same frequency map as in the previous problem (O(n)). Then do the *second-largest* trick from the Arrays section on the **frequency values**: keep `maxFreq` and `secondFreq`.
- A frequency bigger than `maxFreq` → old max becomes second, new value becomes max.
- A frequency strictly between `secondFreq` and `maxFreq` → becomes second.
- (Notes: `secondMax > Max` is impossible; equal frequencies must NOT become second — check `freq < maxFreq`.)
Finally return the (smallest) element having `secondFreq`, or −1 if every element has the same frequency.

### Pseudocode

```text
build map x -> freq
maxF = 0 ; secondF = 0
for each freq f in map:
    if f > maxF:   secondF = maxF ; maxF = f
    else if f < maxF and f > secondF: secondF = f
if secondF == 0 return -1
answer = smallest key whose frequency == secondF
return answer
```

### Time & Space Complexity

**Time: O(n)**  
Map build O(n) + one pass over ≤ n map entries to track the two largest frequencies + one more pass to pick the element = O(n).

**Space: O(n)**  
Map with up to n distinct elements.

## Corrections to your notes / code

- **Confirmed bug:** for `[1,1,1]` (only one distinct frequency) your code prints `0`; the answer must be `-1`.
- Ties for second place must return the smaller element — as in problem 1, your code does not tie-break.

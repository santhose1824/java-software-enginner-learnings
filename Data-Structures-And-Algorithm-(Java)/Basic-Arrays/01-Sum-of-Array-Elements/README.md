# Sum of Array Elements

> **Section:** Basic Arrays  |  **Your solution file:** `SumOfElementsInArray.java`

## Question

```text
Given an array arr of size n, the task is to find the sum of all the elements in the array.

Example 1:
Input: n=5, arr = [1,2,3,4,5]

Output: 15

Explanation: Sum of all the elements is 1+2+3+4+5 = 15

Example 2:
Input: n=6, arr = [1,2,1,1,5,1]

Output: 11

Explanation: Sum of all the elements is 1+2+1+1+5+1 = 11
```

> Brute force and optimal are the same: the answer depends on every element, so each element must be read once.

## Solution (brute force = optimal here)

### Idea — how to think about it

Think of a running total. Start with `sum = 0` (adding nothing changes nothing), visit each element once and add it.
Nothing can be skipped, because changing any single element changes the answer — so no algorithm can do better than looking at all n elements.

### Pseudocode

```text
sum = 0
for i = 0 to n-1:
    sum = sum + arr[i]
return sum
```

### Time & Space Complexity

**Time: O(n)**  
The loop body runs once per element = n times, each addition is constant time.

**Space: O(1)**  
One variable `sum`; the input array is not copied.

## Corrections to your notes / code

- Overflow: if the values are large (e.g. 10⁹ each) use `long sum`. Your notes already point this out for the missing-number problem; the same applies here.

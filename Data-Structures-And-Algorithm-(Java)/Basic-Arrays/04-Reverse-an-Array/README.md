# Reverse an Array

> **Section:** Basic Arrays  |  **Your solution file:** `ReverseAnArray.java`

## Question

```text
Given an array arr of n elements. The task is to reverse the given array. The reversal of array should be inplace.

Example 1:
Input: n=5, arr = [1,2,3,4,5]

Output: [5,4,3,2,1]

Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]

Example 2:
Input: n=6, arr = [1,2,1,1,5,1]

Output: [1,5,1,1,2,1]

Explanation: The reverse of the array [1,2,1,1,5,1] is [1,5,1,1,2,1].
```

## Approach 1 — Brute Force

### Idea — how to think about it

Make a new array and fill it from the back: `rev[i] = arr[n-1-i]`. Simple and obviously correct, but it needs a second array of the same size.

### Pseudocode

```text
rev = new array of size n
for i = 0 to n-1:
    rev[i] = arr[n-1-i]
return rev
```

### Time & Space Complexity

**Time: O(n)**  
n elements copied once.

**Space: O(n)**  
The extra array `rev` has n elements.

## Approach 2 — Optimal

### Idea — how to think about it

Reversing means the first element swaps with the last, the second with the second-last, and so on. So put **one pointer at each end** and swap while they move towards each other. When they meet in the middle (start ≥ end) everything is done — that is why we only run n/2 swaps. (Your notes show the 5-element dry run: swaps (0,4) and (1,3); index 2 stays.)

### Pseudocode

```text
start = 0
end = n - 1
while start < end:
    temp = arr[start]
    arr[start] = arr[end]
    arr[end] = temp
    start++
    end--
```

### Time & Space Complexity

**Time: O(n)**  
Each iteration fixes two elements, so the loop runs n/2 times. Dropping the constant ½ gives O(n).

**Space: O(1)**  
Reversal is done in place — only the variable `temp` is extra. (Your notes' remark: 'space used O(n), extra space O(1)'.)

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

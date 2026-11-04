# Largest Digit in a Number

> **Section:** Basic Maths  |  **Your solution file:** `ReturnLargestDigit.java`

## Question

```text
You are given an integer n. Return the largest digit present in the number.

Example 1:
Input: n = 25

Output: 5

Explanation: The largest digit in 25 is 5.

Example 2:
Input: n = 99

Output: 9

Explanation: The largest digit in 99 is 9.
```

> Brute force and optimal are the same: every digit must be inspected once.

## Solution (brute force = optimal here)

### Idea — how to think about it

Extract each digit with `% 10`, keep a running maximum, and drop the digit with `/ 10`.
This is the *maximum-so-far* pattern: start `large = 0` (the smallest possible digit) and replace it whenever a bigger digit appears.

### Pseudocode

```text
large = 0
while n > 0:
    digit = n % 10
    if digit > large: large = digit
    n = n / 10
return large
```

### Time & Space Complexity

**Time: O(log10 n)**  
One iteration per digit; each iteration does constant work.

**Space: O(1)**  
Two variables.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

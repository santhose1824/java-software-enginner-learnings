# Palindrome Number

> **Section:** Basic Maths  |  **Your solution file:** `PalindromeOfGivenNumber.java`

## Question

```text
You are given an integer n. You need to check whether the number is a palindrome number or not. Return true if it's a palindrome number, otherwise return false.

A palindrome number is a number which reads the same both left to right and right to left.

Example 1:
Input: n = 121

Output: true

Explanation: When read from left to right : 121.

When read from right to left : 121.

Example 2:
Input: n = 123

Output: false

Explanation: When read from left to right : 123.

When read from right to left : 321.
```

## Approach 1 — Brute Force

### Idea — how to think about it

A palindrome reads the same both ways, so compare the number with its reverse.
Reuse *Reverse a Number*. Important point from your notes: the `while` loop destroys n, so **save the original in a copy first**, then compare.

### Pseudocode

```text
copy = n
reverse = 0
while n > 0:
    reverse = reverse * 10 + n % 10
    n = n / 10
return copy == reverse
```

### Time & Space Complexity

**Time: O(log10 n)**  
Reversing visits every digit once; digits ≈ log10(n).

**Space: O(1)**  
Only integers `copy`, `reverse`.

## Approach 2 — Optimal

### Idea — how to think about it

A palindrome is symmetric, so we only need to reverse **half** of the digits and compare it with the other half.
Keep removing the last digit of n and pushing it into `half` until `half >= n` (we have passed the middle).
Then n == half (even length) or n == half/10 (odd length — the middle digit is ignored).
Benefit: half the work and the reversed value can never overflow.

### Pseudocode

```text
if n < 0 or (n % 10 == 0 and n != 0) return false
half = 0
while n > half:
    half = half * 10 + n % 10
    n = n / 10
return n == half or n == half / 10
```

### Time & Space Complexity

**Time: O(log10 n)**  
The loop runs for half the digits = (log10 n)/2 iterations. Constants are dropped in Big-O, so asymptotically it is the same as the brute force, just about 2× faster.

**Space: O(1)**  
Only `half` and `n`.

## Corrections to your notes / code

- Your notes give TC O(log10 n) and SC O(1) — correct.
- Negative numbers: your code returns `false` (the loop is skipped, reverse = 0 ≠ n) which is the expected answer.

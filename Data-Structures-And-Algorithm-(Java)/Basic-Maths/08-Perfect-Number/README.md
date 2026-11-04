# Perfect Number

> **Section:** Basic Maths  |  **Your solution file:** `PerfectNumber.java`

## Question

```text
You are given an integer n. You need to check if the number is a perfect number or not. Return true if it is a perfect number, otherwise, return false.

A perfect number is a number whose proper divisors (excluding the number itself) add up to the number itself.

Example 1:
Input: n = 6

Output: true

Explanation: Proper divisors of 6 are 1, 2, 3.

1 + 2 + 3 = 6.

Example 2:
Input: n = 4

Output: false

Explanation: Proper divisors of 4 are 1, 2.

1 + 2 = 3.
```

## Approach 1 — Brute Force

### Idea — how to think about it

A perfect number equals the sum of its proper divisors (6 = 1+2+3). Direct translation: try every number from 1 to n−1, add those that divide n, compare with n.

### Pseudocode

```text
sum = 0
for i = 1 to n-1:
    if n % i == 0: sum += i
return sum == n
```

### Time & Space Complexity

**Time: O(n)**  
The loop tries every i from 1 to n−1 → about n iterations, each one a constant-time `%` and add.

**Space: O(1)**  
Just `sum`.

## Approach 2 — Optimal

### Idea — how to think about it

Look at the divisors of 36 in your notes: (1,36) (2,18) (3,12) (4,9) (6,6). **Divisors come in pairs** (i, n/i), and after √n the pairs just repeat in reverse.
So we only search i up to √n and add *both* members of each pair (add only once when i = n/i, e.g. 6 for 36).
Start `sum = 1` because 1 is always a proper divisor, and n itself is not allowed (so the pair (1, n) contributes only 1).

### Pseudocode

```text
if n <= 1 return false
sum = 1
for i = 2 while i * i <= n:
    if n % i == 0:
        sum += i
        if i != n / i: sum += n / i
return sum == n
```

### Time & Space Complexity

**Time: O(√n)**  
The loop stops when i·i > n, i.e. after √n iterations. Example: n = 1,000,000 needs only 1,000 checks instead of 1,000,000.

**Space: O(1)**  
Only `sum`.

## Corrections to your notes / code

- Your Java file only contains the brute-force O(N) loop; the O(√N) version is in your notes and is shown above.
- **Bug in the notes' pseudocode:** with `sum = 1` the answer for **n = 1** comes out as `true` (sum 1 == n 1), but 1 is *not* a perfect number (it has no proper divisors). Add `if n <= 1 return false`.
- Write the loop condition as `i * i <= n` instead of recomputing `Math.sqrt(n)` every iteration.

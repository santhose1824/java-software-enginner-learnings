# Prime Number Check

> **Section:** Basic Maths  |  **Your solution file:** `PrimeNumberOrNot.java`

## Question

```text
You are given an integer n. You need to check if the number is prime or not. Return true if it is a prime number, otherwise return false.

A prime number is a number which has no divisors except 1 and itself.

Example 1:
Input: n = 5

Output: true

Explanation: The only divisors of 5 are 1 and 5 , So the number 5 is prime.

Example 2:
Input: n = 8

Output: false

Explanation: The divisors of 8 are 1, 2, 4, 8, thus it is not a prime number.
```

## Approach 1 — Brute Force

### Idea — how to think about it

A prime has exactly two divisors: 1 and itself. So check every number from 2 to n−1; if any divides n, it is not prime.

### Pseudocode

```text
if n <= 1 return false
for i = 2 to n-1:
    if n % i == 0: return false
return true
```

### Time & Space Complexity

**Time: O(n)**  
Worst case (n is prime) every i from 2 to n−1 is tried → ~n iterations.

**Space: O(1)**  
No extra storage.

## Approach 2 — Optimal

### Idea — how to think about it

If n = a × b then one of a, b must be ≤ √n (if both were bigger, a×b would exceed n). So if n has any divisor at all, it has one in [2, √n].
That means it is enough to test i = 2 … √n. For n = 36 that is 2…6 instead of 2…35.

### Pseudocode

```text
if n <= 1 return false
for i = 2 while i * i <= n:
    if n % i == 0: return false
return true
```

### Time & Space Complexity

**Time: O(√n)**  
The loop stops at i = √n. For a prime n=1,000,003 that is ~1,000 iterations rather than 1,000,003.

**Space: O(1)**  
No extra storage.

## Corrected Java

```java
static boolean isPrime(int n) {
    if (n <= 1) return false;            // 0, 1, negatives
    for (int i = 2; (long) i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}
```

## Corrections to your notes / code

- **Code bug (confirmed by running it):** `PrimeNumberOrNot(1)` prints *Prime*. 1 is not prime — your notes have `if(n==1) false` but the Java loses it. Use `n <= 1` (also covers 0 and negatives).
- Use `i * i <= n` rather than `i <= Math.sqrt(n)` computed each loop.

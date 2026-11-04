# Count Primes up to N

> **Section:** Basic Maths  |  **Your solution file:** `CountAllPrimeNumberUptoN.java`

## Question

```text
You are given an integer n. You need to find out the number of prime numbers in the range [1, n] (inclusive). Return the number of prime numbers in the range.

A prime number is a number which has no divisors except, 1 and itself.

Example 1:
Input: n = 6

Output: 3

Explanation: Prime numbers in the range [1, 6] are 2, 3, 5.

Example 2:
Input: n = 10

Output: 4

Explanation: Prime numbers in the range [1, 10] are 2, 3, 5, 7.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Reuse the prime check: go through every number 2…N, test it with the √ prime check, and count the primes.

### Pseudocode

```text
count = 0
for i = 2 to N:
    if isPrime(i): count++      // isPrime is the O(√i) check
return count
```

### Time & Space Complexity

**Time: O(N · √N)**  
The outer loop runs N times and each call to isPrime costs up to √i ≤ √N steps. N × √N.

**Space: O(1)**  
Only a counter.

## Approach 2 — Optimal

### Idea — how to think about it

**(Not in your notes — added as the real optimal answer.)** Testing every number separately wastes work. The *Sieve of Eratosthenes* flips the question: instead of asking "is i prime?", start from a prime p and **cross out all its multiples** (2p, 3p, 4p, …). Whatever is never crossed out is prime.
Optimisation: for prime p start crossing at p·p (smaller multiples were already crossed by smaller primes), and stop when p·p > N.

### Pseudocode

```text
isPrime[0..N] = true ; isPrime[0] = isPrime[1] = false
for p = 2 while p * p <= N:
    if isPrime[p]:
        for m = p * p; m <= N; m += p:
            isPrime[m] = false
return number of true values in isPrime
```

### Time & Space Complexity

**Time: O(N log log N)**  
For each prime p the inner loop crosses off about N/p numbers. The total is N·(1/2 + 1/3 + 1/5 + 1/7 + …) — the sum of 1/p over primes up to N — which grows like log log N. So the work is N · log log N, which is almost linear (for N = 10⁷ it is only ~3× N).

**Space: O(N)**  
We store one boolean per number 0…N in the `isPrime` array.

## Corrections to your notes / code

- Your notes only contain the brute-force version (O(N·√N)). The Sieve above is the optimal solution and is worth adding to your Java file.

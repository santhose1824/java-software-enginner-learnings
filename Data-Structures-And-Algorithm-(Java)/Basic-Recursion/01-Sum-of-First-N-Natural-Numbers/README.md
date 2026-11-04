# Sum of First N Natural Numbers

> **Section:** Basic Recursion  |  **Your solution file:** `SumOfFirstNNumbers.java`

## Question

```text
Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.

Example 1:
Input : N = 4

Output : 10

Explanation : first four natural numbers are 1, 2, 3, 4.

Sum is 1 + 2 + 3 + 4 => 10.

Example 2:
Input : N = 2

Output : 3

Explanation : first two natural numbers are 1, 2.

Sum is 1 + 2 => 3.
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

Sum(N) = N + Sum(N−1). The smallest case is Sum(0) = 0 (nothing to add), which is the base condition. Dry run of N=4 (as in your notes): 4 + (3 + (2 + (1 + 0))) = 10. The additions happen while the stack *unwinds* (return N + f(N−1)).

### Pseudocode

```text
sum(N):
    if N == 0: return 0
    return N + sum(N - 1)
```

### Time & Space Complexity

**Time: O(N)**  
Each call does one addition and makes one call with N−1, so there are N+1 calls in total (N, N−1, … 0). The recursion tree is a straight line of length N.

**Space: O(N)**  
Each pending call stays on the call stack until the base case returns, so N frames exist at the deepest point (your notes: 'recursive stack space').

## Approach 2 — Optimal

### Idea — how to think about it

Pair the numbers: 1+N, 2+(N−1), 3+(N−2) … each pair adds to N+1 and there are N/2 pairs. So the sum is **N(N+1)/2**. No loop, no recursion. (Gauss's trick.)

### Pseudocode

```text
return N * (N + 1) / 2
```

### Time & Space Complexity

**Time: O(1)**  
One multiplication, one addition, one division — independent of N.

**Space: O(1)**  
No recursion, no extra storage.

## Corrections to your notes / code

- Overflow: for N around 65,000 the sum no longer fits in `int`; use `long` (and `(long)N*(N+1)/2`).

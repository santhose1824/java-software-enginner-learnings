# Factorial using Recursion

> **Section:** Basic Recursion  |  **Your solution file:** `FactorialOfGivenNumber.java`

## Question

```text
Given an integer n, return the factorial of n.

Factorial of a non-negative integer, is the multiplication of all integers smaller than or equal to n (use 64-bits to return answer).

Example 1:
Input : n = 3

Output : 6

Explanation : Factorial = 1 * 2 * 3 => 6

Example 2:
Input : n = 5

Output : 120

Explanation : Factorial = 1 * 2 * 3 * 4 * 5 => 120
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

n! = n × (n−1)!, and 0! = 1 is the base case (1! also stops the recursion). Your notes' dry run: fact(3) = 3 × fact(2) = 3 × (2 × fact(1)) = 3×2×1 = 6.

### Pseudocode

```text
fact(n):
    if n == 0 or n == 1: return 1
    return n * fact(n - 1)
```

### Time & Space Complexity

**Time: O(n)**  
A chain of n calls, each doing one multiplication.

**Space: O(n)**  
n frames wait on the call stack before the first one can return.

## Approach 2 — Optimal

### Idea — how to think about it

The same result can be computed with a simple loop — no stack frames are needed, only a running product (see the Maths section).

### Pseudocode

```text
fact = 1
for i = 2 to n:
    fact = fact * i
return fact
```

### Time & Space Complexity

**Time: O(n)**  
n multiplications.

**Space: O(1)**  
Only `fact` and `i` — no recursion stack.

## Corrections to your notes / code

- Use `long` as the return type (the question says '64-bit'): `int` overflows at 13!.
- Time stays O(n) in both versions; what improves is the **space** (O(n) → O(1)).

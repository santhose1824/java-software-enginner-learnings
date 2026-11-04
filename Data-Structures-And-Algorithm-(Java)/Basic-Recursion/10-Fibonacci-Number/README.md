# Fibonacci Number

> **Section:** Basic Recursion  |  **Your solution file:** `FibonacciSeries.java`

## Question

```text
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:
Input : n = 2

Output : 1

Explanation : F(2) = F(1) + F(0) => 1 + 0 => 1.

Example 2:
Input : n = 3

Output : 2

Explanation : F(3) = F(2) + F(1) => 1 + 1 => 2.
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

F(n) = F(n−1) + F(n−2), with base cases F(0)=0 and F(1)=1. Your notes draw the recursion tree: F(3) → F(2)+F(1) → (F(1)+F(0)) + 1 … Notice **F(2) and F(1) are computed again and again** — that waste is what makes it slow.

### Pseudocode

```text
fib(n):
    if n == 0 return 0
    if n == 1 return 1
    return fib(n - 1) + fib(n - 2)
```

### Time & Space Complexity

**Time: O(2ⁿ)**  
Every call makes two more calls, so the recursion tree roughly doubles at each level. A tree of depth n with up to 2 children per node has about 2ⁿ nodes (the exact bound is φⁿ ≈ 1.618ⁿ, still exponential).

**Space: O(n)**  
The deepest path goes fib(n) → fib(n−1) → … → fib(1): n frames. The two branches are not on the stack at the same time.

## Approach 2 — Optimal

### Idea — how to think about it

The same sub-problems repeat, so **never compute the same F(k) twice**. Walk upwards from the bottom, keeping only the last two values: `prev = F(0)`, `curr = F(1)`, and each step makes the next Fibonacci number. (Memoising the recursion also gives O(n), but the loop uses O(1) space.)

### Pseudocode

```text
if n <= 1 return n
prev = 0 ; curr = 1
for i = 2 to n:
    next = prev + curr
    prev = curr
    curr = next
return curr
```

### Time & Space Complexity

**Time: O(n)**  
The loop runs n−1 times and each step is one addition.

**Space: O(1)**  
Just `prev`, `curr`, `next`.

## Corrections to your notes / code

- Values above F(46) overflow `int`; use `long` (up to F(92)).

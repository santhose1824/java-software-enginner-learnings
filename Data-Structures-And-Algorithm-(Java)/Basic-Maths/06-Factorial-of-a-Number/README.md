# Factorial of a Number

> **Section:** Basic Maths  |  **Your solution file:** `FactorialOfGivenNumber.java`

## Question

```text
You are given an integer n. Return the value of n! or n factorial.

Factorial of a number is the product of all positive integers less than or equal to that number.

Example 1:
Input: n = 2

Output: 2

Explanation: 2! = 1 * 2 = 2.

Example 2:
Input: n = 0

Output: 1

Explanation: 0! is defined as 1
```

> Brute force and optimal are the same: n! is the product of n numbers, so n multiplications are required.

## Solution (brute force = optimal here)

### Idea — how to think about it

n! = 1 × 2 × 3 × … × n. Start with `fact = 1` (the neutral value for multiplication, and also the correct answer for 0!) and multiply by every number from 1 to n.
Your notes also say "test case is huge → use long": 13! already exceeds the `int` limit (≈2.1 billion), and 20! is the biggest that fits in a `long`.

### Pseudocode

```text
fact = 1
for i = 1 to n:
    fact = fact * i
return fact
```

### Time & Space Complexity

**Time: O(n)**  
The loop body runs exactly n times; each multiplication is one constant-time step.

**Space: O(1)**  
Only `fact` and `i`.

## Corrections to your notes / code

- Make sure `fact` is declared as `long` (not `int`) — with `int` any n ≥ 13 silently gives a wrong (overflowed) answer.

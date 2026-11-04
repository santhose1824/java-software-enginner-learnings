# Divisors of a Number

> **Section:** Basic Maths  |  **Your solution file:** `DivisorsOfNumber.java`

## Question

```text
You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.

A number which completely divides another number is called it's divisor.

Example 1:
Input: n = 6

Output = [1, 2, 3, 6]

Explanation: The divisors of 6 are 1, 2, 3, 6.

Example 2:
Input: n = 8

Output: [1, 2, 4, 8]

Explanation: The divisors of 8 are 1, 2, 4, 8.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Check every number from 1 to n; the ones that leave remainder 0 are divisors. The output is already in sorted order.

### Pseudocode

```text
list = []
for i = 1 to n:
    if n % i == 0: list.add(i)
return list
```

### Time & Space Complexity

**Time: O(n)**  
One `%` check for each of the n numbers.

**Space: O(d(n)) for the answer, O(1) extra**  
Only the divisors are stored (at most a few hundred even for big n).

## Approach 2 — Optimal

### Idea — how to think about it

Same pairing idea as *Perfect Number*: divisors come in pairs (i, n/i) — for 36: (1,36)(2,18)(3,12)(4,9)(6,6). Loop only to √n; every time i divides n, record **both** i and n/i (once if they are equal).
The small halves come out in increasing order; the big halves come out in decreasing order, so put the big halves in a second list and append it reversed (or just sort).

### Pseudocode

```text
small = [] ; big = []
for i = 1 while i * i <= n:
    if n % i == 0:
        small.add(i)
        if i != n / i: big.add(n / i)
return small + reverse(big)
```

### Time & Space Complexity

**Time: O(√n)**  
The loop runs until i·i > n, i.e. √n iterations. Building the answer list is proportional to the number of divisors, which is much smaller than √n.

**Space: O(d(n))**  
Two lists that together hold all divisors (d(n) = number of divisors).

## Corrections to your notes / code

- No handwritten notes page was found for this problem. Your Java file only has the brute-force O(n) loop, so the optimal O(√n) version above is **added** (it reuses the pairing idea from your Perfect Number notes).

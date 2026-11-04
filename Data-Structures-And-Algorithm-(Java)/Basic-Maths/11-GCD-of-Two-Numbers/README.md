# GCD of Two Numbers

> **Section:** Basic Maths  |  **Your solution file:** `GCDOfTwoNumbers.java`

## Question

```text
You are given two integers n1 and n2. You need find the Greatest Common Divisor (GCD) of the two given numbers. Return the GCD of the two numbers.

The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers.

Example 1:
Input: n1 = 4, n2 = 6

Output: 2

Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6

Greatest Common divisor = 2.

Example 2:
Input: n1 = 9, n2 = 8

Output: 1

Explanation: Divisors of n1 = 1, 3, 9 Divisors of n2 = 1, 2, 4, 8.

Greatest Common divisor = 1.
```

## Approach 1 — Brute Force

### Idea — how to think about it

The GCD is the largest number that divides both. It can never be bigger than the smaller number, so try every i from min(n1,n2) down to 1 and return the first i that divides both (or go up from 1 and remember the last).

### Pseudocode

```text
for i = min(n1, n2) down to 1:
    if n1 % i == 0 and n2 % i == 0: return i
```

### Time & Space Complexity

**Time: O(min(n1, n2))**  
Worst case (GCD = 1) we try every value from min(n1,n2) down to 1.

**Space: O(1)**  
No extra storage.

## Approach 2 — Optimal

### Idea — how to think about it

**Euclid's observation (your notes):** gcd(n1, n2) = gcd(n1 − n2, n2) when n1 > n2 — any number dividing both also divides their difference. (gcd(35,10) = gcd(25,10) = gcd(15,10) = gcd(5,10) = 5.)
Repeated subtraction is slow (gcd(1000000, 1) subtracts a million times), but subtracting n2 many times is the same as taking the **remainder**: n1 % n2. So repeat: (n1, n2) → (n2, n1 % n2) until one becomes 0. The other one is the GCD.

### Pseudocode

```text
while n2 != 0:
    temp = n2
    n2 = n1 % n2
    n1 = temp
return n1
```

### Time & Space Complexity

**Time: O(log(min(n1, n2)))**  
Key fact: after two steps the remainder is at most half of the earlier number (if r = a % b then r < a/2 whenever b ≤ a/2, otherwise r = a − b < a/2). The numbers shrink by half every two steps, and you can halve a number only log₂ times before reaching 0/1. That is where the log comes from.

**Space: O(1)**  
Two variables, no recursion.

## Corrections to your notes / code

- Your notes' subtraction loop (`n1 = n1 − n2` / `n2 = n2 − n1`) is correct but worst-case O(max/min) — the modulo version is what gives O(log min).

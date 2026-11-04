# Armstrong Number

> **Section:** Basic Maths  |  **Your solution file:** `AmstrongNumber.java`

## Question

```text
You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.

An armstrong number is a number which is equal to the sum of the digits of the number, raised to the power of the number of digits.

Example 1:
Input: n = 153

Output: true

Explanation: Number of digits : 3.

13 + 53 + 33 = 1 + 125 + 27 = 153.

Therefore, it is an Armstrong number.

Example 2:
Input: n = 12

Output: false

Explanation: Number of digits : 2.

12 + 22 = 1 + 4 = 5.

Therefore, it is not an Armstrong number.
```

> Brute force and optimal are the same idea: we must visit each digit twice (once to count them, once to sum their powers).

## Solution (brute force = optimal here)

### Idea — how to think about it

Definition: sum of (each digit ^ number-of-digits) equals the number itself (153 = 1³+5³+3³).
So two things are needed: (1) the **number of digits** `d` (use the *Count Digits* logic), (2) walk over digits, add `digit^d`, and compare to the **original** n (keep a copy — the loop destroys n).

### Pseudocode

```text
d = number of digits of n
copy = n
sum = 0
while n > 0:
    digit = n % 10
    sum = sum + digit ^ d       // power by multiplication
    n = n / 10
return sum == copy
```

### Time & Space Complexity

**Time: O(d · log d)  where d = log10 n**  
The loop runs d times (one per digit). Each step computes digit^d; with fast exponentiation that costs O(log d) multiplications. So d × log d. (Your notes: `log10(n) × log2(digits)` — same thing.) Because d ≤ 10 for an int, in practice it is a tiny constant.

**Space: O(1)**  
A few integer variables.

## Corrections to your notes / code

- `n = 0`: `log10(0)` = −∞ so the 'count digits by log' method breaks; handle 0 first (0 is an Armstrong number: 0⁰… treated as true).
- `Math.pow` returns a `double`; for big numbers rounding can give 152.99999. Prefer integer multiplication in a small loop, or `Math.round(Math.pow(..))`.

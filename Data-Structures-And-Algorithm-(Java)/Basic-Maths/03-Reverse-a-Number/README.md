# Reverse a Number

> **Section:** Basic Maths  |  **Your solution file:** `ReverseANumber.java`

## Question

```text
You are given an integer n. Return the integer formed by placing the digits of n in reverse order.

Example 1:
Input: n = 25

Output: 52

Explanation: Reverse of 25 is 52.

Example 2:
Input: n = 123

Output: 321

Explanation: Reverse of 123 is 321.
```

> Brute force and optimal are the same: each digit has to be moved once, so O(digits) is the minimum.

## Solution (brute force = optimal here)

### Idea — how to think about it

Build the answer from the back: take the last digit of n and *append* it to the end of the reversed number.
Appending a digit d to a number r means `r = r * 10 + d` (shift r one place left, then put d in the ones place).
Example 152: r=0 → 0*10+2=2 → 2*10+5=25 → 25*10+1=251. This is the formula in your notes (`val × 10 + digit`).

### Pseudocode

```text
reverse = 0
while n > 0:
    digit = n % 10
    reverse = reverse * 10 + digit
    n = n / 10
return reverse
```

### Time & Space Complexity

**Time: O(log10 n)**  
The loop removes one digit per iteration → number of iterations = number of digits ≈ log10(n).

**Space: O(1)**  
Two integers (`reverse`, `digit`).

## Corrections to your notes / code

- Overflow: reversing `1999999999` gives a number bigger than `int` can hold. Use `long` for `reverse` if the problem allows large inputs.
- Negative numbers are not handled (`while n > 0` skips them). The question only gives non-negative n, so this is fine here.

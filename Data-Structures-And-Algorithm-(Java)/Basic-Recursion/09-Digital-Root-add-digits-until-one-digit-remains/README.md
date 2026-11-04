# Digital Root (add digits until one digit remains)

> **Section:** Basic Recursion  |  **Your solution file:** `SumOfDigitsOfGivenNumber.java`

## Question

```text
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input : num = 529

Output : 7

Explanation : In first iteration the digits sum will be = 5 + 2 + 9 => 16

In second iteration the digits sum will be 1 + 6 => 7.

Now single digit is remaining , so we return it.

Example 2:
Input : num = 101

Output : 2

Explanation : In first iteration the digits sum will be = 1 + 0 + 1 => 2

Now single digit is remaining , so we return it.
```

## Approach 1 — Brute Force

### Idea — how to think about it

**How to build any recursion (from your notes):** (1) write the **base condition** first — the smallest input whose answer you know, so the calls stop; (2) express the answer for size n using the answer for a *smaller* size; (3) every call adds one frame to the call stack, so the stack depth is the extra space.

Step 1 is *sum of the digits* (`n % 10` + sum of `n / 10`). Step 2 is the extra rule in this question: **if the result still has more than one digit, do it again**. 529 → 16 → 7. Recurse on the sum until it is below 10.

### Pseudocode

```text
digitSum(n):
    if n == 0: return 0
    return n % 10 + digitSum(n / 10)

digitalRoot(n):
    s = digitSum(n)
    if s < 10: return s
    return digitalRoot(s)
```

### Time & Space Complexity

**Time: O(log n) per pass × very few passes**  
One pass over the digits costs about log10(n) steps. After the first pass the value is at most 9·(digits) — tiny — so only a couple of extra passes happen. In practice ≈ O(log n).

**Space: O(log n)**  
The recursion depth is the number of digits (log10 n).

## Approach 2 — Optimal

### Idea — how to think about it

Use modular arithmetic: because 10 ≡ 1 (mod 9), **a number and its digit sum leave the same remainder when divided by 9**. Repeating the digit sum therefore ends at the number's remainder mod 9, with 9 (not 0) used when the number is a non-zero multiple of 9.
Formula: `0` if n = 0, otherwise `1 + (n − 1) % 9`.
Check: 529 → 1 + 528 % 9 = 1 + 6 = 7 ✔; 101 → 1 + 100 % 9 = 1 + 1 = 2 ✔.

### Pseudocode

```text
if n == 0 return 0
return 1 + (n - 1) % 9
```

### Time & Space Complexity

**Time: O(1)**  
One subtraction, one modulo, one addition.

**Space: O(1)**  
No recursion or storage.

## Corrections to your notes / code

- **Code does only half the job (confirmed):** `SumOfDigitsOfGivenNumber` returns the plain digit sum (`529 → 16`), but the question asks to *repeat until one digit* (`529 → 7`). Your notes show the stopping check (`if (num / 10 == 0) return num` style) — wrap the digit-sum in the repeat loop/recursion shown above, or use the O(1) formula.
- Inside `sum()` the temporary variables `int sum = 0; sum += digit;` are unnecessary — `return digit + sum(n / 10)` is enough.

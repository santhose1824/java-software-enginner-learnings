# Count Digits in a Number

> **Section:** Basic Maths  |  **Your solution file:** `CountAllDigitsOfNumber.java`

## Question

```text
You are given an integer n. You need to return the number of digits in the number.

The number will have no leading zeroes, except when the number is 0 itself.

Example 1:
Input: n = 4

Output: 1

Explanation: There is only 1 digit in 4.

Example 2:
Input: n = 14

Output: 2

Explanation: There are 2 digits in 14.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Dividing a number by 10 (integer division) throws away its last digit: 153 → 15 → 1 → 0.
So the number of digits is simply **how many times we can divide by 10 before the number becomes 0**.
That is exactly the picture in your notes (the long-division drawing of 153 ÷ 10).
Edge case: `0` has 1 digit, but the loop would run zero times — so it must be handled separately.

### Pseudocode

```text
if n == 0 return 1
count = 0
while n > 0:
    n = n / 10        // drop last digit
    count++
return count
```

### Time & Space Complexity

**Time: O(log10 n)  (= O(number of digits))**  
Every loop iteration removes exactly one digit, so the loop runs once per digit. A number n has ⌊log10 n⌋+1 digits (100 has 3, 1000 has 4), so the loop runs about log10(n) times. It is NOT O(n): going from n = 100 to n = 1,000,000 only adds 4 iterations.

**Space: O(1)**  
Only one integer variable `count` is stored, no matter how large n is.

## Approach 2 — Optimal

### Idea — how to think about it

Instead of removing digits one by one, use the maths fact that digits = ⌊log10(n)⌋ + 1.
Check with your notes: log10(100) = 2, +1 = 3 digits. The processor computes the logarithm in one library call, so there is no loop at all.
Still guard n = 0 because log10(0) is −infinity.

### Pseudocode

```text
if n == 0 return 1
return floor(log10(n)) + 1
```

### Time & Space Complexity

**Time: O(1)**  
One library call and one addition — it does not depend on how many digits n has. (Your notes wrote O(log10 n); that is the *mathematical* meaning of the formula, but in code it is a single constant-time operation.)

**Space: O(1)**  
No extra storage.

## Corrected Java

```java
static int countDigits(int n) {
    if (n == 0) return 1;          // <- missing in your code
    int count = 0;
    while (n > 0) { n /= 10; count++; }
    return count;
}
```

## Corrections to your notes / code

- **Code bug (confirmed by running it):** `CountAllDigitsOfNumber` prints `0` for input `0`. Your own notes say `if(n==0) return 1` — that line is missing from the Java. Add it.
- In the log10 version, `log10(0)` is −∞, so the same `n == 0` guard is required there too.

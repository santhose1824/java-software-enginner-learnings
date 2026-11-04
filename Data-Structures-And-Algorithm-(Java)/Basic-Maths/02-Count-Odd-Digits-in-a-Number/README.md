# Count Odd Digits in a Number

> **Section:** Basic Maths  |  **Your solution file:** `OddDigitsInNumber.java`

## Question

```text
You are given an integer n. You need to return the number of odd digits present in the number.

The number will have no leading zeroes, except when the number is 0 itself.

Example 1:
Input: n = 5

Output: 1

Explanation: 5 is an odd digit.

Example 2:
Input: n = 25

Output: 1

Explanation: The only odd digit in 25 is 5.
```

> Brute force and optimal are the same: every digit must be looked at at least once, so no algorithm can beat O(number of digits).

## Solution (brute force = optimal here)

### Idea — how to think about it

Same trick as *Count Digits*: `n % 10` gives the last digit, `n / 10` removes it.
For each digit ask one question — is it odd? (`digit % 2 != 0`). If yes, count it.
Walk through 153: digits 3 (odd), 5 (odd), 1 (odd) → 3. Matches your notes.

### Pseudocode

```text
count = 0
while n > 0:
    digit = n % 10
    if digit % 2 != 0: count++
    n = n / 10
return count
```

### Time & Space Complexity

**Time: O(log10 n)**  
One iteration per digit; a number n has log10(n)+1 digits. Inside the loop everything (%, /, comparison) is constant time.

**Space: O(1)**  
Just `count` and `digit`.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

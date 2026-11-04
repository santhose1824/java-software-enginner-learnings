# Largest Odd Number in a String

> **Section:** Basic Strings  |  **Your solution file:** `LargestOddNumberInString.java`

## Question

```text
Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.

The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)

Example 1:
Input : s = "5347"

Output : "5347"

Explanation :

The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.

So the largest among all the possible odd numbers for given string is 5347.

Example 2:
Input : s = "0214638"

Output : "21463"

Explanation :

The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.

We cannot include 021463 as the number contains leading zero.

So largest odd number in given string is 21463.
```

## Approach 1 — Brute Force

### Idea — how to think about it

Generate every substring, keep only the ones that end in an odd digit, and return the biggest number (compare by length first, then lexicographically). Correct but slow — there are n² substrings.

### Pseudocode

```text
best = ""
for i = 0 to n-1:
    for j = i to n-1:
        sub = s[i..j]
        if sub ends with an odd digit and sub (without leading zeros) > best:
            best = sub
return best
```

### Time & Space Complexity

**Time: O(n³)**  
There are n(n+1)/2 ≈ n² substrings, and building/comparing each one costs up to n characters → n² × n.

**Space: O(n)**  
Storing the best substring.

## Approach 2 — Optimal

### Idea — how to think about it

Reason with the examples in your notes:
1. A number is odd **only if its last digit is odd**. So the answer must end at an odd digit.
2. A longer number is bigger than a shorter one (ignoring leading zeros). So the answer should be as **long** as possible: start as far left as possible and end as far right as possible.
3. The furthest-right end = the **last odd digit** (search from the back). The furthest-left start = the **first non-zero digit** (leading zeros do not add value).
So the answer is `s[firstNonZero .. lastOdd]`. If there is no odd digit, return `""`.

### Pseudocode

```text
j = -1
for i = n-1 down to 0:                 // find last odd digit
    if (s[i] - '0') % 2 != 0: j = i ; break
if j == -1 return ""
i = 0
while i < n and s[i] == '0': i++       // skip leading zeros
return s.substring(i, j+1)
```

### Time & Space Complexity

**Time: O(n)**  
Scan 1 (from the back) stops at the first odd digit — at most n steps. Scan 2 (from the front) skips zeros — at most n steps. `substring` copies ≤ n chars. n + n + n = O(n).

**Space: O(n) for the returned substring, O(1) extra**  
Only index variables are used besides the answer string.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

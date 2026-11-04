# LCM of Two Numbers

> **Section:** Basic Maths  |  **Your solution file:** `LCMOfTwoNumbers.java`

## Question

```text
You are given two integers n1 and n2. You need find the Lowest Common Multiple (LCM) of the two given numbers. Return the LCM of the two numbers.

The Lowest Common Multiple (LCM) of two integers is the lowest positive integer that is divisible by both the integers.

Example 1:
Input: n1 = 4, n2 = 6

Output: 12

Explanation: 4 * 3 = 12, 6 * 2 = 12.

12 is the lowest integer that is divisible both 4 and 6.

Example 2:
Input: n1 = 3, n2 = 5

Output: 15

Explanation: 3 * 5 = 15, 5 * 3 = 15.

15 is the lowest integer that is divisible both 3 and 5.
```

## Approach 1 — Brute Force

### Idea — how to think about it

LCM is the smallest number divisible by both. It must be a multiple of the bigger number, so test multiples of max(n1,n2): 1×max, 2×max, 3×max, … and return the first one divisible by both.

### Pseudocode

```text
mx = max(n1, n2)
i = 1                      // start at 1, NOT 0
while true:
    multiple = i * mx
    if multiple % n1 == 0 and multiple % n2 == 0: return multiple
    i++
```

### Time & Space Complexity

**Time: O(min(n1, n2))**  
The answer is at most n1·n2, and we step in jumps of max, so we try at most (n1·n2)/max = min(n1, n2) multiples.

**Space: O(1)**  
No extra storage.

## Approach 2 — Optimal

### Idea — how to think about it

Use the identity **gcd(a,b) × lcm(a,b) = a × b** (each prime's higher power goes to the LCM, the lower to the GCD). So lcm = a·b / gcd(a,b). The GCD is computed with Euclid.
Divide first, then multiply — `a / gcd * b` — so the intermediate value does not overflow.

### Pseudocode

```text
g = gcd(n1, n2)            // Euclid
return n1 / g * n2
```

### Time & Space Complexity

**Time: O(log(min(n1, n2)))**  
Dominated by the Euclid GCD; the divide and multiply are O(1).

**Space: O(1)**  
No extra storage.

## Corrected Java

```java
static long lcm(long a, long b) {
    return a / gcd(a, b) * b;      // divide first to avoid overflow
}
```

## Corrections to your notes / code

- **Bug in the notes' brute force:** the pseudocode starts at `i = 0`, which makes `multiple = 0`, and 0 is divisible by everything — it would always return 0. Start from `i = 1`.
- **Wrong complexity in the notes:** brute force is O(min(n1,n2)), not O(n1 × n2) (explained above). n1×n2 is only the *value* of the largest answer.
- **Overflow (confirmed):** `LCM(100000, 99999)` printed `1409965408` — the true value is 9,999,900,000, which overflowed `int`. Use `long`, and compute `n1 / gcd * n2`.

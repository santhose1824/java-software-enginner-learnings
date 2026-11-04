# Pattern 18 — Right-Aligned Alphabet Triangle

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern18.java`

## Question

```text
N = 4
D
CD
BCD
ABCD
```

> Patterns have no 'brute force vs optimal' — the standard approach is nested loops, and every pattern needs to print each of its characters, so O(number of characters printed) is the minimum.

## Solution (brute force = optimal here)

### Idea — how to think about it

**Recipe for every pattern (use it each time):**
1. Count the **rows** → this is the outer loop (`i`).
2. In one row, list what is printed from left to right (spaces, stars, numbers …) → one inner loop per group.
3. For each group, write *how many* there are as a formula of the row number `i` and `N` (look at 2–3 rows and spot the change per row).
4. Decide **what** is printed (always `*`, the column number, the row number, a counter …).
5. Print a new line after each row.

Row i (1 … N) has i letters and ends with the N-th letter: D / CD / BCD / ABCD. So row i **starts** at the letter `'A' + (N − i)` and counts up for i letters. Your code loops `i` from N down to 1 and starts at `'Z' − 26 + i` = `'A' − 1 + i`, which gives the same rows in the order D, CD, BCD, ABCD.

### Pseudocode

```text
for i = N down to 1:
    ch = char('A' - 1 + i)       // starting letter of this row
    for j = 1 to N - i + 1:
        print ch
        ch++
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Triangle of N(N+1)/2 letters → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- Your code prints `(char)val + " "` (a space after each letter). The sample shows letters without spaces (`CD`). Remove the `+ " "` if the exact output matters.
- `90 - 26 + i` works but is hard to read; write `'A' - 1 + i` (or `64 + i`).

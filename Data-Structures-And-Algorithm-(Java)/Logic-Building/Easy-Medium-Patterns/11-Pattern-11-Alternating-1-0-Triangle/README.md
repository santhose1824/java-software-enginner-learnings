# Pattern 11 — Alternating 1 / 0 Triangle

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern11.java`

## Question

```text
N = 3
1
01
101
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

Row i has i digits and they alternate 1,0,1,0… Each row **starts** with 1 when the row number is odd and with 0 when it is even (1 / 01 / 101). So: pick the starting value from `i % 2`, then print it and **flip** it each step with `value = 1 − value` (1→0, 0→1).

### Pseudocode

```text
for i = 1 to N:
    value = (i is even) ? 0 : 1
    for j = 1 to i:
        print value
        value = 1 - value
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Triangle: row i prints i digits → N(N+1)/2 → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

# Pattern 20 — Butterfly (small at the ends)

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern20.java`

## Question

```text
N = 4
*      *
**    **
***  ***
********
***  ***
**    **
*      *
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

Same structure as Pattern 19 but the narrowest row is on top. Rows 1 … N: k = r (1, 2, …, N); rows N+1 … 2N−1: k = 2N − r (N−1, …, 1). Each row = k stars + 2(N − k) spaces + k stars. For N = 4 the first row is `*      *` (1 + 6 + 1) and the middle row `********`.

### Pseudocode

```text
for r = 1 to 2*N - 1:
    k = (r <= N) ? r : 2*N - r
    print "*" k times
    print " " 2*(N - k) times
    print "*" k times
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
(2N − 1) rows × 2N characters → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- Your Java is correct (7 rows for N = 4).

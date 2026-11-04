# Pattern 19 — Butterfly (large at the ends)

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern19.java`

## Question

```text
N = 4
********
***  ***
**    **
*      *
**    **
***  ***
********
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

Make the **middle** the narrowest row. There are 2N − 1 rows. In row r let `k` = the number of stars on *each* side:
- upper half (r = 1 … N): k = N − r + 1  (N, N−1, …, 1)
- lower half (r = N+1 … 2N−1): k = r − N + 1  (2, 3, …, N)
Each row = k stars, then 2(N − k) spaces, then k stars. For N = 4: row 1 → 4 stars + 0 spaces + 4 stars; middle → 1 + 6 + 1.
Easy way to code it: print the shrinking half (N rows), then the growing half **starting from 2** stars, because the 1-star row was already printed.

### Pseudocode

```text
for r = 1 to 2*N - 1:
    k = (r <= N) ? N - r + 1 : r - N + 1
    print "*" k times
    print " " 2*(N - k) times
    print "*" k times
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
2N − 1 rows, each row prints exactly 2N characters (k + 2(N−k) + k) → (2N−1) × 2N ≈ 4N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- **Code bug (confirmed by running it):** `Pattern19` prints **8 rows** for N = 4 — the 1-star middle row appears twice (once as the last row of the shrinking half and again as the first row of the growing half). The question's sample has 7 rows. Start the second half from 2 stars (call it with `N − 1` / loop `i = 2 … N`), exactly like you did in Pattern 10.

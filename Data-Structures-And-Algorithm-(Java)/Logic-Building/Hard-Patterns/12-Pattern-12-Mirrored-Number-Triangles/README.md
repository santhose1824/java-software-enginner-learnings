# Pattern 12 — Mirrored Number Triangles

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern12.java`

## Question

```text
N = 3
1    1
12  21
123321
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

Each row has three parts: **numbers 1..i**, **gap**, **numbers 1..i again** The right-hand block is the **mirror image** of the left one, so it counts *down*: row 3 is `123` + `321` = `123321` (your sample: `1    1 / 12  21 / 123321`).
Width is always 2N, so the gap = 2N − 2i spaces: i = 1 → 4 (N=3), i = 3 → 0.

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to i:             print j
    for k = 1 to 2*N - 2*i:     print " "
    for j = i down to 1:        print j      // mirrored right side
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Every row prints 2N characters (i + (2N−2i) + i) → N rows × 2N = 2N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- **Code bug (confirmed by running it):** for N = 3 your `Pattern12` prints `123123` as the last row; the question wants `123321`. The right-hand number loop counts *up* (`j = 1 … i`) — it must count **down** (`j = i … 1`).

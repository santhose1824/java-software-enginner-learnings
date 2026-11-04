# Pattern 8 — Inverted Pyramid

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern8.java`

## Question

```text
N = 3
* * * * *
  * * *
    *
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

Mirror of Pattern 7. Row i (0-based): **i spaces**, then **2N − 1 − 2i stars** (N=3 → 5, 3, 1 stars). Each row loses one space-slot on each side, i.e. two stars.

### Pseudocode

```text
for i = 0 to N-1:
    for j = 0 to i-1:                  print " "
    for k = 0 to (2*N - 1) - 2*i - 1:  print "*"
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Row i prints i + (2N−1−2i) characters; over N rows this is ≈ N² total → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- Same spacing remark as Pattern 7: the sample has `* * * * *` with spaces between the stars, your code prints `*****`.

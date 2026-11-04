# Pattern 2 — Right Triangle of Stars

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern2.java`

## Question

```text
N = 4
*
**
***
****
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

Row 1 has 1 star, row 2 has 2, row 3 has 3 … so **row i has i stars**. The inner loop limit depends on the row: `j = 1 … i`.

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to i:
        print "*"
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Row i prints i stars: 1 + 2 + … + N = N(N+1)/2 ≈ N²/2 prints, which is O(N²) (constants are ignored).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

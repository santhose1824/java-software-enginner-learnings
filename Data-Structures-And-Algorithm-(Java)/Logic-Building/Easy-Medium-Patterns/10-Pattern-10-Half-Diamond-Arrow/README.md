# Pattern 10 — Half Diamond (Arrow)

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern10.java`

## Question

```text
N = 4
*
**
***
****
***
**
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

It is **Pattern 2 (growing triangle) followed by Pattern 5 (shrinking triangle)**. The catch your comment mentions: the longest row (N stars) would be printed twice, so the second triangle must start from N − 1 stars → call it with `N − 1`. Total rows: N + (N − 1) = 2N − 1.

### Pseudocode

```text
triangle(N)           // rows with 1,2,...,N stars
invertedTriangle(N-1) // rows with N-1,...,1 stars
```

### Time & Space Complexity

**Time: O(N²)**  
Both halves are triangles of about N²/2 prints → total ≈ N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

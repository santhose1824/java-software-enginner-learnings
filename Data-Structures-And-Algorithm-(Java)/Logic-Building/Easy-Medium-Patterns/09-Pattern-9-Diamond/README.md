# Pattern 9 — Diamond

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern9.java`

## Question

```text
    *
  * * *
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

Notice that a diamond is just **Pattern 7 on top of Pattern 8** — exactly what your code comment says. Print the pyramid (rows grow), then the inverted pyramid (rows shrink). Reusing the two pattern functions means no new thinking is needed. (The sample in the question is the N = 2 diamond: 2 rows going up, 2 rows coming down — i.e. 2N rows in total.)

### Pseudocode

```text
pyramid(N)            // Pattern 7
invertedPyramid(N)    // Pattern 8
```

### Time & Space Complexity

**Time: O(N²)**  
Two O(N²) patterns one after the other: N² + N² = 2N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

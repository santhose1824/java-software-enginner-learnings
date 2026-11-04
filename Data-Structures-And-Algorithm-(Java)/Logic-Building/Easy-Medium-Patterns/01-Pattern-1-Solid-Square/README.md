# Pattern 1 — Solid Square

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern1.java`

## Question

```text
N = 4
*****
*****
*****
*****
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

Every row is identical: N stars. With N = 4 you print 4 rows of 4 stars. So rows = N and columns = N — a nested loop where the inner loop prints one star.

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to N:
        print "*"
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
The outer loop runs N times and each time the inner loop runs N times → N × N = N² prints.

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- The sample in `Questions.txt` shows **5** stars per row for N = 4, but a square needs N = 4 stars per row — your code (N × N) is the right interpretation; the sample looks like a typo.

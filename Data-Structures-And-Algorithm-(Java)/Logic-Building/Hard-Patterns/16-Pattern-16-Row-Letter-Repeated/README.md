# Pattern 16 — Row Letter Repeated

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern16.java`

## Question

```text
N = 3
A
BB
CCC
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

Like Pattern 4 but with letters: row i prints the i-th letter **i times** (A / BB / CCC). The letter depends on the row only: `'A' + i − 1`.

### Pseudocode

```text
for i = 1 to N:
    ch = char('A' + i - 1)
    for j = 1 to i:
        print ch
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Triangle: N(N+1)/2 characters → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

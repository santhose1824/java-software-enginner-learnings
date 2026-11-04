# Pattern 14 — Alphabet Triangle (A, AB, ABC)

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern14.java`

## Question

```text
N = 3
A
AB
ABC
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

Same triangle as Pattern 3, but print letters. Convert the column number to a letter: **'A' + (j − 1)** (characters are numbers underneath: 'A' = 65, so 'A'+1 = 'B').

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to i:
        print char('A' + j - 1)
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
N(N+1)/2 letters → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

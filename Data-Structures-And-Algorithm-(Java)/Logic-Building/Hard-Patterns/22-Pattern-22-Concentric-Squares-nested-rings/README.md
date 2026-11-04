# Pattern 22 — Concentric Squares (nested rings)

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern22.java`

## Question

```text
N = 4
4444444
4333334
4322234
4321234
4322234
4333334
4444444
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

The grid has **2N − 1** rows and columns. Look at N = 4: the outer ring is all 4s, the next ring 3s, … the centre is 1. So the value at (i, j) depends only on **how far the cell is from the nearest edge**.
With 0-based indices the distances to the four edges are: top = i, bottom = (2N−2) − i, left = j, right = (2N−2) − j. The smallest of these is the ring depth `d` (0 for the outer ring). Print **N − d**.
Check the centre (3,3), N = 4: all distances are 3 → 4 − 3 = 1 ✔. Corner (0,0): d = 0 → 4 ✔.

### Pseudocode

```text
size = 2*N - 1
for i = 0 to size - 1:
    for j = 0 to size - 1:
        top = i ; bottom = size - 1 - i
        left = j ; right = size - 1 - j
        d = min(top, bottom, left, right)
        print N - d
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
The grid has (2N−1)² cells and each is computed in O(1) → (2N−1)² ≈ 4N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- In your code the variable names are mixed up (`left = (2N-2)-i` is really the *bottom* distance and `right = j` is really *left*). The answer is still right because only the minimum of the four matters, but rename them to avoid confusion.
- The sample's last row `44444444` has 8 characters — a typo; a 2N−1 = 7 wide grid prints `4444444`.

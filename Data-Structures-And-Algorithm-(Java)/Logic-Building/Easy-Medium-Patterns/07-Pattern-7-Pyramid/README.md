# Pattern 7 — Pyramid

> **Section:** Patterns Easy Medium  |  **Your solution file:** `Pattern7.java`

## Question

```text
N = 3
    *
  * * *
* * * * *
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

Look at one row of the star pyramid (N = 3): row 1 → 2 spaces, 1 star; row 2 → 1 space, 3 stars; row 3 → 0 spaces, 5 stars.
- **spaces** before the stars: N − i (decreases by 1 each row)
- **stars**: 2i − 1 (odd numbers 1, 3, 5 …: grows by 2 each row)
A trailing-space loop on the right is optional (it prints nothing visible).

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to N - i:      print " "
    for k = 1 to 2*i - 1:    print "*"
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Each row prints (N − i) + (2i − 1) = N + i − 1 characters; summed over N rows this is about 1.5·N² → O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

- The sample in `Questions.txt` has the stars **separated by spaces** (`  * * *`) while your code prints them touching (`  ***`). The shape is right; if you need the exact sample output, print `"* "` for each star and two spaces `"  "` for each leading space.

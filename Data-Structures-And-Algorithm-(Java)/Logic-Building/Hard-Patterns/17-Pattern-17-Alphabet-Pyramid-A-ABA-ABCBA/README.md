# Pattern 17 — Alphabet Pyramid (A, ABA, ABCBA)

> **Section:** Patterns Hard  |  **Your solution file:** `Pattern17.java`

## Question

```text
N = 3
   A  
  ABA
 ABCBA
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

Pyramid shape (spaces N − i, then 2i − 1 characters) like Pattern 7. Inside a row the letters climb A, B, C … up to the middle character, then **come back down** (…, B, A).
Position k (1 … 2i−1): while k < i the letter goes up after printing, afterwards it goes down. A neat rule: print `'A' + min(k − 1, 2i − 1 − k)`.
(Your own comment: 'don't print inside the if-condition' — print first, then move `ch`.)

### Pseudocode

```text
for i = 1 to N:
    for j = 1 to N - i:        print " "
    ch = 'A'
    for k = 1 to 2*i - 1:
        print ch
        if k < i: ch++      // climbing
        else:     ch--      // coming back
    for j = 1 to N - i:        print " "   // optional
    newline
```

### Time & Space Complexity

**Time: O(N²)**  
Each row prints (N−i) + (2i−1) (+ (N−i) trailing) characters — about 2N per row → N rows × ~2N = O(N²).

**Space: O(1)**  
Only loop counters (and at most one extra variable such as `ch`/`value`) are used; nothing grows with N. The printed output is not counted as space.

## Corrections to your notes / code

None needed — your notes and code match the algorithm described above.

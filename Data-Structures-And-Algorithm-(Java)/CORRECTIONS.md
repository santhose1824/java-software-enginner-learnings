# All Corrections in One Place

Every mistake found in our **notes** or **Java code**, grouped by problem. Items marked *confirmed* were reproduced by compiling and running your code (Java 17).


## Basic Maths

### 01. Count Digits in a Number
- **Code bug (confirmed by running it):** `CountAllDigitsOfNumber` prints `0` for input `0`. Your own notes say `if(n==0) return 1` — that line is missing from the Java. Add it.
- In the log10 version, `log10(0)` is −∞, so the same `n == 0` guard is required there too.

### 03. Reverse a Number
- Overflow: reversing `1999999999` gives a number bigger than `int` can hold. Use `long` for `reverse` if the problem allows large inputs.
- Negative numbers are not handled (`while n > 0` skips them). The question only gives non-negative n, so this is fine here.

### 04. Palindrome Number
- Your notes give TC O(log10 n) and SC O(1) — correct.
- Negative numbers: your code returns `false` (the loop is skipped, reverse = 0 ≠ n) which is the expected answer.

### 06. Factorial of a Number
- Make sure `fact` is declared as `long` (not `int`) — with `int` any n ≥ 13 silently gives a wrong (overflowed) answer.

### 07. Armstrong Number
- `n = 0`: `log10(0)` = −∞ so the 'count digits by log' method breaks; handle 0 first (0 is an Armstrong number: 0⁰… treated as true).
- `Math.pow` returns a `double`; for big numbers rounding can give 152.99999. Prefer integer multiplication in a small loop, or `Math.round(Math.pow(..))`.

### 08. Perfect Number
- Your Java file only contains the brute-force O(N) loop; the O(√N) version is in your notes and is shown above.
- **Bug in the notes' pseudocode:** with `sum = 1` the answer for **n = 1** comes out as `true` (sum 1 == n 1), but 1 is *not* a perfect number (it has no proper divisors). Add `if n <= 1 return false`.
- Write the loop condition as `i * i <= n` instead of recomputing `Math.sqrt(n)` every iteration.

### 09. Prime Number Check
- **Code bug (confirmed by running it):** `PrimeNumberOrNot(1)` prints *Prime*. 1 is not prime — your notes have `if(n==1) false` but the Java loses it. Use `n <= 1` (also covers 0 and negatives).
- Use `i * i <= n` rather than `i <= Math.sqrt(n)` computed each loop.

### 10. Count Primes up to N
- Your notes only contain the brute-force version (O(N·√N)). The Sieve above is the optimal solution and is worth adding to your Java file.

### 11. GCD of Two Numbers
- Your notes' subtraction loop (`n1 = n1 − n2` / `n2 = n2 − n1`) is correct but worst-case O(max/min) — the modulo version is what gives O(log min).

### 12. LCM of Two Numbers
- **Bug in the notes' brute force:** the pseudocode starts at `i = 0`, which makes `multiple = 0`, and 0 is divisible by everything — it would always return 0. Start from `i = 1`.
- **Wrong complexity in the notes:** brute force is O(min(n1,n2)), not O(n1 × n2) (explained above). n1×n2 is only the *value* of the largest answer.
- **Overflow (confirmed):** `LCM(100000, 99999)` printed `1409965408` — the true value is 9,999,900,000, which overflowed `int`. Use `long`, and compute `n1 / gcd * n2`.

### 13. Divisors of a Number
- No handwritten notes page was found for this problem. Your Java file only has the brute-force O(n) loop, so the optimal O(√n) version above is **added** (it reuses the pairing idea from your Perfect Number notes).


## Basic Arrays

### 01. Sum of Array Elements
- Overflow: if the values are large (e.g. 10⁹ each) use `long sum`. Your notes already point this out for the missing-number problem; the same applies here.


## Basic Hashing

### 01. Highest Occurring Element (smallest on a tie)
- **Missing tie-break in the code:** you only test `val > maxValue`. For `[4,4,5,5,6]` the answer must be 4 (the smaller). Your run happened to print 4 only because `HashMap` iterates small integer keys in ascending order — that is not guaranteed in general. Add `|| (val == maxValue && key < result)`.
- Alternative: use `TreeMap` (sorted keys) and a strict `>` comparison; the first key reaching the max is then automatically the smallest.

### 02. Second Highest Occurring Element
- **Confirmed bug:** for `[1,1,1]` (only one distinct frequency) your code prints `0`; the answer must be `-1`.
- Ties for second place must return the smaller element — as in problem 1, your code does not tie-break.

### 03. Sum of Highest and Lowest Frequency
- Edge case: if all elements are equal (single key), max = min = n, so the answer is 2n — that is correct by the definition, just be aware.


## Basic Strings

### 02. Palindrome String
- **Wrong complexity in the notes:** the brute force is written as 'TC: O(N), SC: O(1)'. With `reverse += s.charAt(i)` it is actually **O(n²) time and O(n) space** (new String objects are created every time). Use `StringBuilder` to make it O(n)/O(n), or use two pointers for O(n)/O(1).

### 04. Longest Common Prefix
- **Complexity of your sorting approach:** sorting n strings = O(n log n) comparisons, and each comparison can look at up to m characters → **O(n·m·log n)**, then O(m) for the first-vs-last comparison. The vertical scan is O(n·m).
- Empty input array / empty first string should return `""` — check before indexing `strs[0]`.

### 05. Isomorphic Strings
- **Code is wrong (confirmed by running it):** `isomorphic('apple','bbnbm')` printed `true` — it must be `false`. In `IsomorphicString.java` the arrays are incremented with `++` (counting) and the mismatch branch only `break`s, after which the method still returns `true`. Replace it with the algorithm from your own notes: **return false** on mismatch and store `i + 1`.

### 07. Valid Anagram
- Your solution works for lowercase letters only (as the question states). For any Unicode text use a `HashMap<Character,Integer>`.

### 08. Sort Characters by Frequency
- **Your `Questions.txt` is cut off:** Example 3 (`s = "bbccddaaa"`) has no output line. The expected answer is `['a', 'b', 'c', 'd']` (a→3, then b, c, d with 2 each in alphabetical order).
- **Wrong comparator in the notes:** you wrote `if (A != B) return A - B;` — that sorts frequency **ascending** (lowest first), but the question wants highest → lowest. It must be `return B - A;`, and the alphabetical tie-break `return a - b;` is missing.
- **Code is incomplete (confirmed):** your Java comparator never looks at frequencies, so `zzzay` printed `[a, y, z]` instead of `[z, a, y]`. (`tree` only looked right by luck because e,r,t is also alphabetical.)


## Basic Recursion

### 01. Sum of First N Natural Numbers
- Overflow: for N around 65,000 the sum no longer fits in `int`; use `long` (and `(long)N*(N+1)/2`).

### 02. Factorial using Recursion
- Use `long` as the return type (the question says '64-bit'): `int` overflows at 13!.
- Time stays O(n) in both versions; what improves is the **space** (O(n) → O(1)).

### 05. String Palindrome using Recursion
- **Notes bug:** the base case in your pseudocode says `if(start >= end) return;` — it must be **`return true`**; returning nothing would make the method fail to compile / give no answer.

### 06. Prime Number using Recursion
- **Code bug (same as Maths):** `isPrime(1, 2)` returns `true` because `2 > √1`. Add `if (num <= 1) return false`.

### 08. Check if Array is Sorted using Recursion
- Empty / single-element arrays must return `true` — make sure the first call does not read `arr[-1]` (start at index 1).

### 09. Digital Root (add digits until one digit remains)
- **Code does only half the job (confirmed):** `SumOfDigitsOfGivenNumber` returns the plain digit sum (`529 → 16`), but the question asks to *repeat until one digit* (`529 → 7`). Your notes show the stopping check (`if (num / 10 == 0) return num` style) — wrap the digit-sum in the repeat loop/recursion shown above, or use the O(1) formula.
- Inside `sum()` the temporary variables `int sum = 0; sum += digit;` are unnecessary — `return digit + sum(n / 10)` is enough.

### 10. Fibonacci Number
- Values above F(46) overflow `int`; use `long` (up to F(92)).


## Sorting

### 01. Selection Sort
- **Code bug (confirmed — failed 22 of 40 random test arrays):** the outer loop is `i < n-2`, so the last pair is never fixed — `[3,1,2]` stayed unsorted. It must be `i < n-1` (i ≤ n−2). Your notes (`for 0 → n-2`, inclusive) are right.
- The notes' step-by-step example shows the unsorted array order slightly mixed up after step 1 (a swap moves 12 to the end, it does not shift it) — the algorithm itself is right.

### 02. Bubble Sort
- **Notes bug:** the pseudocode sets `swap = true` before the inner loop and does `if(swap) break` — that is inverted. It must start each pass with `didSwap = false`, set it to `true` when a swap happens, and `break` when it is **still false** after the pass.
- **Code bug (confirmed):** in `BubbleSort.java` the swap flag is never reset to false at the start of a pass, so once a swap has happened the early-exit never triggers and the 'optimised' best case is still O(n²).

### 03. Insertion Sort
- Your code uses the swap version, which is correct. Notes' 'O(N²) | O(N)' means worst | best — both are right.

### 04. Merge Sort
- **Code bug (confirmed — failed 34 of 40 random test arrays):** your `merge()` uses `left <= mid + 1` (reads the first element of the right half as part of the left half) and the two 'copy leftovers' loops are **inside** the main `while` loop. The two leftover loops must come *after* the main loop (as in your notes), and the condition is `left <= mid && right <= high`. See the corrected merge above.
- **Unclear explanation in the notes:** 'O(log N) → merge, O(N) → merge sort' is backwards. Correct statement: there are **log n levels**, and each level does **O(n)** merging work → O(n log n).
- Compute `mid` as `low + (high - low) / 2` to avoid int overflow on huge indices.

### 05. Quick Sort
- **Wrong complexity in the notes:** 'TC O(N log N), SC O(1), slightly better than merge sort'. Quick sort's worst case is **O(n²)**, and the recursion stack makes the space **O(log n) average / O(n) worst**, not O(1). (It is fast in practice because it is in place and cache friendly.)
- Code detail: `while(array[j] > pivot && i >= low+1)` — the second condition should check **`j >= low+1`**. It still works because `array[low]` is the pivot and stops the loop, but write it correctly. Your QuickSort passed all 40 random test arrays (including duplicates).

### 06. Recursive Bubble Sort
- Without the `didSwap` check (as in your file) the best case is also O(n²). Add the check to reach O(n) for sorted input.


## Arrays Easy

### 03. Second Largest Element
- **Notes:** `SMax = 0` as the starting value is wrong in principle — for an array of negatives such as `[-5,-3]` it would never be replaced correctly. Start it at `Integer.MIN_VALUE` (the final check `SMax == MIN ? -1 : SMax` already assumes that).
- Your Java works because the first element always overwrites the initial value, but fix the initial value so the logic is correct on its own.

### 06. Move Zeros to End
- In the notes' brute-force pseudocode the condition is written `if(i != 0)`; it must test the **value**: `if (arr[i] != 0)`.
- If you find the first zero first (as in the notes) and no zero exists, `j = -1` — return immediately, otherwise the second loop starts at index 0 and swaps wrongly.

### 07. Remove Duplicates from Sorted Array
- **Code does not do what the question requires (confirmed):** it only counts the unique values; the array is never rearranged, so `[0,0,3,3,5,6]` is left unchanged. The question says the first k elements must *contain* the unique values. Use the `arr[++i] = arr[j]` write shown above.
- Empty array: your code returns `1` (count+1 with count=0). Guard `n == 0` and return 0.

### 08. Find the Missing Number
- **Code bug (confirmed by running it):** for `[0,2,3,1,4]` (answer 5) `FindTheMissingNumber` prints **4**; for `[0,1]` it prints 1 instead of 2. The loops run to `length - 1`, so the last element and the number `n` are never XOR-ed. Loop over **all n elements** (`i < array.length`) with `(i+1)` on the first XOR, as in your notes.
- **Notes (brute force):** the outer loop is `for(1 → N)` — it must start at **0** (0 may be the missing number).
- **Notes (Optimal I):** 'return sum − sum' should say `expectedSum − arraySum`. Use `long` for the sums (your note: 'may need long') or prefer the XOR version.


## Arrays Medium

### 01. Left Rotate Array by K Places
- Guard `n == 0` before `k % n` (division by zero).
- Your code and notes for the reversal method are correct.

### 02. Union of Two Sorted Arrays
- Your code is correct. (Space: the output list is the only storage — it is *required* output, so the extra/auxiliary space is O(1).)

### 03. Intersection of Two Sorted Arrays
- **Code bug (confirmed by running it):** `IntersectionOfTwoSortedArrays` has `else if (arrayTwo[j] > arrayOne[i])` which is the *same* condition as the first branch, so it can never run; the `else` therefore fires when `arrayOne[i] > arrayTwo[j]` and wrongly adds a value. Example: `[7]` ∩ `[1,5]` printed `[7]` instead of `[]`. The second branch must be `arrayOne[i] > arrayTwo[j]` → `j++`.
- **Notes (brute force):** the early-exit test is written `if (arr1[i] > arr2[j]) break` — it should be `arr2[j] > arr1[i]` (stop when the scanned value is already larger).
- **Notes (optimal):** the second condition is written with `nums1[j]` — it must be `nums2[j] < nums1[i]`.

### 04. Majority Element (> n/2)
- **Code bug:** your verification uses `count >= n/2`; a majority needs **strictly more** than n/2 (`> n/2`) — your notes have `>`. E.g. `[1,2]` has no majority but `>=` would accept it.

### 05. Leaders in an Array
- **Wrong complexity in the notes:** the optimal approach is listed as 'TC: O(N log N)'. Nothing here is a sort — the pass is O(n) and the reversal is O(n), so the total is **O(n)**.
- **Notes (brute force):** the pseudocode adds `arr[i]` when `arr[i] > arr[j]` for *some* j — it must hold for **all** j to its right (use a `leader` flag and break at the first `arr[j] >= arr[i]`).


## Patterns Easy Medium

### 01. Pattern 1 — Solid Square
- The sample in `Questions.txt` shows **5** stars per row for N = 4, but a square needs N = 4 stars per row — your code (N × N) is the right interpretation; the sample looks like a typo.

### 06. Pattern 6 — Inverted Number Triangle
- If the expected output has a space between numbers (`1 2 3`, as in the question), print `j + " "` — check that your code prints the separators.

### 07. Pattern 7 — Pyramid
- The sample in `Questions.txt` has the stars **separated by spaces** (`  * * *`) while your code prints them touching (`  ***`). The shape is right; if you need the exact sample output, print `"* "` for each star and two spaces `"  "` for each leading space.

### 08. Pattern 8 — Inverted Pyramid
- Same spacing remark as Pattern 7: the sample has `* * * * *` with spaces between the stars, your code prints `*****`.


## Patterns Hard

### 12. Pattern 12 — Mirrored Number Triangles
- **Code bug (confirmed by running it):** for N = 3 your `Pattern12` prints `123123` as the last row; the question wants `123321`. The right-hand number loop counts *up* (`j = 1 … i`) — it must count **down** (`j = i … 1`).

### 18. Pattern 18 — Right-Aligned Alphabet Triangle
- Your code prints `(char)val + " "` (a space after each letter). The sample shows letters without spaces (`CD`). Remove the `+ " "` if the exact output matters.
- `90 - 26 + i` works but is hard to read; write `'A' - 1 + i` (or `64 + i`).

### 19. Pattern 19 — Butterfly (large at the ends)
- **Code bug (confirmed by running it):** `Pattern19` prints **8 rows** for N = 4 — the 1-star middle row appears twice (once as the last row of the shrinking half and again as the first row of the growing half). The question's sample has 7 rows. Start the second half from 2 stars (call it with `N − 1` / loop `i = 2 … N`), exactly like you did in Pattern 10.

### 20. Pattern 20 — Butterfly (small at the ends)
- Your Java is correct (7 rows for N = 4).

### 22. Pattern 22 — Concentric Squares (nested rings)
- In your code the variable names are mixed up (`left = (2N-2)-i` is really the *bottom* distance and `right = j` is really *left*). The answer is still right because only the minimum of the four matters, but rename them to avoid confusion.
- The sample's last row `44444444` has 8 characters — a typo; a 2N−1 = 7 wide grid prints `4444444`.
